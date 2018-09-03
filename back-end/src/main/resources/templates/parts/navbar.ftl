
<#include "security.ftl">
<#macro navbar>
 <nav class="teal">
    <div class="nav-wrapper">
        <div class="container">
        <a href="#" class="brand-logo left">  <i class="material-icons large" style="margin-top: 3px">directions_bus</i> One Click Bus</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down" style="margin-right: 250px">
            <li><a href="/public/main">Купить билет</a></li>
            <li><a href="/public/info">Информация</a></li>
            <!--   <li><a href=/staff">Персонал</a></li> -->
            <li><a href="/profile">Личный кабинет</a></li>

               <li style="margin-left: 150px">
                   <div><#if user??>${name}<#else> Please, login</div>
                   <form action="/logout" method="post" >
                       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                         <button class="waves-effect waves-light btn-large blue-grey" type="submit"><#if user??> Выйти <#else> Войти </#if> <i class="material-icons right">exit_to_app</i></button>
                   </form>
               </li>

            </#if>
        </ul>
        </div>
    </div>
 </nav>
</#macro>
