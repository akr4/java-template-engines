<div id="navibar" class="navbar" data-active-navibar-item-id="${navibarItemId}">
  <div class="navbar-inner">
    <div class="container" style="width: auto;">
      <a class="brand" href=".">Java Template Engines</a>
      <div class="nav-collapse">
        <ul class="nav">
          <#list templateEngines as e>
            <li><a href="${e.id}">${e.engineName}</a></li>
          </#list>
        </ul>
      </div>
    </div>
  </div>
</div>