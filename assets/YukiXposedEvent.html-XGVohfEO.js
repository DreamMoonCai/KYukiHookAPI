import{_ as s,o as e,c as a,a as o}from"./app-_EbBKIXU.js";const n={},t=o(`<h1 id="yukixposedevent-object" tabindex="-1"><a class="header-anchor" href="#yukixposedevent-object" aria-hidden="true">#</a> YukiXposedEvent <span class="symbol">- object</span></h1><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">object</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">YukiXposedEvent</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.80</code> <code>添加</code></p><p><strong>功能描述</strong></p><blockquote><p>实现对原生 Xposed API 的装载事件监听。</p></blockquote><h2 id="events-method" tabindex="-1"><a class="header-anchor" href="#events-method" aria-hidden="true">#</a> events <span class="symbol">- method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">inline</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">events</span><span style="color:#ADBAC7;">(initiate: </span><span style="color:#F69D50;">YukiXposedEvent</span><span style="color:#ADBAC7;">.() </span><span style="color:#F47067;">-&gt;</span><span style="color:#ADBAC7;"> Unit)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.80</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>对 <code>YukiXposedEvent</code> 创建一个方法体。</p></blockquote><h2 id="oninitzygote-method" tabindex="-1"><a class="header-anchor" href="#oninitzygote-method" aria-hidden="true">#</a> onInitZygote <span class="symbol">- method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">onInitZygote</span><span style="color:#ADBAC7;">(result: (</span><span style="color:#F69D50;">StartupParam</span><span style="color:#ADBAC7;">) -&gt; </span><span style="color:#F69D50;">Unit</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.80</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>设置 initZygote 事件监听。</p></blockquote><h2 id="onhandleloadpackage-method" tabindex="-1"><a class="header-anchor" href="#onhandleloadpackage-method" aria-hidden="true">#</a> onHandleLoadPackage <span class="symbol">- method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">onHandleLoadPackage</span><span style="color:#ADBAC7;">(result: (</span><span style="color:#F69D50;">LoadPackageParam</span><span style="color:#ADBAC7;">) -&gt; </span><span style="color:#F69D50;">Unit</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.80</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>设置 handleLoadPackage 事件监听。</p></blockquote><h2 id="onhandleinitpackageresources-method" tabindex="-1"><a class="header-anchor" href="#onhandleinitpackageresources-method" aria-hidden="true">#</a> onHandleInitPackageResources <span class="symbol">- method</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">onHandleInitPackageResources</span><span style="color:#ADBAC7;">(result: (</span><span style="color:#F69D50;">InitPackageResourcesParam</span><span style="color:#ADBAC7;">) -&gt; </span><span style="color:#F69D50;">Unit</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.80</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>设置 handleInitPackageResources 事件监听。</p></blockquote>`,30),l=[t];function p(c,d){return e(),a("div",null,l)}const i=s(n,[["render",p],["__file","YukiXposedEvent.html.vue"]]);export{i as default};
