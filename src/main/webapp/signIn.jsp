<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>登陆</title>

    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link href="css/signin.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="/userSignIn"  method="post">
        <h2 class="form-signin-heading text-center">用户登录</h2>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input type="text" id="inputUsername" class="form-control" name="username" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="密码" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
        <button class="btn btn-lg btn-info btn-block" type="button">还没账号？注册一个</button>
        <div class="container" id="errmsg"><%=session.getAttribute("errmsg") %></div>
        <%
          session.removeAttribute("errmsg");
        %>
      </form>

    </div> <!-- /container -->
  <script>
    if (document.getElementById("errmsg").innerText == "null") {
      document.getElementById("errmsg").style.display = 'none';
    }

  </script>
  </body>
</html>
