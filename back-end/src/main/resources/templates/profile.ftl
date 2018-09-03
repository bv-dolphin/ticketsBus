<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>

<aside class="profile-card" style="margin-top: 50px">
    <div class="container center">
<form method="post">
    <h5 class="card-title center" style= "color: #009688" >Личный кабинет</h5>
    <#if isGuest>
    <br>
            <h5 class="center">${messageNotActiveEmail}</h5>
    <div class="panel panel-info">
        <div class="panel-body">
            <div class="row">
                <div class=" col-md-9 col-lg-9 ">
                    <table class="table table-user-information">
                        <tbody>
                        <tr>
                            <td>First name:</td>
                            <td>${first_name!'Your name'}</td>
                        </tr>
                        <tr>
                            <td>Last name:</td>
                            <td>${last_name!'Your last name'}</td>
                        </tr>
                        <tr>
                            <td>Old password:</td>
                            <td>------------</td>
                        </tr>

                        <tr>
                        <tr>
                            <td>New Password:</td>
                            <td>------------</td>
                        </tr>
                        <tr>
                            <td>Password confirm:</td>
                            <td>------------</td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td>${userEmail !' '}</td>
                        </tr>
                        </td>

                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </div>
    <#else>
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >

        <div class="panel panel-info">
            <div class="panel-body">
                <div class="row">
                    <div class=" col-md-9 col-lg-9 ">
                        <table class="table table-user-information">
                            <tbody>
                            <tr>
                                <td>First name:</td>
                                <td><input class="center" name="firstName" type="text" value="${first_name!' '}"></td>
                            </tr>
                            <tr>
                                <td>Last name:</td>
                                <td><input class="center" name="lastName" type="text" value="${last_name!' '}"</td>
                            </tr>
                            <tr>
                                <td>Old password:</td>
                                <td><input class="center" name="oldPassword" type="password" ></td>
                            </tr>

                            <tr>
                            <tr>
                                <td>New Password:</td>
                                <td><input class="center" name="newPassword" type="password" ></td>
                            </tr>
                            <tr>
                                <td>Password confirm:</td>
                                <td><input class="center" name="confirmPassword" type="password" ></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td> <input class="center" name="email" type="email" value="${email!' '}"></td>
                            </tr>
                            </td>

                            </tr>

                            </tbody>
                        </table>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <input type="submit" class="fadeIn fourth" value="Save" style="margin-top: 20px">
                    </div>
                </div>
            </div>
        </div>
    </div>
    </#if>
</form>
</div>
</aside>
</@c.page>