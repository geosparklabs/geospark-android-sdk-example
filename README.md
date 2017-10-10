# GeoSpark Android SDK Example

An example app for android which implements the GeoSpark SDK and shows your location history.

GeoSpark Android Documentation link: https://dashboard.geospark.co/docs/android/

## Example App

### To get started:

Download this project and open it in Android Studio.

1. [Request](https://geospark.co) for a GeoSpark developer account to get your SDK key and Secret.

2. In the projects MainActivity, update this line `GeoSpark.initialize(this,”YOUR-SDK-KEY”,”YOUR-SECRET”);` to contain your GeoSpark SDK key and Secret.

3. Update the AndroidManifest.xml file to contain your google app ID and enable Google Maps Android API for your project. (you can get one here: https://console.developers.google.com/)

```
<meta-data
  android:name="com.google.android.geo.API_KEY"
  android:value="YOUR-GOOGLE-APP-ID" />
```

4. Import your google-services.json file into app folder. Follow the instructions here to get one https://support.google.com/firebase/answer/7015592

## Installation

Installing the GeoSpark SDK is done in 3 steps.

1. **Import SDK into project**
2. **Enable Location and Run-time Permissions**
3. **Initialize the SDK** 

### Import SDK into your project

After downloading the SDK from [here](https://s3.amazonaws.com/geospark-framework/Android/GeoSpark.aar), click `File > Project Structure` in Android Studio. Click the green plus icon in the top left, click `Import AAR`, select the GeoSpark SDK file, press OK and wait for Gradle to finish syncing.

Once Gradle is finished (only a few seconds), click `File > Project Structure` again. Click on `app`, then `Depenencies` tab, then the green icon (top right), select `Module dependency`, click on GeoSpark, then press Ok and wait for Gradle to sync again.

### Enable Location and Run-time permissions
To enable location, call the `requestPermissions` and `requestLocationServices` method. For Android 6.0 and above, calling this method will trigger a location permission popup that the user has to allow.

```
GeoSpark.requestPermission(this);
GeoSpark.requestLocationServices(this);
```

Location popup for Android 6.0 and above:

### Initialize the SDK

To initialize the SDK, you must call the `GeoSpark.initialize` method when your app is started.

```
GeoSpark.initialize(this,”YOUR-SDK-KEY”,”YOUR-SECRET”);
```

You should call this method in your Main Activity's onCreate method. Put in your own sdk key and secret here.

[Request](https://geospark.co) for SDK keys if you don't have already.

## Create User

The SDK needs an User ID object to identify the device. The SDK has a convenience method `createUser()` to create a user which returns USer ID. 




## Get User

If you already have an User ID object. The SDK has a convenience method `getUser()` to to start the session for the existing user.




## Start Location Tracking

To start tracking the location, use the `startLocationTracking()` method. You can keep SDK to track location, or turn it off if you want to stop tracking the user at any point of time using the stopLocationTracking()  method.




## Stop Location Tracking

You can stop tracking the user at any point of time using the `stopLocationTracking()` method.






## View Dashboard

Install your app with the GeoSpark SDK on a device and begin tracking on the Dashboard. You would see the user’s current state on the GeoSpark dashboard. If you click on the user, you should be able to view the user's location history.





