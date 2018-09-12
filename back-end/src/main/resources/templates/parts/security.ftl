<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    userIsEntered = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    <#-- userName = details.getUser().getFirstName()-->
    userEmail = userIsEntered.getUser().getEmail()
    isAdmin = userIsEntered.getUser().isAdmin()
    isGuest = userIsEntered.getUser().isGuest()
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    isGuest =  false
    >
</#if>