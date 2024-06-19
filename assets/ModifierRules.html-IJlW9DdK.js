import{_ as e,o as s,c as o,a}from"./app-_EbBKIXU.js";const c={},d=a(`<h1 id="modifierrules-class" tabindex="-1"><a class="header-anchor" href="#modifierrules-class" aria-hidden="true">#</a> ModifierRules <span class="symbol">- class</span></h1><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">class</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">ModifierRules</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">private</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">constructor</span><span style="color:#ADBAC7;">()</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>新增 <code>Class</code> 的描述符判断</p><p>作为 lambda 整体判断条件使用</p><p>移动到 base 包名</p><p>私有化构造方法</p><p><strong>功能描述</strong></p><blockquote><p>这是一个 <code>Class</code>、<code>Member</code> 描述符条件实现类。</p></blockquote><p>可对 R8 混淆后的 <code>Class</code>、<code>Member</code> 进行更加详细的定位。</p><h2 id="ispublic-i-ext-field" tabindex="-1"><a class="header-anchor" href="#ispublic-i-ext-field" aria-hidden="true">#</a> isPublic <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isPublic: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Class</code>、<code>Member</code> 类型是否包含 <code>public</code>。</p></blockquote><h2 id="isprivate-i-ext-field" tabindex="-1"><a class="header-anchor" href="#isprivate-i-ext-field" aria-hidden="true">#</a> isPrivate <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isPrivate: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Class</code>、<code>Member</code> 类型是否包含 <code>private</code>。</p></blockquote><h2 id="isprotected-i-ext-field" tabindex="-1"><a class="header-anchor" href="#isprotected-i-ext-field" aria-hidden="true">#</a> isProtected <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isProtected: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Class</code>、<code>Member</code> 类型是否包含 <code>protected</code>。</p></blockquote><h2 id="isstatic-i-ext-field" tabindex="-1"><a class="header-anchor" href="#isstatic-i-ext-field" aria-hidden="true">#</a> isStatic <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isStatic: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Class</code>、<code>Member</code> 类型是否包含 <code>static</code>。</p></blockquote><p>对于任意的静态 <code>Class</code>、<code>Member</code> 可添加此描述进行确定。</p><div class="custom-container warning"><p class="custom-container-title">注意</p><p>Kotlin → Jvm 后的 <strong>object</strong> 类中的方法并不是静态的。</p></div><h2 id="isfinal-i-ext-field" tabindex="-1"><a class="header-anchor" href="#isfinal-i-ext-field" aria-hidden="true">#</a> isFinal <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isFinal: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Class</code>、<code>Member</code> 类型是否包含 <code>final</code>。</p></blockquote><div class="custom-container warning"><p class="custom-container-title">注意</p><p>Kotlin → Jvm 后没有 <strong>open</strong> 符号标识的 <strong>Class</strong>、<strong>Member</strong> 和没有任何关联的 <strong>Class</strong>、<strong>Member</strong> 都将为 <strong>final</strong>。</p></div><h2 id="issynchronized-i-ext-field" tabindex="-1"><a class="header-anchor" href="#issynchronized-i-ext-field" aria-hidden="true">#</a> isSynchronized <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isSynchronized: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Class</code>、<code>Member</code> 类型是否包含 <code>synchronized</code>。</p></blockquote><h2 id="isvolatile-i-ext-field" tabindex="-1"><a class="header-anchor" href="#isvolatile-i-ext-field" aria-hidden="true">#</a> isVolatile <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isVolatile: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Field</code> 类型是否包含 <code>volatile</code>。</p></blockquote><h2 id="istransient-i-ext-field" tabindex="-1"><a class="header-anchor" href="#istransient-i-ext-field" aria-hidden="true">#</a> isTransient <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isTransient: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Field</code> 类型是否包含 <code>transient</code>。</p></blockquote><h2 id="isnative-i-ext-field" tabindex="-1"><a class="header-anchor" href="#isnative-i-ext-field" aria-hidden="true">#</a> isNative <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isNative: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Method</code> 类型是否包含 <code>native</code>。</p></blockquote><p>对于任意 JNI 对接的 <code>Method</code> 可添加此描述进行确定。</p><h2 id="isinterface-i-ext-field" tabindex="-1"><a class="header-anchor" href="#isinterface-i-ext-field" aria-hidden="true">#</a> isInterface <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isInterface: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Class</code> 类型是否包含 <code>interface</code>。</p></blockquote><h2 id="isabstract-i-ext-field" tabindex="-1"><a class="header-anchor" href="#isabstract-i-ext-field" aria-hidden="true">#</a> isAbstract <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isAbstract: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Class</code>、<code>Member</code> 类型是否包含 <code>abstract</code>。</p></blockquote><p>对于任意的抽象 <code>Class</code>、<code>Member</code> 可添加此描述进行确定。</p><h2 id="isstrict-i-ext-field" tabindex="-1"><a class="header-anchor" href="#isstrict-i-ext-field" aria-hidden="true">#</a> isStrict <span class="symbol">- i-ext-field</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> isStrict: </span><span style="color:#F69D50;">Boolean</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.67</code> <code>新增</code></p><p><code>v1.1.0</code> <code>修改</code></p><p>统一合并到扩展方法并改名</p><p><strong>功能描述</strong></p><blockquote><p><code>Class</code>、<code>Member</code> 类型是否包含 <code>strictfp</code>。</p></blockquote>`,113),n=[d];function l(t,i){return s(),o("div",null,n)}const r=e(c,[["render",l],["__file","ModifierRules.html.vue"]]);export{r as default};
