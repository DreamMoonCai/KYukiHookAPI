package com.dream.yukihookapi.hook.entity

import com.dream.yukihookapi.hook.param.KPackageParam
import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.log.YLog
import com.highcapable.yukihookapi.hook.param.PackageParam
import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker

/**
 * [YukiHookAPI] 的子类 Hooker 实现
 *
 * 也许你的模块中存在多个功能模块 (Hooker) - 继承并使用此类可以方便帮你管理每个功能模块 (Hooker)
 *
 * 更多请参考 [InjectYukiHookWithXposed] 中的注解内容
 *
 * 详情请参考 [通过自定义 Hooker 创建](https://highcapable.github.io/YukiHookAPI/zh-cn/config/api-example#%E9%80%9A%E8%BF%87%E8%87%AA%E5%AE%9A%E4%B9%89-hooker-%E5%88%9B%E5%BB%BA)
 *
 * For English version, see [Created by Custom Hooker](https://highcapable.github.io/YukiHookAPI/en/config/api-example#created-by-custom-hooker)
 *
 * - 与原[YukiBaseHooker]功能一致但拓展于Kotlin
 */
abstract class KYukiBaseHooker : KPackageParam() {

    /**
     * 赋值并克隆一个 [KPackageParam]
     * @param packageParam 需要使用的 [KPackageParam]
     */
    internal fun assignInstance(packageParam: KPackageParam) {
        assign(packageParam.wrapper)
        runCatching { onHook() }.onFailure { YLog.innerE("An exception occurred in $this", it) }
    }

    /** 子类 Hook 开始 */
    abstract fun onHook()
}