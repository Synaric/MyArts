package com.synaric.myarts.samples.kotlin.clz

import android.util.Log
import com.synaric.myarts.samples.kotlin.Base

object Controlflow : Base() {

    override fun run() {
        // for循环遍历map
        val map = mapOf("a" to 1, "b" to 2)
        for ((k, v) in map) {
            Log.d(TAG, k + v)
        }

        // for循环遍历数组
        val list = listOf(1, 2, 3)
        for (i in list.indices) {
            Log.d(TAG, list[i].toString())
        }

        // for循环与withIndex
        for ((index, value) in list.withIndex()) {
            Log.d(TAG, "index: $index, value: $value")
        }

        // 带label的break
        loop@ for (i in 1..100) {
            for (j in 1..100) {
                if (j == 2) break@loop
            }
        }

        // foreach中lambda表达式的continue
        foo()

        // foreach中lambda表达式的break
        foo2()
    }

    private fun foo() {
        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
                                    // 如果直接写return，返回foo的调用者
            Log.d(TAG, it.toString())
        }
        Log.d(TAG,"done with explicit label")
    }

    private fun foo2() {
        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // 从传入 run 的 lambda 表达式非局部返回
                print(it)
            }
        }
        Log.d(TAG,"done with nested loop")
    }
}