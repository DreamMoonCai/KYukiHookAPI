@file:Suppress("NOTHING_TO_INLINE", "NON_PUBLIC_CALL_FROM_PUBLIC_INLINE","INVISIBLE_REFERENCE","INVISIBLE_MEMBER")
package io.github.dreammooncai.yukihookapi.kt.factory

import com.highcapable.yukihookapi.hook.core.finder.members.ConstructorFinder
import com.highcapable.yukihookapi.hook.core.finder.members.FieldFinder
import com.highcapable.yukihookapi.hook.core.finder.members.MethodFinder
import com.highcapable.yukihookapi.hook.factory.constructor
import com.highcapable.yukihookapi.hook.factory.field
import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.factory.toClass
import io.github.dreammooncai.yukireflection.factory.javaConstructorNoError
import io.github.dreammooncai.yukireflection.factory.javaMember
import io.github.dreammooncai.yukireflection.factory.javaMethodNoError
import io.github.dreammooncai.yukireflection.factory.kotlin
import io.github.dreammooncai.yukireflection.factory.name
import io.github.dreammooncai.yukireflection.factory.refImpl
import io.github.dreammooncai.yukireflection.factory.returnClass
import io.github.dreammooncai.yukireflection.factory.returnJavaClass
import io.github.dreammooncai.yukireflection.factory.toKClass
import io.github.dreammooncai.yukireflection.factory.type
import io.github.dreammooncai.yukireflection.finder.callable.KConstructorFinder
import java.lang.reflect.Field
import java.lang.reflect.Method
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KFunction0
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction3
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty2
import kotlin.reflect.full.valueParameters

/**
 * 将此构造函数相关内容附加到此查找器
 *
 * 将影响[ConstructorFinder.param]
 *
 * @param R 返回类型/构造目标类的类型
 * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用默认 [ClassLoader]
 * @param isUseMember 是否将构造函数转换为JavaMethod再进行附加 - 即使为false当构造函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
 */
fun <R> ConstructorFinder.attach(function: KFunction<R>, loader: ClassLoader? = null, isUseMember:Boolean = false){
    fun Class<*>.toClass() = if (loader == null) this else name.toClass(loader)

    fun attachMember(e:Throwable? = null){
        val method = function.javaConstructorNoError ?: function.refImpl?.javaConstructorNoError ?: let {
            errorMsg("This constructor cannot be attached, or the constructor is hidden by Kotlin to prohibit reflection, you can try to use [java.constructor {}] to do the reflection !!!", e)
            return
        }
        if (method.parameterTypes.isEmpty())
            emptyParam()
        else
            param(*method.parameterTypes.map { it.toClass() }.toTypedArray())
    }
    fun attachCallable(function: KFunction<*>){
        if (function.valueParameters.isEmpty())
            emptyParam()
        else
            param(*function.valueParameters.map {
                if (loader != null)
                    it.kotlin.java.toClass()
                else it.kotlin.java
            }.toTypedArray())
    }
    if (isUseMember)
        attachMember()
    else runCatching {
        attachCallable(function)
    }.getOrNull() ?: runCatching {
        attachCallable(function.refImpl!!)
    }.getOrElse {
        attachMember(it)
    }
}

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
 * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用默认 [ClassLoader]
 * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
 */
@JvmName("attach_1")
fun <R> MethodFinder.attach(function:KFunction<R>, loader: ClassLoader? = null, isUseMember:Boolean = false){
    fun Class<*>.toClass() = if (loader == null) this else name.toClass(loader)

    fun attachMember(e:Throwable? = null){
        val method = function.javaMethodNoError ?: function.refImpl?.javaMethodNoError ?: let {
            errorMsg("If you can't attach this function or the function is hidden by Kotlin to prohibit reflection, you can try to use [java.method {}] to do the reflection !!!", e)
            return
        }
        this@attach.name = method.name
        this@attach.returnType = method.returnType.toClass()
        if (method.parameterTypes.isEmpty())
            emptyParam()
        else
            param(*method.parameterTypes.map { it.toClass() }.toTypedArray())
    }
    fun attachCallable(function: KFunction<*>){
        this@attach.name = function.name
        this@attach.returnType = runCatching {
            if (loader != null)
                function.returnJavaClass.toClass()
            else
                function.returnJavaClass
        }.getOrNull() ?: function.returnJavaClass.toClass()
        if (function.valueParameters.isEmpty())
            emptyParam()
        else
            param(*function.valueParameters.map {
                if (loader != null)
                    it.kotlin.java.toClass()
                else
                    it.kotlin.java
            }.toTypedArray())
    }
    if (isUseMember)
        attachMember()
    else runCatching {
        attachCallable(function)
    }.getOrNull() ?: runCatching {
        attachCallable(function.refImpl!!)
    }.getOrElse {
        attachMember(it)
    }
}

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
 * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用默认 [ClassLoader]
 * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
 */
