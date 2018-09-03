
<#include "security.ftl">
<#macro navbar>
 <nav class="teal">
    <div class="nav-wrapper">
        <div class="container">
            <a href="/public/main" class="brand-logo"><i class="material-icons">directions_bus</i>One Click Bus</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down" style="margin-right: 250px">
            <li><a href="/public/main">Купить билет</a></li>
            <li><a href="/public/info">Информация</a></li>
            <!--   <li><a href=/staff">Персонал</a></li> -->

            <#if details??>
            <li><a href="/profile">Личный кабинет</a></li>
            <li><input type="hidden" name="_csrf" value="${_csrf.token}" />
                <a href="/logout">Выйти</a></li>
            <#else>
                <li ><a href="/public/login">Войти на сайт</a></li>

            </#if>
        </ul>
        </div>
    </div>
 </nav>
</#macro>
