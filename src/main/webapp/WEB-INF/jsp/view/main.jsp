<%--@elvariable id="wikiPage" type="net.physalis.javaviews.domain.wikiPage.wikiPage"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="../../../stylesheets/bootstrap.min.css">
  <link rel="stylesheet" href="../../../stylesheets/main.css">
  <title>JSP</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/layout/navibar.jspf"%>
<div class="container">
  <article>
    <div class="row">
      <h1>HTML Escape</h1>
      <p>
        Default escaping is achived by using ELResolver. However what ELResolver can escape is only String, and not
        other classes. So if a class's toString() returns HTML unsafe character, there would be a chance of XSS.
        You can also add the feature to skip escaping when the custom tag like &lt;noescape&gt; is surrounding or
        specific class (e.g. annotated by @NoEscape or implements SafeHtml) is rendered.
      </p>
      <div class="span6">
        <h3>String</h3>
        <dl>
          <dt>code</dt>
          <dd><pre><code>\${wikiPage.title}</code></pre></dd>
          <dt>result</dt>
          <dd><pre class="ok"><code>${wikiPage.title}</code></pre></dd>
        </dl>
      </div>
      <div class="span6">
        <h3>Object</h3>
        <dl>
          <dt>code</dt>
          <dd><pre><code>\${wikiPage}</code></pre></dd>
          <dt>result</dt>
          <dd><pre class="ng"><code>${wikiPage}</code></pre></dd>
        </dl>
      </div>
      <div class="span6">
        <h3>String (explicit no escape)</h3>
        <dl>
          <dt>code</dt>
          <dd><pre><code>&lt;tags:noescape&gt;\${wikiPage.wikiText.value}&lt;/tags:noescape&gt;</code></pre></dd>
          <dt>result</dt>
          <dd><pre class="ok"><code><tags:noescape>${wikiPage.wikiText.value}</tags:noescape></code></pre></dd>
        </dl>
      </div>
      <div class="span6">
        <h3>Safe HTML Object</h3>
        <dl>
          <dt>code</dt>
          <dd><pre><code>\${wikiPage.wikiText}</code></pre></dd>
          <dt>result</dt>
          <dd><pre class="ok"><code>${wikiPage.wikiText}</code></pre></dd>
        </dl>
      </div>
    </div>
    <div class="row">
      <h1>Version</h1>
      <dl>
        <dt>JSP</dt><dd>2.2</dd>
        <dt>JSTL</dt><dd>1.2</dd>
      </dl>
    </div>
  </article>
</div>
<%@ include file="/WEB-INF/jsp/layout/footer.jspf"%>
<script src="../../../javascripts/jquery-2.0.0.min.js"></script>
<script src="../../../javascripts/navibar.js"></script>
<%@ include file="/WEB-INF/jsp/layout/ga.jspf"%>
</body>
</html>
