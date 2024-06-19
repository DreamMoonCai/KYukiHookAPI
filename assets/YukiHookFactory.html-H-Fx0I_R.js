import{_ as e,o,c as s,a}from"./app-_EbBKIXU.js";const c={},p=a(`<h1 id="yukihookfactory-kt" tabindex="-1"><a class="header-anchor" href="#yukihookfactory-kt" aria-hidden="true">#</a> YukiHookFactory <span class="symbol">- kt</span></h1><p><strong>变更记录</strong></p><p><code>v1.0</code> <code>添加</code></p><p><code>v1.0.80</code> <code>修改</code></p><p>合并到 <code>IYukiHookXposedInit</code>，将方法体进行 inline</p><p><strong>功能描述</strong></p><blockquote><p>这是 <code>YukiHookAPI</code> 相关 <strong>lambda</strong> 方法的封装类以及部分 API 用法。</p></blockquote><h2 id="iyukihookxposedinit-configs-ext-method" tabindex="-1"><a class="header-anchor" href="#iyukihookxposedinit-configs-ext-method" aria-hidden="true">#</a> IYukiHookXposedInit.configs <span class="symbol">- ext-method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">inline</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">IYukiHookXposedInit</span><span style="color:#ADBAC7;">.</span><span style="color:#DCBDFB;">configs</span><span style="color:#ADBAC7;">(initiate: </span><span style="color:#F69D50;">YukiHookAPI</span><span style="color:#ADBAC7;">.Configs.() </span><span style="color:#F47067;">-&gt;</span><span style="color:#ADBAC7;"> Unit)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.1</code> <code>新增</code></p><p><code>v1.0.80</code> <code>修改</code></p><p>合并到 <code>IYukiHookXposedInit</code></p><p><strong>功能描述</strong></p><blockquote><p>在 <code>IYukiHookXposedInit</code> 中配置 <code>Configs</code>。</p></blockquote><h2 id="iyukihookxposedinit-encase-ext-method" tabindex="-1"><a class="header-anchor" href="#iyukihookxposedinit-encase-ext-method" aria-hidden="true">#</a> IYukiHookXposedInit.encase <span class="symbol">- ext-method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">IYukiHookXposedInit</span><span style="color:#ADBAC7;">.</span><span style="color:#DCBDFB;">encase</span><span style="color:#ADBAC7;">(initiate: </span><span style="color:#F69D50;">PackageParam</span><span style="color:#ADBAC7;">.() </span><span style="color:#F47067;">-&gt;</span><span style="color:#ADBAC7;"> Unit)</span></span>
<span class="line"></span></code></pre></div><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">IYukiHookXposedInit</span><span style="color:#ADBAC7;">.</span><span style="color:#DCBDFB;">encase</span><span style="color:#ADBAC7;">(</span><span style="color:#F47067;">vararg</span><span style="color:#ADBAC7;"> hooker: </span><span style="color:#F69D50;">YukiBaseHooker</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0</code> <code>添加</code></p><p><code>v1.0.80</code> <code>修改</code></p><p>合并到 <code>IYukiHookXposedInit</code></p><p><strong>功能描述</strong></p><blockquote><p>在 <code>IYukiHookXposedInit</code> 中调用 <code>YukiHookAPI</code>。</p></blockquote><h2 class="deprecated">Context.modulePrefs - ext-field</h2><p><strong>变更记录</strong></p><p><code>v1.0</code> <code>添加</code></p><p><code>v1.1.9</code> <code>作废</code></p><p>请迁移到 <code>prefs</code> 方法</p><h2 class="deprecated">Context.modulePrefs - ext-method</h2><p><strong>变更记录</strong></p><p><code>v1.0</code> <code>添加</code></p><p><code>v1.1.9</code> <code>作废</code></p><p>请迁移到 <code>prefs</code> 方法</p><h2 id="context-prefs-ext-method" tabindex="-1"><a class="header-anchor" href="#context-prefs-ext-method" aria-hidden="true">#</a> Context.prefs <span class="symbol">- ext-method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">Context</span><span style="color:#ADBAC7;">.</span><span style="color:#DCBDFB;">prefs</span><span style="color:#ADBAC7;">(name: </span><span style="color:#F69D50;">String</span><span style="color:#ADBAC7;">): </span><span style="color:#F69D50;">YukiHookPrefsBridge</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.1.9</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>创建 <code>YukiHookPrefsBridge</code> 对象。</p></blockquote><p>可以同时在模块与 (Xposed) 宿主环境中使用。</p><p>如果你想在 (Xposed) 宿主环境将数据存入当前宿主的私有空间，请使用 <code>YukiHookPrefsBridge.native</code> 方法。</p><p>在未声明任何条件的情况下 (Xposed) 宿主环境默认读取模块中的数据。</p><h2 id="context-datachannel-ext-method" tabindex="-1"><a class="header-anchor" href="#context-datachannel-ext-method" aria-hidden="true">#</a> Context.dataChannel <span class="symbol">- ext-method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">Context</span><span style="color:#ADBAC7;">.</span><span style="color:#DCBDFB;">dataChannel</span><span style="color:#ADBAC7;">(packageName: </span><span style="color:#F69D50;">String</span><span style="color:#ADBAC7;">): </span><span style="color:#F69D50;">YukiHookDataChannel</span><span style="color:#ADBAC7;">.NameSpace</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.88</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>获取 <code>YukiHookDataChannel</code> 对象。</p></blockquote><div class="custom-container danger"><p class="custom-container-title">特别注意</p><p>只能在模块环境使用此功能，其它环境下使用将不起作用。</p></div><h2 id="context-processname-ext-field" tabindex="-1"><a class="header-anchor" href="#context-processname-ext-field" aria-hidden="true">#</a> Context.processName <span class="symbol">- ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> Context.processName: </span><span style="color:#F69D50;">String</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0</code> <code>添加</code></p><p><strong>功能描述</strong></p><blockquote><p>获取当前进程名称。</p></blockquote><h2 id="context-resources-injectmoduleappresources-ext-method" tabindex="-1"><a class="header-anchor" href="#context-resources-injectmoduleappresources-ext-method" aria-hidden="true">#</a> Context+Resources.injectModuleAppResources <span class="symbol">- ext-method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">Context</span><span style="color:#ADBAC7;">.</span><span style="color:#DCBDFB;">injectModuleAppResources</span><span style="color:#ADBAC7;">()</span></span>
<span class="line"></span></code></pre></div><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">Resources</span><span style="color:#ADBAC7;">.</span><span style="color:#DCBDFB;">injectModuleAppResources</span><span style="color:#ADBAC7;">()</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.1.0</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>向 Hook APP (宿主) <code>Context</code> 或 <code>Resources</code> 注入当前 Xposed 模块的资源。</p></blockquote><p>注入成功后，你就可以直接使用例如 <code>ImageView.setImageResource</code> 或 <code>Resources.getString</code> 装载当前 Xposed 模块的资源 ID。</p><p>注入的资源作用域仅限当前 <code>Context</code> 或 <code>Resources</code>，你需要在每个用到宿主 <code>Context</code> 或 <code>Resources</code> 的地方重复调用此方法进行注入才能使用。</p><div class="custom-container danger"><p class="custom-container-title">特别注意</p><p>只能在 (Xposed) 宿主环境使用此功能，其它环境下使用将不生效且会打印警告信息。</p></div><h2 id="context-registermoduleappactivities-ext-method" tabindex="-1"><a class="header-anchor" href="#context-registermoduleappactivities-ext-method" aria-hidden="true">#</a> Context.registerModuleAppActivities <span class="symbol">- ext-method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">Context</span><span style="color:#ADBAC7;">.</span><span style="color:#DCBDFB;">registerModuleAppActivities</span><span style="color:#ADBAC7;">(proxy: </span><span style="color:#F69D50;">Any</span><span style="color:#ADBAC7;">?)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.1.0</code> <code>新增</code></p><p><code>v1.1.5</code> <code>修改</code></p><p>加入最低 API 版本限制</p><p><strong>功能描述</strong></p><blockquote><p>向 Hook APP (宿主) 注册当前 Xposed 模块的 <code>Activity</code>。</p></blockquote><p>注册成功后，你就可以直接使用 <code>Context.startActivity</code> 来启动未在宿主中注册的 <code>Activity</code>。</p><p>使用此方法会在未注册的 <code>Activity</code> 在 Hook APP (宿主) 中启动时自动调用 <code>injectModuleAppResources</code> 注入当前 Xposed 模块的资源。</p><p>你要将需要在宿主启动的 <code>Activity</code> 继承于 <code>ModuleAppActivity</code> 或 <code>ModuleAppCompatActivity</code>。</p><div class="custom-container danger"><p class="custom-container-title">特别注意</p><p>只能在 (Xposed) 宿主环境使用此功能，其它环境下使用将不生效且会打印警告信息。</p><p>最低支持 Android 7.0 (API 24)。</p></div><h2 id="context-applymoduletheme-ext-method" tabindex="-1"><a class="header-anchor" href="#context-applymoduletheme-ext-method" aria-hidden="true">#</a> Context.applyModuleTheme <span class="symbol">- ext-method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">Context</span><span style="color:#ADBAC7;">.</span><span style="color:#DCBDFB;">applyModuleTheme</span><span style="color:#ADBAC7;">(theme: </span><span style="color:#F69D50;">Int</span><span style="color:#ADBAC7;">, configuration: </span><span style="color:#F69D50;">Configuration</span><span style="color:#ADBAC7;">?): </span><span style="color:#F69D50;">ModuleContextThemeWrapper</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.1.0</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>生成一个 <code>ContextThemeWrapper</code> 代理以应用当前 Xposed 模块的主题资源。</p></blockquote><p>在 Hook APP (宿主) 中使用此方法会自动调用 <code>injectModuleAppResources</code> 注入当前 Xposed 模块的资源。</p><p>如果在 Hook APP (宿主) 中使用此方法发生 <code>ClassCastException</code>，请手动设置 <code>configuration</code>。</p><h2 class="deprecated">isSupportResourcesHook - field</h2><p><strong>变更记录</strong></p><p><code>v1.0.80</code> <code>新增</code></p><p><code>v1.0.91</code> <code>移除</code></p><p>请迁移到 <code>YukiHookAPI.Status.isSupportResourcesHook</code></p><h2 class="deprecated">isModuleActive - field</h2><p><strong>变更记录</strong></p><p><code>v1.0.6</code> <code>新增</code></p><p><code>v1.0.91</code> <code>移除</code></p><p>请迁移到 <code>YukiHookAPI.Status.isModuleActive</code></p><h2 class="deprecated">isXposedModuleActive - field</h2><p><strong>变更记录</strong></p><p><code>v1.0.6</code> <code>新增</code></p><p><code>v1.0.91</code> <code>移除</code></p><p>请迁移到 <code>YukiHookAPI.Status.isXposedModuleActive</code></p><h2 class="deprecated">isTaiChiModuleActive - field</h2><p><strong>变更记录</strong></p><p><code>v1.0</code> <code>添加</code></p><p><code>v1.0.91</code> <code>移除</code></p><p>请迁移到 <code>YukiHookAPI.Status.isTaiChiModuleActive</code></p><h1 class="deprecated">YukiHookModuleStatus - class</h1><p><strong>变更记录</strong></p><p><code>v1.0</code> <code>添加</code></p><p><code>v1.0.91</code> <code>作废</code></p><p>请迁移到 <code>YukiHookAPI.Status</code></p>`,111),n=[p];function t(d,l){return o(),s("div",null,n)}const i=e(c,[["render",t],["__file","YukiHookFactory.html.vue"]]);export{i as default};
