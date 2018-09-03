<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<!-- смотрим  -->
<!-- проверяем является ли пользователь админом -->
<#if isUserControl>
        <#assign
        details = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = details.getUser().getEmail
        isAdmin = details.getUser().isAdmin()
            >
<#else >
        <#assign
            name = "unknown"
            isAdmin = false
        <#--В случае если пользователь не авторизован,
         устанавливает id = -1, что не соответствует ни одному пользователю-->
            currentUserId = -1
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