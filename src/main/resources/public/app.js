
angular
    .module('task', ['ui.router'])
    .config(
        function ($stateProvider, $urlRouterProvider) {

          //  $urlRouterProvider.otherwise('/users');

            $stateProvider
                .state('all', {
                    url: '/all',
                    templateUrl: '/pages/all.html',
                    controller: 'taskController'
                })
                .state('rating', {
                    url: '/rating',
                    templateUrl: '/pages/rating.html',
                    controller: 'taskController'
                })
                .state('movies', {
                    url: '/movies',
                    templateUrl: '/pages/movies.html',
                    controller: 'taskController'
                })
                .state('movieByRate', {
                    url: '/movieByRate',
                    templateUrl: '/pages/movieByRate.html',
                    controller: 'taskController'
                })
                .state('movieWithoutRate', {
                    url: '/movieWithoutRate',
                    templateUrl: '/pages/movieWithoutRate.html',
                    controller: 'taskController'
                })
                .state('allRate', {
                    url: '/allRate',
                    templateUrl: '/pages/allRate.html',
                    controller: 'taskController'
                })
        }
    );