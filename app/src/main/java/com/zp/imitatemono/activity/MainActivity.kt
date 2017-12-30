package com.zp.imitatemono.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import com.zp.imitatemono.R
import com.zp.imitatemono.app.BaseActivity
import com.zp.imitatemono.net.RetrofitFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isFist()
        initView()
    }

    private fun isFist() {
        var preferences = getSharedPreferences("imitatemono", Context.MODE_PRIVATE)
        var edit = preferences.edit()
        edit.putBoolean("isFist", false)
        edit.commit()
    }

    private fun initView() {
        textView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            textView -> {
                RetrofitFactory
                        .instance
                        .builder()
                        .getData("/api/v3/domain_category/\n")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe {
                            println("call…………………………")
                        }
                        .subscribe({ result ->
                            println(result.toString())
                        })
            }
        }
    }
}
