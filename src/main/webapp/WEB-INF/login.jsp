<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 10.01.2017
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<div class="container">
    <div class="starter-template">
<form method="post" class="form-horizontal logform">
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Электронная почта</label>
        <div class="col-sm-10">
            <input type="email" class="form-control" name="email" id="email">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Пароль</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" name="password" id="password">
        </div>
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="btn btn-primary btn-lg btn-block button" value="Войти">
        </div>
    </div>
</form>





    </div>
</div>
</body>
</html>
