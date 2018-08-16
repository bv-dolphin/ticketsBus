<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>
<#import "parts/footer.ftl" as f>


<@c.page>
    <@n.navbar></@n.navbar>
<main>


    <!-- Preloader and it's background. -->
   <!-- <div class="preloader-background center" style="margin-top: 250px">
        <div class="preloader-wrapper big active">
            <div class="spinner-layer spinner-blue">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div><div class="gap-patch">
                <div class="circle"></div>
            </div><div class="circle-clipper right">
                <div class="circle"></div>
            </div>
            </div>

            <div class="spinner-layer spinner-red">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div><div class="gap-patch">
                <div class="circle"></div>
            </div><div class="circle-clipper right">
                <div class="circle"></div>
            </div>
            </div>
        </div>
        <p class="blinking">Loading</p>
    </div>

    <!--       -->
    <h3 style="color: #009688; margin-top: 100px; margin-left: 320px" >Оформление билета</h3>
    <div class="container">
        <div class="card" style="margin-top: 100px; ">
        <div class="card-content" >
    <form class="col s12">
    <div class="row">
        <div class="input-field col s2">
            <input id="first_name" type="text">
            <label class="active">Имя</label>
        </div>
        <div class="input-field col s2">
            <input id="last_name" type="text" >
            <label class="active">Фамилия</label>
        </div>
        <div class="input-field col s2">
            <input id="second_name" type="text">
            <label class="active">Отчество</label>
        </div>
        <div class="input-field col s2">
            <input id="citizenship" type="text">
            <label class="active">Гражданство</label>
        </div>
        <div class="input-field col s2">
            <input id="dateofbirth" type="text" placeholder="дд.мм.гггг">
            <label class="active" >Год рождения</label>
        </div>
        <a class="waves-effect waves-light btn-floating btn-large pink" style="margin-top: 20px; margin-left: 30px"><i class="material-icons right">airline_seat_recline_normal</i>Выбрать место</a>
        <a class="">

        </a>
    </div>
        <a class="waves-effect waves-light btn-large teal "><i class="material-icons right">attach_money</i>Оплатить</a>

    </form>


    </div>
    </div>

    </div>


</main>


<!-- add jquery script -->
<script type="text/javascript">

    document.addEventListener("DOMContentLoaded", function(){
        $('.preloader-background').delay(1700).fadeOut('slow');

        $('.preloader-wrapper')
                .delay(1700)
                .fadeOut();
    });

</script>

<!--materialize script --->

<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/materialize.min.js"></script>

    <@f.footer></@f.footer>
</@c.page>

