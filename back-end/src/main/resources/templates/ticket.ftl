<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>
<#import "parts/footer.ftl" as f>


<@c.page>
    <@n.navbar></@n.navbar>
<main>

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

                <a class="waves-effect waves-light btn-floating btn-large pink btn modal-trigger" data-target="modal1" style="margin-top: 20px; margin-left: 30px"><i class="material-icons right">airline_seat_recline_normal</i>Выбрать место</a>

                <div id="modal1" class="modal">
                    <div class="modal-content">

                        <div class="container">
                            <div class="wrapper">
                                <div class="box">40</div>
                                <div class="box">39</div>
                                <div class="box">38</div>
                                <div class="box">37</div>
                                <div class="box">36</div>
                                <div class="box">35</div>
                                <div class="box">34</div>
                                <div class="box">33</div>
                                <div class="box">32</div>
                                <div class="box">31</div>
                                <div class="box">30</div>
                                <div class="box">29</div>
                                <div class="box">28</div>
                                <div class="box">27</div>
                                <div class="box">26</div>
                                <div class="box">25</div>
                                <div class="box">24</div>
                                <div class="box">23</div>
                                <div class="box">22</div>
                                <div class="box">21</div>

                            </div>
                            <div class="wrapper" style="margin-top: 50px">
                                <div class="box">20</div>
                                <div class="box">19</div>
                                <div class="box">18</div>
                                <div class="box">17</div>
                                <div class="box">16</div>
                                <div class="box">15</div>
                                <div class="box">14</div>
                                <div class="box">13</div>
                                <div class="box">12</div>
                                <div class="box">11</div>
                                <div class="box">10</div>
                                <div class="box">9</div>
                                <div class="box">8</div>
                                <div class="box">7</div>
                                <div class="box">6</div>
                                <div class="box">5</div>
                                <div class="box">4</div>
                                <div class="box">3</div>
                                <div class="box">2</div>
                                <div class="box">1</div>
                            </div>
                            <a class="waves-effect waves-light btn" style="margin-top: 20px; padding-bottom: 30px float: left">забронировать</a>
                        </div>

                    </div>

            </div>
                <a class="waves-effect waves-light btn-large teal" style="margin-top: 30px"><i class="material-icons right">attach_money</i>Оплатить</a>

             </form>
         </div>
    </div>
</div>
</main>




<!-- add jquery script -->
<script type="text/javascript">
    $(document).ready(function(){
        var $currentSeat = {};

        $('.box').click(function(){
            $(this).toggleClass('seatSelected');
            $currentSeat = $(this);
        });

    });

</script>


<script type="text/javascript">
    $(document).ready(function(){
        $('.modal').modal();
    });
</script>

<!--materialize script --->
<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/materialize.min.js"></script>

    <@f.footer></@f.footer>
</@c.page>

