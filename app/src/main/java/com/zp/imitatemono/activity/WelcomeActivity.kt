package com.zp.imitatemono.activity

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.zp.imitatemono.R
import com.zp.imitatemono.app.BaseActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import java.io.IOException


class WelcomeActivity : BaseActivity() {

    //MediaPlayer初始化播放器
    val mp = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置全屏
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_welcome)
        initView()
    }


    private fun initView() {
        welcome_imagebutton.setOnClickListener(this)
        //给videoView设置要播放的视频
        welcome_videoview_spa.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.welcome))
        //监听播放状态，播放完了继续播放
        welcome_videoview_spa.setOnCompletionListener(MediaPlayer.OnCompletionListener {
            welcome_videoview_spa.start()
        })
        welcome_videoview_spa.start()
        //获取要播放的音频
        var file = resources.openRawResourceFd(R.raw.welcome_3_0)
        try {
            //给MediaPlayer设置音频源
            mp.setDataSource(file.fileDescriptor, file.startOffset, file.length)
            //MediaPlayer预准备
            mp.prepare()
            file.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        //MediaPlayer设置音量
        mp.setVolume(0.5f, 0.5f)
        //MediaPlayer设置循环播放
        mp.isLooping = true
        //开始播放
        mp.start()
    }


    override fun onPause() {
        super.onPause()
        if (mp != null) {
            //MediaPlayer停止播放
            mp.stop()
            //MediaPlayer资源释放
            mp.release()
        }
        //videoView停止播放
        welcome_videoview_spa.stopPlayback()
        //videoView释放资源
        welcome_videoview_spa.suspend()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        skip()
    }

    override fun onClick(v: View?) {
        when (v) {
            welcome_imagebutton -> {
                skip()
            }
        }
    }


    private fun skip() {
        var preferences = getSharedPreferences("imitatemono", Context.MODE_PRIVATE)
        var isFist = preferences.getBoolean("InterestActivity", true)
        if (isFist) {
            startActivity(Intent(this, InterestActivity::class.java))
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
