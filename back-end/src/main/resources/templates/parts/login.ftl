<#macro login path>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body class="teal">
            <div class="wrapper fadeInDown">
                <div id="formContent">
                    <!-- Tabs Titles -->
                    <h5>Login form</h5>
                    <!-- Icon -->
                    <div class="fadeIn first">
                        <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
                    </div>

                     <#if sendMessageRecovery??>
                    <div id="card-alert" class="card green lighten-5 center" role="alert">${sendMessageRecovery}</div>
                     </#if>
                        <#if error??>
                            <div id="card-alert" class="card red lighten-5 center" role="alert">Invalid Username or Password!</div>
                        </#if>
                    <!-- Login Form -->
                    <form action="${path}" method="post">
                        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
                        <input type="text" id="login" class="fadeIn second" name="email" placeholder="login">
                        <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
                        <input type="submit" class="fadeIn fourth" value="Log In">
                    </form>

                    <!-- Remind Passowrd -->
                    <div id="formFooter">
                        <a href="/registration" class="underlineHover">Register Now!</a>
                        <a class="underlineHover ml-4" href="/recovery">Forgot Password?</a>
                    </div>

                </div>
            </div>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>

</#macro>


