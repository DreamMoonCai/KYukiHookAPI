/*
 * YukiHookAPI - An efficient Kotlin version of the Xposed Hook API.
 * Copyright (C) 2019-2022 HighCapable
 * https://github.com/fankes/YukiHookAPI
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This file is Created by fankes on 2022/2/2.
 */
@file:Suppress("unused", "KDocUnresolvedReference", "DEPRECATION", "FunctionName", "NewApi", "UNCHECKED_CAST")

package com.highcapable.yukihookapi.hook.type.java

import android.os.Build
import com.highcapable.yukihookapi.hook.factory.classOf
import com.highcapable.yukihookapi.hook.factory.toClass
import dalvik.system.BaseDexClassLoader
import dalvik.system.DexClassLoader
import dalvik.system.InMemoryDexClassLoader
import dalvik.system.PathClassLoader
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.lang.ref.Reference
import java.lang.ref.WeakReference
import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.lang.reflect.Member
import java.lang.reflect.Method
import java.net.HttpCookie
import java.net.HttpURLConnection
import java.net.http.HttpClient
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean
import java.util.function.Supplier
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream
import java.lang.reflect.Array as JavaArray

/**
 * 获得任意类型的数组
 *
 * 它在 Java 中表示为：([type])[]
 * @param type 类型
 * @return [Class]<[JavaArray]>
 */
fun ArrayClass(type: Class<*>) = JavaArray.newInstance(type, 0).javaClass as Class<JavaArray>

/**
 * 获得 [Any] 类型
 *
 * - ❗此方法已弃用 - 在之后的版本中将直接被删除
 *
 * - ❗请现在转移到 [AnyClass]
 * @return [Class]
 */
@Deprecated(message = "请使用新的命名方法", replaceWith = ReplaceWith(expression = "AnyClass"))
val AnyType get() = AnyClass

/**
 * 获得 [Boolean] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) - 它在字节码中的关键字为 "boolean"
 * @return [Class]
 */
val BooleanType get() = Boolean::class.javaPrimitiveType ?: "boolean".toClass()

/**
 * 获得 [Char] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) - 它在字节码中的关键字为 "char"
 * @return [Class]
 */
val CharType get() = Char::class.javaPrimitiveType ?: "char".toClass()

/**
 * 获得 [Byte] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) - 它在字节码中的关键字为 "byte"
 * @return [Class]
 */
val ByteType get() = Byte::class.javaPrimitiveType ?: "byte".toClass()

/**
 * 获得 [Short] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) - 它在字节码中的关键字为 "short"
 * @return [Class]
 */
val ShortType get() = Short::class.javaPrimitiveType ?: "short".toClass()

/**
 * 获得 [Int] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) - 它在字节码中的关键字为 "int"
 * @return [Class]
 */
val IntType get() = Int::class.javaPrimitiveType ?: "int".toClass()

/**
 * 获得 [Float] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) - 它在字节码中的关键字为 "float"
 * @return [Class]
 */
val FloatType get() = Float::class.javaPrimitiveType ?: "float".toClass()

/**
 * 获得 [Long] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) - 它在字节码中的关键字为 "long"
 * @return [Class]
 */
val LongType get() = Long::class.javaPrimitiveType ?: "long".toClass()

/**
 * 获得 [Double] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) - 它在字节码中的关键字为 "double"
 * @return [Class]
 */
val DoubleType get() = Double::class.javaPrimitiveType ?: "double".toClass()

/**
 * 获得 [Unit] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) - 它在字节码中的关键字为 "void"
 * @return [Class]
 */
val UnitType get() = Void.TYPE ?: "void".toClass()

/**
 * 获得 [Any] 类型
 *
 * 它等价于 Java 中的 [java.lang.Object]
 * @return [Class]
 */
val AnyClass get() = classOf<Any>()

/**
 * 获得 [Boolean] 类型
 *
 * 它等价于 Java 中的 [java.lang.Boolean]
 * @return [Class]
 */
val BooleanClass get() = classOf<Boolean>()

/**
 * 获得 [Char] 类型
 *
 * 它等价于 Java 中的 [java.lang.Character]
 * @return [Class]
 */
val CharClass get() = classOf<Char>()

