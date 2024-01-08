'use strict';
import { StyleSheet } from 'react-native';
import { useFonts } from 'expo-font';

function fontDec() {
    const [fontsLoaded] = useFonts({
        'Nunito-Regular': require('REDACTED/NunitoRegular-vmABZ.ttf'),
        'Nunito-Bold': require('REDACTED/NunitoBold-1GD50.ttf'),
        'Poppins-Regular': require('REDACTED/PoppinsRegular-B2Bw.otf'),
        'Poppins-Semibold': require('REDACTED/PoppinsSemibold-8l8n.otf'),
      });
}

export default StyleSheet.create({
    defaultFont: {
        fontFamily: 'Nunito-Regular',
        fontSize: 18,
    },
    nunitoRegular: {
        fontFamily: 'Nunito-Regular',
    },
    nunitoBold: {
        fontFamily: 'Nunito-Bold',
    },
    poppinsRegular: {
        fontFamily: 'Poppins-Regular',
    },
    poppinsSemibold: {
        fontFamily: 'Poppins-Semibold',
    },
})