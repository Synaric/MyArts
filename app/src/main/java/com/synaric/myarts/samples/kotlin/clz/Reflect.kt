package com.synaric.myarts.samples.kotlin.clz

import android.util.Log
import com.synaric.myarts.samples.kotlin.Base

object Reflect: Base() {

    override fun run() {
        // 给类的成员函数取别名
        val foo: A.() -> Unit = A::doo
        A().foo()
    }

    class A {
        fun doo() {
            Log.d(TAG, "run doo")
        }
    }
}