/**
 * 获得 [Byte] 类型
 *
 * 它等价于 Java 中的 [java.lang.Byte]
 * @return [Class]
 */
val ByteClass get() = classOf<Byte>()

/**
 * 获得 [Short] 类型
 *
 * 它等价于 Java 中的 [java.lang.Short]
 * @return [Class]
 */
val ShortClass get() = classOf<Short>()

/**
 * 获得 [Int] 类型
 *
 * 它等价于 Java 中的 [java.lang.Integer]
 * @return [Class]
 */
val IntClass get() = classOf<Int>()

/**
 * 获得 [Float] 类型
 *
 * 它等价于 Java 中的 [java.lang.Float]
 * @return [Class]
 */
val FloatClass get() = classOf<Float>()

/**
 * 获得 [Long] 类型
 *
 * 它等价于 Java 中的 [java.lang.Long]
 * @return [Class]
 */
val LongClass get() = classOf<Long>()

/**
 * 获得 [Double] 类型
 *
 * 它等价于 Java 中的 [java.lang.Double]
 * @return [Class]
 */
val DoubleClass get() = classOf<Double>()

/**
 * 获得 [Number] 类型
 *
 * 它等价于 Java 中的 [java.lang.Number]
 * @return [Class]
 */
val NumberClass get() = classOf<Number>()

/**
 * 获得 [Unit] 类型
 *
 * 它等价于 Java 中的 [java.lang.Void]
 * @return [Class]
 */
val UnitClass get() = classOf<Void>()

/**
 * 获得 [String] 类型
 *
 * - ❗此方法已弃用 - 在之后的版本中将直接被删除
 *
 * - ❗请现在转移到 [StringClass]
 * @return [Class]
 */
@Deprecated(message = "请使用新的命名方法", replaceWith = ReplaceWith(expression = "StringClass"))
val StringType get() = StringClass

/**
 * 获得 [CharSequence] 类型
 *
 * - ❗此方法已弃用 - 在之后的版本中将直接被删除
 *
 * - ❗请现在转移到 [CharSequenceClass]
 * @return [Class]
 */
@Deprecated(message = "请使用新的命名方法", replaceWith = ReplaceWith(expression = "CharSequenceClass"))
val CharSequenceType get() = CharSequenceClass

/**
 * 获得 [String] 类型
 *
 * 它等价于 Java 中的 [java.lang.String]
 * @return [Class]
 */
val StringClass get() = classOf<String>()

/**
 * 获得 [CharSequence] 类型
 *
 * 它等价于 Java 中的 [java.lang.CharSequence]
 * @return [Class]
 */
val CharSequenceClass get() = classOf<CharSequence>()

/**
 * 获得 [Serializable] 类型
 * @return [Class]
 */
val SerializableClass get() = classOf<Serializable>()

/**
 * 获得 [Array] 类型
 *
 * 它等价于 Java 中的 [java.lang.reflect.Array]
 * @return [Class]
 */
val ArrayClass get() = classOf<JavaArray>()

/**
 * 获得 [Boolean] - [Array] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) 数组 - 它在字节码中的关键字为 "boolean[]"
 * @return [Class]
 */
val BooleanArrayType get() = ArrayClass(BooleanType)

/**
 * 获得 [Char] - [Array] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) 数组 - 它在字节码中的关键字为 "char[]"
 * @return [Class]
 */
val CharArrayType get() = ArrayClass(CharType)

/**
 * 获得 [Byte] - [Array] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) 数组 - 它在字节码中的关键字为 "byte[]"
 * @return [Class]
 */
val ByteArrayType get() = ArrayClass(ByteType)

/**
 * 获得 [Short] - [Array] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) 数组 - 它在字节码中的关键字为 "short[]"
 * @return [Class]
 */
val ShortArraytType get() = ArrayClass(ShortType)

/**
 * 获得 [Int] - [Array] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) 数组 - 它在字节码中的关键字为 "int[]"
 * @return [Class]
 */
val IntArrayType get() = ArrayClass(IntType)

/**
 * 获得 [Float] - [Array] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) 数组 - 它在字节码中的关键字为 "float[]"
 * @return [Class]
 */
val FloatArrayType get() = ArrayClass(FloatType)

/**
 * 获得 [Long] - [Array] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) 数组 - 它在字节码中的关键字为 "long[]"
 * @return [Class]
 */
