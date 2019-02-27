package com.synaric.myarts.samples.kotlin.clz

import android.util.Log
import com.synaric.myarts.samples.kotlin.Base

object NestedClz: Base() {

    private var name = "NestedClz"

    override fun run() {
        val inner = NestedClz.Inner()
        inner.setName()
        inner.getName()

        val funLit = lambda@ fun String.() {
            val d = this // funLit 的接收者
            Log.d(TAG, d)
        }
    }

    class Inner {

        fun getName() = name

        fun setName() {
            name = "InnerNestedClz"
        }
    }
}