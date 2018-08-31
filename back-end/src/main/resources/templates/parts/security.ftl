<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    details = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    user = details.getUser().getFirstName()
    isAdmin = details.getUser().isAdmin()
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    >
</#if>