val LongArrayType get() = ArrayClass(LongType)

/**
 * 获得 [Double] - [Array] 类型
 *
 * 这是 Java 原始类型 (Primitive Type) 数组 - 它在字节码中的关键字为 "double[]"
 * @return [Class]
 */
val DoubleArrayType get() = ArrayClass(DoubleType)

/**
 * 获得 [Any] - [Array] 类型
 *
 * 它在 Java 中表示为：Object[]
 * @return [Class]
 */
val AnyArrayClass get() = ArrayClass(AnyClass)

/**
 * 获得 [Boolean] - [Array] 类型
 *
 * 它在 Java 中表示为：Boolean[]
 * @return [Class]
 */
val BooleanArrayClass get() = ArrayClass(BooleanClass)

/**
 * 获得 [Char] - [Array] 类型
 *
 * 它在 Java 中表示为：Character[]
 * @return [Class]
 */
val CharArrayClass get() = ArrayClass(CharClass)

/**
 * 获得 [Byte] - [Array] 类型
 *
 * 它在 Java 中表示为：Byte[]
 * @return [Class]
 */
val ByteArrayClass get() = ArrayClass(ByteClass)

/**
 * 获得 [Short] - [Array] 类型
 *
 * 它在 Java 中表示为：Short[]
 * @return [Class]
 */
val ShortArrayClass get() = ArrayClass(ShortClass)

/**
 * 获得 [Int] - [Array] 类型
 *
 * 它在 Java 中表示为：Integer[]
 * @return [Class]
 */
val IntArrayClass get() = ArrayClass(IntClass)

/**
 * 获得 [Float] - [Array] 类型
 *
 * 它在 Java 中表示为：Float[]
 * @return [Class]
 */
val FloatArrayClass get() = ArrayClass(FloatClass)

/**
 * 获得 [Long] - [Array] 类型
 *
 * 它在 Java 中表示为：Long[]
 * @return [Class]
 */
val LongArrayClass get() = ArrayClass(LongClass)

/**
 * 获得 [Double] - [Array] 类型
 *
 * 它在 Java 中表示为：Double[]
 * @return [Class]
 */
val DoubleArrayClass get() = ArrayClass(DoubleClass)

/**
 * 获得 [Number] - [Array] 类型
 *
 * 它在 Java 中表示为：Number[]
 * @return [Class]
 */
val NumberArrayClass get() = ArrayClass(NumberClass)

/**
 * 获得 [String] - [Array] 类型
 *
 * 它在 Java 中表示为：String[]
 * @return [Class]
 */
val StringArrayClass get() = ArrayClass(StringClass)

/**
 * 获得 [CharSequence] - [Array] 类型
 *
 * 它在 Java 中表示为：CharSequence[]
 * @return [Class]
 */
val CharSequenceArrayClass get() = ArrayClass(CharSequenceClass)

/**
 * 获得 [Cloneable] 类型
 * @return [Class]
 */
val CloneableClass get() = classOf<Cloneable>()

/**
 * 获得 [List] 类型
 * @return [Class]
 */
val ListClass get() = classOf<List<*>>()

/**
 * 获得 [ArrayList] 类型
 * @return [Class]
 */
val ArrayListClass get() = classOf<ArrayList<*>>()

/**
 * 获得 [HashMap] 类型
 * @return [Class]
 */
val HashMapClass get() = classOf<HashMap<*, *>>()

/**
 * 获得 [HashSet] 类型
 * @return [Class]
 */
val HashSetClass get() = classOf<HashSet<*>>()

/**
 * 获得 [WeakHashMap] 类型
 * @return [Class]
 */
val WeakHashMapClass get() = classOf<WeakHashMap<*, *>>()

/**
 * 获得 [WeakReference] 类型
 * @return [Class]
 */
val WeakReferenceClass get() = classOf<WeakReference<*>>()

/**
 * 获得 [Enum] 类型
 * @return [Class]
 */
val EnumClass get() = classOf<Enum<*>>()

/**
 * 获得 [Map] 类型
 * @return [Class]
 */
val MapClass get() = classOf<Map<*, *>>()

/**
 * 获得 [Map.Entry] 类型
 * @return [Class]
 */
