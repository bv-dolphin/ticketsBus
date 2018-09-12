<#macro login path isLoginForm isRegistrationForm isRecoveryForm>
            <div class="wrapper fadeInDown">
                <div id="formContent">
                    <!-- Tabs Titles -->
                    <#if isLoginForm>
                    <h5>Login form</h5>
                    </#if>
                    <#if isRegistrationForm>
                    <h5>Registration form</h5>
                    </#if>
                    <#if isRecoveryForm>
                    <h5>Recovery Form</h5>
                    </#if>
                    <!-- Icon -->
                    <div class="fadeIn first">
                        <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
                    </div>

                     <#if sendMessageRecovery??>
                             <div id="card-alert" class="card center" role="alert">${sendMessageRecovery}</div>
                     </#if>

                    <#if sendMessageRegistration??>
                             <div id="card-alert" class="card center" role="alert">${sendMessageRegistration}</div>
                    </#if>

                     <#if error??>
                         <div id="card-alert" class="card center" role="alert">Invalid Username or Password!</div>
                     </#if>

                    <#if emailRecoveryError??>
                            <div id="card-alert" class="card center" role="alert">${emailRecoveryError}</div>
                    </#if>

                        <#if userRecoveryError??>
                            <div id="card-alert" class="card center" role="alert">${userRecoveryError}</div>
                        </#if>
                    <!-- Login Form -->
                    <form action="${path}" method="post">
                        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden" />
                        <input type="text" id="login" class="fadeIn second" name="email"
                               placeholder="<#if isLoginForm>login<#else>Email</#if>" />
                        <#if emailError??><div class="error">${emailError}</div></#if>

                        <#if !isRecoveryForm>
                        <input type="password" id="password" class="fadeIn third" name="password" placeholder="password" />
                            <#if passwordError??><div class="error">${passwordError}</div></#if>

                            <#if !isLoginForm>
                             <input type="password" id="password" class="fadeIn third" name="confirmPassword" placeholder="confirm password" />
                                <#if confirmPasswordError??><div class="error">${confirmPasswordError}</div></#if>
                            </#if>
                        </#if>

                        <input type="submit" class="fadeIn fourth"
                               <#if isLoginForm>value="Log In"</#if>
                               <#if isRegistrationForm>value="Sign Up"</#if>
                               <#if isRecoveryForm>value="Send"</#if>
                        />
                    </form>

                    <!-- Remind Passowrd -->
                    <div id="formFooter">
                        <#if isLoginForm>
                        <a href="/registration" class="underlineHover">Register Now!</a>
                        <a class="underlineHover ml-4" href="/recovery">Forgot Password?</a>
                        </#if>

                        <#if isRegistrationForm>
                             <p>Already have an account? <a class="underlineHover" href="/login">Login</a></p>
                        </#if>

                        <#if isRecoveryForm>
                            <p>Back to <a class="underlineHover" href="/login">Login Page</a></p>
                        </#if>
                    </div>

                </div>
            </div>
</#macro>

