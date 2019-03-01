package com.synaric.myarts.samples.kotlin.clz

import android.util.Log
import com.synaric.myarts.samples.kotlin.Base
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object DelegatedProperties: Base() {

    val a: String by lazy {
        Log.d(TAG, "lazy property init")
        "aaa"
    }

    class Delegate1: ReadWriteProperty<A, String> {
        override fun getValue(thisRef: A, property: KProperty<*>): String {
            Log.d(TAG, "get $thisRef  $property")
            return ""
        }
        override fun setValue(thisRef: A, property: KProperty<*>, value: String) {
            Log.d(TAG, "set $thisRef  $value")
        }
    }

    class A(map: Map<String, Any?>) {

        // 构造函数传入一个map，各字段根据map初始化
        val p1: String by map
        val p2: String by map
        // 演示get与set的监听
        var p3: String by Delegate1()
    }

    override fun run() {
        val a = this.a
        val b = this.a

        val a2 = A(mapOf("p1" to "p1 value", "p2" to "p2 value"))
        a2.p3 = "p3"
        Log.d(TAG, a2.p3)
    }
}