val Map_EntryClass get() = classOf<Map.Entry<*, *>>()

/**
 * 获得 [Reference] 类型
 * @return [Class]
 */
val ReferenceClass get() = classOf<Reference<*>>()

/**
 * 获得 [Vector] 类型
 * @return [Class]
 */
val VectorClass get() = classOf<Vector<*>>()

/**
 * 获得 [File] 类型
 * @return [Class]
 */
val FileClass get() = classOf<File>()

/**
 * 获得 [InputStream] 类型
 * @return [Class]
 */
val InputStreamClass get() = classOf<InputStream>()

/**
 * 获得 [OutputStream] 类型
 * @return [Class]
 */
val OutputStreamClass get() = classOf<OutputStream>()

/**
 * 获得 [BufferedReader] 类型
 * @return [Class]
 */
val BufferedReaderClass get() = classOf<BufferedReader>()

/**
 * 获得 [Date] 类型
 * @return [Class]
 */
val DateClass get() = classOf<Date>()

/**
 * 获得 [TimeZone] 类型
 * @return [Class]
 */
val TimeZoneClass get() = classOf<TimeZone>()

/**
 * 获得 [SimpleDateFormat] 类型
 * @return [Class]
 */
val SimpleDateFormatClass_Java get() = classOf<SimpleDateFormat>()

/**
 * 获得 [Timer] 类型
 * @return [Class]
 */
val TimerClass get() = classOf<Timer>()

/**
 * 获得 [TimerTask] 类型
 * @return [Class]
 */
val TimerTaskClass get() = classOf<TimerTask>()

/**
 * 获得 [Thread] 类型
 * @return [Class]
 */
val ThreadClass get() = classOf<Thread>()

/**
 * 获得 [Base64] 类型
 *
 * - ❗在 Android O (26) 及以上系统加入
 * @return [Class] or null
 */
val Base64Class_Java get() = if (Build.VERSION.SDK_INT >= 26) classOf<Base64>() else null

/**
 * 获得 [Observer] 类型
 * @return [Class]
 */
val ObserverClass get() = classOf<Observer>()

/**
 * 获得 [Set] 类型
 * @return [Class]
 */
val SetClass get() = classOf<Set<*>>()

/**
 * 获得 [JSONObject] 类型
 * @return [Class]
 */
val JSONObjectClass get() = classOf<JSONObject>()

/**
 * 获得 [JSONArray] 类型
 * @return [Class]
 */
val JSONArrayClass get() = classOf<JSONArray>()

/**
 * 获得 [StringBuilder] 类型
 * @return [Class]
 */
val StringBuilderClass get() = classOf<StringBuilder>()

/**
 * 获得 [StringBuffer] 类型
 * @return [Class]
 */
val StringBufferClass get() = classOf<StringBuffer>()

/**
 * 获得 [ZipEntry] 类型
 * @return [Class]
 */
val ZipEntryClass get() = classOf<ZipEntry>()

/**
 * 获得 [ZipFile] 类型
 * @return [Class]
 */
val ZipFileClass get() = classOf<ZipFile>()

/**
 * 获得 [ZipInputStream] 类型
 * @return [Class]
 */
val ZipInputStreamClass get() = classOf<ZipInputStream>()

/**
 * 获得 [ZipOutputStream] 类型
 * @return [Class]
 */
val ZipOutputStreamClass get() = classOf<ZipOutputStream>()

/**
 * 获得 [HttpURLConnection] 类型
 * @return [Class]
 */
val HttpURLConnectionClass get() = classOf<HttpURLConnection>()

/**
 * 获得 [HttpCookie] 类型
 * @return [Class]
 */
val HttpCookieClass get() = classOf<HttpCookie>()

/**
 * 获得 [HttpClient] 类型
 * @return [Class]
 */
val HttpClientClass get() = classOf<HttpClient>()

/**
 * 获得 [AtomicBoolean] 类型
 * @return [Class]
 */
val AtomicBooleanClass get() = classOf<AtomicBoolean>()

/**
 * 获得 [Supplier] 类型
 * @return [Class]
 */
val SupplierClass get() = classOf<Supplier<*>>()

/**
 * 获得 [Class] 类型
 * @return [Class]
 */
val JavaClass get() = classOf<Class<*>>()

