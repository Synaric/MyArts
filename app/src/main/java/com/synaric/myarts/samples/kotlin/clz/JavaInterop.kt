package com.synaric.myarts.samples.kotlin.clz

import android.app.Activity
import com.synaric.myarts.samples.kotlin.Base
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

object JavaInterop: Base() {

    override fun run() {
        // 获取java的class对象
        val acClz = Activity::class.java

        // 演示SAM转换
        val executor = Executors.newSingleThreadExecutor()
        executor.execute { println("This runs in a thread pool") }
    }
}