@file:Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
package io.github.dreammooncai.yukihookapi.kt.core

import io.github.dreammooncai.yukihookapi.kt.factory.kotlin
import io.github.dreammooncai.yukihookapi.kt.param.KHookParam
import io.github.dreammooncai.yukireflection.factory.kotlin
import com.highcapable.yukihookapi.hook.core.YukiMemberHookCreator.MemberHookCreator
import com.highcapable.yukihookapi.hook.core.YukiMemberHookCreator.MemberHookCreator.HookCallback
import com.highcapable.yukihookapi.hook.core.YukiMemberHookCreator.MemberHookCreator.Result as MemberResult
import kotlin.reflect.*

/**
 *
 * Hook 核心功能实现类
 *
 * 查找和处理需要 Hook 的 [KFunction]、Constructor[KFunction]
 *
 * 基于 [MemberHookCreator] 实现的 Kotlin 版本
 *
 * @property impl 依据实现的源实例
 */
class KCallableHookCreator internal constructor(internal val impl: MemberHookCreator) {
    /**
     * 在 [KCallable] 执行完成前 Hook
     *
     * - 不可与 [replaceAny]、[replaceUnit]、[replaceTo] 同时使用
     * @param initiate [KHookParam] 方法体
     * @return [HookCallback]
     */
    fun before(initiate: KHookParam.() -> Unit): HookCallback {
        return impl.before {
            initiate(KHookParam.create(this))
        }
    }

    /**
     * 在 [KCallable] 执行完成后 Hook
     *
     * - 不可与 [replaceAny]、[replaceUnit]、[replaceTo] 同时使用
     * @param initiate [KHookParam] 方法体
     * @return [HookCallback]
     */
    fun after(initiate: KHookParam.() -> Unit): HookCallback {
        return impl.after {
            initiate(KHookParam.create(this))
        }
    }

    /**
     * 拦截并替换此 [KCallable] 内容 - 给出返回值
     *
     * - 不可与 [before]、[after] 同时使用
     * @param initiate [KHookParam] 方法体
     */
    fun replaceAny(initiate: KHookParam.() -> Any?) {
        impl.replaceAny {
            initiate(KHookParam.create(this))
        }
    }

    /**
     * 拦截并替换此 [KCallable] 内容 - 没有返回值 ([Unit])
     *
     * - 不可与 [before]、[after] 同时使用
     * @param initiate [KHookParam] 方法体
     */
    fun replaceUnit(initiate: KHookParam.() -> Unit) {
        impl.replaceUnit {
            initiate(KHookParam.create(this))
        }
    }

    /**
     * 拦截并替换 [KCallable] 返回值
     *
     * - 不可与 [before]、[after] 同时使用
     * @param any 要替换为的返回值对象
     */
    fun replaceTo(any: Any?) {
        impl.replaceTo(any)
    }

    /**
     * 拦截并替换 [KCallable] 返回值为 true
     *
     * - 确保替换 [KCallable] 的返回对象为 [Boolean]
     *
     * - 不可与 [before]、[after] 同时使用
     */
    fun replaceToTrue() {
        impl.replaceToTrue()
    }

    /**
     * 拦截并替换 [KCallable] 返回值为 false
     *
     * - 确保替换 [KCallable] 的返回对象为 [Boolean]
     *
     * - 不可与 [before]、[after] 同时使用
     */
    fun replaceToFalse() {
        impl.replaceToFalse()
    }

    /**
     * 拦截此 [KCallable]
     *
     * - 这将会禁止此 [KCallable] 执行并返回 null
     *
     * - 注意：例如 [Int]、[Long]、[Boolean] 常量返回值的 [KCallable] 一旦被设置为 null 可能会造成 Hook APP 抛出异常
     *
     * - 不可与 [before]、[after] 同时使用
     */
    fun intercept() {
        impl.intercept()
    }

    /**
     * 移除当前注入的 Hook [KFunction]、Constructor[KFunction] (解除 Hook)
     *
     * - 你只能在 Hook 回调方法中使用此功能
     * @param result 回调是否成功
     */
    fun removeSelf(result: (Boolean) -> Unit = {}) = impl.removeSelf(result)

