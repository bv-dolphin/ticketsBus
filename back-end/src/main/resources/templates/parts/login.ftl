<#macro login path>
<body class="teal">
<!-- Start Page Loading -->
<div id="loader-wrapper">
    <div id="loader"></div>
    <div class="loader-section section-left"></div>
    <div class="loader-section section-right"></div>
</div>
<!-- End Page Loading -->
<div class="container "  >
    <div class="row" >
        <div class="col s4 l3 z-depth-5 card-panel  #fafafa grey lighten-5" style="margin-top: 100px; margin-left: 450px">

            <div id="login-page" class="row" >
                <form  class="login-form" method="post" action="${path}">
                    <div class="panel-heading ">
                        <h5 class="card-title center" >Login Form</h5>
                    </div>
                    <#if sendMessageRecovery??>
                    <div id="card-alert" class="card green lighten-5 center" role="alert">${sendMessageRecovery}</div>
                    </#if>
                        <#if logout??>
                            <div id="card-alert" class="card green lighten-5 center" role="alert">You've been logged out successfully.</div>
                        </#if>
                        <#if error??>
                            <div id="card-alert" class="card red lighten-5 center" role="alert">Invalid Username or Password!</div>
                        </#if>

                    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                    <div class="input-field col s9" style="margin-left: 25px; margin-top: 30px">
                        <i class="tiny material-icons prefix" >person</i>
                        <input  id="login" name="email" placeholder="login" type="text" class="validate">
                        <label class="active" for="login">login</label>
                    </div>
            </div>

            <div class="row">
                <div class="input-field col s9" style="margin-left: 25px">
                    <i class="tiny material-icons prefix"  >lock</i>
                    <input  id="password" name="password" placeholder="password" type="password" class="validate">
                    <label class="active" for="password">password</label>
                </div>
            </div>

            <div class="form-group" style="margin-bottom: 10px " >
                <label style="margin-left: 25px">
                    <input type="checkbox" id="remember-me" name="remember-me" />
                    <span>Remember me</span>
                </label>
            </div>
            <button type="submit" class="btn waves-effect waves-light col s10" style="margin-left: 25px" >Log in</button>

            <div class="input-field col s12"">
                <p><a href="/registration" class="margin medium-small">Register Now!</a>
                <a href="/recovery" class="margin medium-small right">Forgot password ?</a>
                </p>
            </div>

        </div>
    </div>
</div>
</#macro>
