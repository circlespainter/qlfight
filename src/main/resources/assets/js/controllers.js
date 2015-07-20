var module = angular.module('DashboardApp.controllers', []);

module.controller('tourneysController', function($scope, apiService) {
    $scope.test = '';
    apiService.tourneys().success(function(response) {
        $scope.test = response;
    });
});
