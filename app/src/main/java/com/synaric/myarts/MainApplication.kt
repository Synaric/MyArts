package com.synaric.myarts

class MainApplication: FrameworkApplication() {

    override fun onCreate() {
        super.onCreate()
        isDebug = BuildConfig.DEBUG
        this.initBugly(BuildConfig.BUGLY_APP_ID)
    }
}