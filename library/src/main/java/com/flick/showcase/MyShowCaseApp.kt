package com.flick.showcase

import android.app.Application
import android.content.ContextWrapper
import android.util.Log
import com.pixplicity.easyprefs.library.Prefs

class MyShowCaseApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName("showcase_pref")
            .setUseDefaultSharedPreference(true)
            .build()
    }
}