package com.synaric.myarts

import android.app.Application
import android.content.Context
import com.tencent.bugly.crashreport.CrashReport
import android.text.TextUtils
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import com.tencent.bugly.crashreport.CrashReport.UserStrategy




open class FrameworkApplication: Application() {

    protected var isDebug: Boolean = true

    protected fun initBugly(appId: String) {
        val context = applicationContext
        val packageName = context.packageName
        val processName = this.getProcessName(android.os.Process.myPid())
        val strategy = UserStrategy(context)
        strategy.isUploadProcess = processName == null || processName == packageName
        CrashReport.initCrashReport(applicationContext, appId, isDebug, strategy)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        // Multidex.install(this)
    }

    protected fun getProcessName(pid: Int): String? {
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(FileReader("/proc/$pid/cmdline"))
            var processName = reader.readLine()
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim({ it <= ' ' })
            }
            return processName
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        } finally {
            try {
                if (reader != null) {
                    reader.close()
                }
            } catch (exception: IOException) {
                exception.printStackTrace()
            }

        }
        return null
    }
}