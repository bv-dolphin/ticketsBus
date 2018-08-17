<#import "parts/common.ftl" as c>

<@c.page>
<body class="teal">
<div id="loader-wrapper">
    <div id="loader"></div>
    <div class="loader-section section-left"></div>
    <div class="loader-section section-right"></div>
</div>
<!-- End Page Loading -->
<div class="container "  >
    <div class="row">
        <div class="col s4 l3 z-depth-5 card-panel  #fafafa grey lighten-5" style="margin-top: 100px; margin-left: 450px">

            <div id="login-page" class="row" >
                <form class="login-form" method="post" action="/registration">
                    <div class="panel-heading ">
                        <h5 class="card-title center" >Registration Form</h5>
                    </div>

                    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                    <div class="input-field col s9" style="margin-left: 25px; margin-top: 30px">
                        <i class="tiny material-icons prefix" >person</i>
                        <input  id="email" name="email" placeholder="Email" type="email" class="validate">
                        <label class="active" for="login">email</label>
                    </div>
            </div>

            <div class="row">
                <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                <div class="input-field col s9" style="margin-left: 25px">
                    <i class="tiny material-icons prefix"  >lock</i>
                    <input  id="password" name="password" placeholder="password" type="password" class="validate">
                    <label class="active" for="password">password</label>
                </div>
            </div>

            <div class="row">
                <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                <div class="input-field col s9" style="margin-left: 25px">
                    <i class="tiny material-icons prefix"  >lock</i>
                    <input  id="confirmpassword" name="confirmpassword" placeholder="password" type="password" class="validate">
                    <label class="active" for="password">password</label>
                </div>
            </div>
            <button type="submit" class="btn waves-effect waves-light pink col s10" style="margin-left: 25px;" >Register now</button>
            <div class="input-field col s12">
                <p class="margin center medium-small sign-up">Already have an account? <a href="/login">Login</a></p>
            </div>
        </div>

    </div>
</div>

</@c.page>