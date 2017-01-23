angular
    .module("task")

    .controller("taskController",["$scope", "$http", "$timeout",
        function ($scope, $http, $timeout) {

            $scope.users = [];
            $scope.movies = [];
            $scope.ratings = [];
            $scope.rates = [];
            $scope.getUsers = function () {
                $http.get("/showUsers").then((result) => {
                    $scope.users = result.data;
                })
            };
            $scope.getMovies = function () {
                $http.get("/showMovies").then((result) => {
                    $scope.movies = result.data;
                })
            };
            $scope.getRatings = function () {
                $http.get("/showRatings").then((result) => {
                    $scope.ratings = result.data;
                })
            };
            $scope.getRates = function () {
                $http.get("/showRates").then((result) => {
                    $scope.rates = result.data;
                })
            };
            $scope.changeDates = function () {
                $http.put("/changeDates").then((result) => {
                    $scope.ratings = result.data;
                })
            };
            $scope.insertMovie = function () {
                $timeout(() => {
                    $http.post("/insert?title=" + $scope.title + "&director=" + $scope.director).then((result) => {
                        $scope.movies = result.data;
                    })
                }, 0, false);
            };
            $scope.findMovieByRate =function () {
                $timeout(() => {
                    $http.get("/findByRate?first="+$scope.first+"&second="+$scope.second).then((result) => {
                    $scope.ratings = result.data;
                })
                }, 0, false);
            };
            $scope.findWithoutRate = function () {
                $http.get("/findWithoutRate").then((result) => {
                    $scope.movies = result.data;
                })
            }
            $scope.deleteMovie = function (movie) {
                $timeout(() => {
                    $http.delete("/delete?movie="+movie.id).then((result) => {
                    $scope.movies = result.data;
                })
                }, 0, false);
            }
        }]);
