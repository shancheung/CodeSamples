import React, { useEffect, useRef } from 'react';
import LottieView from 'lottie-react-native';
import { StyleSheet, View, Text } from 'react-native';

/**
 * This file is responsible for the loading screen portion of the application.
 * It is important to note that it is impossible to remove the splash screen that appears while
 * bundling the application as that is per the nature of native-base. It cannot be skipped out
 * on either as it appears during the bundling phase. This loading screen is meant for
 * post bundling processes.
 *
 * The .json chosen for this screen is currently a cat to ensure that it is easy to see as the
 * app itself actually loads incredibly fast and seeing the loading icon does not register into
 * the brain as well as the cat does. As such, this is for demo uses only.
 *
 * To change the loading screen image, please modify line [28] to the appropriate .json within
 * assets/lottie. Animations have been sourced from the Lottie website itself.
 *
 * Important: To get a longer animation cycle, reload the app while logged in as opposed to an
 * instance where the user is not already logged in. It's still fast but you can see it better.
 */
export default function LoadingAnimation () {
    const animationRef = useRef()
    return (
        <View style={styles.container}>
            <LottieView
                ref={animationRef}
                source={require('../assets/lottie/loadingCat.json')}
                autoPlay
                loop={true}
                speed={0.5}
            />
        </View>
    )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
