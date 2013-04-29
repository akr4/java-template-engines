<#macro basic>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="../../../stylesheets/bootstrap.min.css">
  <link rel="stylesheet" href="../../../stylesheets/main.css">
  <title>${title}</title>
</head>
<body>
  <#include "navibar.ftl">
  <div class="container">
    <#nested>
  </div>
  <#include "footer.ftl">
  <script src="../../../javascripts/jquery-2.0.0.min.js"></script>
  <script src="../../../javascripts/navibar.js"></script>
  ${script!}
  <#include "ga.ftl">
</body>
</html>
</#macro>
