@file:Suppress("NOTHING_TO_INLINE", "NON_PUBLIC_CALL_FROM_PUBLIC_INLINE","INVISIBLE_REFERENCE","INVISIBLE_MEMBER")

package io.github.dreammooncai.yukihookapi.kt.param

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.dreammooncai.yukihookapi.kt.core.KCallableHookCreator
import io.github.dreammooncai.yukihookapi.kt.entity.KYukiBaseHooker
import io.github.dreammooncai.yukihookapi.kt.factory.kotlin
import io.github.dreammooncai.yukihookapi.kt.factory.yuki
import io.github.dreammooncai.yukireflection.build.KTypeBuild
import io.github.dreammooncai.yukireflection.factory.*
import io.github.dreammooncai.yukireflection.finder.base.KBaseFinder
import io.github.dreammooncai.yukireflection.finder.callable.KConstructorFinder
import io.github.dreammooncai.yukireflection.finder.callable.KFunctionFinder
import io.github.dreammooncai.yukireflection.finder.callable.KPropertyFinder
import io.github.dreammooncai.yukireflection.finder.classes.KClassFinder
import io.github.dreammooncai.yukireflection.type.android.*
import io.github.dreammooncai.yukireflection.type.kotlin.IntArrayKType
import io.github.dreammooncai.yukireflection.type.kotlin.IntKType
import io.github.dreammooncai.yukireflection.type.kotlin.StringArrayKClass
import com.highcapable.yukihookapi.hook.core.YukiMemberHookCreator.MemberHookCreator.HookCallback
import com.highcapable.yukihookapi.hook.core.api.priority.YukiHookPriority
import com.highcapable.yukihookapi.hook.core.finder.base.BaseFinder
import com.highcapable.yukihookapi.hook.core.finder.members.ConstructorFinder
import com.highcapable.yukihookapi.hook.core.finder.members.FieldFinder
import com.highcapable.yukihookapi.hook.core.finder.members.MethodFinder
import com.highcapable.yukihookapi.hook.param.PackageParam
import com.highcapable.yukihookapi.hook.param.wrapper.PackageParamWrapper
import io.github.dreammooncai.yukihookapi.kt.factory.attach
import io.github.dreammooncai.yukihookapi.kt.factory.attachEmptyParam
import io.github.dreammooncai.yukihookapi.kt.factory.attachStatic
import io.github.dreammooncai.yukireflection.bean.KVariousClass
import io.github.dreammooncai.yukireflection.factory.allFunctionSignatures
import io.github.dreammooncai.yukireflection.factory.allPropertySignatures
import io.github.dreammooncai.yukireflection.factory.attach
import io.github.dreammooncai.yukireflection.factory.functionSignature
import io.github.dreammooncai.yukireflection.factory.hasFunctionSignature
import io.github.dreammooncai.yukireflection.factory.hasKClass
import io.github.dreammooncai.yukireflection.factory.hasPropertySignature
import io.github.dreammooncai.yukireflection.factory.propertySignature
import io.github.dreammooncai.yukireflection.factory.toKCallable
import io.github.dreammooncai.yukireflection.factory.toKClass
import io.github.dreammooncai.yukireflection.factory.toKClassOrNull
import io.github.dreammooncai.yukireflection.factory.toKFunction
import io.github.dreammooncai.yukireflection.factory.toKFunctionOrNull
import io.github.dreammooncai.yukireflection.factory.toKProperty
import io.github.dreammooncai.yukireflection.factory.toKPropertyOrNull
import io.github.dreammooncai.yukireflection.finder.signature.KFunctionSignatureFinder
import io.github.dreammooncai.yukireflection.finder.signature.KPropertySignatureFinder
import io.github.dreammooncai.yukireflection.finder.signature.support.KFunctionSignatureSupport
import io.github.dreammooncai.yukireflection.finder.signature.support.KPropertySignatureSupport
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty
import io.github.dreammooncai.yukireflection.finder.tools.KReflectionTool
import kotlin.reflect.KFunction0
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction3
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty2
import kotlin.reflect.full.valueParameters
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf

import io.github.dreammooncai.yukireflection.factory.toKClass as toKClassGlobal
import io.github.dreammooncai.yukireflection.factory.toKClassOrNull as toKClassGlobalOrNull
import io.github.dreammooncai.yukireflection.factory.toKCallable as toCallableGlobal
import io.github.dreammooncai.yukireflection.factory.toKCallableOrNull as toCallableGlobalOrNull
import io.github.dreammooncai.yukireflection.factory.toKFunction as toKFunctionGlobal
import io.github.dreammooncai.yukireflection.factory.toKFunctionOrNull as toKFunctionGlobalOrNull
import io.github.dreammooncai.yukireflection.factory.toKProperty as toKPropertyGlobal
import io.github.dreammooncai.yukireflection.factory.toKPropertyOrNull as toKPropertyGlobalOrNull
import io.github.dreammooncai.yukireflection.factory.lazyKClass as lazyKClassGlobal
import io.github.dreammooncai.yukireflection.factory.lazyKClassOrNull as lazyKClassGlobalOrNull
import io.github.dreammooncai.yukireflection.factory.hasKClass as hasKClassGlobalOrNull
import io.github.dreammooncai.yukireflection.factory.hasFunctionSignature as hasFunctionSignatureGlobal
import io.github.dreammooncai.yukireflection.factory.hasPropertySignature as hasPropertySignatureGlobal
import io.github.dreammooncai.yukireflection.factory.propertySignature as propertySignatureGlobal
import io.github.dreammooncai.yukireflection.factory.functionSignature as functionSignatureGlobal
import io.github.dreammooncai.yukireflection.factory.allFunctionSignatures as allFunctionSignaturesGlobal
import io.github.dreammooncai.yukireflection.factory.allPropertySignatures as allPropertySignaturesGlobal
import io.github.dreammooncai.yukireflection.factory.findClass as findClassGlobal
import io.github.dreammooncai.yukireflection.factory.attach as attachGlobal
import io.github.dreammooncai.yukireflection.factory.attachStatic as attachStaticGlobal
import io.github.dreammooncai.yukireflection.factory.attachEmptyParam as attachEmptyParamGlobal
import io.github.dreammooncai.yukihookapi.kt.factory.attach as attachGlobal
import io.github.dreammooncai.yukihookapi.kt.factory.attachStatic as attachStaticGlobal
import io.github.dreammooncai.yukihookapi.kt.factory.attachEmptyParam as attachEmptyParamGlobal

/**
 * 获取 Kotlin 拓展式 [PackageParam]
 *
 * @constructor 原版 [PackageParam]
 *
 * @param wrapper 原版 [PackageParam] 包装器
 */
open class KPackageParam internal constructor(wrapper: PackageParamWrapper? = null) : PackageParam(wrapper) {
    internal constructor(packageParam: PackageParam) : this(packageParam.wrapper)

    /**
     * 通用的[Suppress]过滤规则
     *
     * 这些规则同于快速参考与记忆部分规则
     *
     * 直接调用可能没有效果应该像下面这样写入字符串值
     *
     *     如:
     *     Suppress(Ignore.INVISIBLE_REFERENCE,Ignore.INVISIBLE_MEMBER)
     *     ->>
     *     Suppress("INVISIBLE_REFERENCE","INVISIBLE_MEMBER")
     */
    object Ignore {
        /**
         * 忽略父类依赖有问题的提示异常
         *
         * 这通常在反编译的代码引用中出现的异常
         *
         * 错误效果如下:
         *
         *     Cannot access 'xx.xxx.A' which is a supertype of 'xx.xxx.A'. Check your module classpath for missing or conflicting dependencies
         */
        const val MISSING_DEPENDENCY_SUPERCLASS = "MISSING_DEPENDENCY_SUPERCLASS"

