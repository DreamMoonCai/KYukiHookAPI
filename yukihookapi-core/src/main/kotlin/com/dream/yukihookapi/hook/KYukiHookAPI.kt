package com.dream.yukihookapi.hook

import android.app.Application
import android.content.Context
import com.dream.yukihookapi.hook.entity.KYukiBaseHooker
import com.dream.yukihookapi.hook.factory.kotlin
import com.dream.yukihookapi.hook.param.KPackageParam
import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.param.PackageParam

/**
 * [KYukiHookAPI] 的装载调用类
 *
 * [YukiHookAPI] 的 Kotlin 版本封装
 */
object KYukiHookAPI {

    /**
     * 作为 Xposed 模块装载调用入口方法
     *
     * 基于 [YukiHookAPI.encase]
     *
     * @param initiate Hook 方法体
     */
    fun encaseKotlin(initiate: KPackageParam.() -> Unit) {
        YukiHookAPI.encase{
            initiate(this.kotlin)
        }
    }

    /**
     * 作为 Xposed 模块装载调用入口方法
     *
     * 基于 [YukiHookAPI.encase]
     *
     * @param hooker Hook 子类数组 - 必填不能为空
     * @throws IllegalStateException 如果 [hooker] 是空的
     */
    fun encaseKotlin(vararg hooker: KYukiBaseHooker) {
        YukiHookAPI.encase(*hooker.map {
            object : YukiBaseHooker() {
                override fun onHook() {
                    it.assignInstance(this.kotlin)
                }
            }
        }.toTypedArray())
    }

    /**
     * 作为 [Application] 装载调用入口方法
     *
     * 基于 [YukiHookAPI.encase]
     *
     * @param baseContext Hook 所在的 [Context] - 可为空
     * @param initiate Hook 方法体
     */
    fun encaseKotlin(baseContext: Context?, initiate: KPackageParam.() -> Unit) {
        YukiHookAPI.encase(baseContext) {
            initiate(this.kotlin)
        }
    }

    /**
     * 作为 [Application] 装载调用入口方法
     *
     * 基于 [YukiHookAPI.encase]
     *
     * @param baseContext Hook 所在的 [Context] - 可为空
     * @param hooker Hook 子类数组 - 必填不能为空
     * @throws IllegalStateException 如果 [hooker] 是空的
     */
    fun encaseKotlin(baseContext: Context?, vararg hooker: KYukiBaseHooker) {
        YukiHookAPI.encase(baseContext, *hooker.map {
            object : YukiBaseHooker() {
                override fun onHook() {
                    it.assignInstance(this.kotlin)
                }
            }
        }.toTypedArray())
    }
}