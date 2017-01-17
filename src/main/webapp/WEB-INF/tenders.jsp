<!--
Created by IntelliJ IDEA.
User: Денис
Date: 03.01.2017
Time: 0:06
To change this template use File | Settings | File Templates.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<div class="container">
    <div class="starter-template">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
                integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
                crossorigin="anonymous"
                xmlns="http://www.w3.org/1999/html"></script>

        <form method="post" id="search">

            <div class="form-group">
                <label for="val">Поиск по контексту</label>
                <input type="text" class="form-control" name="context" id="val"/>
            </div>
            <input type="submit" class="btn btn-default" name="search" value="Поиск"/>
        </form>
        <div id="but">
            <button id="extended">Расширенный поиск</button>
        </div>
        <div id="more" style="display: none" class="starter-template">
            <div class="form-group">Организатор:
                <input class="form-control" list="company" name="company" form="search"/>
                <datalist id="company">
                    <c:forEach var="item" items="${companyNames}">
                        <option value="<c:out value="${item}"/>"/>
                    </c:forEach>
                </datalist>
            </div>
            <div class="form-group">Категория:
                <input class="form-control" list="category" name="category" form="search"/>
                <datalist id="category">

                    <c:forEach var="item" items="${categoryNames}">
                        <option value="<c:out value="${item}"/>"/>
                    </c:forEach>

                </datalist>
            </div>
            <button id="rollup">Свернуть поиск</button>
            <button type="reset" form="search">Очистить</button>
        </div>
        <br/>
        <%= request.getAttribute("tenders")%>
        <%= session.getAttribute("tender")%>
        <%= request.getParameter("command")%>
        <%= request.getAttribute("command")%>
        <table class="table table-hover table-condensed">
            <tr style="background-color: lightgray">
                <th>№</th>
                <th>Предмет торгов</th>
                <th>Организатор</th>
                <th>Категория</th>
                <th>Статус торгов</th>
                <th>Дата и время закрытия</th>
            </tr>

            <c:forEach var="item" items="${tenders}">

                <tr class="navigatorItem" id="${item.getId()}">
                    <td><c:out value="${item.getId()}"/></td>
                    <td><c:out value="${item.getTenderName()}"/></td>
                    <td><c:out value="${item.getCompany().getCompanyName()}"/></td>
                    <td><c:out value="${item.getCategory().getCategoryName()}"/></td>
                    <td><c:out value="${item.getStatus().getStatusName()}"/></td>
                    <td><c:out value="${item.getEndDate()}"/></td>
                </tr>

                <tbody style="display: none; background-color: #f0f0f0;" class="${item.getId()}">
                <tr>
                    <td colspan="6">Детальная информация по тендеру</td>
                </tr>
                <tr>
                    <td colspan="6"><c:out value="${item.getId()}"/></td>
                </tr>
                <tr>
                    <td colspan="6">Организатор</td>
                </tr>
                <tr>
                    <td colspan="2">Наименование</td>
                    <td colspan="4"><c:out value="${item.getCompany().getCompanyName()}"/></td>
                </tr>
                <tr>
                    <td colspan="2">Адрес</td>
                    <td colspan="4"><c:out value="${item.getCompany().getAddress()}"/></td>
                </tr>
                <tr>
                    <td colspan="6">Информация про процедуру</td>
                </tr>
                <tr>
                    <td colspan="2">Окончание приёма предложений</td>
                    <td colspan="4"><c:out value="${item.getEndDate()}"/></td>
                </tr>
                <tr>
                    <td colspan="6">Предмет торгов</td>
                </tr>
                <tr>
                    <td colspan="2">Предмет торгов</td>
                    <td colspan="4"><c:out value="${item.getTenderName()}"/></td>
                </tr>
                <tr>
                    <td colspan="2">Категория</td>
                    <td colspan="4"><c:out value="${item.getCategory().getCategoryName()}"/></td>
                </tr>
                <tr>
                    <td colspan="2">Статус торгов</td>
                    <td colspan="4"><c:out value="${item.getStatus().getStatusName()}"/></td>
                </tr>
                <tr>
                    <td colspan="6">Контактное лицо</td>
                </tr>
                <tr>
                    <td colspan="2">Ф.И.О.</td>
                    <td colspan="4"><c:out value="${item.getCompany().getContactName()}"/></td>
                </tr>
                <tr>
                    <td colspan="2">Телефон</td>
                    <td colspan="4"><c:out value="${item.getCompany().getContactPhone()}"/></td>
                </tr>
                <tr>
                    <td colspan="6">
                        <c:if test="${sessionScope.get('user') != null}">
                            <form method="post" action="?command=/viewTender&id=${item.getId()}">
                                <c:choose>
                                    <c:when test="${requestScope.get('command') == '/'}">
                                        <button type="submit" class="btn btn-primary btn-lg active"
                                                value="${item.getId()}">Подать предложение
                                        </button>
                                    </c:when>
                                    <c:when test="${requestScope.get('command') == '/history'}">
                                        <button type="submit" class="btn btn-primary btn-lg active"
                                                value="${item.getId()}">Просмотреть предложение
                                        </button>
                                        <input type="hidden" name="isHistory" value="true"></c:when>
                                </c:choose>
                            </form>
                        </c:if>
                    </td>
                </tr>

                </tbody>
            </c:forEach>

        </table>

    </div>
</div>
</body>
</html>