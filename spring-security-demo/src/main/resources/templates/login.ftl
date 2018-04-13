<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/lib/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/lib/sb-admin-2/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form role="form">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Username" name="username" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" type="password" value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <div id="error" class="alert alert-danger alert-dismissable" style="display: none;">
                                <button type="button" class="close">×</button>
                                <span></span>
                            </div>
                            <input type="submit" value="Login" class="btn btn-lg btn-success btn-block"/>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="/resources/lib/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/lib/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/resources/lib/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/resources/lib/sb-admin-2/js/sb-admin-2.min.js"></script>

<script>
    $('form').submit(function (e) {
        e.preventDefault();
        var username = $(this).find('[name=username]').val();
        var password = $(this).find('[name=password]').val();
        if (!username || !password) {
            showError('用户名密码不能为空');
            return;
        }

        $.ajax('/login', {
            method:'POST',
            data:$(this).serialize(),
            success:function () {
                window.location.replace('/')
            },
            error:function (xhr) {
                showError(xhr.responseJSON.message);
            }
        })
    });

    $('.close').click(function () {
        $(this).parent().hide();
    });

    function showError(error) {
        $('#error').show().find('span').text(error);
    }
</script>

</body>

</html>