    /**
     * Hook 创建入口
     * @return [Result]
     */
    @Suppress("INVISIBLE_REFERENCE","INVISIBLE_MEMBER")
    internal fun build() = impl.build().kotlin

    override fun toString() =
        impl.toString()

    /**
     * 监听 Hook 结果实现类
     *
     * 可在这里处理失败事件监听
     *
     * 基于 [MemberHookCreator.Result] 实现的 Kotlin 版本
     *
     * @property impl 依据实现的源实例
     */
    class Result internal constructor(internal val impl: MemberResult) {

        /**
         * 创建监听事件方法体
         * @param initiate 方法体
         * @return [Result] 可继续向下监听
         */
        inline fun result(initiate: Result.() -> Unit) = apply(initiate)

        /**
         * 添加执行 Hook 需要满足的条件
         *
         * 不满足条件将直接停止 Hook
         * @param condition 条件方法体
         * @return [Result] 可继续向下监听
         */
        inline fun by(condition: () -> Boolean): Result {
            impl.by(condition)
            return this
        }

        /**
         * 监听 callables Hook 成功的回调方法
         *
         * 在首次 Hook 成功后回调
         *
         * 在重复 Hook 时会回调 [onAlreadyHooked]
         * @param result 回调被 Hook 的 [KCallable]
         * @return [Result] 可继续向下监听
         */
        fun onHooked(result: (KCallable<*>) -> Unit): Result {
            impl.onHooked {
                result(it.kotlin)
            }
            return this
        }

        /**
         * 监听 callables 重复 Hook 的回调方法
         *
         * - 同一个 KClass 中的同一个 callables 不会被 API 重复 Hook - 若由于各种原因重复 Hook 会回调此方法
         * @param result 回调被重复 Hook 的 [KCallable]
         * @return [Result] 可继续向下监听
         */
        fun onAlreadyHooked(result: (KCallable<*>) -> Unit): Result {
            impl.onAlreadyHooked {result(it.kotlin)}
            return this
        }

        /**
         * 监听 Hook 进行过程中发生错误的回调方法
         * @param result 回调错误 - ([KHookParam] 当前 Hook 实例,[Throwable] 异常)
         * @return [Result] 可继续向下监听
         */
        fun onConductFailure(result: (KHookParam, Throwable) -> Unit): Result {
            impl.onConductFailure { hookParam, throwable ->
                result(KHookParam.create(hookParam), throwable)
            }
            return this
        }

        /**
         * 忽略 Hook 进行过程中发生的错误
         * @return [Result] 可继续向下监听
         */
        fun ignoredConductFailure() = impl.ignoredConductFailure()

        /**
         * 监听 Hook 开始时发生错误的回调方法
         * @param result 回调错误
         * @return [Result] 可继续向下监听
         */
        fun onHookingFailure(result: (Throwable) -> Unit): Result {
            impl.onHookingFailure(result)
            return this
        }

        /**
         * 忽略 Hook 开始时发生的错误
         * @return [Result] 可继续向下监听
         */
        fun ignoredHookingFailure() = impl.ignoredHookingFailure()

        /**
         * 监听全部 Hook 过程发生错误的回调方法
         * @param result 回调错误
         * @return [Result] 可继续向下监听
         */
        fun onAllFailure(result: (Throwable) -> Unit): Result {
            impl.onAllFailure(result)
            return this
        }

        /**
         * 忽略全部 Hook 过程发生的错误
         * @return [Result] 可继续向下监听
         */
        fun ignoredAllFailure() = impl.ignoredAllFailure()

        /**
         * 移除当前注入的 Hook [KFunction]、Constructor[KFunction] (解除 Hook)
         *
         * - 你只能在 Hook 成功后才能解除 Hook - 可监听 [onHooked] 事件
         * @param result 回调是否成功
         */
        fun remove(result: (Boolean) -> Unit = {}) {
            impl.remove(result)
        }
    }
}