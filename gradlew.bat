<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/la"
    tools:context=".LoginActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:padding="1dp">

        <ImageView
            android:id="@+id/logo"
            android:layout_width="400dp"
            android:layout_height="350dp"
            android:layout_marginTop="5dp"
            android:scaleType="centerCrop"
            android:layout_gravity="center_horizontal"
            android:src="@drawable/c"/>

        <ScrollView
            android:id="@+id/login_form"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:layout_marginTop="20dp">

                <EditText
                    android:id="@+id/edt_username"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginVertical="15dp"
                    android:background="@drawable/rauded_form"
                    android:drawableRight="@drawable/icon_user_drawer"
                    android:hint="@string/username"
                    android:inputType="textEmailAddress"
                    android:maxLines="1"
                    android:padding="15dp"
                    android:singleLine="true"/>
                <EditText
                    android:id="@+id/edt_password"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="@drawable/rauded_form"
                    android:hint="@string/password"
               