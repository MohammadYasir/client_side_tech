angular.module('app').controller('HomePageController', ['$scope', '$location', 
    function ($scope, $location) {
        
        $scope.toggleMenu = function () {
            
        };
        $scope.showAccount = function () {
            $location.path('/user');
        };
        $scope.showAbout = function () {
            $location.path('/about');
        };
        $scope.showFaqs = function () {
            $location.path('/faqs');
        };
        $scope.openEmail = function () {
            console.log("To be implememnted");
        };
        $scope.rateUsNow = function () {
            console.log("To be implememnted");
        };
        $scope.logout = function () {
            console.log("To be implememnted");
        };
    }
]);