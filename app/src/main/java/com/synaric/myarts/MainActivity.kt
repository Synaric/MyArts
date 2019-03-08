package com.synaric.myarts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.synaric.myarts.samples.kotlin.clz.ClzAndImplementation
import com.synaric.myarts.samples.kotlin.clz.DataClz
import com.synaric.myarts.samples.kotlin.clz.Extensions
import com.synaric.myarts.samples.kotlin.clz.NestedClz
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()
//        sample_text.setOnClickListener {
//            it?.visibility = View.GONE
//        }

        // ClzAndImplementation.run()
        // Extensions.run()
        // DataClz.run()
        // NestedClz.run()
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
