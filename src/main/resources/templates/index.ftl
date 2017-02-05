<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
    <!-- Optional theme
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">-->
    <title>Sauron</title>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/"  style="padding: 10px 10px !important;">
                    <img style=" height: 31px;" src="img/sauron.png" alt="S">
                </a>
            </div>
        </div>
    </nav>
    <div class='container'>
        <h2><span class="label label-default">Systems status</span></h2>
        <div class="alert <#if status !=0>alert-warning <#else> alert-success</#if>" role="alert">
            <#if status !=0> System outage is running. <#else> All systems are operational.</#if>
        </div>
        <h3><span class="label label-default">Components</span></h3>
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