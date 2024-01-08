import React, { useCallback, useEffect } from 'react';
REDACTED

import {
  Alert,
  ScrollView,
  StyleSheet,
  TextInput,
  TouchableOpacity,
  Image,
} from 'react-native';

import {
  Text,
  Center,
  NativeBaseProvider,
  Box,
  Flex,
  AspectRatio,
  View,
} from 'native-base';

import { SecureCache } from 'REDACTED';
import { Services } from 'REDACTED';

const endpoint = 'REDACTED';
const userInfoEndpoint = `REDACTED`;

export default function Login({ REDACTED, REDACTED }) {
REDACTED

  async function REDACTED(response) {
    REDACTED
  }

  async function REDACTED(data) {
    REDACTED
  }

  onSave = async () => {
    try {
      const response = await axios.post(endpoint, {
        headers: {
          'Content-Type': 'application/json;charset=UTF-8',
        },
        email: email,
        password: password
      });
      await handleResponse(response);

    } catch (error) {
      Alert.alert('Error', `Incorrect email or password, please try again`);
      console.error(`LOGIN: Could not authenticate user.\n${error}`);
    }
  }
  return (
    <NativeBaseProvider>
      <View backgroundColor='#EAF0F6'>
        <AspectRatio ratio={{ base: 1 / 4, md: 9 / 10 }}>
          <Flex>
            <Flex style={styles.container}>
              <Text ></Text>
              <Image source={require('REDACTED.png')}
                style={{ width: 300, height: 50 }}>
              </Image>
              <Text style={styles.welcomeTxt}>
                Welcome back! 👋
              </Text>
              <Text style={styles.directionsTxt}>
                Please sign in or sign up to continue.
              </Text>
              <TextInput
                style={styles.textField}
                onChangeText={onEmailChange}
                value={email}
                placeholder="✉  Email@Example.com" />
              <TextInput
                secureTextEntry={true}
                style={styles.textField}
                onChangeText={onPasswordChange}
                value={password}
                placeholder="🔒 Password" />
              <TouchableOpacity onPress={onSave} style={styles.button}>
                <Text fontFamily='Nunito-Bold' fontSize='20' color='#fff'>
                  Sign in
                </Text>
              </TouchableOpacity>
              <Text style={styles.bottomText} color='#838F9B'
                paddingTop='2' paddingBottom='2'>
                Forgot password
              </Text>
              <Text style={styles.bottomText} color='#00D6BA'>
                Create an account
              </Text>
            </Flex>
          </Flex>
        </AspectRatio>
      </View>
    </NativeBaseProvider>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#FFF',
    borderRadius: 50,
    marginVertical: 30,
    marginHorizontal: 25,
    paddingTop: 55,
    paddingBottom: 40,
    paddingHorizontal: 30,
  },
  welcomeTxt: {
    alignSelf: 'center',
    fontFamily: 'Poppins-Semibold',
    color: '#253342',
    fontSize: 22,
    paddingTop: 50,
    paddingBottom: 1,
  },
  directionsTxt: {
    alignSelf: 'center',
    fontFamily: 'Poppins-Regular',
    color: '#253342',
    fontSize: 14,
    paddingBottom: 15,
  },
  button: {
    backgroundColor: '#00D6BA',
    fontFamily: 'Poppins-Semibold',
    alignSelf: "center",
    padding: 10,
    width: 260,
    paddingHorizontal: 95,
    borderRadius: 100,
    marginTop: 15,
    marginBottom: 65,
  },
  textField: {
    textAlign: 'center',
    fontFamily: 'Nunito-Bold',
    alignSelf: "center",
    color: "#33475B",
    marginTop: 15,
    width: 260,
    borderColor: "#00D6BA",
    borderWidth: 3,
    borderRadius: 100,
    padding: 10,
  },
  bottomText: {
    fontFamily: 'Poppins-Semibold',
    alignSelf: 'center',
  },
});
