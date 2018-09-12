<#include "security.ftl">
<!-- ========== MAIN MENU ========== -->
<div class="container">
    <ul id="gn-menu" class="gn-menu-main">
        <li class="gn-trigger">
            <a class="gn-icon gn-icon-menu"><span>Menu</span></a>
            <nav class="gn-menu-wrapper">
                <div class="gn-scroller">
                    <ul class="gn-menu">
                        <li class="gn-search-item">

                        </li>
                        <li><a href="/public/main" class="gn-icon gn-icon-home">Home</a></li>
                            <#if userIsEntered??>
                                        <li><a href="/profile" class="gn-icon gn-icon-lab">Личный кабинет</a></li>
                            </#if>
                        <li><a href="#about" class="gn-icon gn-icon-newspaper smoothscroll">Купить билет</a></li>
                    <#--  <li><a href="/public/main" class="gn-icon gn-icon-newspaper">Купить билет</a></li>-->
                        <li><a href="#portfolio" class="gn-icon gn-icon-illustrator smoothscroll">Наши автобусы</a></li>
                        <li><a href="#contact" class="gn-icon gn-icon-envelop smoothscroll">Contact</a></li>
                        <li><a href="#blog"  class="gn-icon gn-icon-archive">Информация</a></li>
                    </ul>
                </div>
                <!-- /gn-scroller -->
            </nav>
        </li>
          <#if userIsEntered??>
               <li> <a href="/logout">Выйти</a></li>
          <#else>
                <li ><a href="/public/login">Войти на сайт</a></li>
          </#if>
    <#--<li><a href="#home" class="smoothscroll">Freelance</a></li>-->
    </ul>
</div>
  <!-- /container -->