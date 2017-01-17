<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 12.01.2017
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="index.jsp" %>

<form id="offer" method="post" action=?command=/save>
<table class="table table-striped table-hover table-condensed table-bordered">

    <tr>
        <td colspan="4">Тендер <%= request.getParameter("id")%>.  <%= request.getAttribute("tenderName")%></td>
    </tr>
<c:forEach var = "item" items = "${tenderSpec}">
    <c:set var="id" value="${item.getLotId()}"/>
    <fmt:parseNumber var="i" integerOnly="true" type="number" value="${id}"/>
    <tr>
        <td colspan="4"><c:out value="${item.getLotId()}"/>. <c:out value="${item.getSpecification()}"/></td>

    </tr>
    <tr>
        <td>Лучшая цена</td>
        <td colspan="3"><c:out value="${bestPrice.get(item.getLotId())}"/></td>
    </tr>
    <tr>
        <td>
            <label for="${item.getLotId()}">Цена за единицу (без НДС)</label>
        </td>
        <td>
            <input type="text" class="navigatorInput" name="price" id="${item.getLotId()}" placeholder="0.00" pattern="\d+(\.\d{2})?" form="offer" value="<c:out value="${offer.get(item.getLotId()).getPrice()}"/>">
        </td>
        <td >Количество</td>
        <td><c:out value="${item.getQuantity()}"/></td>
    </tr>
    <tr>
        <td>
            <label for="term">Срок поставки (в днях)</label>
        </td>
        <td>
            <input type="text" name="term_of_delivery" id="term" class="${item.getLotId()}" form="offer" pattern="^[ 0-9]+$" required value="<c:out value="${offer.get(item.getLotId()).getTermOfDelivery()}"/>">
        </td>
        <td>
            <label for="condition">Условия оплаты</label>
        </td>
        <td>
            <input type="text" name="condition_of_payment" id="condition" class="${item.getLotId()}" required form="offer" value="<c:out value="${offer.get(item.getLotId()).getConditionOfPayment()}"/>">
        </td>
    </tr>
    <tr>
        <td>
            <label for="delivery">Условия доставки</label>
        </td>
        <td>
            <input list="incoterms" size="30" name="condition_of_delivery" class="${item.getLotId()}" id="delivery" required form="offer" value="<c:out value="${offer.get(item.getLotId()).getConditionOfDelivery()}"/>" placeholder="Инкотермс 2010">
            <datalist id="incoterms">
                <option value="EXW Ex Works / Франко завод">
                <option value="FCA Free Carrier / Франко перевозчик">
                <option value="CPT Carriage Paid to / Перевозка оплачена до">
                <option value="CIP Carriage and Insurance Paid to / Перевозка и страхование оплачены до">
                <option value="DAT Delivered at Terminal / Поставка на терминале">
                <option value="DAP Delivered at Place / Поставка в месте назначения">
                <option value="DDP Delivered Duty Paid / Поставка с оплатой пошлин">
            </datalist>
        </td>
        <td>
            <label for="guarantee">Гарантия (лет)</label>
        </td>
        <td>
            <input type="number" min="0" max="10" step="0.1" name="guarantee" class="${item.getLotId()}" id="guarantee" required form="offer" pattern="^[ 0-9]+$" value="<c:out value="${offer.get(item.getLotId()).getGuarantee()}"/>">
        </td>
    </tr>
    <tr>
        <td>Дополнительная информация</td>
        <td colspan="3"><c:out value="${item.getInformation()}"/></td>
    </tr>
    <tr>
        <td>
            <label for="info">Информация участника</label>
        </td>
        <td colspan="3">
            <textarea rows="5" cols="100" name="additional_info" id="info" form="offer"><c:out value="${offer.get(item.getLotId()).getAdditionalInfo()}"/></textarea>
        </td>
    </tr>
    <tr><td colspan="3"> <input type="hidden" name="lot_id" value="${item.getLotId()}"></td></tr>

</c:forEach>
    <tr>
        <td colspan="4">

            <input type="hidden" name="supplier_id" value="${sessionScope.get("user").getId()}">
            <input type="hidden" name="tender_id" value="${request.getParameter("id")}">
            <c:if test="${offer != null}"> <input type="hidden" name="update" value="true"></c:if>
            <input type="submit" id="button_send" value="Отправить предложение">

        </td>
    </tr>
</table>
</form>

</div>
</div>
</body>
</html>