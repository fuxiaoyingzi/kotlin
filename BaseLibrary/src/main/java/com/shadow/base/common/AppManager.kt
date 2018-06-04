package com.shadow.base.common

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * Author : shadow
 * Desc :
 * Date :2018/6/4/004
 */
class AppManager private constructor() {
    /**
     * 单例模式
     */
    companion object {
        val instance: AppManager by lazy {
            AppManager()
        }
    }

    private var activityStack: Stack<Activity> = Stack()

    /**
     * 入栈
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /**
     * 出栈
     */
    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    /**
     * 栈顶数据
     */
    fun currentActivity(): Activity {
        return activityStack.lastElement()
    }

    /**
     * 关闭所有的activity
     */
    fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }

    /**
     * 退出程序
     */
    @SuppressLint("MissingPermission")
    fun exitApp(context: Context) {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }
}