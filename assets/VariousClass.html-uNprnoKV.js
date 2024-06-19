import{_ as s,o,c as a,a as e}from"./app-_EbBKIXU.js";const n={},l=e(`<div class="custom-container warning"><p class="custom-container-title">Notice</p><p>The English translation of this page has not been completed, you are welcome to contribute translations to us.</p><p>You can use the <strong>Chrome Translation Plugin</strong> to translate entire pages for reference.</p></div><h1 id="variousclass-class" tabindex="-1"><a class="header-anchor" href="#variousclass-class" aria-hidden="true">#</a> VariousClass <span class="symbol">- class</span></h1><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">class</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">VariousClass</span><span style="color:#ADBAC7;">(</span><span style="color:#F47067;">private</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">vararg</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> name: </span><span style="color:#F69D50;">String</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><p><strong>Change Records</strong></p><p><code>v1.0</code> <code>first</code></p><p><code>v1.1.5</code> <code>modified</code></p><p>私有化 <code>name</code> 参数并设置为不可修改</p><p><strong>Function Illustrate</strong></p><blockquote><p>这是一个不确定性 <code>Class</code> 类名装载器，通过 <code>name</code> 装载 <code>Class</code> 名称数组。</p></blockquote><h2 id="get-method" tabindex="-1"><a class="header-anchor" href="#get-method" aria-hidden="true">#</a> get <span class="symbol">- method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">get</span><span style="color:#ADBAC7;">(loader: </span><span style="color:#F69D50;">ClassLoader</span><span style="color:#ADBAC7;">? </span><span style="color:#F47067;">=</span><span style="color:#ADBAC7;"> </span><span style="color:#6CB6FF;">null</span><span style="color:#ADBAC7;">, initialize: </span><span style="color:#F69D50;">Boolean</span><span style="color:#ADBAC7;">): </span><span style="color:#F69D50;">Class</span><span style="color:#ADBAC7;">&lt;*&gt;</span></span>
<span class="line"></span></code></pre></div><p><strong>Change Records</strong></p><p><code>v1.0.70</code> <code>added</code></p><p><code>v1.1.5</code> <code>modified</code></p><p>新增 <code>initialize</code> 参数</p><p><strong>Function Illustrate</strong></p><blockquote><p>获取匹配的实体类。</p></blockquote><p>使用当前 <code>loader</code> 装载目标 <code>Class</code>。</p><h2 id="getornull-method" tabindex="-1"><a class="header-anchor" href="#getornull-method" aria-hidden="true">#</a> getOrNull <span class="symbol">- method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">getOrNull</span><span style="color:#ADBAC7;">(loader: </span><span style="color:#F69D50;">ClassLoader</span><span style="color:#ADBAC7;">? </span><span style="color:#F47067;">=</span><span style="color:#ADBAC7;"> </span><span style="color:#6CB6FF;">null</span><span style="color:#ADBAC7;">, initialize: </span><span style="color:#F69D50;">Boolean</span><span style="color:#ADBAC7;">): </span><span style="color:#F69D50;">Class</span><span style="color:#ADBAC7;">&lt;*&gt;?</span></span>
<span class="line"></span></code></pre></div><p><strong>Change Records</strong></p><p><code>v1.1.0</code> <code>added</code></p><p><code>v1.1.5</code> <code>modified</code></p><p>新增 <code>initialize</code> 参数</p><p><strong>Function Illustrate</strong></p><blockquote><p>获取匹配的实体类。</p></blockquote><p>使用当前 <code>loader</code> 装载目标 <code>Class</code>。</p><p>匹配不到 <code>Class</code> 会返回 <code>null</code>，不会抛出异常。</p>`,28),c=[l];function t(p,r){return o(),a("div",null,c)}const i=s(n,[["render",t],["__file","VariousClass.html.vue"]]);export{i as default};
