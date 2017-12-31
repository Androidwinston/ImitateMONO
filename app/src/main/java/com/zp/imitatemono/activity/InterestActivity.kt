package com.zp.imitatemono.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.allen.library.SuperTextView
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper
import com.zp.imitatemono.R
import com.zp.imitatemono.app.BaseActivity
import com.zp.imitatemono.app.MyApplication
import com.zp.imitatemono.net.Bean
import com.zp.imitatemono.net.RetrofitFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_interest.*


class InterestActivity : BaseActivity() {

    val TAG = "InterestActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interest)
        initView()
        getData()
    }


    private fun initView() {
        interest_textview.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            interest_textview -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }


    private fun initAdapter(mDatas: List<Bean.CategoryListBean>) {
        var commonAdapter: CommonAdapter<Bean.CategoryListBean> = object : CommonAdapter<Bean.CategoryListBean>(
                this,
                R.layout.item_theme_interest_recyclerview,
                mDatas) {
            override fun convert(holder: ViewHolder?, t: Bean.CategoryListBean?, position: Int) {
                holder!!.setText(R.id.textView2, t!!.name)
                holder!!.setText(R.id.textView3, t!!.name)
                var superTextView: SuperTextView = holder.getView(R.id.superTextView)
                superTextView.setOnClickListener(View.OnClickListener {
                    superTextView.setCenterString("√")
                })
            }
        }
        var headAndFoot = HeaderAndFooterWrapper<View>(commonAdapter)
        var view = View.inflate(MyApplication.context, R.layout.item_image_interest_recyclerview, null);
        headAndFoot.addHeaderView(view)
        interest_recyclerview.layoutManager = GridLayoutManager(this, 3)
        interest_recyclerview.adapter = headAndFoot
    }


    private fun getData() {
        RetrofitFactory
                .instance
                .builder()
                .getData("/api/v3/domain_category/")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    var bean: Bean = result.body()!!
                    initAdapter(bean.getCategory_list()!!)
                })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }

}

