var module = angular.module('QlFightApp.services', []);

module.factory('apiService', function($http) {
    var api = {};

    api.tourneys = function() {
        return $http.get('http://localhost:7070/api/tourneys');
    }

    api.matches = function(id) {
        return $http.get('http://localhost:7070/api/matches/' + id);
    }

    api.match = function(id) {
        return $http.get('http://localhost:7070/api/match');
    }

    return api;
});