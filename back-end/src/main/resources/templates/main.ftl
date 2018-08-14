<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>
<#import "parts/footer.ftl" as f>

<@c.page>
<@n.navbar></@n.navbar>
<main>
<div class="row">

    <form  class="col s12" style="margin-top: 250px; margin-left:">
        <div class="row" style="margin-left: 200px">
            <div class="input-field col s3" style="margin-right: 100px">
                <i class="material-icons prefix">directions_bus</i>
                <input id="icon_prefix" type="text"  class="validate">
                <label for="icon_prefix">Откуда</label>
            </div>
            <div class="input-field col s3" style="margin-right: 50px">
                <i class="material-icons prefix">directions_bus</i>

                <input id="icon_telephone" type="tel" class="validate">
                <label for="icon_telephone">Куда</label>
            </div>
            <div class="input-field col s2" style="margin-right: 50px">
                <i class="material-icons prefix">today</i>
                <input id="icon_telephone" type="tel" class="datepicker">
                <label for="icon_telephone">Дата</label>
            </div>
        </div>
        <button class=" btn btn-large waves-effect waves-default btn modal-trigger" data-target="modal1" style="margin-left: 220px; margin-top: 70px;">Найти билет</button>
</div>

 <div class="modal bottom-sheet"  id="modal1">
     <div class="modal-content">
         <h4> Забронировать билет </h4>
         <ul class="collection">
             <li class="collection-item avatar">

                 <img src=/static/images/men.jpg class="circle">

                 <i class="material-icons">directions_bus</i>
                 <span class="title">Москва - Киев</span>
                 <p>13 авг.
                     <button class="btn waves-effect waves-light pink" type="submit" name="action" style="margin-left: 1400px" >Купить
                         <i class="material-icons right">send</i>
                     </button>

                     <br> 6.00

                 </p>


             </li>
             <li class="collection-item avatar">
                 <img src=/static/images/men.jpg class="circle">
                 <i class="material-icons">directions_bus</i>
                 <span class="title">Москва - Киев</span>
                 <p>13 авг.
                     <button class="btn waves-effect waves-light pink" type="submit" name="action" style="margin-left: 1400px" >Купить
                         <i class="material-icons right">send</i>
                     </button>
                     <br> 21.00
                 </p>
             </li>

             <li class="collection-item avatar">
                 <img src=/static/images/men.jpg class="circle">
                 <i class="material-icons">directions_bus</i>
                 <span class="title">Москва - Киев</span>
                 <p>13 авг.
                     <button class="btn waves-effect waves-light pink" type="submit" name="action" style="margin-left: 1400px" >Купить
                         <i class="material-icons right">send</i>
                     </button>
                     <br> 15.00
                 </p>

             </li>
             <li class="collection-item avatar">
                 <img src=/static/images/men.jpg class="circle">
                 <i class="material-icons">directions_bus</i>
                 <span class="title">Москва - Киев</span>
                 <p>13 авг.
                     <button class="btn waves-effect waves-light pink" type="submit" name="action" style="margin-left: 1400px" >Купить
                         <i class="material-icons right">send</i>
                     </button>
                     <br> 23.00
                 </p>
             </li>
         </ul>
     </div>
     <div class="modal-footer">
         <a href="#" class="btn-flat modal-action modal-close waves-effect waves-default">close</a>
     </div>
 </div>
</main>


<!-- add jquery script -->

<script type="text/javascript">
    $(document).ready(function(){
        $('.modal').modal();
    });
</script>

<script type="text/javascript">

    $(document).ready(function(){
        $('.datepicker').datepicker();
    });

</script>

<!--materialize <script --->

<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/materialize.min.js"></script>


<@f.footer></@f.footer>
</@c.page>