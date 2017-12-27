package com.zp.imitatemono.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.zp.imitatemono.app.BaseActivity

class SplashActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Handler(Looper.getMainLooper()).postDelayed({
            var preferences = getSharedPreferences("imitatemono",Context.MODE_PRIVATE)
            var isFist = preferences.getBoolean("isFist",true)
            if (isFist){
                startActivity(Intent(this,WelcomeActivity::class.java))
            }else{
                startActivity(Intent(this,MainActivity::class.java))
            }
            finish()
        },3000);
    }
}
