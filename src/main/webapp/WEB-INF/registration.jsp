<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 11.01.2017
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>

<h1>Регистрация нового поставщика</h1>

<form method="post" action="">
    <div class="form-group">
        <label for="supplier_name"><p>Название предприятия</p></label>
        <input type="text" class="form-control" name="supplier_name" id="supplier_name" value="${sessionScope.get("supplierName")}">
    </div>
    <div class="form-group">
        <label for="okpo"><p>Код ОКПО</p></label>
        <input type="text" class="form-control" name="okpo" id="okpo" pattern="[0-9]{8}" value="${sessionScope.get("okpo")}">
    </div>
    <div class="form-group">
        <label for="address"><p>Адрес</p></label>
        <input type="text" class="form-control" name="address" id="address" value="${sessionScope.get("address")}">
    </div>
    <div class="form-group">
        <label for="contact_name"><p>Контактное лицо</p></label>
        <input type="text" class="form-control" name="contact_name" id="contact_name" value="${sessionScope.get("contactName")}">
    </div>
    <div class="form-group">
        <label for="contact_phone"><p>Контактный телефон</p></label>
        <input type="text" class="form-control" name="contact_phone" id="contact_phone" value="${sessionScope.get("contactPhone")}">
    </div>
    <div class="form-group">
        <label for="email"><p>Электронная почта</p></label>
        <input type="email" class="form-control" name="email" id="email" value="${sessionScope.get("email")}">
    </div>
    <div class="form-group">
        <label for="password"><p>Пароль</p></label>
        <input type="password" class="form-control" name="password" id="password">
    </div>
    <div class="form-group">
        <label for="passwordConfirm"><p>Подтверждение пароля</p></label>
        <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm">
    </div>
    <input type="submit" class="btn btn-default" value="Зарегестрироватся">
</form>

</div>
</div>
</body>
</html>