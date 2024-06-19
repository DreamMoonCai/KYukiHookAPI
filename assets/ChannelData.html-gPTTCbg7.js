import{_ as s,o as a,c as n,a as l}from"./app-_EbBKIXU.js";const e={},o=l(`<div class="custom-container warning"><p class="custom-container-title">Notice</p><p>The English translation of this page has not been completed, you are welcome to contribute translations to us.</p><p>You can use the <strong>Chrome Translation Plugin</strong> to translate entire pages for reference.</p></div><h1 id="channeldata-class" tabindex="-1"><a class="header-anchor" href="#channeldata-class" aria-hidden="true">#</a> ChannelData <span class="symbol">- class</span></h1><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">data</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">class</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">ChannelData</span><span style="color:#ADBAC7;">&lt;</span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">&gt;(</span><span style="color:#F47067;">var</span><span style="color:#ADBAC7;"> key: </span><span style="color:#F69D50;">String</span><span style="color:#ADBAC7;">, </span><span style="color:#F47067;">var</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">value</span><span style="color:#ADBAC7;">: </span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">?) : </span><span style="color:#F69D50;">Serializable</span></span>
<span class="line"></span></code></pre></div><p><strong>Change Records</strong></p><p><code>v1.0.88</code> <code>added</code></p><p><code>v1.1.5</code> <code>modified</code></p><p>实现了 <code>Serializable</code> 接口</p><p><strong>Function Illustrate</strong></p><blockquote><p>数据通讯桥键值构造类。</p></blockquote><p>这个类是对 <code>YukiHookDataChannel</code> 的一个扩展用法。</p><p><strong>Function Example</strong></p><p>建立一个模板类定义模块与宿主需要发送的键值数据。</p><blockquote><p>The following example</p></blockquote><div class="language-kotlin line-numbers-mode" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">object</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">DataConst</span><span style="color:#ADBAC7;"> {</span></span>
<span class="line"></span>
<span class="line"><span style="color:#ADBAC7;">    </span><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> TEST_KV_DATA_1 </span><span style="color:#F47067;">=</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">ChannelData</span><span style="color:#ADBAC7;">(</span><span style="color:#96D0FF;">&quot;test_data_1&quot;</span><span style="color:#ADBAC7;">, </span><span style="color:#96D0FF;">&quot;defalut value&quot;</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"><span style="color:#ADBAC7;">    </span><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> TEST_KV_DATA_2 </span><span style="color:#F47067;">=</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">ChannelData</span><span style="color:#ADBAC7;">(</span><span style="color:#96D0FF;">&quot;test_data_2&quot;</span><span style="color:#ADBAC7;">, </span><span style="color:#6CB6FF;">0</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"><span style="color:#ADBAC7;">}</span></span>
<span class="line"></span></code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>键值数据定义后，你就可以方便地在模块和宿主中调用所需要发送的数据。</p><blockquote><p>模块示例如下</p></blockquote><div class="language-kotlin line-numbers-mode" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#768390;">// 从指定包名的宿主获取</span></span>
<span class="line"><span style="color:#DCBDFB;">dataChannel</span><span style="color:#ADBAC7;">(packageName </span><span style="color:#F47067;">=</span><span style="color:#ADBAC7;"> </span><span style="color:#96D0FF;">&quot;com.example.demo&quot;</span><span style="color:#ADBAC7;">).</span><span style="color:#DCBDFB;">wait</span><span style="color:#ADBAC7;">(DataConst.TEST_KV_DATA_1) { </span><span style="color:#F47067;">value</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">-&gt;</span></span>
<span class="line"><span style="color:#ADBAC7;">    </span><span style="color:#768390;">// Your code here.</span></span>
<span class="line"><span style="color:#ADBAC7;">}</span></span>
<span class="line"><span style="color:#768390;">// 发送给指定包名的宿主 - 未填写 value 时将使用模板提供的默认值</span></span>
<span class="line"><span style="color:#DCBDFB;">dataChannel</span><span style="color:#ADBAC7;">(packageName </span><span style="color:#F47067;">=</span><span style="color:#ADBAC7;"> </span><span style="color:#96D0FF;">&quot;com.example.demo&quot;</span><span style="color:#ADBAC7;">).</span><span style="color:#DCBDFB;">put</span><span style="color:#ADBAC7;">(DataConst.TEST_KV_DATA_1, </span><span style="color:#F47067;">value</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">=</span><span style="color:#ADBAC7;"> </span><span style="color:#96D0FF;">&quot;sending value&quot;</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><blockquote><p>宿主示例如下</p></blockquote><div class="language-kotlin line-numbers-mode" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#768390;">// 从模块获取</span></span>
<span class="line"><span style="color:#ADBAC7;">dataChannel.</span><span style="color:#DCBDFB;">wait</span><span style="color:#ADBAC7;">(DataConst.TEST_KV_DATA_1) { </span><span style="color:#F47067;">value</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">-&gt;</span></span>
<span class="line"><span style="color:#ADBAC7;">    </span><span style="color:#768390;">// Your code here.</span></span>
<span class="line"><span style="color:#ADBAC7;">}</span></span>
<span class="line"><span style="color:#768390;">// 发送给模块 - 未填写 value 时将使用模板提供的默认值</span></span>
<span class="line"><span style="color:#ADBAC7;">dataChannel.</span><span style="color:#DCBDFB;">put</span><span style="color:#ADBAC7;">(DataConst.TEST_KV_DATA_1, </span><span style="color:#F47067;">value</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">=</span><span style="color:#ADBAC7;"> </span><span style="color:#96D0FF;">&quot;sending value&quot;</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p>你依然可以不使用模板定义的默认值，随时修改你的默认值。</p><blockquote><p>The following example</p></blockquote><div class="language-kotlin line-numbers-mode" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#768390;">// 获取 - 此时 value 取到的默认值将会是 2 - 并不是模板提供的 0</span></span>
<span class="line"><span style="color:#ADBAC7;">dataChannel.</span><span style="color:#DCBDFB;">wait</span><span style="color:#ADBAC7;">(DataConst.TEST_KV_DATA_2, </span><span style="color:#F47067;">value</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">=</span><span style="color:#ADBAC7;"> </span><span style="color:#6CB6FF;">2</span><span style="color:#ADBAC7;">) { </span><span style="color:#F47067;">value</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">-&gt;</span></span>
<span class="line"><span style="color:#ADBAC7;">    </span><span style="color:#768390;">// Your code here.</span></span>
<span class="line"><span style="color:#ADBAC7;">}</span></span>
<span class="line"></span></code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div>`,22),p=[o];function t(c,r){return a(),n("div",null,p)}const d=s(e,[["render",t],["__file","ChannelData.html.vue"]]);export{d as default};
