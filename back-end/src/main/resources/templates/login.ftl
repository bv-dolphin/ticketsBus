<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="../static/css/signin.css">
    <link rel="stylesheet" type="text/css" href="../static/signin.css">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default" style="margin-top:45px">
                <div class="panel-heading">
                    <h3 class="panel-title">Login Form</h3>
                </div>
                <div class="panel-body">
                <#if logout??>
                    <div class="alert alert-info" role="alert">You've been logged out successfully.</div>
                </#if>
                <#if error??>
                    <div class="alert alert-danger" role="alert">Invalid Username or Password!</div>
                </#if>

                    <form method="post" action="/public/login">
                        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                        <div class="form-group">
                            <label for="login">Login</label>
                            <input type="text" class="form-control" id="login" placeholder="Email"
                                   name="email">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" placeholder="Password"
                                   name="password">
                        </div>
                        <div class="form-group">
                            <label for="remember-me">
                                <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня
                            </label>
                        </div>
                        <button type="submit" class="btn btn-default">Log in</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>


<#--<!doctype html>-->
<#--<head>-->
<#--<meta charset="utf-8">-->
<#--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">-->
<#--<title>Spring Security Demo Apps</title>-->

<#--<!-- Bootstrap CSS &ndash;&gt;-->
<#--<link rel="stylesheet"-->
<#--href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"-->
<#--integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"-->
<#--crossorigin="anonymous">-->
<#--<link rel="stylesheet" href="../public/css/signin.css">-->


<#--</head>-->

<#--<body class="text-center">-->
<#--<form class="form-signin" action="/login" method="post">-->
<#--<img class="mb-4"-->
<#--src="https://getbootstrap.com/docs/4.1/assets/brand/bootstrap-solid.svg"-->
<#--alt="" width="72" height="72">-->

<#--<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>-->

<#--<#if logout??>-->
<#--<div class="alert alert-info" role="alert">You've been logged out successfully.</div>-->
<#--</#if>-->
<#--<#if error??>-->
<#--<div class="alert alert-danger" role="alert">Invalid Username or Password!</div>-->
<#--</#if>-->

<#--<label for="email" class="sr-only">Email address</label>-->
<#--<input type="email" id="email" name="email" class="form-control"-->
<#--placeholder="Email address" required autofocus>-->

<#--<label for="password" class="sr-only">Password</label>-->
<#--<input type="password" id="password" name="password" class="form-control"-->
<#--placeholder="Password" required>-->


<#--<input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">-->
<#--<button class="btn btn-lg btn-primary btn-block" type="submit">-->
<#--Sign in-->
<#--</button>-->
<#--<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>-->
<#--</form>-->
<#--</body>-->