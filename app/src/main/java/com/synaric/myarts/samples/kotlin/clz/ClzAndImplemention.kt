package com.synaric.myarts.samples.kotlin.clz

import android.util.Log
import com.synaric.myarts.samples.kotlin.Base

/*
    类与继承
 */
object ClzAndImplementation: Base(){

    override fun run() {
        // 演示构造函数委托与执行顺序
        // 父类构造函数优先子类构造函数和初始化块执行
        Something5("ha", 2)

        // 演示内部类
        OuterClz().testFoo()

        // 演示多重继承
    }

    // 构造函数，省略了constructor
    class Something(name: String) {}

    // 声明了name和length属性
    class Something2(val name: String, var length: Int) {}

    // 构造函数有修饰符或注解时，不能省略constructor
    class Something3 public constructor(name: String) {}

    // 演示构造函数委托与执行顺序
    // 父类构造函数优先子类构造函数和初始化块执行
    open class Something4 {

        init {
            Log.d(TAG, "1.Init block1")
        }

        constructor(name: String) {
            Log.d(TAG, "3.constructor super")
        }

        constructor(name: String, length: Int): this(name) {
            Log.d(TAG, "constructor super2")
        }

        init {
            Log.d(TAG, "2.Init block2")
        }
    }

    class Something5: Something4 {

        init {
            Log.d(TAG, "4.Init block3")
        }

        constructor(name: String, length: Int): super(name) {
            Log.d(TAG, "5.constructor")
        }
    }

    // 演示内部类
    open class OuterClzBase {

        open fun foo () {
            Log.d(TAG, "OuterClzBase.foo()")
        }
    }
    class OuterClz: OuterClzBase() {

        override fun foo () {
            Log.d(TAG, "OuterClz.foo()")
        }

        fun testFoo () {
            InnerClz().doo()
        }

        inner class InnerClz {

            fun doo () {
                // 调用外部类的父类的foo方法
                super@OuterClz.foo()
            }
        }
    }

    // 演示多重继承
    open class A {

        open fun foo() {
            Log.d(TAG, "A.foo()")
        }
    }

    interface B {

        open fun foo() {
            Log.d(TAG, "B.foo()")
        }
    }

    class C: A(), B {

        override fun foo() {
            super<A>.foo()
            super<B>.foo()
        }
    }
}