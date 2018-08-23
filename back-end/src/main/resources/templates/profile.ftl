<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>
<#import "parts/footer.ftl" as f>

<@c.page>
    <@n.navbar></@n.navbar>
<form method="post">
 <h5 class="card-title center" style="margin-top: 50px; color: #009688" >Личный кабинет</h5>
<div class="container" >

  <div class="row" style="margin-top: 100px">
      <form class="col s12">
          <div class="row">
              <div class="input-field col s6">
                  <input id="firstName" name="firstName" type="text">
                  <label for="firstName">First Name</label>
              </div>
              <div class="input-field col s6">
                  <input id="lastName" name="lastName" type="text">
                  <label for="lastName">Last Name</label>
              </div>
          </div>
          <div class="row">
              <div class="input-field col s5">
                  <input id="oldPassword" name="oldPassword" type="password" >
                  <label for="oldPassword">Old password</label>
              </div>
          </div>
          <div class="row">
              <div class="input-field col s5">
                  <input id="newPassword" name="newPassword" type="password" >
                  <label for="password">New password</label>
              </div>
          </div>
          <div class="row">
              <div class="input-field col s5">
                  <input id="confirmPassword" name="confirmPassword" type="password" >
                  <label for="password">Сonfirm Password</label>
              </div>
          </div>
          <div class="row">
              <div class="input-field col s5">
                  <input id="email" name="email" type="email">
                  <label for="email">Email</label>
              </div>
          </div>
      </form>
  </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit">Save</button>

</form>
<@f.footer></@f.footer>
</@c.page>