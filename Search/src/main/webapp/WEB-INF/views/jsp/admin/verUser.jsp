<%-- 
    Document   : verUser
    Created on : oct 4, 2016, 2:34:23 p.m.
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file="/WEB-INF/views/jsp/comun/directivas.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <%@include file="/WEB-INF/views/jsp/comun/intoHead.jsp" %>
        <spring:url value="/resources/admin/js/userController.js" var="adminJs"/>
        <script src="${adminJs}"></script>
        <title>Users List</title>
    </head>
    <body>
        <%@include file="/WEB-INF/views/jsp/comun/layersBegin.jspf"%>
        <div ng-app="adminModule" ng-controller="userListController">

            <h1>{{title}}</h1>
            <!--<div ng-show="msgType!==1" class="bg-danger text-danger"> {{msg}} </div>-->
            <div ng-switch="msgType">
                <p ng-switch-when="0" class="bg-danger text-danger"> {{msg}} </p>
                <p ng-switch-when="1" class="bg-warning text-warning"> {{msg}} </p>
            </div>
            <table class="table-condensed table-striped">
                <tr ng-repeat="user in result">
                    <td>{{ user.name + " " + user.surname}}</td>
                    <td>{{ user.username}}</td>
                    <td>{{ user.createDate}}</td>
                </tr>
            </table>
        </div>
        <%@include file="/WEB-INF/views/jsp/comun/layersEnd.jspf" %>
    </body>
</html>
