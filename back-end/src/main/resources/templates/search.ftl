<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
</head>


<body style="background-color: #666869">

<main xmlns="http://www.w3.org/1999/html">

<div class="container" style="margin-top:  200px; margin-left: 400px">

<form action="/public/search" method="get">
    <div class="form-row">
        <div class="col-sm-2">
        <input type="text" class="form-control"  name="departure" placeholder="Откуда">
        </div>

        <div class="col-sm-2">
        <input type="text" class="form-control" name="arrival" placeholder="Куда">
        </div>
        <p>

        </p>
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
</div>


<#if busflights??>
    <#list busflights as busflight >
    <span class="counter pull-right"></span>
    <table class="table table-hover table-bordered results" style="margin-top: 100px; margin-right: 50px; background-color: #f7f7f7">
        <thead>
        <tr>
            <th>#</th>
            <th class="col-md-5 col-xs-5">Откуда</th>
            <th class="col-md-4 col-xs-4">Куда</th>
            <th class="col-md-3 col-xs-3">Время отправелния</th>
        </tr>
        </thead>


        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>${busflight.getDeparture()}</td>
            <td>${busflight.getArrival()}</td>
            <td>${busflight.departureTime}</td>
        </tr>
        </tbody>
    </table>
    </#list>
<#else >
NO BUSES
</#if>
</main>
</body>

<style>
    body{
        padding:20px 20px;
    }

    .results tr[visible='false'],

    }

    .results tr[visible='true']{
        display:table-row;
    }

    .counter{
        padding:8px;
        color: #f7f7f7;
    }

</style>

<script type="text/javascript">
    $(function () {
        $('#datetimepicker3').datetimepicker({format: 'YYYY-MM-DD'});
    });

</script>


</html>

