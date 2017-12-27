package com.zp.imitatemono.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zp.imitatemono.R

open class BaseActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    override fun onClick(v: View?) {

    }
}
