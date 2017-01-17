<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 25.12.2016
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.tender.main.Message" %>
>
<%@ taglib prefix="tag" uri="/WEB-INF/welcomeCustomTag.tld" %>
<html>
<head>
    <title>Smarttender</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../static/css/style.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>
    <script src="../static/js/jquery-1.10.2.js"></script>
    <script src="../static/js/form.js"></script>
    <script src="../static/js/watch.js"></script>
    <script src="../static/js/jquery-1.10.2.js"></script>
    <script src="../static/js/search.js"></script>
</head>
<body onload="digitalWatch()">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">

            <a class="navbar-brand" href="/">Smarttender</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="?command=/">Тендеры</a></li>
                <li><a href="?command=/history">История предложений</a></li>
                <li><a href="?command=/logout">Выйтии</a></li>
                <li><a href="?command=/registration">Регистрация</a></li>
                <li><a href="?command=/login">Войти</a></li>

                <div class="container">
                    <div class="header clearfix">
                        <nav>
                            <ul class="nav nav-pills pull-right">
                                <li><a href="/ru">RU</a></li>
                                <li><a href="/en">EN</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="jumbotron">
    <h2><b>Время на сайте: </b><span id="digital_watch"></span></h2>
    <h2><b><tag:welcome
            supplierName="${sessionScope.get('user').getSupplierName()}">Авторизируйтесь или зарегестрируйтесь для того чтобы подать предложение</tag:welcome></b>
    </h2>
</div>

<div class="container">
    <div class="starter-template">
        <c:if test="${!Message.hasFlash()}">
        <div class="alert alert-info" role="alert">
            <c:out value="${Message.getFlash()}"/>
        </div>
        </c:if>
