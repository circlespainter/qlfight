var module = angular.module('QlFightApp.services', []);

module.factory('apiService', function($http) {
    var api = {};

    api.servers = function() {
        return $http.get('http://localhost:7070/api/servers');
    }

    api.server = function(id) {
        return $http.get('http://localhost:7070/api/server/' + id);
    }

    api.matches = function(id) {
        return $http.get('http://localhost:7070/api/matches/' + id);
    }

    api.match = function(id) {
        return $http.get('http://localhost:7070/api/match');
    }

    api.tourney = function() {
        return $http.get('http://localhost:7070/api/tourney');
    }

    return api;
});