        /**
         * 强制使用 internal 引用内容
         *
         * 往往需要同时引用 [INVISIBLE_MEMBER]
         *
         * 常用于引用内部模块获取class 如A::class
         *
         * 错误效果如下:
         *
         *     Cannot access 'A': it is internal in 'xx.xxx'
         */
        const val INVISIBLE_REFERENCE = "INVISIBLE_REFERENCE"

        /**
         * 强制使用 internal 成员内容
         *
         * 往往需要同时引用 [INVISIBLE_REFERENCE] 可能还额外需要 [NO_COMPANION_OBJECT]
         *
         * 注意:编译器无法获取内模块引用和成员所以涉及类型需指明
         *
         * 常用于引用内部模块获取其成员 如A::abc
         *
         * 此抑制并不稳定 不推荐使用 会有编译器的连带问题解决得不偿失
         *
         * 错误效果如下:
         *
         *     Cannot access 'xx': it is internal in 'A'
         */
        const val INVISIBLE_MEMBER = "INVISIBLE_MEMBER"

        /**
         * 强制在没有伴生对象的类使用表达式
         *
         * 错误效果如下:
         *
         *     Classifier 'class A' does not have a companion object, so it cannot be used as an expression.
         */
        const val NO_COMPANION_OBJECT = "NO_COMPANION_OBJECT"

        /**
         * 强制允许私有内容被内联使用
         *
         * 错误效果如下:
         *
         *     Public-API inline function cannot access non-public-API 'private xx xx x: Member defined in xx.xxx.A'
         */
        const val NON_PUBLIC_CALL_FROM_PUBLIC_INLINE = "NON_PUBLIC_CALL_FROM_PUBLIC_INLINE"
    }

    /**
     * 装载并 Hook 指定包名的 APP
     *
     * 若要装载 APP Zygote 事件 - 请使用 [loadZygote]
     *
     * 若要 Hook 系统框架 - 请使用 [loadSystem]
     * @param name 包名
     * @param initiate 方法体
     */
    inline fun loadAppKotlin(name: String, initiate: KPackageParam.() -> Unit) {
        loadApp(name){initiate()}
    }

    /**
     * 装载并 Hook 指定包名的 APP
     *
     * 若要装载 APP Zygote 事件 - 请使用 [loadZygote]
     *
     * 若要 Hook 系统框架 - 请使用 [loadSystem]
     * @param name 包名数组
     * @param initiate 方法体
     */
    inline fun loadAppKotlin(vararg name: String, initiate: KPackageParam.() -> Unit) {
        loadApp(*name){initiate()}
    }

    /**
     * 装载并 Hook 指定包名的 APP
     *
     * 若要装载 APP Zygote 事件 - 请使用 [loadZygote]
     *
     * 若要 Hook 系统框架 - 请使用 [loadSystem]
     * @param name 包名
     * @param hooker Hook 子类
     */
    fun loadApp(name: String, hooker: KYukiBaseHooker) {
        loadApp(name, hooker.yuki)
    }

    /**
     * 装载并 Hook 指定包名的 APP
     *
     * 若要装载 APP Zygote 事件 - 请使用 [loadZygote]
     *
     * 若要 Hook 系统框架 - 请使用 [loadSystem]
     * @param name 包名 - 不填将过滤除了 [loadZygote] 事件外的全部 APP
     * @param hooker Hook 子类数组
     */
    fun loadApp(name: String, vararg hooker: KYukiBaseHooker) {
        loadApp(name, *hooker.yuki)
    }

    /**
     * 装载并 Hook 全部 APP
     *
     * 若要装载 APP Zygote 事件 - 请使用 [loadZygote]
     *
     * 若要 Hook 系统框架 - 请使用 [loadSystem]
     * @param isExcludeSelf 是否排除模块自身 - 默认否 - 启用后被 Hook 的 APP 将不包含当前模块自身
     * @param initiate 方法体
     */
    inline fun loadAppKotlin(isExcludeSelf: Boolean = false, initiate: KPackageParam.() -> Unit) {
        loadApp(isExcludeSelf){initiate()}
    }

    /**
     * 装载并 Hook 全部 APP
     *
     * 若要装载 APP Zygote 事件 - 请使用 [loadZygote]
     *
     * 若要 Hook 系统框架 - 请使用 [loadSystem]
     * @param isExcludeSelf 是否排除模块自身 - 默认否 - 启用后被 Hook 的 APP 将不包含当前模块自身
     * @param hooker Hook 子类
     */
    fun loadApp(isExcludeSelf: Boolean = false, hooker: KYukiBaseHooker) {
        loadApp(isExcludeSelf,hooker.yuki)
    }

    /**
     * 装载并 Hook 全部 APP
     *
     * 若要装载 APP Zygote 事件 - 请使用 [loadZygote]
     *
     * 若要 Hook 系统框架 - 请使用 [loadSystem]
     * @param isExcludeSelf 是否排除模块自身 - 默认否 - 启用后被 Hook 的 APP 将不包含当前模块自身
     * @param hooker Hook 子类数组
     */
    fun loadApp(isExcludeSelf: Boolean = false, vararg hooker: KYukiBaseHooker) {
        loadApp(isExcludeSelf,*hooker.yuki)
    }

    /**
     * 装载并 Hook 系统框架
     * @param initiate 方法体
     */
    inline fun loadSystemKotlin(initiate: KPackageParam.() -> Unit) = loadSystem {initiate()}

    /**
     * 装载并 Hook 系统框架
     * @param hooker Hook 子类
     */
    fun loadSystem(hooker: KYukiBaseHooker) = loadSystem(hooker.yuki)

    /**
     * 装载并 Hook 系统框架
     * @param hooker Hook 子类数组
     */
    fun loadSystem(vararg hooker: KYukiBaseHooker) {
        loadSystem(*hooker.yuki)
    }

    /**
     * 装载 APP Zygote 事件
     * @param initiate 方法体
     */
    inline fun loadZygoteKotlin(initiate: KPackageParam.() -> Unit) {
        loadZygote {initiate()}
    }

    /**
     * 装载 APP Zygote 事件
     * @param hooker Hook 子类
     */
    fun loadZygote(hooker: KYukiBaseHooker) {
        loadZygote(hooker.yuki)
    }

    /**
     * 装载 APP Zygote 事件
     * @param hooker Hook 子类数组
     */
    fun loadZygote(vararg hooker: KYukiBaseHooker) {
        loadZygote(*hooker.yuki)
    }

    /**
     * 装载并 Hook APP 的指定进程
     * @param name 进程名 - 若要指定主进程可填写 [mainProcessName] - 效果与 [isFirstApplication] 一致
     * @param initiate 方法体
     */
    inline fun withProcessKotlin(name: String, initiate: KPackageParam.() -> Unit) {
        withProcess(name){initiate()}
    }

    /**
     * 装载并 Hook APP 的指定进程
     * @param name 进程名数组 - 若要指定主进程可填写 [mainProcessName] - 效果与 [isFirstApplication] 一致
     * @param initiate 方法体
     */
    inline fun withProcessKotlin(vararg name: String, initiate: KPackageParam.() -> Unit) {
        withProcess(*name){initiate()}
    }

    /**
     * 装载并 Hook APP 的指定进程
     * @param name 进程名 - 若要指定主进程可填写 [mainProcessName] - 效果与 [isFirstApplication] 一致
     * @param hooker Hook 子类
     */
    fun withProcess(name: String, hooker: KYukiBaseHooker) {
        withProcess(name,hooker.yuki)
    }

    /**
     * 装载并 Hook APP 的指定进程
     * @param name 进程名 - 若要指定主进程可填写 [mainProcessName] - 效果与 [isFirstApplication] 一致
     * @param hooker Hook 子类数组
     */
    fun withProcess(name: String, vararg hooker: KYukiBaseHooker) {
        withProcess(name,*hooker.yuki)
    }

