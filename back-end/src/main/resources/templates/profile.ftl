<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>
<#import "parts/footer.ftl" as f>

<@c.page>
    <@n.navbar></@n.navbar>
<main>
 <h5 class="card-title center" style="margin-top: 50px; color: #009688" >Личный кабинет</h5>
<div class="container" >

  <div class="row" style="margin-top: 100px">
      <form class="col s12">
          <div class="row">
              <div class="input-field col s6">
                  <input id="first_name" type="text" class="validate">
                  <label for="first_name">First Name</label>
              </div>
              <div class="input-field col s6">
                  <input id="last_name" type="text" class="validate">
                  <label for="last_name">Last Name</label>
              </div>
          </div>
          <div class="row">
              <div class="input-field col s5">
                  <input id="password" type="password" class="validate">
                  <label for="password">Password</label>
              </div>
          </div>
          <div class="row">
              <div class="input-field col s5">
                  <input id="password" type="password" class="validate">
                  <label for="password">Сonfirm Password</label>
              </div>
          </div>
          <div class="row">
              <div class="input-field col s5">
                  <input id="email" type="email" class="validate">
                  <label for="email">Email</label>
              </div>
          </div>
      </form>
  </div>
</main>
<@f.footer></@f.footer>
</@c.page>