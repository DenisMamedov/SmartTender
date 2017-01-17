<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 15.01.2017
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="index.jsp" %>

<table class="table table-striped table-hover table-condensed table-bordered">

    <tr>
        <td colspan="4">Тендер <%= request.getParameter("id")%>.  <%= request.getAttribute("tenderName")%>
        </td>
    </tr>
    <c:forEach var="item" items="${tenderSpec}">
        <c:set var="id" value="${item.getLotId()}"/>
        <fmt:parseNumber var="i" integerOnly="true" type="number" value="${id}"/>
        <tr>
            <td colspan="4"><c:out value="${item.getLotId()}"/>. <c:out value="${item.getSpecification()}"/></td>
        </tr>
        <tr>
            <td>
                Цена за единицу (без НДС)
            </td>
            <td>
                <c:out value="${offer.get(item.getLotId()).getPrice()}"/>
            </td>
            <td>Количество</td>
            <td><c:out value="${item.getQuantity()}"/></td>
        </tr>
        <tr>
            <td>
                Срок поставки (в днях)
            </td>
            <td>
                <c:out value="${offer.get(item.getLotId()).getTermOfDelivery()}"/>
            </td>
            <td>
                Условия оплаты
            </td>
            <td>
                <c:out value="${offer.get(item.getLotId()).getConditionOfPayment()}"/>
            </td>
        </tr>
        <tr>
            <td>
                Условия доставки
            </td>
            <td>
                <c:out value="${offer.get(item.getLotId()).getConditionOfDelivery()}"/>
            </td>
            <td>
                Гарантия (лет)
            </td>
            <td>
                <c:out value="${offer.get(item.getLotId()).getGuarantee()}"/>
            </td>
        </tr>
        <tr>
            <td>Дополнительная информация</td>
            <td colspan="3"><c:out value="${item.getInformation()}"/></td>
        </tr>
        <tr>
            <td>
                Информация участника
            </td>
            <td colspan="3">
                <c:out value="${offer.get(item.getLotId()).getAdditionalInfo()}"/>
            </td>
        </tr>

    </c:forEach>
    <tr>
        <td colspan="4">
            <a href="?command=/history">
                <button class="btn btn-primary">Назад</button>
            </a>
        </td>
    </tr>
</table>


</div>
</div>
</body>
</html>