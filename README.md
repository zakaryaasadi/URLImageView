# URLImageView
 
A powerful image downloading and caching library with spinner and refresh button for Android

## Preview

<img src="https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/screen.gif" width="240px" height="240px"/>

<img src="https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/screen2.gif" width="200px" height="200px"/>

## Gradle Dependency

 ``` gradle
dependencies {
    implementation 'com.github.zakaryaasadi:URLImageView:0.0.1'
 }
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
 
- JAVA

 ```java
    URLImageView imageView = findViewById(R.id.image);
    imageView.load("https://i.ytimg.com/vi/scYvJUUOHK4/maxresdefault.jpg");
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
