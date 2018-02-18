angular.module("app", ["ngRoute"]);
angular.module("app").controller("rootCtrl", ["$scope", "$http", 
    function ($scope, $http) {
        $scope.obj = {
            year: 2012,
            month: "January"
        };
        $scope.csnetJson = {}
        $http.get("/js/csnet.json")
                .success(function(data){
                    $scope.csnetJson = data;
                    console.log(data);
                }).error(function(err){
                    console.log(err);
                });
        $scope.changeYear = function(val){
            $scope.obj.year = val;
            console.log($scope.obj);
        };
        $scope.changeMonth = function(val){
            $scope.obj.month = val;
            console.log($scope.obj);
        };
        
    }
]);