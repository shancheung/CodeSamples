/**********************************
* http_device_cmd(SOCKET s, int cmd, int reset)
*
* If PUT /device/config?TEMPTARG=1234, just an example not meant to work, but
* handles the temp tag if the command was written correctly. Sets temps.
* Also updates config.
*
* arguments: Socket s = client request socket
*            flag = determines which alarm/warning to be set.
*            val = value to put in for temp read from socket.
*
* returns:
* Nothing.
*
* changes: config value for respective temp param.
*
*
* NOTE:
* SAMPLE NOT FOR USE
*/
void http_device_config(SOCKET s, int flag, int val) {
    socket_writestr(s, "in config\n");
    switch (flag) {
    case HI_ALARM :
        config.hi_alarm = val;  /* sets config.hi_alarm to the value received. */
        config_update_noisr();  /* Update eeprom config with noisr. */
        http_200Response(s);    /* congratulate the user. */
        break;
    case HI_WARN :              /* rinse and repeat the above for each temp tier. */
        config.hi_warn = val;
        config_update_noisr();
        http_200Response(s);
        break;
    case LO_WARN :
        config.lo_warn = val;
        config_update_noisr();
        http_200Response(s);
        break;
    case LO_ALARM :
        config.lo_alarm= val;
        config_update_noisr();
        http_200Response(s);
        break;
    default:
        http_sendError(s);  /* default is to send an error because you souldn't even reach this, ever. */
    }
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////

    while (1) {
        wdt_reset(); /* reset  the watchdog timer every loop */
        led_update(); /* update the LED blink state */
        if (delay_isdone(1)) {  /* If temp sensor delay is done, proceed. */
            current_temperature = temp_get(); /* read the temperature sensor */
            tempfsm_update(current_temperature, config.hi_alarm, config.hi_warn, config.lo_alarm, config.lo_warn); /* update the temperature fsm and send any alarms associated with it */
            delay_set(1, 1000); /* restart the temperature sensor delay to trigger in 1 second */
        } if (socket_is_closed(SERVER_SOCKET)) { /*if the server socket is closed */
            socket_open(SERVER_SOCKET, HTTP_PORT); /* if socket is closed, open it in passive (listen) mode */
            socket_listen(SERVER_SOCKET);
            log_update_noisr(); /* update any pending log write backs (eeprom) */
            config_update_noisr(); /* update any pending config write backs (eeprom) */
        } else if (socket_recv_available(SERVER_SOCKET)) { /* See if there is more than 0 bytes in recv. buffer. */
                /* parse and process any pending commands */
                if (socket_recv_compare(SERVER_SOCKET, "GET")) { /* If socket recv compare socket get... put and delete. */
                        if (socket_recv_compare(SERVER_SOCKET, " /device")) {/* If srecv_compare "device" */
                            http_device_cmd(SERVER_SOCKET, GET, 0); /* prep valid req for end point */
                        } else {    /* else, prepare error request if not found */
                            socket_flush_line(SERVER_SOCKET);/* Always flush before sending an error. */
                            http_sendError(SERVER_SOCKET); /* Send the error */
                        }   /* Exit "GET" check. */
                   } else if (socket_recv_compare(SERVER_SOCKET, "PUT")) {  /* Check if PUT is in receiver. */
                        if (socket_recv_compare(SERVER_SOCKET, " /device/config")) { /* If the case is device/config is in the endpoint. */
                            int val = 0;    /* Place holder for temp to be read. */
                            int flag = -1;  /* Flag used to indicate where the temp input goes. */
                            if (socket_recv_compare(SERVER_SOCKET, "?tcrit_hi=")){ /* For every temp that can be changed check if it matches any of the possible options */
                                flag = HI_ALARM; /* If it matches tcrit_hi, set the flag to signal  */
                            } else if (socket_recv_compare(SERVER_SOCKET, "?twarn_hi=")) {  /* preconditions for flag to signal for twarn_hi */
                                flag = HI_WARN;
                            } else if (socket_recv_compare(SERVER_SOCKET, "?twarn_lo=")) {  /* preconditions for flag to signal for twarn_lo */
                                flag = LO_WARN;
                            } else if (socket_recv_compare(SERVER_SOCKET, "?tcrit_lo=")) {  /* preconditions for flag to signal for tcrit_lo */
                                flag = LO_ALARM;
                            }
                            if (( flag != -1)) {    /* If flag has been set ... */
                                socket_recv_int(SERVER_SOCKET, &val);           /* receive the following int val. */
                                http_device_config(SERVER_SOCKET, flag, val);   /* device_config modifies config.t warn/alarm hi/lo accordingly based on flag. */
                            } else if ((flag = -1)){                /* There was probably a typo  */
                                socket_flush_line(SERVER_SOCKET);   /* this royal flush won't get your chips back. */
                                http_sendError(SERVER_SOCKET);      /* send error response due to invalid input. */
                            } /* end of device/config if statement. */
                        } else if (socket_recv_compare(SERVER_SOCKET, "?reset=")) { /* see if the endpoint is PUT device/config?reset="TRUE/FALSE" */
                            if ((socket_recv_compare(SERVER_SOCKET, "\"true\""))) {     /* If TRUE then actually reset the device. */
                                http_device_cmd(SERVER_SOCKET, PUT, 1);             /* Flag 1 in device_cmd signals http.c to actually use wdt_force_restart() */
                            } else if ((socket_recv_compare(SERVER_SOCKET, "\"false\""))) { /* Flag 2 is an easter egg to do nothing but with fun text. */
                                http_device_cmd(SERVER_SOCKET, PUT, 2);             /* Returns "time to do nothing" because its supposed to do nothing but I notify the user anyway. */
                            } else {    /* Any other input just flushes and sends an error. */
                                socket_flush_line(SERVER_SOCKET);   /* this royal flush won't get your chips back. */
                                http_sendError(SERVER_SOCKET);      /* send error response due to invalid input. */
                            }
                        } /* End of "?reset=" else if statement. */
                   } else if (socket_recv_compare(SERVER_SOCKET, "DELETE")) {   /* If the command type is "DELETE"... */
                      if (socket_recv_compare(SERVER_SOCKET, " /device/log")) {   /* check if there's "device/log" in the receiver. */
                        http_device_cmd(SERVER_SOCKET, DELETE,0);               /* If typed correctly, tell cmd to delete the log. */
                      } else {  /* If DELETE does not have device/log... */
                        socket_flush_line(SERVER_SOCKET); /* Always flush before sending error. */
                        http_sendError(SERVER_SOCKET); /* If typed incorrectly send an error response. */
                      }
                   } else { /* If anything else was put in and doesn't match PUT, Get or Delete... */
                    socket_flush_line(SERVER_SOCKET);   /* Immediately just flush and send an error. */
                    http_sendError(SERVER_SOCKET);
                   }
            socket_disconnect(SERVER_SOCKET);   /* disconnect before closing! */
            if (socket_is_active(SERVER_SOCKET)) {
                socket_close(SERVER_SOCKET);        /* close the socket by force if its still active. */
            }
            } else {    /* According to fsm1, if socket is opened and put into listening mode or no new data, write eeprom log/config. */
                log_update_noisr(); /* update any pending log write backs (eeprom) */
                config_update_noisr(); /* update any pending config write backs (eeprom) */
            }
    }
