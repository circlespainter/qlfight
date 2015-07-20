var module = angular.module('QlFightApp', [
  'DashboardApp.controllers',
  'DashboardApp.services',
  'ngRoute',
]);

module.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when("/", {templateUrl: "partials/tourneys.html", controller: "tourneysController"}).
    otherwise({redirectTo: '/'});
}]);
