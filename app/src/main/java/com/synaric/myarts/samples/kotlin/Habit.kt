package com.synaric.myarts.samples.kotlin

import android.util.Log

object Habit {

    private const val TAG = "sample.kotlin"

    fun run () {
        val a: String? = null

        // if null else
        // 等价于a ? a.length : -1
        Log.d(TAG, "" + (a?.length ?: -1))

        // if null执行了一个语句
        println(a?: "empty")

        // 在可能会空的集合中取第一元素
        val emails = intArrayOf(1) // 可能会是空集合
        val mainEmail = emails.firstOrNull() ?: ""
    }
}