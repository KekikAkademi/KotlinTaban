emulator -avd Pixel_2_API_30 -writable-system -no-snapshot

./gradlew installDebug

adb logcat -c && adb logcat -v tag | logcat-colorize | grep "d_KekikTaban"

adb shell am start -n com.keyiflerolsun.kekiktaban/.AnaActivity




./keyStore.sh
./gradlew clean && ./gradlew assembleRelease androidSourcesJar