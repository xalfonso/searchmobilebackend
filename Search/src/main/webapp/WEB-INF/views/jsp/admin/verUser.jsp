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
        <title>Users</title>
    </head>
    <body>
        <%@include file="/WEB-INF/views/jsp/comun/menu.jsp"%>
        <div ng-app="adminModule" ng-controller="userController" class="content">
           <h1>{{title}}</h1>
           <table class="table-condensed table-striped">
                <tr ng-repeat="user in result">
                    <td>{{ user.name + " " + user.surname}}</td>
                    <td>{{ user.username}}</td>
                    <td>{{ user.createDate}}</td>
                </tr>
            </table>
        </div>
    </body>
</html>
