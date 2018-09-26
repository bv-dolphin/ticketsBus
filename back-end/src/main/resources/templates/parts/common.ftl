<#macro page>
<#import "navbar.ftl" as nav>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--main css -->
    <#--<link rel="stylesheet" type="text/css" href="/static/style.css">-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <#--<link rel="stylesheet" type="text/css" href="/static/grid.css">-->
    <!--main css -->
    <#--<link rel="stylesheet" type="text/css" href="/static/style.css">-->

    <#--<link rel="stylesheet" type="text/css" href="/static/grid.css">-->
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<#-- Sweet-->
    <script src="/static/js/sweet-alert.min.js"></script>

    <link rel="stylesheet" type="text/css" href="/static/css/sweet-alert.css">
    <!-- Compiled and minified JavaScript -->

    <!-- Bootstrap CSS File -->

    <link href="/static/css/profile.css" rel="stylesheet">
    <link href="/static/css/login.css" rel="stylesheet">

    <!--icons-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Let browser know website is optimized for mobile-->
    <#--<meta name="viewport" content="width=device-width, initial-scale=1.0"/>-->

    <!--jQuery Migrate -->
    <script src="https://code.jquery.com/jquery-3.0.0.js"></script>
    <script src="https://code.jquery.com/jquery-migrate-3.0.1.js"></script>


</head>
<@nav.navbar></@nav.navbar>
<#nested >
<body>
<script src='https://www.google.com/recaptcha/api.js'></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/static/js/materialize.min.js"></script>
</body>
</html>
</#macro>

