package com.synaric.myarts.samples.kotlin.clz

import android.util.Log
import com.synaric.myarts.samples.kotlin.Base

object ClzAndImplemention: Base(){

    override fun run() {
        Something4("ha", 2)
    }

    // 构造函数，省略了constructor
    class Something(name: String) {}

    // 声明了name和length属性
    class Something2(val name: String, var length: Int) {}

    // 构造函数有修饰符或注解时，不能省略constructor
    class Something3 public constructor(name: String) {}

    // 演示构造函数委托与执行顺序
    class Something4 (name: String) {

        init {
            Log.d(TAG, "Init block1")
        }

        constructor(name: String, length: Int): this(name) {
            Log.d(TAG, "constructor")
        }

        init {
            Log.d(TAG, "Init block2")
        }
    }
}