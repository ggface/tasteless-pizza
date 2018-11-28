package io.ggface.tastelesspizza

import android.app.Application

import net.danlew.android.joda.JodaTimeAndroid

/**
 * "Tasteless pizza" Application
 *
 * @author Ivan Novikov on 2017-09-19.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this)
    }
}