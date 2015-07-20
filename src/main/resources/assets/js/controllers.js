var module = angular.module('QlFightApp.controllers', []);

module.controller('headerController', function($scope, $location) {
    $scope.location = $location;
});

module.controller('tourneysController', function($scope, apiService) {
    $scope.test = '';
    apiService.tourneys().success(function(response) {
        $scope.test = response;
    });
});

module.controller('matchesController', function($scope, apiService) {
    $scope.test = '';
    apiService.matches("803265").success(function(response) {
        $scope.test = response;
    });
});

module.controller('matchController', function($scope, apiService) {
    $scope.test = '';
    apiService.match().success(function(response) {
        $scope.test = response;
    });
});
