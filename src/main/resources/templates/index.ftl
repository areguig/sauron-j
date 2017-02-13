<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link  href="img/favicon.ico"  rel="icon" type="image/x-icon">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
    <!-- Optional theme
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">-->
    <title>Sauron</title>
</head>
<body>
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Sauron</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/"> <span class="glyphicon glyphicon-refresh"></span> ${time?datetime}</a></li> </li>
        </ul>
    </div>
    <div class='container'>
        <h4><span class="label label-default">Systems status</span></h4>
        <div class="alert <#if systems_status ==2>alert-danger <#elseif  systems_status ==0> alert-success <#else> alert-warning </#if>" role="alert">
            <#if systems_status gt 0> Systems are experiencing issues. <#else> All systems are operational. </#if>
        </div>
        <h4><span class="label label-default">Components</span></h4>
        <div class="list-group">
            <#list components as component>
                <div class="list-group-item">
                    <a href="${component.link}" target="_blank"><h5 class="list-group-item-heading">${component.name}</h5></a>
                    <div class="pull-right">
                        <span class="label  <#if component.status ==0> label-success <#elseif component.status==1> label-warning <#else> label-danger</#if>">
                        ${component.statusStr}</span>
                    </div>
                    <p class="list-group-item-text">${component.description}</p>
                </div>
            </#list>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-5">
                    <p>Powered by <a href="https://areguig.io" class="links">Sauron</a>.</p>
                </div>
                <div class="col-sm-7">
                    <ul class="list-inline">

                    </ul>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>