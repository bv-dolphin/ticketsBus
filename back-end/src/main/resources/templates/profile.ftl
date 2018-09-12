<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<div class="container clearfix">
    <div class="content clearfix">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <h4 class="title">Личный кабинет</h4>
                <!--<div id="message"></div>-->
                <form class="contact-form" role="form" method="POST">

                    <div class="form-group">
                        <input name="firstName" type="text" value="${first_name!' '}" class="form-control" placeholder="First Name">
                        <div class="validate"></div>
                    </div>
                    <div class="form-group">
                        <input name="lastName" type="text" value="${last_name!' '}" class="form-control" placeholder="Last Name">
                        <div class="validate"></div>
                    </div>
                    <div class="form-group">
                        <input name="oldPassword" type="password" class="form-control" placeholder="Old password">
                        <div class="validate"></div>
                    </div>
                    <div class="form-group">
                        <input name="newPassword" type="password" class="form-control" placeholder="New password">
                        <div class="validate"></div>
                    </div>
                    <div class="form-group">
                        <input name="confirmPassword" type="password" class="form-control" placeholder="Confirm password">
                        <div class="validate"></div>
                    </div>
                    <div class="form-group">
                        <input name="email" type="text" value="${email!' '}" class="form-control" placeholder="Your Email">
                        <div class="validate"></div>
                    </div>

                    <div class="form-send center">
                        <button type="submit" class="btn btn-large">Save edit</button>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    </div>

                </form>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
                <h4 class="title">Details</h4>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry"s standard dummy text ever since the 1500s. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                <ul class="contact_details">
                    <li><i class="fa fa-envelope-o"></i>Какая то инфа1</li>
                    <li><i class="fa fa-phone-square"></i>Какая то инфа2</li>
                    <li><i class="fa fa-home"></i>Какая то инфа3</li>
                </ul>
                <!-- contact_details -->
            </div>
        <#--row-->
        </div>
        <!-- end large-6 -->
    </div>
    <!-- end container -->
</div>
</@c.page>