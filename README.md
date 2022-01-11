# ClickAnimationEffectAndroid

[![](https://jitpack.io/v/Pisey-Nguon/ClickAnimationEffectAndroid.svg)](https://jitpack.io/#Pisey-Nguon/ClickAnimationEffectAndroid)

How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

*If your Gradle version below 7.0*
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' } //add this line
		}
	}

*if your Gradle version from 7.0*
Add it in your root settings.gradle at the end of repositories:

    dependencyResolutionManagement {  
      repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)  
        repositories {  
		    google()  
            mavenCentral()  
            jcenter() // Warning: this repository is going to shut down soon  
		    maven { url 'https://jitpack.io' }  // add this line
     }}

Step 2. Add the dependency

dependencies {


    implementation 'com.github.Pisey-Nguon:ClickAnimationEffectAndroid:1.0.0'

}

Step 3. Implement code

## Preview
![20220111_115715](https://user-images.githubusercontent.com/47247206/148896913-08c72b49-244c-4dba-b9ff-f8f82ec4a47f.gif)
## Using default style
    bt1.setOnSingleClickListener {  
      Log.d(TAG, "onClick: button 1")  
    }
## Using with color

    bt2.setOnSingleClickListener(colorFilter = ContextCompat.getColor(this,R.color.purple_200)){  
      Log.d(TAG, "onClick: button 2")  
    }
## Using with color and option of animation

    bt3.setOnSingleClickListener(colorFilter = ContextCompat.getColor(this,R.color.purple_200), isAnimate = true){  
      Log.d(TAG, "onClick: button 3")  
    }
## Using with double click that have two override function

You also can implement property like above

    bt4.setOnDoubleClickListener(object:DoubleClick.DoubleClickListener{  
        override fun onDoubleClick() {  
            Log.d(TAG, "onDoubleClick")  
        }  
      
        override fun onSingleClick() {  
            Log.d(TAG, "onSingleClick")  
        }  
      
    })
