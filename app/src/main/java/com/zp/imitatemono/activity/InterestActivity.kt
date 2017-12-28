package com.zp.imitatemono.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import com.zp.imitatemono.R
import com.zp.imitatemono.app.BaseActivity
import kotlinx.android.synthetic.main.activity_interest.*
import org.json.JSONObject

class InterestActivity : BaseActivity() {


    var commonAdapter:CommonAdapter<JSONObject>?=null
    var mDatas:List<JSONObject>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interest)
        initView()
    }


    private fun initView(){
        interest_textview.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v){
            interest_textview -> {
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }

    private fun initAdapter(){
        mDatas = listOf()
        interest_recyclerview.setAdapter(object : CommonAdapter<JSONObject>(this, R.layout.item_theme_interest_recyclerview, mDatas) {
            override fun convert(holder: ViewHolder?, t: JSONObject?, position: Int) {


            }
        })
    }

}
