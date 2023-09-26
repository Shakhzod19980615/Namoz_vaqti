package com.example.namoz_vaqti.data.common

import android.content.Context
import android.content.SharedPreferences
import com.example.namoz_vaqti.data.common.Constants.Latitude
import com.example.namoz_vaqti.data.common.Constants.Longitude


object MySettings {
    private var appContext: Context? = null
    private var instance: MySettings? = null

    fun initInstance(con: Context?) {
        appContext = con
        if (instance == null) instance = MySettings
    }
    fun setContext(context:Context){
        this.appContext = context
    }
   fun getInstance(): MySettings? {
        if (instance == null) instance = MySettings
        return instance
    }


    fun getLongtitude(): String? {
        val preferences: SharedPreferences =
            appContext!!.getSharedPreferences("settings", Context.MODE_PRIVATE)
        return preferences.getString(Longitude, "")
    }
    fun setLongtitude(longitude: String?) {
        val preferences: SharedPreferences =
            appContext!!.getSharedPreferences("settings", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString(Longitude, longitude)
        editor.apply()
    }
    fun getLatitude(): String? {
        val preferences: SharedPreferences =
            appContext!!.getSharedPreferences("settings", Context.MODE_PRIVATE)
        return preferences.getString(Latitude, "")
    }
    fun setLatitude(latitude: String?) {
        val preferences: SharedPreferences =
            appContext!!.getSharedPreferences("settings", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString(Latitude, latitude)
        editor.apply()
    }


}