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
        <h5>Registration form</h5>
        <!-- Icon -->
        <div class="fadeIn first">
            <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
        </div>
        <!-- Login Form -->
        <form action="/registration" method="post">
            <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
            <div>
            <input type="text" id="login" class="fadeIn second" name="email" placeholder="Email">
                 <#if emailError??>
                 <div class="errorTxt1">
                            <div class="error" type="text" style="text-decoration-color: #e51c23">
                                ${emailError}
                            </div>
                 </#if>

            </div>

            <div>
            <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
                  <#if passwordError??>
                  <div class="errorTxt1">
                            <div class="error">
                                ${passwordError}
                            </div>
                  </#if>
            </div>
            <div>
            <input type="password" id="password" class="fadeIn third" name="confirmPassword" placeholder="confirm password"
                 <#if confirmPasswordError??>
                 <div class="errorTxt1">
                            <div class="error">
                                ${confirmPasswordError}
                            </div>
                 </#if>
    </div>
            <input type="submit" class="fadeIn fourth" value="Sign Up">
        </form>
        <!-- Remind Passowrd -->
        <div id="formFooter">
            <p >Already have an account? <a class="underlineHover" href="/login">Login</a></p>
        </div>

    </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>

</@c.page>