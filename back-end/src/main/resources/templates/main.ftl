<#import "parts/common.ftl" as c>
<#import "parts/footer.ftl" as f>

<@c.page>

<main xmlns="http://www.w3.org/1999/html">
    <div class="row">

        <form action="/public/main/search" method="get"  class="col s12" style="margin-top: 250px; margin-left:">

            <div class="row" style="margin-left: 200px">

                <div class="input-field col s3" style="margin-right: 100px" >
                    <i class="material-icons prefix">directions_bus</i>
                    <input id="icon_prefix" type="text" name="departure">
                    <label for="icon_prefix">Откуда</label>
                </div>
                <div class="input-field col s3" style="margin-right: 50px">
                    <i class="material-icons prefix">directions_bus</i>

                    <input id="icon_telephone" type="text" name="arrival">
                    <label for="icon_telephone">Куда</label>
                </div>
                <div class="input-field col s2" style="margin-right: 50px">
                    <i class="material-icons prefix">today</i>
                    <input id="icon_telephone" type="date" name="departureTime"> <!--class="datepicker"> -->
                    <label for="icon_telephone">Дата</label>
                </div>
            </div>
            <button class=" btn btn-large waves-effect waves-default btn modal-trigger" data-target="modal1" style="margin-left: 220px; margin-top: 70px;">Найти билет</button>
        </form>
    </div>
<#if busflights??>
    <#list busflights as busflight >
        <div class="row">
            <h5 > Забронировать билет </h5>
            <ul class="collection">
                <li class="collection-item avatar">

                    <img src=/static/images/men.jpg class="circle">

                    <i class="material-icons">directions_bus</i>
                    <span class="title">${busflight.departure} - ${busflight.arrival}</span>
                    <p>
                        <a href="/public/ticket" class="btn waves-effect waves-light pink" data-target="modal2">Купить
                            <i class="material-icons right">send</i>
                        </a>
                        <br> ${busflight.departureTime}
                    </p>
                </li>
            </ul>
        </div>

    </#list>
<#else >
No buses
</#if>


</main>
<!-- add jquery script -->


<script type="text/javascript">
    $(document).ready(function(){
        $('.datepicker').datepicker();
    });
</script>

<!--materialize script -->
<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/materialize.min.js"></script>


    <@f.footer></@f.footer>

</@c.page>
    <!--
    <div class="row" style="margin-left: 200px">
    <h5 content=""> Забронировать билет </h5>
    <ul class="collection">
        <li class="collection-item avatar">
            <img src=/static/images/men.jpg class="circle">
            <i class="material-icons">directions_bus</i>
            <span class="title">Москва - Киев</span>
            <p>13 авг.
                <a href="/public/ticket" class="btn waves-effect waves-light pink" data-target="modal2" style="margin-left: 1400px" >Купить
                    <i class="material-icons right">send</i>
                </a>
                <br> 6.00
            </p>
        </li>
    </ul>
    </div>

-->








