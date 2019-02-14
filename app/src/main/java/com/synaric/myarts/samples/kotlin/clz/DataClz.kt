package com.synaric.myarts.samples.kotlin.clz

import android.util.Log
import com.synaric.myarts.samples.kotlin.Base

object DataClz: Base() {

    override fun run() {
        val book = Book("ha", "i")
        Log.d(TAG, book.toString())

        var b1 = Book("b", "1")
        var b2 = Book("b", "1")
        var b3 = Book("b", "1")

        // 测试相等性判断
        b1.code = "1"
        b2.code = "2"
        b3.code = "1"
        Log.d(TAG, "b1 == b2: ${b1 == b2}") // true
        Log.d(TAG, "b1 == b3: ${b1 == b3}") // true

        // 测试相等性判断
        // 对于类似Int?的类型，调用java的自动装箱，而Integer.valueOf在-127~128有特殊处理，因此有不同的行为
        Log.d(TAG, "test == and ===")
        test1()
        test2()
        test3()
        test4()
        test5()

        // 解构
        val (name, author) = book
        Log.d(TAG, "Book: $name, $author")

        // 拷贝
        val newBook = book.copy(name = "hahahaha")
        Log.d(TAG, "new book: $newBook")
    }

    data class Book(var name: String, var author: String) {

        // 对于那些自动生成的函数，编译器只使用在主构造函数内部定义的属性
        var code: String = ""
    }

    private fun test1() {
        // val a: Int = 100
        val b: Int = 100
        val c: Int = 100
        val d: Int = 1000
        val e: Int = 1000
        Log.d(TAG, "b == c: ${b == c}")     // true
        Log.d(TAG, "b === c: ${b === c}")   // true
        Log.d(TAG, "d == e: ${d == e}")     // true
        Log.d(TAG, "d === e: ${d === e}")   // true
    }

    private fun test2() {
        val a: Int = 100
        val b: Int? = a
        val c: Int? = a
        Log.d(TAG, "b == c: ${b == c}")     // true
        Log.d(TAG, "b === c: ${b === c}")   // true
    }

    private fun test3() {
        val a: Int = 1000
        val b: Int? = a
        val c: Int? = a
        Log.d(TAG, "b == c: ${b == c}")     // true
        Log.d(TAG, "b === c: ${b === c}")   // false
    }

    private fun test4() {
        val a: Int? = 100
        val b: Int? = a
        val c: Int? = a
        Log.d(TAG, "b == c: ${b == c}")     // true
        Log.d(TAG, "b === c: ${b === c}")   // true
    }

    private fun test5() {
        val a: Int? = 1000
        val b: Int? = a
        val c: Int? = a
        Log.d(TAG, "b == c: ${b == c}")     // true
        Log.d(TAG, "b === c: ${b === c}")   // true
    }
}