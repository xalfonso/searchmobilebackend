<%-- 
    Document   : insertUser
    Created on : 11-oct-2016, 20:45:57
    Author     : ley
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
        <title>Insert User</title>
    </head>
    <body>
        <%@include file="/WEB-INF/views/jsp/comun/layersBegin.jspf"%>
        <div ng-app="adminModule" ng-controller="userInsertController">
            <h3>Insertar usuario</h3>
            <div ng-switch="msgType">
                <p ng-switch-when="0" class="bg-danger text-danger"> {{msg}} </p>
                <p ng-switch-when="1" class="bg-warning text-warning"> {{msg}} </p>
                <p ng-switch-when="2" class="bg-info text-info"> {{msg}} </p>
            </div>
            <form class="form-horizontal" name='insertUserForm' novalidate ng-submit="submit()">
                <div class="form-group">
                    <label class="col-sm-1 control-label">Name</label>
                    <div class="col-sm-5">
                        <input type=text class="form-control" name="name" id="nameId" ng-model="user.name" ng-pattern="/^[A-Za-záéíóúñ']{1,}([\s][A-Za-záéíóúñ']{1,})*$/" required >
                    </div>
                    <div>
                        <span ng-show="insertUserForm.name.$touched && insertUserForm.name.$error.required" class="text-danger">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            The name is required.
                        </span>
                        <span ng-show="insertUserForm.name.$touched && insertUserForm.name.$error.pattern" class="text-danger">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                            Only letters.
                        </span>
                    </div>
                </div>
                <div class="form-group">    
                    <label class="col-sm-1 control-label">Surname</label>
                    <div class="col-sm-5">
                        <input type=text class="form-control" id="surnameId" ng-model="user.surname" name="surname" required ng-pattern="/^[A-Za-záéíóúñ']{1,}([\s][A-Za-záéíóúñ']{1,})+$/">
                    </div>
                    <div>
                        <span ng-show="insertUserForm.surname.$touched && insertUserForm.surname.$error.required" class="text-danger">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            The surname is required.
                        </span>
                        <span ng-show="insertUserForm.name.$touched && insertUserForm.surname.$error.pattern" class="text-danger">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                            Only letters.
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label">Username</label>
                    <div class="col-sm-5">
                        <input type=text class="form-control" id="usernameId" ng-model="user.username" name="username" required ng-pattern="/^[a-z0-9_-]{3,15}$/">
                    </div>
                    <div>
                        <span ng-show="insertUserForm.username.$touched && insertUserForm.username.$error.required" class="text-danger">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            The username is required.
                        </span>
                        <span ng-show="insertUserForm.username.$touched && insertUserForm.username.$error.pattern" class="text-danger">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                            Invalid username.
                        </span>
                    </div>
                </div>
                <div class="form-group">    
                    <label class="col-sm-1 control-label">Password</label>
                    <div class="col-sm-5">
                        <input type=password class="form-control" id="passId" ng-model="user.password" name="pass" ng-minlength="7" required>
                    </div>
                    <div>
                        <span ng-show="insertUserForm.pass.$touched && insertUserForm.pass.$error.required" class="text-danger">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            The password is required.
                        </span>
                        <span ng-show="insertUserForm.pass.$error.minlength" class="text-danger">
                            <span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
                            The password may have more than 7 characters.
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10">
                        <button type="submit" id="bth-insert"
                                class="btn btn-primary btn-sm">Insertar</button>
                    </div>
                </div>    
            </form>
        </div>
        <%@include file="/WEB-INF/views/jsp/comun/layersEnd.jspf" %>
    </body>
</html>
