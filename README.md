# SCViewPager
_Jazz score for android_

A simple ViewPager extends that provide scroll based animation like Jazz Hands for iOS. 
Jazz Hands library provided by IFTTT : https://github.com/IFTTT/JazzHands

![alt tag](https://github.com/sacot41/SCViewPager/blob/master/example_2.gif?raw=true)

# Start

First, add SCViewPager to your project. Create an activity with the viewPage and the views you want to animate.

	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    	xmlns:tools="http://schemas.android.com/tools" 			android:layout_width="match_parent"
    	android:layout_height="match_parent"
    	tools:context=".MainActivity">

    	<com.dev.sacot41.myresume.SCViewPager
        	android:id="@+id/viewpager_main_activity"
        	android:layout_width="match_parent"
        	android:layout_height="match_parent">
    	</com.dev.sacot41.myresume.SCViewPager>

    	<TextView
        	android:id="@+id/textview_to_animate"
        	android:layout_width="wrap_content"
        	android:layout_height="wrap_content"
        	android:background="@color/white"
        	android:text="@string/textview_bonjour"/>

	</RelativeLayout>

Retrive view and add animation after you have set viewPager and his adapter.
		
        Point size = SCViewAnimationUtil.getDisplaySize(this);
        
		View view = findViewById(R.id.textview_to_animate);
        SCViewAnimation viewAnimation = new SCViewAnimation(view);
        viewAnimation.startToPosition((int)(size.x*1.5), null);
        viewAnimation.addPageAnimation(new SCPositionAnimation(this, 0, -(int)(size.x*1.5), 0));
        mViewPager.addAnimation(viewAnimation);