@JvmName("attachStatic_0")
inline fun <R> MethodFinder.attachStatic(function: KFunction0<R>, loader: ClassLoader? = null, isUseMember:Boolean = false){
    attach(function,loader,isUseMember)
}

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
 * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用默认 [ClassLoader]
 * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
 */
inline fun <R> MethodFinder.attachEmptyParam(function: KFunction1<*, R>, loader: ClassLoader? = null, isUseMember:Boolean = false) {
    attach(function, loader, isUseMember)
}

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
 * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用默认 [ClassLoader]
 * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
 */
@JvmName("attach_2")
inline fun <P1, R> MethodFinder.attach(function: KFunction2<*, P1, R>, loader: ClassLoader? = null, isUseMember:Boolean = false){
    attach<R>(function,loader, isUseMember)
}

/**
 * 将此函数相关内容附加到此查找器 - 指定参数的快捷方法 参阅:[attach]
 *
 * 将影响[MethodFinder.name]、[MethodFinder.returnType]、[MethodFinder.param]
 *
 * 重载引用参考[attach]
 *
 * @param P1 第一个参数的类型
 * @param P2 第二个参数的类型
 * @param R 返回类型
 * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用默认 [ClassLoader]
 * @param isUseMember 是否将函数转换为JavaMethod再进行附加 - 即使为false当函数附加错误时依然会尝试JavaMethod - 为true时会导致类型擦除
 */
@JvmName("attach_3")
inline fun <P1,P2,R> MethodFinder.attach(function: KFunction3<*, P1, P2, R>, loader: ClassLoader? = null, isUseMember:Boolean = false){
    attach<R>(function,loader, isUseMember)
}

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
 * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用默认 [ClassLoader]
 * @param isUseMember 是否将属性转换为JavaField再进行附加 - 即使为false当属性附加错误时依然会尝试JavaField - 为true时会导致类型擦除
 */
fun <R> FieldFinder.attach(function: KProperty<R>, loader: ClassLoader? = null, isUseMember:Boolean = false){
    fun Class<*>.toClass() = if (loader == null) this else name.toClass(loader)

    fun attachMember(e:Throwable? = null){
        val member = function.javaMember ?: function.refImpl?.javaMember ?: let {
            errorMsg("This property cannot be attached, or it is hidden by Kotlin to prohibit reflection, you can try to use [field {}] to reflect it !!!", e)
            return
        }
        this@attach.name = member.name
        this@attach.type = when(member){
            is Field -> member.type.toClass()
            is Method -> member.returnType.toClass()
            else -> null
        }
    }
    fun attachCallable(property: KProperty<*>){
        this@attach.name = property.name
        this@attach.type = runCatching {
            if (loader != null)
                property.returnJavaClass.toClass()
            else
                property.returnJavaClass
        }.getOrNull() ?: property.returnJavaClass.toClass()
    }
    if (isUseMember)
        attachMember()
    else runCatching {
        attachCallable(function)
    }.getOrNull() ?: runCatching {
        attachCallable(function.refImpl!!)
    }.getOrElse {
        attachMember(it)
    }
}

/**
 * 将此属性相关内容附加到此查找器
 *
 * 将影响[FieldFinder.name]、[FieldFinder.type]
 *
 * @param R 属性类型
 * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用默认 [ClassLoader]
 * @param isUseMember 是否将属性转换为JavaField再进行附加 - 即使为false当属性附加错误时依然会尝试JavaField - 为true时会导致类型擦除
 */
inline fun <R> FieldFinder.attachStatic(function: KProperty0<R>, loader: ClassLoader? = null, isUseMember:Boolean = false){
    attach(function,loader,isUseMember)
}

/**
 * 将此属性相关内容附加到此查找器
 *
 * 将影响[FieldFinder.name]、[FieldFinder.type]
 *
 * @param ExpandThis 拓展类的类型
 * @param R 属性类型
 * @param loader [ClassLoader] 装载实例 - 默认空 - 不填使用默认 [ClassLoader]
 * @param isUseMember 是否将属性转换为JavaField再进行附加 - 即使为false当属性附加错误时依然会尝试JavaField - 为true时会导致类型擦除
 */
inline fun <ExpandThis,R> FieldFinder.attach(function: KProperty2<*, ExpandThis, R>, loader: ClassLoader? = null, isUseMember:Boolean = false){
    attach<R>(function,loader,isUseMember)
}

/**
 * 查找并得到变量 Java 方式
 * @param initiate 查找方法体
 * @return [FieldFinder.Result]
 */
inline fun KClass<*>.field(initiate: FieldFinder.() -> Unit = {}) = java.field(initiate)

/**
 * 查找并得到方法 Java 方式
 * @param initiate 查找方法体
 * @return [MethodFinder.Result]
 */
inline fun KClass<*>.method(initiate: MethodFinder.() -> Unit = {}) = java.method(initiate)
