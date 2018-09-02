<#import "parts/common.ftl" as c>
<@c.page>
<head>
    <link href="/static/css/login.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body class="teal">
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h5 class="card-title center" >Recovery Form</h5>
        <!-- Icon -->
        <div class="fadeIn first">
            <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
        </div>
                       <#if emailRecoveryError??>
                                            <div id="card-alert" class="card red lighten-5 center" role="alert">${emailRecoveryError}</div>
                       </#if>

                        <#if userRecoveryError??>
                            <div id="card-alert" class="card red lighten-5 center" role="alert">${userRecoveryError}</div>
                        </#if>
        <!-- Login Form -->
        <form action="/recovery" method="post">
            <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
            <input type="text" id="login" class="fadeIn second" name="email" placeholder="Email">
            <input type="submit" class="fadeIn fourth" value="Send">
        </form>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <p >Back to <a class="underlineHover" href="/login">Login Page</a></p>
        </div>

    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>

</@c.page>