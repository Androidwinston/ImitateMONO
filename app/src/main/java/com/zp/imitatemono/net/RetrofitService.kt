package com.zp.imitatemono.net

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by 安眠 on 2017/12/30.
 */
interface RetrofitService{

    @GET("{url}")
    fun getData(@Path("url")url: String): Observable<ResponseBody>
}