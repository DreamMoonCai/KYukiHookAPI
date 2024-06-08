@file:Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
package com.dream.yukihookapi.hook.param

import android.os.Bundle
import com.dream.yukihookapi.hook.core.KCallableHookCreator
import com.dream.yukireflection.factory.kotlin
import com.highcapable.yukihookapi.hook.core.YukiMemberHookCreator
import com.highcapable.yukihookapi.hook.core.api.helper.YukiHookHelper
import com.highcapable.yukihookapi.hook.core.api.proxy.YukiHookCallback
import com.highcapable.yukihookapi.hook.factory.classOf
import com.highcapable.yukihookapi.hook.log.YLog
import com.highcapable.yukihookapi.hook.param.HookParam
import kotlin.reflect.*

/**
 * Hook 方法、构造方法的目标对象实现类
 *
 * 基于 [HookParam] 实现的 Kotlin 版本
 */
class KHookParam private constructor(
    private val impl:HookParam
) {

    internal companion object {

        /**
         * 创建新的 [KHookParam]
         *
         * @param impl 原始 [HookParam]
         * @return [KHookParam]
         */
        internal fun create(impl: HookParam) =
            KHookParam(impl)
    }

    /**
     * 获取当前 Hook 对象 [function] 的参数对象数组
     *
     * 这里的数组每项类型默认为 [Any] - 你可以使用 [args] 方法来实现 [HookParam.ArgsModifyer.cast] 功能
     * @return [Array]
     * @throws IllegalStateException 如果对象为空
     */
    val args get() = impl.args

    /**
     * 获取当前 Hook 实例的对象
     *
     * - 如果你当前 Hook 的对象是一个静态 - 那么它将不存在实例的对象
     *
     * - 如果你不确定当前实例的对象是否为 null - 你可以使用 [instanceOrNull]
     * @return [Any]
     * @throws IllegalStateException 如果对象为空
     */
    val instance get() = impl.instance

    /**
     * 获取当前 Hook 实例的对象
     *
     * - 如果你当前 Hook 的对象是一个静态 - 那么它将不存在实例的对象
     * @return [Any] or null
     */
    val instanceOrNull get() = impl.instanceOrNull

    /**
     * 获取当前 Hook 实例的类对象
     *
     * - 如果你当前 Hook 的对象是一个静态 - 那么它将不存在实例的对象
     * @return [Class] or null
     */
    val instanceClass get() = impl.instanceClass?.kotlin

    /**
     * 获取当前 Hook 对象的 [KCallable]
     *
     * 在不确定 [KCallable] 类型为 [KFunction] or Constructor[KFunction] 时可以使用此方法
     * @return [KCallable]
     * @throws IllegalStateException 如果 [callable] 为空
     */
    val callable get() = impl.member.kotlin

    /**
     * 获取当前 Hook 对象的方法
     * @return [KFunction]
     * @throws IllegalStateException 如果 [callable] 类型不是 [KFunction]
     */
    val function get() = runCatching { impl.method.kotlin }.getOrNull() ?: impl.constructor.kotlin

    /**
     * 获取、设置当前 Hook 对象的 [function] 的返回值
     * @return [Any] or null
     */
    var result: Any?
        get() = impl.result
        set(value) {
            impl.result = value
        }

    /**
     * 获取当前回调方法体范围内的数据存储实例
     * @return [Bundle]
     */
    val dataExtra get() = impl.dataExtra

    /**
     * 判断是否存在设置过的方法调用抛出异常
     * @return [Boolean]
     */
    val hasThrowable get() = impl.hasThrowable

    /**
     * 获取设置的方法调用抛出异常
     * @return [Throwable] or null
     */
    val throwable get() = impl.throwable

    /**
     * 向 Hook APP 抛出异常
     *
     * 使用 [hasThrowable] 判断当前是否存在被抛出的异常
     *
     * 使用 [throwable] 获取当前设置的方法调用抛出异常
     *
     * - 仅会在回调方法的 [KCallableHookCreator.before] or [KCallableHookCreator.after] 中生效
     *
     * - 设置后会同时执行 [resultNull] 方法并将异常抛出给当前 Hook APP
     * @return [Throwable] or null
     * @throws Throwable
     */
    fun Throwable.throwToApp() {
        impl.apply {
            throwToApp()
        }
    }

    /**
     * 获取当前 Hook 对象的 [function] 的返回值 [T]
     * @return [T] or null
     */
    inline fun <reified T> result() = impl.result<T>()

    /**
     * 获取当前 Hook 实例的对象 [T]
     * @return [T]
     * @throws IllegalStateException 如果对象为空或对象类型不是 [T]
     */
    inline fun <reified T> instance() = impl.instance<T>()

    /**
     * 获取当前 Hook 实例的对象 [T]
     * @return [T] or null
     */
    inline fun <reified T> instanceOrNull() = impl.instanceOrNull<T>()

    /**
     * 获取当前 Hook 对象的 [function] 的参数数组下标实例化类
     * @return [HookParam.ArgsIndexCondition]
     */
    fun args() = impl.args()

    /**
     * 获取当前 Hook 对象的 [function] 的参数实例化对象类
     * @param index 参数对象数组下标
     * @return [HookParam.ArgsModifyer]
     */
    fun args(index: Int) = impl.args(index)

    /**
     * 执行原始 [KCallable]
     *
     * 调用自身未进行 Hook 的原始 [KCallable] 并调用原始参数执行
     * @return [Any] or null
     */
    fun callOriginal() = impl.callOriginal()

    /**
     * 执行原始 [KCallable]
     *
     * 调用自身未进行 Hook 的原始 [KCallable] 并调用原始参数执行
     * @return [T] or null
     */
    @JvmName(name = "callOriginal_Generics")
    fun <T> callOriginal() = impl.callOriginal()

    /**
     * 执行原始 [KCallable]
     *
     * 调用自身未进行 Hook 的原始 [KCallable] 并自定义 [args] 执行
     * @param args 参数实例
     * @return [Any] or null
     */
    fun invokeOriginal(vararg args: Any?) = impl.invokeOriginal(*args)

    /**
     * 执行原始 [KCallable]
     *
     * 调用自身未进行 Hook 的原始 [KCallable] 并自定义 [args] 执行
     * @param args 参数实例
     * @return [T] or null
     */
    @JvmName(name = "invokeOriginal_Generics")
    fun <T> invokeOriginal(vararg args: Any?) = impl.invokeOriginal(*args)

    /**
     * 设置当前 Hook 对象方法的 [result] 返回值为 true
     *
     * - 请确保 [result] 类型为 [Boolean]
     */
    fun resultTrue() {
        impl.resultTrue()
    }

    /**
     * 设置当前 Hook 对象方法的 [result] 返回值为 false
     *
     * - 请确保 [result] 类型为 [Boolean]
     */
    fun resultFalse() {
        impl.resultFalse()
    }

    /**
     * 设置当前 Hook 对象方法的 [result] 为 null
     *
     * - 此方法将强制设置方法体的 [result] 为 null
     */
    fun resultNull() {
        impl.resultNull()
    }

    override fun toString() = "KHookParam(${super.toString()}) by $impl"
}