/**
 * 获得 [ClassLoader] 类型
 * @return [Class]
 */
val JavaClassLoader get() = classOf<ClassLoader>()

/**
 * 获得 [BaseDexClassLoader] 类型
 * @return [Class]
 */
val DalvikBaseDexClassLoader get() = classOf<BaseDexClassLoader>()

/**
 * 获得 [DexClassLoader] 类型
 * @return [Class]
 */
val DalvikDexClassLoader get() = classOf<DexClassLoader>()

/**
 * 获得 [PathClassLoader] 类型
 * @return [Class]
 */
val DalvikPathClassLoader get() = classOf<PathClassLoader>()

/**
 * 获得 [InMemoryDexClassLoader] 类型
 * @return [Class]
 */
val DalvikInMemoryDexClassLoader get() = classOf<InMemoryDexClassLoader>()

/**
 * 获得 [Method] 类型
 * @return [Class]
 */
val JavaMethodClass get() = classOf<Method>()

/**
 * 获得 [Field] 类型
 * @return [Class]
 */
val JavaFieldClass get() = classOf<Field>()

/**
 * 获得 [Constructor] 类型
 * @return [Class]
 */
val JavaConstructorClass get() = classOf<Constructor<*>>()

/**
 * 获得 [Member] 类型
 * @return [Class]
 */
val JavaMemberClass get() = classOf<Member>()

/**
 * 获得 [Annotation] 类型
 * @return [Class]
 */
val JavaAnnotationClass get() = classOf<Annotation>()

/**
 * 获得 [java.util.function.Function] 类型
 * @return [Class]
 */
val FunctionClass get() = classOf<java.util.function.Function<*, *>>()

/**
 * 获得 [Optional] 类型
 * @return [Class]
 */
val OptionalClass get() = classOf<Optional<*>>()

/**
 * 获得 [OptionalInt] 类型
 * @return [Class]
 */
val OptionalIntClass get() = classOf<OptionalInt>()

/**
 * 获得 [OptionalLong] 类型
 * @return [Class]
 */
val OptionalLongClass get() = classOf<OptionalLong>()

/**
 * 获得 [OptionalDouble] 类型
 * @return [Class]
 */
val OptionalDoubleClass get() = classOf<OptionalDouble>()

/**
 * 获得 [Objects] 类型
 * @return [Class]
 */
val ObjectsClass get() = classOf<Objects>()

/**
 * 获得 [Runtime] 类型
 * @return [Class]
 */
val RuntimeClass get() = classOf<Runtime>()

/**
 * 获得 [NullPointerException] 类型
 * @return [Class]
 */
val NullPointerExceptionClass get() = classOf<NullPointerException>()

/**
 * 获得 [NumberFormatException] 类型
 * @return [Class]
 */
val NumberFormatExceptionClass get() = classOf<NumberFormatException>()

/**
 * 获得 [IllegalStateException] 类型
 * @return [Class]
 */
val IllegalStateExceptionClass get() = classOf<IllegalStateException>()

/**
 * 获得 [RuntimeException] 类型
 * @return [Class]
 */
val RuntimeExceptionClass get() = classOf<RuntimeException>()

/**
 * 获得 [ClassNotFoundException] 类型
 * @return [Class]
 */
val ClassNotFoundExceptionClass get() = classOf<ClassNotFoundException>()

/**
 * 获得 [NoClassDefFoundError] 类型
 * @return [Class]
 */
val NoClassDefFoundErrorClass get() = classOf<NoClassDefFoundError>()

/**
 * 获得 [NoSuchMethodError] 类型
 * @return [Class]
 */
val NoSuchMethodErrorClass get() = classOf<NoSuchMethodError>()

/**
 * 获得 [NoSuchFieldError] 类型
 * @return [Class]
 */
val NoSuchFieldErrorClass get() = classOf<NoSuchFieldError>()

/**
 * 获得 [Error] 类型
 * @return [Class]
 */
val ErrorClass get() = classOf<Error>()

/**
 * 获得 [Exception] 类型
 * @return [Class]
 */
val ExceptionClass get() = classOf<Exception>()

/**
 * 获得 [Throwable] 类型
 * @return [Class]
 */
val ThrowableClass get() = classOf<Throwable>()