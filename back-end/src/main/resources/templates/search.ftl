<!DOCTYPE html>
<html>
<!-- TODO create more fiddles (empty option, selected property in data) -->
<head>
    <title>Simple Combobox Description</title>

    <link href="/static/css/jquery.scombobox.css" rel="stylesheet" />
    <link href="/static/css/jquery.ui.datepicker.min.css" rel="stylesheet" />
    <link href="/static/css/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/icons.css" rel="stylesheet" />
    <link href='https://fonts.googleapis.com/css?family=Montez' rel='stylesheet' type='text/css'>


    <script src="/static/js/missed.js"></script><!-- add this script for IE8 compatibility -->
    <script src="/static/js/latinize.js"></script><!-- add this to use filterIgnoreAccents option (convert Művész to Muvesz) -->
    <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.min.js"></script>
    <script src="/static/js/jquery.scombobox.min.js"></script>
    <script src="/static/js/jquery.easing.min.js"></script>
    <!--jQuery Migrate -->
<#--<script src="https://code.jquery.com/jquery-3.0.0.js"></script>-->
<#--<script src="https://code.jquery.com/jquery-migrate-3.0.1.js"></script>-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        * {
            padding: 0; margin: 0;
        }
        body {
            font-family: 'Arial', sans-serif;
            font-size: 90%;
            color: #333;
            line-height: 20px;
        }
        input {
            font-size: 110%;
            width: 6.8em;
            height: 100%;
            padding: 2px 19px 2px 4px;
            border: 1px solid #CCC;
            border-radius: 4px;
            box-sizing: border-box;
            -moz-box-sizing: border-box;

        }

        form {
            margin-left: 540px;
            margin-top: 200px;

        }
        .main {
            padding: 10px 20px;
        }
        .main > table {
            width: 100%;
        }
        p {
            padding: 5px 0 8px 0;
            text-indent: 35px;
            line-height: 20px;
        }
        pre {
            padding: 5px 0 8px 35px;
            line-height: 18px;
        }
        pre.nopadding {
            padding: 0;
        }
        td.result {
            width: 50%;
            vertical-align: top;
        }
        table {
            border-collapse: collapse;
        }
        .docs { margin-top: 10px }
        .docs td {
            vertical-align: top;
        }
        .docs th, .docs td {
            padding: 5px;
            border: 1px solid #CCC;
        }
        .docs th {
            text-align: center;
            background: #F8F8F8;
            font-weight: normal;
            padding-top: 10px;
            padding-bottom: 10px;
        }
    </style>
</head>
<body>

<form action="/public/search" method="get">

    <select name="departure" id="combo-01">
        <#list selects! as select>
            <option  value="${select.id}">${select.departure}</option>
        </#list>
    </select>

    <select name="arrival" id="combo-02">
        <#list selects! as select>
            <option  value="${select.id}">${select.arrival}</option>
        </#list>
    </select>

    <input name="departureDate" style="margin-left: 0.3em" type="text" id="datepicker" value="2018-08-20" />
</form>

<div class="icon">
    <div class="calendar">
        20
        <div class="holes"></div>
        <div class="flip"></div>
    </div>
