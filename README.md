# USCIS Hippo

USCIS Hippo is a small project started to solve a small repetitive task.
The app has usefulness if you are tired of checking [USCIS processing times](https://egov.uscis.gov/processing-times/)


## Building the Sample App

First, clone the repo:

`https://github.com/matthewpkemp/USCISHippo.git`

### Android Studio (Recommended)

(These instructions were tested with Android Studio version 2.2.2, 2.2.3, 2.3, and 2.3.2)

* Open Android Studio and select `File->Open...` or from the Android Launcher select `Import project (Eclipse ADT, Gradle, etc.)` and navigate to the root directory of your project.
* Select the directory or drill in and select the file `build.gradle` in the cloned repo.
* Click 'OK' to open the the project in Android Studio.
* A Gradle sync should start, but you can force a sync and build the 'app' module as needed.

## Running the Sample App

Connect an Android device to your development machine.

### Android Studio

* Select `Run -> Run 'app'` (or `Debug 'app'`) from the menu bar
* Select the device you wish to run the app on and click 'OK'

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Built With

* [Retrofit2](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java
* [Moshi](https://github.com/square/moshi) - A modern JSON library for Kotlin and Java. 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Icon used a combination of these images from [pixabay](https://pixabay.com):
 * [Hippo](https://pixabay.com/vectors/hippo-head-cartoon-cute-grey-zoo-308772/)
 * [US Flag](https://pixabay.com/vectors/flag-usa-america-american-united-32195/)