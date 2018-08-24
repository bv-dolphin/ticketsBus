<#assign
    isUserControl = Session.SPRING_SECURITY_CONTEXT??
>
<!-- смотрим  -->
<!-- проверяем является ли пользователь админом -->
<#if isUserControl>
        <#assign
            user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
          <#--  isGuest = user.isGuest()
            name = user.getEmail()
            isAdmin = user.isAdmin()
            currentUserId = user.getId()-->
            >
<#else >
        <#assign
            name = "unknown"
            isAdmin = false
        <#--В случае если пользователь не авторизован,
         устанавливает id = -1, что не соответствует ни одному пользователю-->
            currentUserId = -1
        >
</#if>bus_route_tbl