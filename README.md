# URLImageView

A powerful image downloading and caching library with spinner and refresh button for Android


![](1.gif)

![](2.gif)

## Gradle Dependency

- build.gradle (Project.Your_App)
 ``` gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 - build.gradle (Module.app)
 ``` gradle
dependencies {
    implementation 'com.github.zakaryaasadi:URLImageView:0.0.2'
 }
 ```
## Permission
- Mainfests

 ```xml
<uses-permission android:name="android.permission.INTERNET"/>       
```

## Usage
- Xml

 ```xml
    <com.zak.URLImageView
        android:id="@+id/image"
        android:layout_width="match_parent"
        android:layout_height="232.3dp"
        app:scaleType="CENTER_CROP"
        app:Spinner_Style="ThreeBounce"
        app:Spinner_Color="#fff"
        app:Placeholder="@drawable/gradient_rect"/>       
```
 
- Java

 ```java
URLImageView imageView = findViewById(R.id.image);
imageView.load("https://i.ytimg.com/vi/scYvJUUOHK4/maxresdefault.jpg");
```


- Java with events

 ```java
image.setCallback(new URLImageView.Callback() {
            @Override
            public void onStartLoad() {
                Log.d("onStartLoad : ", "Start load");
            }

            @Override
            public void onSuccess() {
                Log.d("onSuccess : ", "success load");
            }

            @Override
            public void onError(Exception e) {
                Log.d("onError : ", e.getMessage());
            }
        }).load("https://i.ytimg.com/vi/scYvJUUOHK4/maxresdefault.jpg");
```
Another method

 ```java
image.setCallback(new URLImageView.Callback() {
            @Override
            public void onStartLoad() {
                Log.d("onStartLoad : ", "Start load");
            }

            @Override
            public void onSuccess() {
                Log.d("onSuccess : ", "success load");
            }

            @Override
            public void onError(Exception e) {
                Log.d("onError : ", e.getMessage());
            }
        });
image.load("https://i.ytimg.com/vi/scYvJUUOHK4/maxresdefault.jpg");
```

## Style

Style | Preview
------------     |   -------------
RotatingPlane    | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/RotatingPlane.gif' alt='RotatingPlane' width="90px" height="90px"/>
DoubleBounce     | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/DoubleBounce.gif' alt='DoubleBounce' width="90px" height="90px"/>
Wave             | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/Wave.gif' alt='Wave' width="90px" height="90px"/>
WanderingCubes   | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/WanderingCubes.gif' alt='WanderingCubes' width="90px" height="90px"/>
Pulse            | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/Pulse.gif' alt='Pulse' width="90px" height="90px"/>
ChasingDots      | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/ChasingDots.gif' alt='ChasingDots' width="90px" height="90px"/>
ThreeBounce      | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/ThreeBounce.gif' alt='ThreeBounce' width="90px" height="90px"/>
Circle           | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/Circle.gif' alt='Circle' width="90px" height="90px"/>
CubeGrid         | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/CubeGrid.gif' alt='CubeGrid' width="90px" height="90px"/>
FadingCircle     | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/FadingCircle.gif' alt='FadingCircle' width="90px" height="90px"/>
FoldingCube      | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/FoldingCube.gif' alt='FoldingCube' width="90px" height="90px"/>
RotatingCircle   | <img src='https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/RotatingCircle.gif' alt='RotatingCircle' width="90px" height="90px"/>