    /**
     * 装载 Hook 子类
     *
     * 你可以在 Hooker 中继续装载 Hooker
     * @param hooker Hook 子类
     */
    fun loadHooker(hooker: KYukiBaseHooker) {
        loadHooker(hooker.yuki)
    }

    /**
     * [javaMember]
     */
    private val KCallable<*>.javaMemberNotNull get() = javaSignatureMember ?: refImpl?.javaSignatureMember ?: error("Unable Convert Java Member !")

    /**
     * 直接 Hook 方法、构造方法
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @return [KCallableHookCreator.Result]
     */
    inline fun KCallable<*>.hook(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT
    ) = javaMemberNotNull.hook(priority).kotlin

    /**
     * 直接 Hook 方法、构造方法
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @param initiate 方法体
     * @return [KCallableHookCreator.Result]
     */
    inline fun KCallable<*>.hook(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        initiate: KCallableHookCreator.() -> Unit
    ) = javaMemberNotNull.hook(priority) {
        initiate(this.kotlin)
    }.kotlin

    /**
     * 直接 Hook 方法、构造方法
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @return [KCallableHookCreator.Result]
     */
    inline fun KPropertySignatureSupport.hook(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT
    ) = member.hook(priority).kotlin

    /**
     * 直接 Hook 方法、构造方法
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @param initiate 方法体
     * @return [KCallableHookCreator.Result]
     */
    inline fun KPropertySignatureSupport.hook(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        initiate: KCallableHookCreator.() -> Unit
    ) = member.hook(priority) {
        initiate(this.kotlin)
    }.kotlin

    /**
     * 直接 Hook 方法、构造方法
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @return [KCallableHookCreator.Result]
     */
    inline fun KFunctionSignatureSupport.hook(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT
    ) = member.hook(priority).kotlin

    /**
     * 直接 Hook 方法、构造方法
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @param initiate 方法体
     * @return [KCallableHookCreator.Result]
     */
    inline fun KFunctionSignatureSupport.hook(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        initiate: KCallableHookCreator.() -> Unit
    ) = member.hook(priority) {
        initiate(this.kotlin)
    }.kotlin

    /**
     * 通过 [BaseFinder.BaseResult] 直接 Hook 方法、构造方法
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param isMultiple 是否为多重查找
     * @param priority Hook 优先级
     * @return [KCallableHookCreator]
     */
    private fun KBaseFinder.BaseResult.baseHook(isMultiple: Boolean, priority: YukiHookPriority) =
        when (this) {
            is KClassFinder.Result, is KTypeBuild.Result ->
                error("Use of searchClass { ... }.hook { ... } is an error, please use like searchClass { ... }.get()?.hook { ... }")

            is KConstructorFinder.Result -> {
                if (isMultiple) giveAll().hookAll(priority) else give()?.hook(priority) ?: arrayListOf<KCallable<*>>().hookAll(priority)
            }

            is KFunctionFinder.Result -> {
                if (isMultiple) giveAll().hookAll(priority) else give()?.hook(priority) ?: arrayListOf<KCallable<*>>().hookAll(priority)
            }

            is KPropertyFinder.Result -> {
                if (isMultiple) giveAll().hookAll(priority) else give()?.hook(priority) ?: arrayListOf<KCallable<*>>().hookAll(priority)
            }

            is KPropertySignatureFinder.Result -> {
                if (isMultiple) giveAll().hookAll(priority) else give()?.hook(priority) ?: arrayListOf<KPropertySignatureSupport>().hookAll(priority)
            }

            is KFunctionSignatureFinder.Result -> {
                if (isMultiple) giveAll().hookAll(priority) else give()?.hook(priority) ?: arrayListOf<KFunctionSignatureSupport>().hookAll(priority)
            }

            else -> error("This type [$this] not support to hook, supported are Constructors and Methods")
        }

    /**
     * 通过 [KBaseFinder.BaseResult] 直接 Hook 方法、构造方法
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @return [KCallableHookCreator]
     */
    inline fun KBaseFinder.BaseResult.hook(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT
    ) = baseHook(isMultiple = false, priority)

