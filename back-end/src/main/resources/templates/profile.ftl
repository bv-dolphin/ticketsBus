<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>
<#import "parts/footer.ftl" as f>

<@c.page>
    <@n.navbar></@n.navbar>
<main>
    <div class="container "  >
        <div class="row">
            <div class="col s4 l3 z-depth-5 card-panel  #fafafa grey lighten-5" style="margin-top: 100px; margin-left: 450px">

                <div id="login-page" class="row" >
                    <form class="login-form" method="post" action="/profile">
                        <div class="panel-heading ">
                            <h5 class="card-title center" >Change Form</h5>
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
                        <label class="active" for="password">new password</label>
                    </div>
                </div>

                <div class="row">
                    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                    <div class="input-field col s9" style="margin-left: 25px">
                        <i class="tiny material-icons prefix"  >lock</i>
                        <input  id="confirmpassword" name="confirmpassword" placeholder="password" type="password" class="validate">
                        <label class="active" for="password" >confirm password</label>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<@f.footer></@f.footer>
</@c.page>