<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<body class="teal">
<div class="container "  >
    <div class="row">
        <div class="col s4 l3 z-depth-5 card-panel  #fafafa grey lighten-5" style="margin-top: 100px; margin-left: 450px">

            <div id="login-page" class="row" >
                <form class="login-form" method="post" action="#">
                    <div class="panel-heading ">
                        <h5 class="card-title center" >Recovery Form</h5>
                        <#if emailRecoveryError??>
                            <div id="card-alert" class="card red lighten-5 center" role="alert">${emailRecoveryError}</div>
                        </#if>

                        <#if userRecoveryError??>
                            <div id="card-alert" class="card red lighten-5 center" role="alert">${userRecoveryError}</div>
                        </#if>

                        <#if sendMessageRecovery??>
                            <div id="card-alert" class="card red lighten-5 center" role="alert">${sendMessageRecovery}</div>
                        </#if>
                    </div>

                    <div class="row" style="margin-top: 30px">
                        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                        <div class="input-field col s9" style="margin-left: 25px">
                            <i class="tiny material-icons prefix">email</i>
                            <input  id="email" name="email" placeholder="Email" type="email" class="validate">
                            <label class="active" for="password">email</label>
                        </div>
                        <button type="submit" class="btn waves-effect waves-light amber col s10" style="margin-left: 25px;" >Send</button>
                        <div class="input-field col s12">
                            <p class="margin center medium-small sign-up">Back to <a href="/login">Login Page</a></p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</@c.page>