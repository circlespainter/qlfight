angular.module('DashboardApp.services', []).
factory('apiService', function($http) {
    var api = {};

    api.tourneys = function() {
        return $http.get('http://localhost:7070/api/tourneys');
    }

    return api;
});