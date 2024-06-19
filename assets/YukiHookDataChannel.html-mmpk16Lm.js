import{_ as s,o as a,c as o,a as e}from"./app-_EbBKIXU.js";const n={},p=e(`<h1 id="yukihookdatachannel-class" tabindex="-1"><a class="header-anchor" href="#yukihookdatachannel-class" aria-hidden="true">#</a> YukiHookDataChannel <span class="symbol">- class</span></h1><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">class</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">YukiHookDataChannel</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">private</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">constructor</span><span style="color:#ADBAC7;">()</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.88</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>实现 Xposed 模块的数据通讯桥。</p></blockquote><p>通过模块与宿主相互注册 <code>BroadcastReceiver</code> 来实现数据的交互。</p><p>模块需要将 <code>Application</code> 继承于 <code>ModuleApplication</code> 来实现此功能。</p><div class="custom-container danger"><p class="custom-container-title">特别注意</p><p>模块与宿主需要保持存活状态，否则无法建立通讯。</p></div><h2 id="namespace-class" tabindex="-1"><a class="header-anchor" href="#namespace-class" aria-hidden="true">#</a> NameSpace <span class="symbol">- class</span></h2><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">inner</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">class</span><span style="color:#ADBAC7;"> </span><span style="color:#F69D50;">NameSpace</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">internal</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">constructor</span><span style="color:#ADBAC7;">(</span><span style="color:#F47067;">private</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> context: </span><span style="color:#F69D50;">Context</span><span style="color:#ADBAC7;">?, </span><span style="color:#F47067;">private</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">val</span><span style="color:#ADBAC7;"> packageName: </span><span style="color:#F69D50;">String</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.88</code> <code>新增</code></p><p><code>v1.0.90</code> <code>修改</code></p><p>新增 <code>isSecure</code> 参数</p><p><code>v1.1.9</code> <code>修改</code></p><p>移除 <code>isSecure</code> 参数</p><p><strong>功能描述</strong></p><blockquote><p><code>YukiHookDataChannel</code> 命名空间。</p></blockquote><h3 id="with-method" tabindex="-1"><a class="header-anchor" href="#with-method" aria-hidden="true">#</a> with <span class="symbol">- method</span></h3><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">inline</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">with</span><span style="color:#ADBAC7;">(initiate: </span><span style="color:#F69D50;">NameSpace</span><span style="color:#ADBAC7;">.() </span><span style="color:#F47067;">-&gt;</span><span style="color:#ADBAC7;"> Unit): </span><span style="color:#F69D50;">NameSpace</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.88</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>创建一个调用空间。</p></blockquote><h3 id="datamaxbytesize-field" tabindex="-1"><a class="header-anchor" href="#datamaxbytesize-field" aria-hidden="true">#</a> dataMaxByteSize <span class="symbol">- field</span></h3><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">var</span><span style="color:#ADBAC7;"> dataMaxByteSize: </span><span style="color:#F69D50;">Int</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.1.9</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p><code>YukiHookDataChannel</code> 允许发送的最大数据字节大小。</p></blockquote><p>默认为 <code>500 KB (500 * 1024)</code>，详情请参考 <code>receiverDataMaxByteSize</code> 的注释。</p><p>最小不能低于 <code>100 KB (100 * 1024)</code>，否则会被重新设置为 <code>100 KB (100 * 1024)</code>。</p><p>设置后将在全局生效，直到当前进程结束。</p><p>超出最大数据字节大小后的数据将被自动分段发送。</p><div class="custom-container danger"><p class="custom-container-title">特别注意</p><p>请谨慎调整此参数，如果超出了系统能够允许的大小会引发 <strong>TransactionTooLargeException</strong> 异常。</p></div><h3 id="datamaxbytecompressionfactor-field" tabindex="-1"><a class="header-anchor" href="#datamaxbytecompressionfactor-field" aria-hidden="true">#</a> dataMaxByteCompressionFactor <span class="symbol">- field</span></h3><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">var</span><span style="color:#ADBAC7;"> dataMaxByteCompressionFactor: </span><span style="color:#F69D50;">Int</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.1.9</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p><code>YukiHookDataChannel</code> 允许发送的最大数据字节大小倍数 (分段数据)。</p></blockquote><p>默认为 <code>3</code>，详情请参考 <code>receiverDataMaxByteCompressionFactor</code> 的注释。</p><p>最小不能低于 <code>2</code>，否则会被重新设置为 <code>2</code>。</p><p>设置后将在全局生效，直到当前进程结束。</p><p>超出最大数据字节大小后的数据将按照此倍数自动划分 <code>receiverDataMaxByteSize</code> 的大小。</p><div class="custom-container danger"><p class="custom-container-title">特别注意</p><p>请谨慎调整此参数，如果超出了系统能够允许的大小会引发 <strong>TransactionTooLargeException</strong> 异常。</p></div><h3 id="allowsendtoolargedata-method" tabindex="-1"><a class="header-anchor" href="#allowsendtoolargedata-method" aria-hidden="true">#</a> allowSendTooLargeData <span class="symbol">- method</span></h3><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">allowSendTooLargeData</span><span style="color:#ADBAC7;">(): </span><span style="color:#F69D50;">NameSpace</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.1.5</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>解除发送数据的大小限制并禁止开启分段发送功能。</p></blockquote><p>仅会在每次调用时生效，下一次没有调用此方法则此功能将被自动关闭。</p><p>你还需要在整个调用域中声明注解 <code>SendTooLargeChannelData</code> 以消除警告。</p><div class="custom-container danger"><p class="custom-container-title">特别注意</p><p>若你不知道允许此功能会带来何种后果，请勿使用。</p></div><h3 id="put-method" tabindex="-1"><a class="header-anchor" href="#put-method" aria-hidden="true">#</a> put <span class="symbol">- method</span></h3><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> &lt;</span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">&gt; </span><span style="color:#DCBDFB;">put</span><span style="color:#ADBAC7;">(key: </span><span style="color:#F69D50;">String</span><span style="color:#ADBAC7;">, </span><span style="color:#F47067;">value</span><span style="color:#ADBAC7;">: </span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> &lt;</span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">&gt; </span><span style="color:#DCBDFB;">put</span><span style="color:#ADBAC7;">(</span><span style="color:#F47067;">data</span><span style="color:#ADBAC7;">: </span><span style="color:#F69D50;">ChannelData</span><span style="color:#ADBAC7;">&lt;</span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">&gt;, </span><span style="color:#F47067;">value</span><span style="color:#ADBAC7;">: </span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">?)</span></span>
<span class="line"></span></code></pre></div><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">put</span><span style="color:#ADBAC7;">(</span><span style="color:#F47067;">vararg</span><span style="color:#ADBAC7;"> </span><span style="color:#F47067;">data</span><span style="color:#ADBAC7;">: </span><span style="color:#F69D50;">ChannelData</span><span style="color:#ADBAC7;">&lt;*&gt;)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.88</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>发送键值数据。</p></blockquote><h3 id="put-method-1" tabindex="-1"><a class="header-anchor" href="#put-method-1" aria-hidden="true">#</a> put <span class="symbol">- method</span></h3><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">put</span><span style="color:#ADBAC7;">(key: </span><span style="color:#F69D50;">String</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.88</code> <code>新增</code></p><p><strong>功能描述</strong></p><blockquote><p>仅发送键值监听，使用默认值 <code>VALUE_WAIT_FOR_LISTENER</code> 发送键值数据。</p></blockquote><h3 id="wait-method" tabindex="-1"><a class="header-anchor" href="#wait-method" aria-hidden="true">#</a> wait <span class="symbol">- method</span></h3><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> &lt;</span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">&gt; </span><span style="color:#DCBDFB;">wait</span><span style="color:#ADBAC7;">(key: </span><span style="color:#F69D50;">String</span><span style="color:#ADBAC7;">, priority: </span><span style="color:#F69D50;">ChannelPriority</span><span style="color:#ADBAC7;">?, result: (</span><span style="color:#F69D50;">value</span><span style="color:#ADBAC7;">: </span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">) -&gt; </span><span style="color:#F69D50;">Unit</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> &lt;</span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">&gt; </span><span style="color:#DCBDFB;">wait</span><span style="color:#ADBAC7;">(</span><span style="color:#F47067;">data</span><span style="color:#ADBAC7;">: </span><span style="color:#F69D50;">ChannelData</span><span style="color:#ADBAC7;">&lt;</span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">&gt;, priority: </span><span style="color:#F69D50;">ChannelPriority</span><span style="color:#ADBAC7;">?, result: (</span><span style="color:#F69D50;">value</span><span style="color:#ADBAC7;">: </span><span style="color:#F69D50;">T</span><span style="color:#ADBAC7;">) -&gt; </span><span style="color:#F69D50;">Unit</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.88</code> <code>新增</code></p><p><code>v1.0.90</code> <code>修改</code></p><p>移除默认值 <code>value</code></p><p><code>v1.1.5</code> <code>修改</code></p><p>新增 <code>priority</code> 参数</p><p><strong>功能描述</strong></p><blockquote><p>获取键值数据。</p></blockquote><h3 id="wait-method-1" tabindex="-1"><a class="header-anchor" href="#wait-method-1" aria-hidden="true">#</a> wait <span class="symbol">- method</span></h3><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">wait</span><span style="color:#ADBAC7;">(key: </span><span style="color:#F69D50;">String</span><span style="color:#ADBAC7;">, priority: </span><span style="color:#F69D50;">ChannelPriority</span><span style="color:#ADBAC7;">?, callback: () </span><span style="color:#F47067;">-&gt;</span><span style="color:#ADBAC7;"> Unit)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.88</code> <code>新增</code></p><p><code>v1.1.5</code> <code>修改</code></p><p>新增 <code>priority</code> 参数</p><p><strong>功能描述</strong></p><blockquote><p>仅获取监听结果，不获取键值数据。</p></blockquote><div class="custom-container danger"><p class="custom-container-title">特别注意</p><p>仅限使用 <strong>VALUE_WAIT_FOR_LISTENER</strong> 发送的监听才能被接收。</p></div><h3 id="checkingversionequals-method" tabindex="-1"><a class="header-anchor" href="#checkingversionequals-method" aria-hidden="true">#</a> checkingVersionEquals <span class="symbol">- method</span></h3><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">checkingVersionEquals</span><span style="color:#ADBAC7;">(priority: </span><span style="color:#F69D50;">ChannelPriority</span><span style="color:#ADBAC7;">?, result: (</span><span style="color:#F69D50;">Boolean</span><span style="color:#ADBAC7;">) -&gt; </span><span style="color:#F69D50;">Unit</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.0.88</code> <code>新增</code></p><p><code>v1.1.5</code> <code>修改</code></p><p>新增 <code>priority</code> 参数</p><p><strong>功能描述</strong></p><blockquote><p>获取模块与宿主的版本是否匹配。</p></blockquote><p>通过此方法可原生判断 Xposed 模块更新后宿主并未重新装载造成两者不匹配的情况。</p><h3 id="obtainloggerinmemorydata-method" tabindex="-1"><a class="header-anchor" href="#obtainloggerinmemorydata-method" aria-hidden="true">#</a> obtainLoggerInMemoryData <span class="symbol">- method</span></h3><div class="language-kotlin" data-ext="kt"><pre class="shiki github-dark-dimmed" style="background-color:#22272e;" tabindex="0"><code><span class="line"><span style="color:#F47067;">fun</span><span style="color:#ADBAC7;"> </span><span style="color:#DCBDFB;">obtainLoggerInMemoryData</span><span style="color:#ADBAC7;">(priority: </span><span style="color:#F69D50;">ChannelPriority</span><span style="color:#ADBAC7;">?, result: (</span><span style="color:#F69D50;">List</span><span style="color:#ADBAC7;">&lt;</span><span style="color:#F69D50;">YLogData</span><span style="color:#ADBAC7;">&gt;) -&gt; </span><span style="color:#F69D50;">Unit</span><span style="color:#ADBAC7;">)</span></span>
<span class="line"></span></code></pre></div><p><strong>变更记录</strong></p><p><code>v1.1.4</code> <code>新增</code></p><p><code>v1.1.5</code> <code>修改</code></p><p>新增 <code>priority</code> 参数</p><p><strong>功能描述</strong></p><blockquote><p>获取模块与宿主之间的 <code>List&lt;YLogData&gt;</code> 数据。</p></blockquote><p>由于模块与宿主处于不同的进程，我们可以使用数据通讯桥访问各自的调试日志数据。</p><div class="custom-container danger"><p class="custom-container-title">特别注意</p><p>模块与宿主必须启用 <a href="../../log/YLog#isrecord-field">YLog.Configs.isRecord</a> 才能获取到调试日志数据。</p><p>由于 Android 限制了数据传输大小的最大值，如果调试日志过多将会自动进行分段发送，数据越大速度越慢。</p></div>`,109),l=[p];function t(c,r){return a(),o("div",null,l)}const i=s(n,[["render",t],["__file","YukiHookDataChannel.html.vue"]]);export{i as default};
