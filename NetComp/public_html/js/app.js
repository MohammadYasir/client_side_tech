'use strict';
angular.module('app', [ 'ngAnimate', 'ngRoute', 'googlechart']);
angular.module('app').controller('BaseController', ['$scope', '$location', '$http',
    function ($scope, $location, $http) {

    }
]);
angular.module('app').config(function ($routeProvider, $sceDelegateProvider) {
    //$routeProvider.when('/blank', {templateUrl: 'partials/main/blank.html'});
    $routeProvider.when('/home', {templateUrl: 'partials/home.html', controller: 'HomePageController'});
    $routeProvider.when('/home1', {templateUrl: 'partials/home1.html', controller: 'HomePageController'});
    //$routeProvider.when('/about', {templateUrl: 'partials/main/aboutpage.html', controller: 'AboutPageController'});
    //$routeProvider.when('/subs', {templateUrl: 'partials/main/subscriptionexpire.html'});
    //$routeProvider.when('/faqs', {templateUrl: 'partials/main/faqs.html', controller: 'FaqsPageController'});
    //$routeProvider.when('/qlist', {templateUrl: 'partials/main/questionlist.html', controller: 'QuestionListController'});
    //$routeProvider.when('/qdisplay', {templateUrl: 'partials/main/question.html', controller: 'QuestionListController'});
    //$routeProvider.when('/analyse', {templateUrl: 'partials/main/analyse.html', controller: 'AnalyseController'});
    //$routeProvider.when('/user', {templateUrl: 'partials/main/accinfo.html', controller: 'UserInfoController'});
    //$routeProvider.otherwise({redirectTo: '/home1'});
    $sceDelegateProvider.resourceUrlWhitelist([
        // Allow same origin resource loads.
        'self',
        // Allow loading from our assets domain.  Notice the difference between * and **.
        'http://localhost:8080/**']);
});