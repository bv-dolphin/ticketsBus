<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <#if sendMessageRecovery??>
<script>
    var sendMessageRecovery = "${sendMessageRecovery}";
    alert(sendMessageRecovery)
</script>
    </#if>
<@l.login "/public/login" />
</@c.page>