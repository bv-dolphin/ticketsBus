
<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    details = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    <#-- userName = details.getUser().getFirstName()-->
    userEmail = details.getUser().getEmail()
    isAdmin = details.getUser().isAdmin()
    isGuest = details.getUser().isGuest()
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    isGuest =  false
    >
</#if>