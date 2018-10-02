<#import "parts/common.ftl" as c>
<@c.page>
<section id="home" name="home"></section>
  <div id="headerwrap">
      <div class="container">
          <div class="col-lg-8">
              <h1>lern and pass on</h1>
          </div>
          <div class="col-lg-4">
          </div>
      </div>
      <!-- /container -->
  </div>


  <!-- ABOUT SECTION -->
  <section id="about" name="about"></section>
  <div class="container about">
      <#--<div class="col-lg-6 col-lg-offset-3">-->
          <h3>Найти Автобус</h3>
          <h5>---------------------</h5>
          <hr>
          <br>
          <br>
          <br>
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

          <!-- Optional theme -->
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
          <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />


          <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>

          <#--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>-->

          <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
          <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">

                              <!--end of col-->
                              <#--<div class="col">-->
                                  <#--<input class="form-control form-control-lg form-control-borderless" type="search" placeholder="Search topics or keywords">-->
                              <#--</div>-->
          <form action="/public/search" method="get">
              <div class="form-row">
                  <div class="col-sm-2">
                      <input type="text" class="form-control"  name="departure" placeholder="Откуда">
                  </div>

                  <div class="col-sm-2">
                      <input type="text" class="form-control" name="arrival" placeholder="Куда">
                  </div>

                  <div class='col-sm-3'>
                      <div class='input-group date' id='datetimepicker3' >
                          <input type='text' class="form-control" name="departureTime" />
                          <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                          </span>
                      </div>
                  </div>

                  <div>
                      <button type="submit" class="btn btn-primary">Искать</button>
                  </div>
              </div>
          </form>


          <hr>
          <br>
          <br>
          <br>
      </div>
      <!-- /col-lg-6 -->
      </div>
  <!-- /container -->

  <section id="portfolio" name="portfolio"></section>
  <div id="foliowrap">
      <div class="container">
          <h3>Наши автобусы</h3>
          <br>
          <br>
          <div class="row">

              <!-- PORTFOLIO IMAGE 1 -->
              <div class="col-md-4 ">
                  <div class="grid mask">
                      <figure>
                          <img class="img-responsive" src="../static/img/portfolio/folio01.jpg" alt="">
                          <figcaption>
                              <h5>Mersedes benz 5612</h5>
                              <a data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Take a Look</a>
                          </figcaption>
                          <!-- /figcaption -->
                      </figure>
                      <!-- /figure -->
                  </div>
                  <!-- /grid-mask -->
                  <br>
              </div>
              <!-- /col -->


              <!-- MODAL SHOW THE PORTFOLIO IMAGE. In this demo, all links point to this modal. You should create
                                    a modal for each of your projects. -->

              <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <h4 class="modal-title">Project Title</h4>
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                          </div>
                          <div class="modal-body">
                              <p><img class="img-responsive" src="../static/img/portfolio/folio01.jpg" alt=""></p>
                              <p>This project was crafted for Some Name corp. Detail here a little about your job requirements and the tools used. Tell about the challenges faced and what you and your team did to solve it.</p>
                              <p><b><a href="#">Visit Site</a></b></p>
                          </div>
                          <div class="modal-footer">
                              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                          </div>
                      </div>
                      <!-- /.modal-content -->
                  </div>
                  <!-- /.modal-dialog -->
              </div>
              <!-- /.modal -->


              <!-- PORTFOLIO IMAGE 2 -->
              <div class="col-md-4">
                  <div class="grid mask">
                      <figure>
                          <img class="img-responsive" src="../static/img/portfolio/folio02.jpg" alt="">
                          <figcaption>
                              <h5>Mersedes benz 5612</h5>
                              <a data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Take a Look</a>
                          </figcaption>
                          <!-- /figcaption -->
                      </figure>
                      <!-- /figure -->
                  </div>
                  <!-- /grid-mask -->
                  <br>
              </div>
              <!-- /col -->

              <!-- PORTFOLIO IMAGE 3 -->
              <div class="col-md-4">
                  <div class="grid mask">
                      <figure>
                          <img class="img-responsive" src="../static/img/portfolio/folio03.jpg" alt="">
                          <figcaption>
                              <h5>Mersedes benz 5612</h5>
                              <a data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Take a Look</a>
                          </figcaption>
                          <!-- /figcaption -->
                      </figure>
                      <!-- /figure -->
                  </div>
                  <!-- /grid-mask -->
                  <br>
              </div>
              <!-- /col -->
          </div>
          <!-- /row -->

          <!-- PORTFOLIO IMAGE 4 -->
          <div class="row">
              <div class="col-md-4 ">
                  <div class="grid mask">
                      <figure>
                          <img class="img-responsive" src="../static/img/portfolio/folio04.jpg" alt="">
                          <figcaption>
                              <h5>Mersedes benz 5612</h5>
                              <a data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Take a Look</a>
                          </figcaption>
                          <!-- /figcaption -->
                      </figure>
                      <!-- /figure -->
                  </div>
                  <!-- /grid-mask -->
                  <br>
              </div>
              <!-- /col -->

              <!-- PORTFOLIO IMAGE 5 -->
              <div class="col-md-4">
                  <div class="grid mask">
                      <figure>
                          <img class="img-responsive" src="../static/img/portfolio/folio05.jpg" alt="">
                          <figcaption>
                              <h5>TWITTER STATUS</h5>
                              <a data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Take a Look</a>
                          </figcaption>
                          <!-- /figcaption -->
                      </figure>
                      <!-- /figure -->
                  </div>
                  <!-- /grid-mask -->
                  <br>
              </div>
              <!-- /col -->

              <!-- PORTFOLIO IMAGE 6 -->
              <div class="col-md-4">
                  <div class="grid mask">
                      <figure>
                          <img class="img-responsive" src="../static/img/portfolio/folio06.jpg" alt="">
                          <figcaption>
                              <h5>Mersedes benz 5612</h5>
                              <a data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Take a Look</a>
                          </figcaption>
                          <!-- /figcaption -->
                      </figure>
                      <!-- /figure -->
                  </div>
                  <!-- /grid-mask -->
              </div>
              <!-- /col -->
              <br>
          </div>
          <!-- /row -->
      </div>
      <!-- /container -->
  </div>
  <!-- /foliowrap -->
  <section id="blog" name="blog"></section>
  <div class="container">
      <div class="row">
          <div class="col-lg-3"></div>
          <div class="col-lg-6 about">
              <h3>Дополнительная информация</h3>
              <h5>_________________________</h5>
              <br>
              <br>

              <!-- ACCORDION -->
              <div class="accordion" id="accordion2">
                  <div class="accordion-group">
                      <div class="accordion-heading">
                          <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                              <date> >Инфо</date>
                              <plus> + </plus> Правила проезда, покупки и возврата билетов
                          </a>
                      </div>
                      <!-- /accordion-heading -->
                      <div id="collapseOne" class="accordion-body collapse in">
                          <br>
                          <div class="accordion-inner">
                              <h4> Возврат и обмен билетов</h4>
                              <p><h5>Обмен билетов</h5><p>Операция обмена билетов автовокзалами не поддерживается. Если возникла потребность обменять билет на другой, необходимо выполнить операцию возврата билета, а затем приобрести новый билет. Мы рекомендуем использовать возврат денег на предоплатный счёт, что позволит получить деньги с минимальными задержками и использовать их для новой покупки.</p>
                              <h5>Правила возврата билетов</h5><p>Согласно статье 23 <a href="http://www.rg.ru/2007/11/17/ustav-doc.html" target="_blank">Устава автомобильного транспорта</a> от 8 ноября 2007 г. при срыве рейса по техническим причинам или задержке рейса более чем на час, возврат денег производится в полном объеме. Если возврат билета инициирует пассажир, то производятся следующие удержания:</p>
                              <ul>
                                  <li>Возврат билета более чем за 2 часа до отправления - 5%
                                  <li>Возврат билета в течение 2 часов до отправления - 15%
                                  <li>Возврат билета в течение 3 часов после отправления - 25%
                                  <li>Через 3 часа после отправления автобуса возврат денег за билет не производится
                              </ul><p>Расчет суммы возврата производится от тарифа автовокзала, а не от конечной цены билета. Таким образом, агентский сбор в сумму возврата не включается. Автовокзал Томска дополнительно производит сбор за возврат билета в размере 25 рублей, автовокзал Самары - в размере 30 рублей. На автовокзалах Омской области возврат билетов на пригородные рейсы производится в том случае, если до отправления автобуса осталось не менее суток.</p></span></div>
                          </li>
                      </div>
                      <!-- /accordion-inner -->
                  </div>
                  <!-- /collapse -->
              </div>
              <!-- /accordion-group -->
              <br>

              <div class="accordion-group">
                  <div class="accordion-heading">
                      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
                          <date> >Инфо</date>
                          <plus> + </plus>Путешествие с детьми
                      </a>
                  </div>
                  <div id="collapseTwo" class="accordion-body collapse">
                      <div class="accordion-inner">
                          <p><p>Порядок перевозки детей определен в Федеральном законе N 259-ФЗ "<a href="https://rg.ru/2007/11/17/ustav-doc.html" target="_blank">Устав автомобильного транспорта и городского наземного электрического транспорта</a>" от 8 ноября 2007 г. В части второй статьи 21 данного закона говорится, что "В случаях, если в установленном порядке запрещена перевозка в транспортных средствах детей без предоставления им отдельных мест для сидения, пассажир имеет право перевезти с собой двух детей в возрасте не старше двенадцати лет с предоставлением им отдельных мест для сидения за плату, размер которой не может составлять более чем пятьдесят процентов провозной платы".</p><br>
                          <p>
                              Действующие Правила дорожного движения определяют правила проезда детей только в легковых, грузовых автомобилях и на мотоциклах. Однако же пункт 22.3 правил гласит: "Число перевозимых людей в кузове грузового автомобиля, а также салоне автобуса, осуществляющего перевозку на междугородном, горном, туристическом или экскурсионном маршруте, и при организованной перевозке группы детей не должно превышать количества оборудованных для сидения мест".</p><p><br>
                          На основании вышеизложенного, положение, позволявшее провозить детей на руках бесплатно, утратило силу. Для ребенка возрастом до 12 лет должен приобретаться детский билет. За проезд детей с 12 лет плата взимается по полному тарифу. Возраст ребенка определяется на день начала поездки.</p><p>
                          Согласно статьи 26 Гражданского кодекса РФ дети до 14 лет являются малолетними и ограничены в праве заключения сделок. Проезд малолетних детей по территории Российской Федерации должен производиться в сопровождении взрослых. Если рейс является международным, то при пересечении границы для сопровождаюшего, не являющегося родителем, усыновителем или опекуном, потребуется доверенность на сопровождение ребенка.</p><p><br>
                          Согласно статьи 60 Конституции РФ гражданин страны может осуществлять свои права и обязанности в полном объеме с 18 лет. Самостоятельное пересечение границы Российской Федерации возможно воможно именно с этого возраста.</p><p><br>
                          Электронные билеты являются именными документами. Без документа, удостоверяющего личность пассажира, электронный билет считается недействительным. Для детей в возрасте до 14 лет документом, удостоверяющем личность, является свидетельство о рождении.</p><br>
                      </div>
                      <!-- /accordion-inner -->
                  </div>
                  <!-- /collapse -->
              </div>
              <!-- /accordion-group -->
              <br>

              <div class="accordion-group">
                  <div class="accordion-heading">
                      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
                          <date> >Инфо</date>
                          <plus> + </plus>Конфиденциальность и защита персональных данных
                      </a>
                  </div>
                  <div id="collapseThree" class="accordion-body collapse">
                      <div class="accordion-inner">
                          <p><p>При регистрации на Сайте Клиент предоставляет следующую информацию: фамилия, имя, отчество, контактный телефон, тип документа, удостоверяющего личность, номер и серия документа, адрес электронной почты, пароль для доступа к Сайту. При этом обязательны к заполнению только следующие поля: фамилия, имя, адрес электронной почты и пароль.</p><p>
                          При оформлении заказа Клиент должен предоставлять следующую информацию: фамилия, имя, тип документа, удостоверяющего личность, номер и серия документа. При покупке билета на международный рейс дополнительно запрашивается отчество и место рождения.</p><p>
                          Предоставляя свои персональные данные при авторизации/регистрации на сайте, Клиент соглашается на их обработку в течение неопределенного срока компанией ООО "Артмарк" (далее также "Продавец") в целях исполнения Продавцом своих обязательств перед клиентом, продажи им товаров и предоставления услуг, предоставления им справочной информации, а также в целях продвижения товаров, работ и услуг. При обработке персональных данных Клиента компания ООО "Артмарк" руководствуется Федеральным законом "О персональных данных" и локальными нормативными документами.
                      </p><p>
                          Клиент вправе получить информацию, касающуюся обработки его персональных данных (в т.ч. о способах и целях обработки, о лицах, которые имеют доступ к его персональным данным или которым могут быть раскрыты персональные данные на основании договора с ООО «Артмарк» или на основании федерального закона, о сроках обработки).
                      </p><h5>Использование информации предоставленной Клиентом</h5><p>
                          Продавец использует предоставленные Клиентом данные в течение всего срока регистрации Клиента на Сайте в целях</p>
                          <ul>
                              <li>для регистрации/авторизации Клиента на Сайте;
                              <li>для обработки заказов Клиента и выполнения своих обязательств перед Клиентом;
                              <li>для осуществления деятельности по продвижению товаров и услуг;
                                  анализа покупательских особенностей Клиента и предоставления персональных рекомендаций.
                          </ul>

                          <h5>Предоставление и передача информации, полученной Продавцом</h5>

                          <p>
                              Продавец обязуется не передавать полученную от Клиента информацию третьим лицам. Не считается нарушением предоставление Продавцом информации агентам и третьим лицам, действующим на основании договора с Продавцом, для исполнения обязательств перед Клиентом и только в рамках договоров.
                          </p>
                          <p>
                              Не считается нарушением обязательств передача информации в соответствии с обоснованными и применимыми требованиями законодательства Российской Федерации.
                          </p>
                          <p>
                              Продавец вправе использовать технологию "cookies". "Cookies" не содержат конфиденциальную информацию и не передаются третьим лицам.
                          </p>
                          <p>
                              Продавец получает информацию об ip-адресе посетителя Сайта www.e-traffic.ru и сведения о том, по ссылке с какого интернет-сайта посетитель пришел. Данная информация не используется для установления личности посетителя.
                          </p>
                          <p>
                              Продавец не несет ответственности за сведения, предоставленные Клиентом на Сайте в общедоступной форме.
                          </p>
                          <p>
                              Продавец при обработке персональных данных принимает необходимые и достаточные организационные и технические меры для защиты персональных данных от неправомерного доступа к ним, а также от иных неправомерных действий в отношении персональных данных.
                          </p></p></div>
                      <!-- /accordion-inner -->
                  </div>
                  <!-- /collapse -->
              </div>
              <!-- /accordion-group -->
              <br>

              <div class="accordion-group">
                  <div class="accordion-heading">
                      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour">
                          <date> >Инфо</date>
                          <plus> + </plus>Перевозка багажа
                      </a>
                  </div>
                  <div id="collapseFour" class="accordion-body collapse">
                      <div class="accordion-inner">
                          Согласно статье 22 "<a href="https://rg.ru/2007/11/17/ustav-doc.html" target="_blank">Устава автомобильного транспорта</a>" при проезде в транспортном средстве, осуществляющем регулярные перевозки пассажиров и багажа, пассажир имеет право:</p><br>
                          <ol><li>перевозить за плату в багажном отделении транспортного средства или в отдельном транспортном средстве багаж в количестве не более двух мест, длина, ширина и высота каждого из которых в сумме не превышают сто восемьдесят сантиметров;<li>провозить с собой бесплатно ручную кладь в количестве не более одного места, длина, ширина и высота которого в сумме не превышают сто двадцать сантиметров, одну пару лыж в чехле, детские санки, детскую коляску.</ol><p><br>К сожалению, из-за технических или организационных ограничений приобретение багажных билетов через интернет возможно далеко не для всех автовокзалов. В таких случаях багажные билеты следует приобретать в кассах автовокзала. Пассажиры, совершающие посадку, имеют право на обслуживание вне очереди.</span></div>
                      </li></div>
                  <!-- /accordion-inner -->
              </div>
              <!-- /collapse -->
          </div>
          <!-- /accordion-group -->
          <br>
      </div>
      <!-- Accordion -->
  </div>
          <!-- /col-lg-6 -->

          <div class="col-lg-3"></div>
      </div>
      <!-- /row -->
  </div>
  <!-- /container -->
  <div id="copyrights">
      <div class="container">
          <p>
              &copy; Copyrights <strong>Osprey studio</strong>. All Rights Reserved
          </p>
          <div class="credits">
              Created by <a href="#">learn and pass on</a>
          </div>
      </div>
  </div>
</@c.page>

<#--<div class="row">

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
                <input id="icon_telephone" type="date" name="departureTime"> <!--class="datepicker"> &ndash;&gt;
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
<!-- add jquery script &ndash;&gt;

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
<!--materialize script &ndash;&gt;
<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/materialize.min.js"></script>-->

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