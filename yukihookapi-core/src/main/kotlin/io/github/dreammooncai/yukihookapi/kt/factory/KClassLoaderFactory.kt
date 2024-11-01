@file:Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE","INVISIBLE_REFERENCE","INVISIBLE_MEMBER")
package io.github.dreammooncai.yukihookapi.kt.factory

import com.highcapable.yukihookapi.hook.factory.field
import com.highcapable.yukihookapi.hook.log.YLog
import java.util.Collections


object KClassLoaderFactory {
    @get:Synchronized
    val dynamicClassLoader: MutableList<ClassLoader> =
        Collections.synchronizedList(mutableListOf<ClassLoader>())

    /**
     * 获取指定类加载器其祖父链上重复的加载器,引起重复的孩子,未找到重复则返回Null
     *
     * @param target 被指定的检测起始的加载器
     * @param repeat 被指定的检测重复的加载器
     * @return 如果有则返回重复的孩子,否则Null
     */
    @JvmStatic
    fun getRepeat(target: ClassLoader?, repeat: ClassLoader?): ClassLoader? {
        tailrec fun repeat(parent: ClassLoader?): ClassLoader? {
            return if (parent == null) null else if (parent.parent == repeat) parent else repeat(
                parent.parent
            )
        }

        return repeat(target)
    }

    /**
     * 如果[new]不在[target]的父加载器中则
     *
     * 将[new]插入到[target]中
     *
     * @param target 目标需要进行操作的类加载器
     * @param new 新插入的类加载器
     */
    @JvmStatic
    fun insertClassLoader(target: ClassLoader, new: ClassLoader) {
        ClassLoader::class.java.field {
            name = "parent"
        }.get(target).let {
            if (it.any() != new)
                it.set(new)
        }
    }

    /**
     * 如果[remove]在[target]的父加载器中则
     *
     * 将[remove]从[target]移除
     *
     * @param target 目标需要进行操作的类加载器
     * @param remove 需要移除的类加载器
     */
    @JvmStatic
    fun removeClassLoader(target: ClassLoader, remove: ClassLoader) {
        ClassLoader::class.java.field {
            name = "parent"
        }.get(target).let {
            if (it.any() == remove)
                it.set(remove.parent)
        }
    }
}