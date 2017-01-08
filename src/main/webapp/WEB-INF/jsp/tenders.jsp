<!--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 03.01.2017
  Time: 0:06
  To change this template use File | Settings | File Templates.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"
            xmlns="http://www.w3.org/1999/html"></script>
    <script src="/js/jquery-1.10.2.js"></script>
    <script src="/js/search.js"></script>
    <link rel="stylesheet" href="/css/style.css"/>
    <form action="" method="post" id="search">

        <div class="form-group">
            <label for="val">Поиск по контексту</label>
            <input type="text" class="form-control" name="val" id="val"/>
        </div>
        <input type="submit" class="btn btn-default" value="Поиск"/>
    </form>
    <div id="but"><button id="extended">Расширенный поиск</button></div>
    <div id="more" style="display: none" class="starter-template">
        <div class="form-group">Организатор:
            <input class="form-control" list="company" name="company" form="search"/>
            <datalist id="company">

                <option value="Взять из базы всех организаторов"/>

            </datalist>
        </div>
        <div class="form-group">Категория:
            <input class="form-control" list="category" name="category" form="search"/>
            <datalist id="category">

                <option value="Взять из базы все категории"/>

            </datalist>
        </div>
        <button id="rollup">Свернуть поиск</button>
        <button type="reset" form="search">Очистить</button>
    </div><br/>


    <table class="table table-hover table-condensed">
        <tr style="background-color: lightgray">
            <th>№</th>
            <th>Предмет торгов</th>
            <th>Организатор</th>
            <th>Категория</th>
            <th>Статус торгов</th>
            <th>Дата и время закрытия</th>
        </tr>


        <tr class="navigatorItem" id="<?=$item['id']?>">
            <td>id</td>
            <td>tender_name</td>
            <td>company_name</td>
            <td>category_name</td>
            <td>status</td>
            <td>end_date</td>
        </tr>

        <tbody style="display: none; background-color: #f0f0f0;" class="<?=$item['id']?>">
        <tr>
            <td colspan="6">Детальная информация по тендеру</td>
        </tr>
        <tr>
            <td colspan="6">id</td>
        </tr>
        <tr>
            <td colspan="6">Организатор</td>
        </tr>
        <tr>
            <td colspan="2">Наименование</td>
            <td colspan="4">company_name</td>
        </tr>
        <tr>
            <td colspan="2">Адрес</td>
            <td colspan="4">address</td>
        </tr>
        <tr>
            <td colspan="6">Информация про процедуру</td>
        </tr>
        <tr>
            <td colspan="2">Окончание приёма предложений</td>
            <td colspan="4">end_date</td>
        </tr>
        <tr>
            <td colspan="6">Предмет торгов</td>
        </tr>
        <tr>
            <td colspan="2">Предмет торгов</td>
            <td colspan="4">tender_name</td>
        </tr>
        <tr>
            <td colspan="2">Категория</td>
            <td colspan="4">category_name</td>
        </tr>
        <tr>
            <td colspan="2">Статус торгов</td>
            <td colspan="4">status</td>
        </tr>
        <tr>
            <td colspan="6">Контактное лицо</td>
        </tr>
        <tr>
            <td colspan="2">Ф.И.О.</td>
            <td colspan="4">contact_name</td>
        </tr>
        <tr>
            <td colspan="2">Телефон</td>
            <td colspan="4">contact_phone</td>
        </tr>
        <tr>
            <td colspan="6">

                <form method="post" action="/tenders/view/<?=$item['id']?>">
                    <button type="submit" class="btn btn-primary btn-lg active" value="<?=$item['id']?>">Подать предложение</button>
                    <input type="checkbox" id="update" name="update" checked="checked" value="on"/><label for="update">Изменить свое предыдущее предложение</label>
                </form>

            </td>
        </tr>

        </tbody>


    </table>

