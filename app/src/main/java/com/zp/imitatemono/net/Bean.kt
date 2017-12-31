package com.zp.imitatemono.net

/**
 * Created by 安眠 on 2017/12/30.
 */
class Bean {

    private var category_list: List<CategoryListBean>? = null

    fun getCategory_list(): List<CategoryListBean>? {
        return category_list
    }

    fun setCategory_list(category_list: List<CategoryListBean>) {
        this.category_list = category_list
    }

    class CategoryListBean {

        var id: Int = 0
        var name: String? = null
    }

}