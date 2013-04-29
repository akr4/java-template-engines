<#import "../layout/layout.ftl" as layout>
<#assign title = "FreeMarker" in layout>
<@layout.basic>
<article>
  <div class="row">
    <h1>HTML Escape</h1>
    <div class="span6">
      <h3>String</h3>
      <dl>
        <dt>code</dt>
        <dd><pre><code>${r"${wikiPage.title}"}</code></pre></dd>
        <dt>result</dt>
        <dd><pre class="ok"><code>${wikiPage.title}</code></pre></dd>
      </dl>
    </div>
    <div class="span6">
      <h3>Object</h3>
      <dl>
        <dt>code</dt>
        <dd><pre><code>${r"${wikiPage}"}</code></pre></dd>
        <dt>result</dt>
        <dd><pre class="ok"><code>${wikiPage}</code></pre></dd>
      </dl>
    </div>
    <div class="span6">
      <h3>String (explicit no escape)</h3>
      <dl>
        <dt>code</dt>
        <dd><pre><code>${r"<#noescape>${wikiPage.wikiText.value}</#noescape>"}</code></pre></dd>
        <dt>result</dt>
        <dd><pre class="ok"><code><#noescape>${wikiPage.wikiText.value}</#noescape></tags:noescape></code></pre></dd>
      </dl>
    </div>
    <div class="span6">
      <h3>Safe HTML Object</h3>
      <dl>
        <dt>code</dt>
        <dd><pre><code>${r"${wikiPage.wikiText}"}</code></pre></dd>
        <dt>result</dt>
        <dd><pre class="notSupported"><code>${wikiPage.wikiText}</code></pre></dd>
      </dl>
    </div>
  </div>
  <div class="row">
    <h1>Version</h1>
    <dl>
      <dt>FreeMarker</dt><dd>2.3.19</dd>
    </dl>
  </div>
</article>
</@layout.basic>
