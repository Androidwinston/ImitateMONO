package com.zp.imitatemono.app

import android.app.Application
import android.content.Context

/**
 * Created by 安眠 on 2017/12/27.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        var context: Context? = null
    }
}