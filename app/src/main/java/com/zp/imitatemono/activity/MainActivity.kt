package com.zp.imitatemono.activity

import android.content.Context
import android.os.Bundle
import com.zp.imitatemono.R
import com.zp.imitatemono.app.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isFist()
    }

    private fun isFist(){
        var preferences = getSharedPreferences("imitatemono", Context.MODE_PRIVATE)
        var edit = preferences.edit()
        edit.putBoolean("isFist",false)
        edit.commit()
    }

    private fun initView(){

    }
}
