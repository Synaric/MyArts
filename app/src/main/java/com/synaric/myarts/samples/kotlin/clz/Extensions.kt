package com.synaric.myarts.samples.kotlin.clz

import android.util.Log
import com.synaric.myarts.samples.kotlin.Base

object Extensions: Base() {

    override fun run() {
        // 这里调用D.foo()
        print(D())
        // 这里调用C.doo()
        // 扩展是静态解析的，这里print2接受类型是C
        print2(D())

        // 在类的内部为其他类做扩展
        C().foo2()
    }

    fun foo () {
        Log.d(TAG, "Extensions.foo()")
    }

    fun C.doo() {
        Log.d(TAG, "C.doo()")
    }

    fun D?.doo() {
        // 可空判断
        if (this == null) {
            Log.d(TAG, "D.doo(), d == null")
            return
        }
        Log.d(TAG, "D.doo()")
    }

    fun C.foo2() {
        Log.d(TAG, "C.foo2() start")
        // this关键字调用Extensions中同名冲突的方法
        this@Extensions.foo()
        foo()
        doo()
        Log.d(TAG, "C.foo2() end")
    }

    private fun print (c: C) {
        c.foo()
    }

    private fun print2 (c: C) {
        c.doo()
    }

    open class C {

        open fun foo() {
            Log.d(TAG, "C.foo()")
        }
    }
    class D: C() {

        override fun foo () {
            Log.d(TAG, "D.foo()")
        }
    }
}