package com.example.gaurav.demoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mCount: Int = 0

    val myListener = View.OnClickListener { view ->
        if(view.id == R.id.btn_counter_main)
            tv_counterLabel_main.text = "btnclicked"
        else if (view.id == R.id.tv_counterLabel_main)
            tv_counterLabel_main.text = "label clicked"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Creating view object from XML from API 26 onwards findViewById is now a generic method so please try this

//        val tvCounter = findViewById<TextView>(R.id.tv_counterLabel_main)
//                      OR
        val tvCounter:TextView = findViewById(R.id.tv_counterLabel_main)
        // Creating view object from XML below 26
//        val tvCounter = findViewById(R.id.tv_counterLabel_main) as TextView

        tvCounter.text = "how are you ?"

        val btnCounter = findViewById<Button>(R.id.btn_counter_main)

        //Event Handling for using Lambda Expression
        btnCounter.setOnClickListener {
            tvCounter.text = "click count is ${++mCount} "
            tvCounter.setAllCaps(true)
        }

        //Event Handling for views using custom listeners
        tvCounter.setOnClickListener(myListener)
//        btnCounter.setOnClickListener(myListener)





    }

//    val toolbar = findViewById(R.id.toolbar) as Toolbar
//    setSupportActionBar(toolbar)
//
//    val fab = findViewById(R.id.fab) as FloatingActionButton
//    fab.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
}
