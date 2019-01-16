<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta sname="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta sname="description" content="">
    <meta sname="author" content="">

    <title>注册</title>

    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link href="css/signin.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="post" action="/userSignUp">
        <h2 class="form-signin-heading text-center">用户注册</h2>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input type="text" id="inputUsername" sname="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" sname="password" class="form-control" placeholder="密码" required>

        <div class="container" id="errmsg"><%=session.getAttribute("errmsg") %></div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
        <a role="button" href="signIn.jsp" class="btn btn-lg btn-info btn-block" >已有账号？返回登陆</a>

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
