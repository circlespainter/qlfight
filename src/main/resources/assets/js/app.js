var module = angular.module('QlFightApp', [
  'QlFightApp.controllers',
  'QlFightApp.services',
  'ngRoute',
]);

module.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when("/", {templateUrl: "partials/test.html", controller: "serversController"}).
    when("/server", {templateUrl: "partials/test.html", controller: "serverController"}).
    when("/matches", {templateUrl: "partials/test.html", controller: "matchesController"}).
    when("/match", {templateUrl: "partials/test.html", controller: "matchController"}).
    otherwise({redirectTo: '/'});
}]);
