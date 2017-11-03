package com.example.gaurav.demoapp

import android.os.Bundle
import com.example.gaurav.demoapp.news.NewsFragment

class MainActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            changeFragment(NewsFragment(),R.id.activity_base_content)
        }

    }

}