    /**
     * 通过 [KBaseFinder.BaseResult] 直接 Hook 方法、构造方法
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @param initiate 方法体
     * @return [KCallableHookCreator.Result]
     */
    inline fun KBaseFinder.BaseResult.hook(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        noinline initiate: KCallableHookCreator.() -> Unit
    ) = baseHook(isMultiple = false, priority).apply(initiate).build()

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @return [KCallableHookCreator]
     */
    @JvmName("hookAll_KCallable")
    inline fun Array<KCallable<*>>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT
    ) = map { it.javaMemberNotNull }.hookAll(priority).kotlin

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @param initiate 方法体
     * @return [KCallableHookCreator.Result]
     */
    @JvmName("hookAll_KCallable")
    inline fun Array<KCallable<*>>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        initiate: KCallableHookCreator.() -> Unit
    ) = map { it.javaMemberNotNull }.hookAll(priority) { initiate(this.kotlin) }.kotlin

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @return [KCallableHookCreator]
     */
    @JvmName("hookAll_KCallable")
    inline fun List<KCallable<*>>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
    ) = map { it.javaMemberNotNull }.hookAll(priority).kotlin

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @param initiate 方法体
     * @return [KCallableHookCreator.Result]
     */
    @JvmName("hookAll_KCallable")
    inline fun List<KCallable<*>>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        initiate: KCallableHookCreator.() -> Unit
    ) = map { it.javaMemberNotNull }.hookAll(priority) { initiate(this.kotlin) }.kotlin

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @return [KCallableHookCreator]
     */
    @JvmName("hookAll_KPropertySignatureSupport")
    inline fun Array<KPropertySignatureSupport>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT
    ) = map { it.member }.hookAll(priority).kotlin

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @param initiate 方法体
     * @return [KCallableHookCreator.Result]
     */
    @JvmName("hookAll_KPropertySignatureSupport")
    inline fun Array<KPropertySignatureSupport>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        initiate: KCallableHookCreator.() -> Unit
    ) = map { it.member }.hookAll(priority) { initiate(this.kotlin) }.kotlin

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @return [KCallableHookCreator]
     */
    @JvmName("hookAll_KPropertySignatureSupport")
    inline fun List<KPropertySignatureSupport>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
    ) = map { it.member }.hookAll(priority).kotlin

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @param initiate 方法体
     * @return [KCallableHookCreator.Result]
     */
    @JvmName("hookAll_KPropertySignatureSupport")
    inline fun List<KPropertySignatureSupport>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        initiate: KCallableHookCreator.() -> Unit
    ) = map { it.member }.hookAll(priority) { initiate(this.kotlin) }.kotlin

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @return [KCallableHookCreator]
     */
    @JvmName("hookAll_KFunctionSignatureSupport")
    inline fun Array<KFunctionSignatureSupport>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT
    ) = map { it.member }.hookAll(priority).kotlin

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @param initiate 方法体
     * @return [KCallableHookCreator.Result]
     */
    @JvmName("hookAll_KFunctionSignatureSupport")
    inline fun Array<KFunctionSignatureSupport>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        initiate: KCallableHookCreator.() -> Unit
    ) = map { it.member }.hookAll(priority) { initiate(this.kotlin) }.kotlin

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @return [KCallableHookCreator]
     */
    @JvmName("hookAll_KFunctionSignatureSupport")
    inline fun List<KFunctionSignatureSupport>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
    ) = map { it.member }.hookAll(priority).kotlin

    /**
     * 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @param initiate 方法体
     * @return [KCallableHookCreator.Result]
     */
    @JvmName("hookAll_KFunctionSignatureSupport")
    inline fun List<KFunctionSignatureSupport>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        initiate: KCallableHookCreator.() -> Unit
    ) = map { it.member }.hookAll(priority) { initiate(this.kotlin) }.kotlin

    /**
     * 通过 [KBaseFinder.BaseResult] 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @return [KCallableHookCreator]
     */
    inline fun KBaseFinder.BaseResult.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT
    ) = baseHook(isMultiple = true, priority)

    /**
     * 通过 [KBaseFinder.BaseResult] 直接 Hook 方法、构造方法 (批量)
     *
     * - 此功能尚在实验阶段 - 在 1.x.x 版本将暂定于此 - 在 2.0.0 版本将完全合并到新 API
     * @param priority Hook 优先级 - 默认为 [YukiHookPriority.DEFAULT]
     * @param initiate 方法体
     * @return [KCallableHookCreator.Result]
     */
    inline fun KBaseFinder.BaseResult.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        noinline initiate: KCallableHookCreator.() -> Unit
    ) = baseHook(isMultiple = true, priority).apply(initiate).build()

    /**
     * 通过 [KVariousClass] 获取 [KClass]
     * @param loader [KClass] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @return [KClass]
     * @throws NoClassDefFoundError 如果找不到 [KClass] 或设置了错误的 [ClassLoader]
     */
    inline fun KVariousClass.toKClass(loader: ClassLoader? = appClassLoader, initialize: Boolean = false) = toKClassGlobal(loader,initialize)

    /**
     * 通过 [KVariousClass] 获取 [KClass]
     *
     * 找不到 [KClass] 会返回 null - 不会抛出异常
     * @param loader [KClass] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @return [KClass] or null
     */
    inline fun KVariousClass.toKClassOrNull(loader: ClassLoader? = appClassLoader, initialize: Boolean = false) = toKClassGlobalOrNull(loader,initialize)

    /**
     * 通过字符串类名转换为 [loader] 中的实体类
     * @param loader [KClass] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @return [KClass]
     * @throws NoClassDefFoundError 如果找不到 [KClass] 或设置了错误的 [ClassLoader]
     */
    inline fun String.toKClass(loader: ClassLoader? = appClassLoader, initialize: Boolean = false) =
        toKClassGlobal(loader, initialize)

    /**
     * 通过字符串类名转换为 [loader] 中的实体类
     * @param loader [KClass] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @return [KClass]<[T]>
     * @throws NoClassDefFoundError 如果找不到 [KClass] 或设置了错误的 [ClassLoader]
     * @throws IllegalStateException 如果 [KClass] 的类型不为 [T]
     */
    @JvmName("toKClass_Generics")
    inline fun <reified T> String.toKClass(loader: ClassLoader? = appClassLoader, initialize: Boolean = false) =
        toKClassGlobal(loader, initialize)

    /**
     * 通过字符串类名转换为 [loader] 中的实体类
     *
     * 找不到 [KClass] 会返回 null - 不会抛出异常
     * @param loader [KClass] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @return [KClass] or null
     */
    inline fun String.toKClassOrNull(loader: ClassLoader? = appClassLoader, initialize: Boolean = false) = toKClassGlobalOrNull(loader,initialize)

    /**
     * 通过字符串类名转换为 [loader] 中的实体类
     *
     * 找不到 [KClass] 会返回 null - 不会抛出异常
     * @param loader [KClass] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @return [KClass]<[T]> or null
     */
    @JvmName("toKClassOrNull_Generics")
    inline fun <reified T> String.toKClassOrNull(loader: ClassLoader? = appClassLoader, initialize: Boolean = false) =
        toKClassGlobalOrNull(loader, initialize)

    /**
     * 通过此[KClass]的字符串类名转换为 [loader] 中的实体类 - 意为重新获取
     * @param loader [KClass] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @return [KClass]
     * @throws NoClassDefFoundError 如果找不到 [KClass] 或设置了错误的 [ClassLoader]
     */
    inline fun KClass<*>.toKClass(loader: ClassLoader? = appClassLoader, initialize: Boolean = false) = toKClassGlobal(loader, initialize)

    /**
     * 通过此[KClass]的字符串类名转换为 [loader] 中的实体类 - 意为重新获取
     * @param loader [KClass] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @return [KClass]<[T]>
     * @throws NoClassDefFoundError 如果找不到 [KClass] 或设置了错误的 [ClassLoader]
     * @throws IllegalStateException 如果 [KClass] 的类型不为 [T]
     */
    @JvmName("toKClass_Generics")
    inline fun <reified T> KClass<T & Any>.toKClass(loader: ClassLoader? = appClassLoader, initialize: Boolean = false) =
        toKClassGlobal<T>(loader, initialize)

    /**
     * 通过此[KClass]的字符串类名转换为 [loader] 中的实体类 - 意为重新获取
     *
     * 找不到 [KClass] 会返回 null - 不会抛出异常
     * @param loader [KClass] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @return [KClass] or null
     */
    inline fun KClass<*>.toKClassOrNull(loader: ClassLoader? = appClassLoader, initialize: Boolean = false) = toKClassGlobalOrNull(loader,initialize)

    /**
     * 通过此[KClass]的字符串类名转换为 [loader] 中的实体类 - 意为重新获取
     *
     * 找不到 [KClass] 会返回 null - 不会抛出异常
     * @param loader [KClass] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @return [KClass]<[T]> or null
     */
    @JvmName("toKClassOrNull_Generics")
    inline fun <reified T> KClass<T & Any>.toKClassOrNull(loader: ClassLoader? = appClassLoader, initialize: Boolean = false) =
        toKClassGlobalOrNull<T>(loader, initialize)

    /**
     * 通过 [clazz] 和 [this] 获取其中的 [KCallable]
     *
     * [loader] 也会作用于所有涉及的类型如 返回类型 参数类型等
     *
     * @param K [this] 支持重新获取可调用实例
     * @param V 可调用实例的返回值
     * @param clazz 指定在哪个类下进行 [KCallable] 获取，默认为 [declaringClass] - 涉及类必须在 [loader] 中否则会抛出 [NoClassDefFoundError]
     * @param loader [clazz] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否使用Java方式反射获取参数名和参数类型 - 默认否
     * @return [KCallable] 新获取到的可调用实例
     */
    inline fun <K:KCallable<V>,V> K.toKCallable(clazz: KClass<*>? = null,loader: ClassLoader? = appClassLoader,isUseMember: Boolean = false): K = toCallableGlobal(clazz,loader,isUseMember)

    /**
     * 通过 [clazz] 和 [this] 获取其中的 [KCallable]
     *
     * [loader] 也会作用于所有涉及的类型如 返回类型 参数类型等
     *
     * 获取不到 [KCallable] 会返回 null - 不会抛出异常
     * @param K [this] 支持重新获取可调用实例
     * @param V 可调用实例的返回值
     * @param clazz 指定在哪个类下进行 [KCallable] 获取，默认为 [declaringClass] - 涉及类必须在 [loader] 中否则会返回 null
     * @param loader [clazz] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否使用Java方式反射获取参数名和参数类型 - 默认否
     * @return [KCallable] 新获取到的可调用实例 or null
     */
    inline fun <K:KCallable<V>,V> K.toKCallableOrNull(clazz: KClass<*>? = null,loader: ClassLoader? = appClassLoader,isUseMember: Boolean = false) = toCallableGlobalOrNull(clazz,loader,isUseMember)

    /**
     * 通过 [clazz] 和 [this] 获取其中的 [KProperty]
     *
     * [loader] 也会作用于所有涉及的类型如 返回类型 参数类型等
     *
     * @param K [this] 支持重新获取可调用实例
     * @param V 可调用实例的返回值
     * @param clazz 指定在哪个类下进行 [KProperty] 获取，默认为 [declaringClass] - 涉及类必须在 [loader] 中否则会抛出 [NoClassDefFoundError]
     * @param loader [clazz] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否使用Java方式反射获取参数名和参数类型 - 默认否
     * @return [KProperty] 新获取到的可调用实例
     */
    inline fun <K: KProperty<V>,V> K.toKProperty(clazz: KClass<*>? = null, loader: ClassLoader? = appClassLoader, isUseMember: Boolean = false): K = toKPropertyGlobal()

    /**
     * 通过 [clazz] 和 [this] 获取其中的 [KProperty]
     *
     * [loader] 也会作用于所有涉及的类型如 返回类型 参数类型等
     *
     * 获取不到 [KProperty] 会返回 null - 不会抛出异常
     * @param K [this] 支持重新获取可调用实例
     * @param V 可调用实例的返回值
     * @param clazz 指定在哪个类下进行 [KProperty] 获取，默认为 [declaringClass] - 涉及类必须在 [loader] 中否则会返回 null
     * @param loader [clazz] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否使用Java方式反射获取参数名和参数类型 - 默认否
     * @return [KProperty] 新获取到的可调用实例 or null
     */
    inline fun <K: KProperty<V>,V> K.toKPropertyOrNull(clazz: KClass<*>? = null, loader: ClassLoader? = appClassLoader, isUseMember: Boolean = false) = toKPropertyGlobalOrNull(clazz, loader, isUseMember)

    /**
     * 通过 [clazz] 和 [this] 获取其中的 [KFunction]
     *
     * [loader] 也会作用于所有涉及的类型如 返回类型 参数类型等
     *
     * @param K [this] 支持重新获取可调用实例
     * @param V 可调用实例的返回值
     * @param clazz 指定在哪个类下进行 [KFunction] 获取，默认为 [declaringClass] - 涉及类必须在 [loader] 中否则会抛出 [NoClassDefFoundError]
     * @param loader [clazz] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否使用Java方式反射获取参数名和参数类型 - 默认否
     * @return [KFunction] 新获取到的可调用实例
     */
    inline fun <K: KFunction<V>,V> K.toKFunction(clazz: KClass<*>? = null, loader: ClassLoader? = appClassLoader, isUseMember: Boolean = false): K = toKFunctionGlobal(clazz,loader,isUseMember)

    /**
     * 通过 [clazz] 和 [this] 获取其中的 [KFunction]
     *
     * [loader] 也会作用于所有涉及的类型如 返回类型 参数类型等
     *
     * 获取不到 [KFunction] 会返回 null - 不会抛出异常
     * @param K [this] 支持重新获取可调用实例
     * @param V 可调用实例的返回值
     * @param clazz 指定在哪个类下进行 [KFunction] 获取，默认为 [declaringClass] - 涉及类必须在 [loader] 中否则会返回 null
     * @param loader [clazz] 所在的 [ClassLoader] - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否使用Java方式反射获取参数名和参数类型 - 默认否
     * @return [KFunction] 新获取到的可调用实例 or null
     */
    inline fun <K: KFunction<V>,V> K.toKFunctionOrNull(clazz: KClass<*>? = null, loader: ClassLoader? = appClassLoader, isUseMember: Boolean = false) = toKFunctionGlobalOrNull(clazz,loader,isUseMember)

    /**
     * 懒装载 [KClass]
     * @param name 完整类名
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @return [KLazyClass.NonNull]
     */
    fun lazyKClass(name: String, initialize: Boolean = false, loader: () -> ClassLoader? = { appClassLoader }) =
        lazyKClassGlobal(name, initialize, loader)

    /**
     * 懒装载 [KClass]<[T]>
     * @param name 完整类名
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @return [KLazyClass.NonNull]<[T]>
     */
    @JvmName("lazyClass_Generics")
    inline fun <reified T> lazyKClass(name: String, initialize: Boolean = false, noinline loader: () -> ClassLoader? = { appClassLoader }) =
        lazyKClassGlobal<T>(name, initialize, loader)

    /**
     * 懒装载 [KClass]
     * @param variousClass [KVariousClass]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @return [KLazyClass.NonNull]
     */
    fun lazyKClass(variousClass: KVariousClass, initialize: Boolean = false, loader: () -> ClassLoader? = { appClassLoader }) =
        lazyKClassGlobal(variousClass, initialize, loader)

    /**
     * 懒装载 [KClass]
     * @param name 完整类名
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @return [KLazyClass.Nullable]
     */
    fun lazyKClassOrNull(name: String, initialize: Boolean = false, loader: () -> ClassLoader? = { appClassLoader }) =
        lazyKClassGlobalOrNull(name, initialize, loader)

    /**
     * 懒装载 [KClass]<[T]>
     * @param name 完整类名
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @return [KLazyClass.Nullable]<[T]>
     */
    @JvmName("lazyClassOrNull_Generics")
    inline fun <reified T> lazyKClassOrNull(name: String, initialize: Boolean = false, noinline loader: () -> ClassLoader? = { appClassLoader }) =
        lazyKClassGlobalOrNull<T>(name, initialize, loader)

    /**
     * 懒装载 [KClass]
     * @param variousClass [KVariousClass]
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @return [KLazyClass.Nullable]
     */
    fun lazyKClassOrNull(variousClass: KVariousClass, initialize: Boolean = false, loader: () -> ClassLoader? = { appClassLoader }) =
        lazyKClassGlobalOrNull(variousClass, initialize, loader)

    /**
     * 通过字符串类名使用指定的 [ClassLoader] 查找是否存在
     * @param loader [KClass] 所在的 [ClassLoader] - 不填使用 [appClassLoader]
     * @return [Boolean] 是否存在
     */
    inline fun String.hasKClass(loader: ClassLoader? = appClassLoader) = hasKClassGlobalOrNull(loader)

    /**
     * 查找变量签名是否存在
     * @param loader [KClass] 所在的 [ClassLoader] - 不填使用 [appClassLoader]
     * @param initiate 方法体
     * @return [Boolean] 是否存在
     */
    inline fun KClass<*>.hasPropertySignature(loader: ClassLoader? = appClassLoader,initiate: KPropertySignatureFinder.() -> Unit) = hasPropertySignatureGlobal(loader,initiate)

    /**
     * 查找方法签名是否存在
     * @param loader [KClass] 所在的 [ClassLoader] - 不填使用 [appClassLoader]
     * @param initiate 方法体
     * @return [Boolean] 是否存在
     */
    inline fun KClass<*>.hasFunctionSignature(loader: ClassLoader? = appClassLoader,initiate: KFunctionSignatureFinder.() -> Unit) = hasFunctionSignatureGlobal(loader,initiate)

    /**
     * 查找并得到方法签名
     *
     * 获取此 [KClass] 指定 [initiate] 条件的签名
     *
     * 此方法以通过 [Metadata] 中定义的属性名获取Java层真正的签名
     *
     * [KPropertySignatureFinder.() -> Unit] 中对属性类型进行筛选如果目标类型也有问题可能依然会出错，建议使用属性名筛选
     *
     * - 此方法不涉及转 Kotlin 的反射属性可以避免一些异常 [Metadata] 数据报错
     * @param loader [ClassLoader] 相关涉及的类型所在的 [ClassLoader] - 不填使用 [appClassLoader]
     * @param initiate 查找方法体
     * @return [KFunctionFinder.Result]
     */
    inline fun KClass<*>.propertySignature(loader: ClassLoader? = appClassLoader,initiate: KPropertySignatureFinder.() -> Unit = {}) = propertySignatureGlobal(loader,initiate)

    /**
     * 查找并得到方法签名
     *
     * 获取此 [KClass] 指定 [initiate] 条件的签名
     *
     * 此方法以通过 [Metadata] 中定义的函数名获取Java层真正的签名
     *
     * [KFunctionSignatureFinder.() -> Unit] 中对返回类型和参数类型进行筛选如果目标类型也有问题可能依然会出错，建议使用参数名筛选
     *
     * - 此方法不涉及转 Kotlin 的反射函数可以避免一些异常 [Metadata] 数据报错
     * @param loader [ClassLoader] 相关涉及的类型所在的 [ClassLoader] - 不填使用 [appClassLoader]
     * @param initiate 查找方法体
     * @return [KFunctionFinder.Result]
     */
    inline fun KClass<*>.functionSignature(loader: ClassLoader? = appClassLoader,initiate: KFunctionSignatureFinder.() -> Unit = {}) = functionSignatureGlobal(loader,initiate)

    /**
     * 遍历当前类中的所有方法签名
     * @param loader [ClassLoader] 方法参数 [KFunctionSignatureSupport.paramClasss] 所在的 [ClassLoader] - 不填使用 [appClassLoader]
     * @param result 回调 - ([Int] 下标,Constructor [KFunction] 实例)
     */
    inline fun KClass<*>.allFunctionSignatures(loader: ClassLoader? = appClassLoader,result: (index: Int, function: KFunctionSignatureSupport) -> Unit) =
        allFunctionSignaturesGlobal(loader, result)

    /**
     * 遍历当前类中的所有变量签名
     * @param loader loader [ClassLoader] - 属性类型所使用的 [ClassLoader] - 不填使用 [appClassLoader]
     * @param result 回调 - ([Int] 下标,[KProperty] 实例)
     */
    inline fun KClass<*>.allPropertySignatures(loader: ClassLoader? = appClassLoader,result: (index: Int, property: KPropertySignatureSupport) -> Unit) =
        allPropertySignaturesGlobal(loader, result)

    /**
     * 查找并得到类
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @param initiate 查找方法体
     * @return [KClassFinder.Result]
     */
    @JvmName("findClass_string")
    inline fun Collection<String>.findClass(loader: ClassLoader? = appClassLoader, initialize: Boolean = false, initiate: KClassFinder.() -> Unit) =
        findClassGlobal(loader, initialize, initiate)

    /**
     * 查找并得到类
     * @param initialize 是否初始化 [KClass] 的静态方法块 - 默认否
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @param initiate 查找方法体
     * @return [KClassFinder.Result]
     */
    @JvmName("findClass_string")
    inline fun Array<String>.findClass(loader: ClassLoader? = appClassLoader, initialize: Boolean = false, initiate: KClassFinder.() -> Unit) =
        findClassGlobal(loader, initialize, initiate)

    /**
     * 将此构造函数相关内容附加到此查找器
     *
     * 将影响[KConstructorFinder.param]
     *
     * @param R 返回类型/构造目标类的类型
     * @param loader 默认使用 [appClassLoader] ，如果使用 [ClassLoader] 将把涉及的类型，转换为指定 [ClassLoader] 中的 [KClass] 并且会擦除泛型
     * @param isUseMember 是否将构造函数转换为JavaMethod再进行附加 - 即使为false当构造函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    inline fun <R> KConstructorFinder.attach(function: KFunction<R>,loader: ClassLoader? = appClassLoader,isUseMember:Boolean = false) = attachGlobal(function, loader, isUseMember)

    /**
     * 将此属性相关内容附加到此查找器
     *
     * 将影响[KPropertyFinder.name]、[KPropertyFinder.type]
     *
     * 多个属性引用使用示例 ↓
     *
     * ```kotlin
     *
     *  class Main{
     *      var sub = ""
     *      companion object{
     *          var sub = 5
     *      }
     *  }
     *
     *  attach(Main::sub) // error:不知道附加哪个属性伴生对象情况下优先使用var sub = ""
     *  attach<Int>(Main::sub) // 将使用返回类型为Int的属性也就是伴生对象中的属性
     * ```
     *
     * @param R 属性类型
     * @param loader 默认使用 [appClassLoader] ，如果使用 [ClassLoader] 将把涉及的类型，转换为指定 [ClassLoader] 中的 [KClass] 并且会擦除泛型
     * @param isUseMember 是否将属性转换为JavaField再进行附加 - 即使为false当属性附加错误时依然会尝试JavaField - 为true时会导致类型擦除
     */
    inline fun <R> KPropertyFinder.attach(function: KProperty<R>,loader: ClassLoader? = appClassLoader,isUseMember:Boolean = false) = attachGlobal(function, loader, isUseMember)

    /**
     * 将此属性相关内容附加到此查找器
     *
     * 将影响[KPropertyFinder.name]、[KPropertyFinder.type]
     *
     * @param R 属性类型
     * @param loader 默认使用 [appClassLoader] ，如果使用 [ClassLoader] 将把涉及的类型，转换为指定 [ClassLoader] 中的 [KClass] 并且会擦除泛型
     * @param isUseMember 是否将属性转换为JavaField再进行附加 - 即使为false当属性附加错误时依然会尝试JavaField - 为true时会导致类型擦除
     */
    inline fun <R> KPropertyFinder.attachStatic(function: KProperty0<R>,loader: ClassLoader? = appClassLoader, isUseMember:Boolean = false) = attachStaticGlobal(function, loader, isUseMember)

    /**
     * 将此属性相关内容附加到此查找器
     *
     * 将影响[KPropertyFinder.name]、[KPropertyFinder.type]
     *
     * @param ExpandThis 拓展类的类型
     * @param R 属性类型
     * @param loader 默认使用 [appClassLoader] ，如果使用 [ClassLoader] 将把涉及的类型，转换为指定 [ClassLoader] 中的 [KClass] 并且会擦除泛型
     * @param isUseMember 是否将属性转换为JavaField再进行附加 - 即使为false当属性附加错误时依然会尝试JavaField - 为true时会导致类型擦除
     */
    inline fun <ExpandThis,R> KPropertyFinder.attach(function: KProperty2<*,ExpandThis,R>,loader: ClassLoader? = appClassLoader, isUseMember:Boolean = false) = attachGlobal(function, loader, isUseMember)

    /**
     * 将此函数相关内容附加到此查找器
     *
     * 将影响[KFunctionFinder.name]、[KFunctionFinder.returnType]、[KFunctionFinder.param]
     *
     * 重载引用使用示例 ↓
     *
     * ```kotlin
     *
     *  class Main{
     *      fun sub(a:Int):Int{}
     *
     *      fun sub(c:Double):String{}
     *  }
     *
     *  attach(Main::sub) // error:不知道附加哪个函数
     *  attach<String>(Main::sub) // 将使用返回类型为String的函数
     * ```
     *
     * @param R 返回类型
     * @param loader 默认使用 [appClassLoader] ，如果使用 [ClassLoader] 将把涉及的类型，转换为指定 [ClassLoader] 中的 [KClass] 并且会擦除泛型
     * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    @JvmName("attach_1")
    fun <R> KFunctionFinder.attach(function:KFunction<R>,loader: ClassLoader? = appClassLoader,isUseMember:Boolean = false) = attachGlobal(function, loader, isUseMember)

    /**
     * 将此函数相关内容附加到此查找器
     *
     * 将影响[KFunctionFinder.name]、[KFunctionFinder.returnType]、[KFunctionFinder.param]
     *
     * 重载引用使用示例 ↓
     *
     * ```java
     *
     *  class Main{
     *      public static void sub(){}
     *      public void sub(){}
     *  }
     *
     *  attach(Main::sub) // error:不知道附加哪个函数
     *  attachStatic(Main::sub) // 将使用静态sub
     * ```
     *
     * @param R 返回类型
     * @param loader 默认使用 [appClassLoader] ，如果使用 [ClassLoader] 将把涉及的类型，转换为指定 [ClassLoader] 中的 [KClass] 并且会擦除泛型
     * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    @JvmName("attachStatic_0")
    inline fun <R> KFunctionFinder.attachStatic(function:KFunction0<R>,loader: ClassLoader? = appClassLoader,isUseMember:Boolean = false) = attachStaticGlobal(function, loader, isUseMember)

    /**
     * 将此函数相关内容附加到此查找器
     *
     * 将影响[KFunctionFinder.name]、[KFunctionFinder.returnType]、[KFunctionFinder.param]
     *
     * 重载引用使用示例 ↓
     *
     * ```java
     *
     *  class Main{
     *      public void sub(a:Int):String{}
     *      public void sub():String{}
     *      public void sub(b:Int):Int{}
     *  }
     *
     *  attach<String>(Main::sub) // error:尽管筛选了返回值但依然不知道附加哪个函数
     *  attachEmptyParam(Main::sub) // 将使用没有参数sub
     * ```
     *
     * @param R 返回类型
     * @param loader 默认使用 [appClassLoader] ，如果使用 [ClassLoader] 将把涉及的类型，转换为指定 [ClassLoader] 中的 [KClass] 并且会擦除泛型
     * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    inline fun <R> KFunctionFinder.attachEmptyParam(function:KFunction1<*,R>,loader: ClassLoader? = appClassLoader,isUseMember:Boolean = false) = attachEmptyParamGlobal(function, loader, isUseMember)

    /**
     * 将此函数相关内容附加到此查找器 - 指定参数的快捷方法 参阅:[attach]
     *
     * 将影响[KFunctionFinder.name]、[KFunctionFinder.returnType]、[KFunctionFinder.param]
     *
     * 重载引用使用示例 ↓
     *
     * ```kotlin
     *
     *  class Main{
     *      fun sub(a:Int):Int{}
     *
     *      fun sub(c:Double):Int{}
     *  }
     *
     *  attach(Main::sub) // error:不知道附加哪个函数
     *  attach<Double,Int>(Main::sub) // 将使用第一个参数为Double返回类型为Int的函数
     * ```
     *
     * @param P1 第一个参数的类型
     * @param R 返回类型
     * @param loader 默认使用 [appClassLoader] ，如果使用 [ClassLoader] 将把涉及的类型，转换为指定 [ClassLoader] 中的 [KClass] 并且会擦除泛型
     * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    @JvmName("attach_2")
    inline fun <P1, R> KFunctionFinder.attach(function:KFunction2<*,P1, R>,loader: ClassLoader? = appClassLoader,isUseMember:Boolean = false) = attachGlobal(function, loader, isUseMember)

    /**
     * 将此函数相关内容附加到此查找器 - 指定参数的快捷方法 参阅:[attach]
     *
     * 将影响[KFunctionFinder.name]、[KFunctionFinder.returnType]、[KFunctionFinder.param]
     *
     * 重载引用参考[KFunctionFinder.attach]
     *
     * @param P1 第一个参数的类型
     * @param P2 第二个参数的类型
     * @param R 返回类型
     * @param loader 默认使用 [appClassLoader] ，如果使用 [ClassLoader] 将把涉及的类型，转换为指定 [ClassLoader] 中的 [KClass] 并且会擦除泛型
     * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    @JvmName("attach_3")
    inline fun <P1,P2,R> KFunctionFinder.attach(function:KFunction3<*,P1,P2,R>,loader: ClassLoader? = appClassLoader,isUseMember:Boolean = false) = attachGlobal(function, loader, isUseMember)

    /**
     * 将此构造函数相关内容附加到此查找器
     *
     * 将影响[ConstructorFinder.param]
     *
     * @param R 返回类型/构造目标类的类型
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否将构造函数转换为JavaMethod再进行附加 - 即使为false当构造函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    inline fun <R> ConstructorFinder.attach(function: KFunction<R>, loader: ClassLoader? = appClassLoader, isUseMember:Boolean = false) = attachGlobal(function, loader, isUseMember)

    /**
     * 将此函数相关内容附加到此查找器
     *
     * 将影响[MethodFinder.name]、[MethodFinder.returnType]、[MethodFinder.param]
     *
     * 重载引用使用示例 ↓
     *
     * ```kotlin
     *
     *  class Main{
     *      fun sub(a:Int):Int{}
     *
     *      fun sub(c:Double):String{}
     *  }
     *
     *  attach(Main::sub) // error:不知道附加哪个函数
     *  attach<String>(Main::sub) // 将使用返回类型为String的函数
     * ```
     *
     * @param R 返回类型
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    @JvmName("attach_1")
    inline fun <R> MethodFinder.attach(function:KFunction<R>,loader: ClassLoader? = appClassLoader,isUseMember:Boolean = false) = attachGlobal(function,loader, isUseMember)

    /**
     * 将此函数相关内容附加到此查找器
     *
     * 将影响[MethodFinder.name]、[MethodFinder.returnType]、[MethodFinder.param]
     *
     * 重载引用使用示例 ↓
     *
     * ```java
     *
     *  class Main{
     *      public static void sub(){}
     *      public void sub(){}
     *  }
     *
     *  attach(Main::sub) // error:不知道附加哪个函数
     *  attachStatic(Main::sub) // 将使用静态sub
     * ```
     *
     * @param R 返回类型
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    @JvmName("attachStatic_0")
    inline fun <R> MethodFinder.attachStatic(function: KFunction0<R>, loader: ClassLoader? = appClassLoader, isUseMember:Boolean = false) = attachStaticGlobal(function, loader, isUseMember)

    /**
     * 将此函数相关内容附加到此查找器
     *
     * 将影响[MethodFinder.name]、[MethodFinder.returnType]、[MethodFinder.param]
     *
     * 重载引用使用示例 ↓
     *
     * ```java
     *
     *  class Main{
     *      public void sub(a:Int):String{}
     *      public void sub():String{}
     *      public void sub(b:Int):Int{}
     *  }
     *
     *  attach<String>(Main::sub) // error:尽管筛选了返回值但依然不知道附加哪个函数
     *  attachEmptyParam(Main::sub) // 将使用没有参数sub
     * ```
     *
     * @param R 返回类型
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    inline fun <R> MethodFinder.attachEmptyParam(function: KFunction1<*, R>, loader: ClassLoader? = appClassLoader, isUseMember:Boolean = false) = attachEmptyParamGlobal(function, loader, isUseMember)

    /**
     * 将此函数相关内容附加到此查找器 - 指定参数的快捷方法 参阅:[attach]
     *
     * 将影响[MethodFinder.name]、[MethodFinder.returnType]、[MethodFinder.param]
     *
     * 重载引用使用示例 ↓
     *
     * ```kotlin
     *
     *  class Main{
     *      fun sub(a:Int):Int{}
     *
     *      fun sub(c:Double):Int{}
     *  }
     *
     *  attach(Main::sub) // error:不知道附加哪个函数
     *  attach<Double,Int>(Main::sub) // 将使用第一个参数为Double返回类型为Int的函数
     * ```
     *
     * @param P1 第一个参数的类型
     * @param R 返回类型
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    @JvmName("attach_2")
    inline fun <P1, R> MethodFinder.attach(function: KFunction2<*, P1, R>, loader: ClassLoader? = appClassLoader, isUseMember:Boolean = false) = attachGlobal(function, loader, isUseMember)

    /**
     * 将此函数相关内容附加到此查找器 - 指定参数的快捷方法 参阅:[attach]
     *
     * 将影响[MethodFinder.name]、[MethodFinder.returnType]、[MethodFinder.param]
     *
     * 重载引用参考[MethodFinder.attach]
     *
     * @param P1 第一个参数的类型
     * @param P2 第二个参数的类型
     * @param R 返回类型
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
     */
    @JvmName("attach_3")
    inline fun <P1,P2,R> MethodFinder.attach(function: KFunction3<*, P1, P2, R>, loader: ClassLoader? = appClassLoader, isUseMember:Boolean = false) = attachGlobal(function, loader, isUseMember)

    /**
     * 将此属性相关内容附加到此查找器
     *
     * 将影响[FieldFinder.name]、[FieldFinder.type]
     *
     * 多个属性引用使用示例 ↓
     *
     * ```kotlin
     *
     *  class Main{
     *      var sub = ""
     *      companion object{
     *          var sub = 5
     *      }
     *  }
     *
     *  attach(Main::sub) // error:不知道附加哪个属性伴生对象情况下优先使用var sub = ""
     *  attach<Int>(Main::sub) // 将使用返回类型为Int的属性也就是伴生对象中的属性
     * ```
     *
     * @param R 属性类型
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否将属性转换为JavaField再进行附加 - 即使为false当属性附加错误时依然会尝试JavaField - 为true时会导致类型擦除
     */
    inline fun <R> FieldFinder.attach(function: KProperty<R>, loader: ClassLoader? = appClassLoader, isUseMember:Boolean = false) = attachGlobal(function, loader, isUseMember)

    /**
     * 将此属性相关内容附加到此查找器
     *
     * 将影响[FieldFinder.name]、[FieldFinder.type]
     *
     * @param R 属性类型
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否将属性转换为JavaField再进行附加 - 即使为false当属性附加错误时依然会尝试JavaField - 为true时会导致类型擦除
     */
    inline fun <R> FieldFinder.attachStatic(function: KProperty0<R>, loader: ClassLoader? = appClassLoader, isUseMember:Boolean = false) = attachStaticGlobal(function, loader, isUseMember)

    /**
     * 将此属性相关内容附加到此查找器
     *
     * 将影响[FieldFinder.name]、[FieldFinder.type]
     *
     * @param ExpandThis 拓展类的类型
     * @param R 属性类型
     * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用 [appClassLoader]
     * @param isUseMember 是否将属性转换为JavaField再进行附加 - 即使为false当属性附加错误时依然会尝试JavaField - 为true时会导致类型擦除
     */
    inline fun <ExpandThis,R> FieldFinder.attach(function: KProperty2<*, ExpandThis, R>, loader: ClassLoader? = appClassLoader, isUseMember:Boolean = false) = attachGlobal(function, loader, isUseMember)

    /**
     * 快速Hook App 一般使用的模板
     *
     * @param fixed 方法体
     * @receiver 被Hook的类
     */
    inline fun KClass<*>.appNormalHookTemplate(fixed: FixedHookTemplate.AppNormal.() -> Unit) = FixedHookTemplate(this).AppNormal().apply(fixed)

    /**
     * 固定 Hook 模板
     *
     * 固定和通用的 Hook
     *
     * @param thisRefKClass 被Hook的类
     */
    inner class FixedHookTemplate(private val thisRefKClass: KClass<*>) {
        /**
         * App 一般使用的模板
         */
        inner class AppNormal {
            /**
             * 针对于 onCreate 查找的Hook
             *
             * @param onCreate - Hook 所插入的代码
             */
            fun onCreate(onCreate: KHookParam.(savedInstanceState: Bundle?) -> Unit) = Result(thisRefKClass.function {
                name = "onCreate"
                param(BundleKClass)
                superClass()
            }.remedys {
                function {
                    name = "onCreate"
                    emptyParam()
                    superClass()
                }
            }.hook()){
                onCreate(runCatching { args(0).cast<Bundle>() }.getOrNull())
            }

            /**
             * 针对于 onCreateView 查找的Hook
             *
             * @param onCreateView 参数 root 为 onCreateView 的返回值 - Hook 所插入的代码
             */
            fun onCreateView(onCreateView: KHookParam.(layoutInflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?, root: View?) -> Unit) =
                Result(thisRefKClass.function {
                    name = "onCreateView"
                    param(LayoutInflaterKClass, ViewGroupKClass, BundleKClass)
                    returnType = ViewKClass
                    superClass()
                }.hook()){
                    onCreateView(
                        args(0).cast()!!,
                        args(1).cast()!!,
                        args(2).cast(),
                        result<View>()
                    )
                }

            /**
             * 针对于 onViewCreated 查找的Hook
             *
             * @param onViewCreated - Hook 所插入的代码
             */
            fun onViewCreated(onViewCreated: KHookParam.(root: View, savedInstanceState: Bundle?) -> Unit) = Result(thisRefKClass.function {
                name = "onViewCreated"
                param(ViewKClass, BundleKClass)
                superClass()
            }.hook()){
                onViewCreated(args(0).cast()!!, args(1).cast())
            }

            /**
             * 针对于 onRequestPermissionsResult 查找的Hook
             *
             * @param onRequestPermissionsResult - Hook 所插入的代码
             */
            fun onRequestPermissionsResult(onRequestPermissionsResult: KHookParam.(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) -> Unit) = Result(thisRefKClass.function {
                name = "onRequestPermissionsResult"
                param(IntKType, StringArrayKClass, IntArrayKType)
                superClass()
            }.hook()){
                onRequestPermissionsResult(args(0).cast()!!, args(1).cast()!!, args(2).cast()!!)
            }

            /**
             * 针对于 onActivityResult 查找的Hook
             *
             * @param onActivityResult - Hook 所插入的代码
             */
            fun onActivityResult(onActivityResult: KHookParam.(requestCode: Int, resultCode: Int, data: Intent?) -> Unit) = Result(thisRefKClass.function {
                name = "onActivityResult"
                param(IntKType, IntKType, IntentKClass)
                superClass()
            }.hook()){
                onActivityResult(args(0).cast()!!, args(1).cast()!!, args(2).cast())
            }

            /**
             * 针对于 attachBaseContext 查找的Hook
             *
             * @param attachBaseContext - Hook 所插入的代码
             */
            fun attachBaseContext(attachBaseContext: KHookParam.(context: Context) -> Unit) = Result(thisRefKClass.function {
                name = "attachBaseContext"
                param(ContextKClass)
                superClass()
            }.hook()){
                attachBaseContext(args(0).cast()!!)
            }
        }

        /**
         * Hook 结果
         *
         * @property result 可执行元素目标Hook实例
         * @property hook 所执行的Hook
         */
        inner class Result(private val result: KCallableHookCreator, private val hook: KHookParam.() -> Unit) {
            /**
             * 在 [KCallable] 执行完成后 Hook
             *
             * - 不可与 [replaceAny]、[replaceUnit]、[replaceTo] 同时使用
             * @return [HookCallback]
             */
            fun after() = result.after(hook)

            /**
             * 在 [KCallable] 执行完成前 Hook
             *
             * - 不可与 [replaceAny]、[replaceUnit]、[replaceTo] 同时使用
             * @return [HookCallback]
             */
            fun before() = result.before(hook)

            /**
             * 拦截并替换此 [KCallable] 内容 - 给出返回值
             *
             * - 不可与 [before]、[after] 同时使用
             */
            fun replaceAny() = result.replaceAny(hook)

            /**
             * 拦截并替换此 [KCallable] 内容 - 没有返回值 ([Unit])
             *
             * - 不可与 [before]、[after] 同时使用
             */
            fun replaceUnit() = result.replaceUnit(hook)

            /**
             * 拦截并替换 [KCallable] 返回值
             *
             * - 不可与 [before]、[after] 同时使用
             * @param any 要替换为的返回值对象
             */
            fun replaceTo(any: Any?) = result.replaceTo(any)

            /**
             * 拦截并替换 [KCallable] 返回值为 true
             *
             * - 确保替换 [KCallable] 的返回对象为 [Boolean]
             *
             * - 不可与 [before]、[after] 同时使用
             */
            fun replaceToTrue() = result.replaceToTrue()

            /**
             * 拦截并替换 [KCallable] 返回值为 false
             *
             * - 确保替换 [KCallable] 的返回对象为 [Boolean]
             *
             * - 不可与 [before]、[after] 同时使用
             */
            fun replaceToFalse() = result.replaceToFalse()

            /**
             * 拦截此 [KCallable]
             *
             * - 这将会禁止此 [KCallable] 执行并返回 null
             *
             * - 注意：例如 [Int]、[Long]、[Boolean] 常量返回值的 [KCallable] 一旦被设置为 null 可能会造成 Hook APP 抛出异常
             *
             * - 不可与 [before]、[after] 同时使用
             */
            fun intercept() = result.intercept()
        }
    }
}