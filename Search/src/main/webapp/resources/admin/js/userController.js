/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var userapp = angular.module('adminModule', []);
userapp.controller('userListController', function ($scope, $http) {
    $http({
        method: "POST",
        url: "http://localhost:8080/search/user"
    }).then(function mySucces(response) {
        $scope.msg = response.data.message.message;
        $scope.msgType = response.data.message.type;
        $scope.result = response.data.result;

        $scope.title = "Users List";
    }, function myError(response) {
        $scope.msg = response.statusText;
        $scope.msgType = -1;
    });
});
userapp.controller('userInsertController', function ($scope, $http) {
    $scope.submit = function () {
        $http({
            method: "POST",
            url: "http://localhost:8080/search/user/insert",
            data: $scope.user 
        }).then(function insertSucces(response) {
            $scope.msg = response.data.message.message;
            $scope.msgType = response.data.message.type;
        }, function insertError(response) {
            $scope.msg = response.statusText;
            $scope.msgType = -1;
        });
    };
});
