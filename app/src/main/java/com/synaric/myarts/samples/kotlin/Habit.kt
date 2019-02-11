package com.synaric.myarts.samples.kotlin

object Habit {

    fun run () {
        val a: String? = null

        // if null else
        // 等价于println(a ? a.length : "empty")
        println(a?.length ?: "empty")


    }
}