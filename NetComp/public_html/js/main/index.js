'use-strict';
angular.module("app",['ngRoute']);
angular.module("app").
        config(function ($routeProvider, $sceDelegateProvider) {
            $routeProvider.when('/home', {templateUrl: 'partials/home.html', controller: 'HomeCtrl'});
            $routeProvider.when('/analyse', {templateUrl: 'partials/analyse.html', controller: 'AnalyseCtrl'});
            $routeProvider.otherwise({redirectTo: '/home'});
            $sceDelegateProvider.resourceUrlWhitelist([
                // Allow same origin resource loads.
                'self',
                // Allow loading from our assets domain.  Notice the difference between * and **.
                'http://localhost:8080/ServerStubFinal/**']);
        }); 
        
angular.module("app").controller("HomeCtrl",["$scope", 
    function($scope){
        
    }
]);

angular.module("app").controller("AnalyseCtrl",["$scope", 
    function($scope){
        
    }
]);

angular.module("app").controller("navCtrl",["$scope", "$location",
    function($scope, $loc){
        $scope.loadAnalyse = function(){
            $loc.path("/analyse");
        };
        $scope.loadHome = function(){
            $loc.path("/home");
        };
    }
]);

angular.module("app").controller("footerCtrl",["$scope", 
    function($scope){
        
    }
]);