package com.zp.imitatemono.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zp.imitatemono.R
import com.zp.imitatemono.app.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isFist()
        initView()
    }

    private fun isFist() {
        var preferences = getSharedPreferences("imitatemono", Context.MODE_PRIVATE)
        var edit = preferences.edit()
        edit.putBoolean("WelcomeActivity", false)
        edit.putBoolean("InterestActivity", false)
        edit.commit()
    }

    private fun initView() {
        textView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            textView -> {

            }
        }
    }


    var isClicked:Boolean = false
    var lastTime:Long = 0


    override fun onBackPressed() {
        if (isClicked){
            var curTime:Long = System.currentTimeMillis()
            if (curTime-lastTime>=2000){
                lastTime = curTime
                Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show()
            }else{
                finish()
            }

        }else{
            isClicked = true
            lastTime = System.currentTimeMillis()
            Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show()
        }
    }
}
