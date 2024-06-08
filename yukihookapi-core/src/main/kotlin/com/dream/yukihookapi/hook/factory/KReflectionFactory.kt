@file:Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE", "NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
package com.dream.yukihookapi.hook.factory

import com.dream.yukihookapi.hook.core.KCallableHookCreator
import com.dream.yukihookapi.hook.param.KHookParam
import com.dream.yukihookapi.hook.param.KPackageParam
import com.highcapable.yukihookapi.hook.core.YukiMemberHookCreator
import com.highcapable.yukihookapi.hook.param.HookParam
import com.highcapable.yukihookapi.hook.param.PackageParam

/**
 * 将原版 [PackageParam] 转换为 Kotlin 拓展式 [KPackageParam]
 */
val PackageParam.kotlin get() = KPackageParam(this)

/**
 * 将原版 [YukiMemberHookCreator.MemberHookCreator] 转换为 Kotlin 拓展式 [KCallableHookCreator]
 */
val YukiMemberHookCreator.MemberHookCreator.kotlin get() = KCallableHookCreator(this)

/**
 * 将原版 [HookParam] 转换为 Kotlin 拓展式 [KHookParam]
 */
val HookParam.kotlin get() = KHookParam.create(this)

/**
 * 将原版 [YukiMemberHookCreator.MemberHookCreator.Result] 转换为 Kotlin 拓展式 [KCallableHookCreator.Result]
 */
val YukiMemberHookCreator.MemberHookCreator.Result.kotlin get() = KCallableHookCreator.Result(this)