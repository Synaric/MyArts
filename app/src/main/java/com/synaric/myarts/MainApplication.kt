package com.synaric.myarts

class MainApplication: FrameworkApplication() {

    override fun onCreate() {
        super.onCreate()
        isDebug = BuildConfig.DEBUG
        this.initBugly("MyArts")
        this.initLogger(BuildConfig.BUGLY_APP_ID)
    }
}