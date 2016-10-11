/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('adminModule', [])
        .controller('userController', function ($scope, $http) {
            $http({
                method: "POST",
                url: "http://localhost:8080/search/user"
            }).then(function mySucces(response) {
                $scope.msg = response.data.message.message;
                $scope.msgType = response.data.message.type;
                $scope.result = response.data.result;
                
                $scope.title = "Users";
            }, function myError(response) {
                $scope.msg = response.statusText;
                $scope.msgType = -1;
            });
        });
