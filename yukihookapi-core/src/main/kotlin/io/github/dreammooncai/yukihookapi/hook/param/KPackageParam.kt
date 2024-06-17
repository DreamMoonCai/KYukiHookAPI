@file:Suppress("NOTHING_TO_INLINE", "NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")

package io.github.dreammooncai.yukihookapi.hook.param

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.dreammooncai.yukihookapi.hook.core.KCallableHookCreator
import io.github.dreammooncai.yukihookapi.hook.entity.KYukiBaseHooker
import io.github.dreammooncai.yukihookapi.hook.factory.kotlin
import io.github.dreammooncai.yukihookapi.hook.factory.yuki
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
import com.highcapable.yukihookapi.hook.param.PackageParam
import com.highcapable.yukihookapi.hook.param.wrapper.PackageParamWrapper
import kotlin.reflect.KCallable
import kotlin.reflect.KClass

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
     */
    object Ignore {
        /**
         * 忽略父类依赖有问题的提示异常
         *
         * 这通常在反编译的代码引用中出现的异常，通常忽略不会影响编译
         */
        const val MISSING_DEPENDENCY_SUPERCLASS = "MISSING_DEPENDENCY_SUPERCLASS"
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
    private val KCallable<*>.javaMemberNotNull get() = javaMember ?: refImpl?.javaMember ?: error("Unable Convert Java Member !")

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
    inline fun List<KCallable<*>>.hookAll(
        priority: YukiHookPriority = YukiHookPriority.DEFAULT,
        initiate: KCallableHookCreator.() -> Unit
    ) = map { it.javaMemberNotNull }.hookAll(priority) { initiate(this.kotlin) }.kotlin

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