</div>
<div class="container">
    <div class="center_wrapper">
        <div class="note red rounded">
            <img alt="" class="img" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABoAAAAhCAYAAADH97ugAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA2hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDowOTgwMTE3NDA3MjA2ODExODIyQUI2NTZGMjczMjg3NSIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpBQjFDOEI3QUI1OTcxMUUyQTQ1NEM2N0M0OEZCNTg0QiIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpBQjFDOEI3OUI1OTcxMUUyQTQ1NEM2N0M0OEZCNTg0QiIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRvc2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6MDk4MDExNzQwNzIwNjgxMTgyMkFCNjU2RjI3MzI4NzUiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6MDk4MDExNzQwNzIwNjgxMTgyMkFCNjU2RjI3MzI4NzUiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7Oag1KAAABbklEQVR42uyXu0oDURCGcxLdvIrPYaMGTCSgYASLCCnSeXmMiI2FhdoIKlioEAgSSKG+g76BjYVCbiqi/8AfWIaz657sgs0Z+Nhkzsx8LHuyuzGvb+85x5jj8dmlKe9Qa8A+eCIt5jIVycBDsBPK7TJnshLJoCPQtKw1uWbSigrgGDRiahqsKUwrksZTUE9w1nXWRspmYiRnYN1hs2xynhy/k5zRLLiwSB4stY/qew2cc0asKACXYFXl78GSRbTItXCscUYQJZKFK1BVjT1KBhbRgGs9la9yVqBFRXANyqqhC5bBMObaDFnTVfkyZxYnIrmAt6CkCu9A5Q9JWFZhTzhKnB2IaAMsqIIOWAEjh103oqyj8jK7lrds8TYl45x7fLC3rX9GBndvuWAnYB7cgG3wGTHox3J7soXMPKBUNsqWcXxMJBWlekykCi/yIi/yIi/6R9FLxOfMRfJi3yd7Lo1miv9Hk5fDL5emXwEGAGRKSazTuULwAAAAAElFTkSuQmCC" />
        </div>
        <div class="note yellow rounded">
            <img alt="" class="img" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABoAAAAhCAYAAADH97ugAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA2hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDowOTgwMTE3NDA3MjA2ODExODIyQUI2NTZGMjczMjg3NSIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpBQjFDOEI3RUI1OTcxMUUyQTQ1NEM2N0M0OEZCNTg0QiIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpBQjFDOEI3REI1OTcxMUUyQTQ1NEM2N0M0OEZCNTg0QiIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRvc2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6MDk4MDExNzQwNzIwNjgxMTgyMkFCNjU2RjI3MzI4NzUiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6MDk4MDExNzQwNzIwNjgxMTgyMkFCNjU2RjI3MzI4NzUiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz4IT8tNAAABfElEQVR42uyXzUrDQBSFrWKl6QvoG/gUCgV/QVRQ0IULf8CFPosuRF0U6SIUF5WqFRTfxAeQ4kJBdxqN9Rw4QrgkNpPWXQY+Mr1z7z2ZzuRmUnh+fRtwbMO6froEDTqKrIEXse4SWHCcURuMqf8U6fd9RtHEo//512VuuVAulAvlQrlQn4WK4Bw8gmP97rUxx5FyMneRL74tdM4iTjdgBQQxCTr2xZkgcgEWIrYdzig0jnS4AiMZZsKYSyPC9k2hOrg3A3PgGpQcREq6wXljZ+46hb7AErg1DjMS81KIeBKZNXbmXOQy/O66d7AMWsZxSmvmdRGhz7Sxt5Tzw25vLv4qaJqACrgD5RiRsu66YuxN5QqSnqNAZ7eGsU9IzDbaJo2toRxBmnPdEPBdD4l6ZjZidnJiZQgV4DuI+Eki3UoQAzZBLYVITb5h1lrHwG1Q/cOnKp+w16LKsrMLTmPGTjTW6Vf1ZqI9cBixHYD9NCJZvibYxnV9cAn6EWAAPAhWNEwsXBEAAAAASUVORK5CYII=" />
        </div>
        <div class="button_group">
            <div>
                <h3>One Click Bus</h3>
                <p><input type="submit" value="SEARCH" class="turquoise-flat-button"></p>
            </div>



<#if busflights??>
    <#list busflights as busflight >
    <table>
        <thead>
        <tr>
            <th>Departure</th>
            <th>Arrival</th>
            <th>Departure Date</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td data-label="First Name">${busflight.departure}</td>
            <td data-label="Last Name">${busflight.arrival}</td>
            <td data-label="Hero Title">${busflight.departureTime}</td>
        </tr>
        </tbody>
    </table>
    </#list>
<#else >
No buses
</#if>




            <script>
                $().scombobox.extendDefaults({
                    filterIgnoreAccents: true,
                    highlight: true
                });
                $(function() {
                    $('#combo-01').scombobox({filterDelay: 300, placeholder: 'Lol'});
                    $('#combo-02').scombobox({filterDelay: 300, placeholder: 'Lol'});
                });

                $(document).ready(function(){
                    $("#datepicker").datepicker({
                        dateFormat: 'yy-mm-dd'
                    });
                });

            </script>
        </div>

    </div>
</body>
</html>
