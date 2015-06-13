# SCViewPager
_Andy wants to jazz_

A simple ViewPager extends that provide scroll based animation like Jazz Hands for iOS. 
Jazz Hands library provided by IFTTT : https://github.com/IFTTT/JazzHands

# Start

First, add SCViewPager to your project. Create an activity with the viewPage and the views you want to animate.

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent"
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

		View view = findViewById(R.id.textview_to_animate);
        SCViewAnimation viewAnimation = new SCViewAnimation(view);
        viewAnimation.addPageAnimation(new SCPositionAnimation(0,500,1000));
        viewAnimation.addPageAnimation(new SCSizeAnimation(0, 1.5f, 1.5f));
        viewAnimation.addPageAnimation(new SCPositionAnimation(1, -1000,0));
        mViewPager.addAnimation(viewAnimation);
