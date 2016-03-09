/**
 * Created by pc8 on 09.12.15.
 */
app.controller('irbisCtrl', ['$scope', '$http', '$sce', 'bindService', 'irbisService', '$rootScope', function ($scope, $http, $sce, bindService, irbisService, $rootScope) {

    $scope.proccesing = false;
    $scope.arrIrbis;
    $scope.indexIrbis = 0;

    var callbackIrbis = function (data) {
        $scope.arrIrbis = data;
        for (var i = 0; i < $scope.arrIrbis.length; i++) {
            $scope.arrIrbis[i].html = $sce.trustAsHtml($scope.arrIrbis[i].html);
        }
        $scope.proccesing = false;
    }

    $scope.cleanIrbisData = function () {
        $scope.arrIrbis = [];
        $scope.indexIrbis = 0;
        $scope.keyword = '';
    }

    $rootScope.$on('nextBook', function () {
        $scope.cleanIrbisData()
    });

    $scope.search = function () {

        $scope.getIrbisDesc();
        $scope.indexIrbis = 0;

    };

    $scope.getIrbisDesc = function () {
        $scope.proccesing = true;
        irbisService.getDesc($scope.keyword, callbackIrbis);
    };

    $scope.bind = function () {
        if ((typeof $scope.arrIrbis !== 'undefined') && ($scope.arrIrbis.length !== 0) && (typeof $scope.arrIrbis[$scope.indexIrbis].mfn !== 'undefined')) {
            bindService.bind($scope.book.bookId, $scope.arrIrbis[$scope.indexIrbis].mfn);
            $scope.cleanIrbisData();
            $rootScope.$broadcast('binded');
        } else {
            alert("Найдите книгу которую нужно связать");
        }
    }

    $scope.noBook = function () {
        bindService.noBook($scope.book.bookId);
        $scope.cleanIrbisData();
        $rootScope.$broadcast('binded');
    }

    $scope.nextIrbis = function () {
        $scope.indexIrbis = ($scope.indexIrbis < $scope.arrIrbis.length - 1) ? ++$scope.indexIrbis : 0;
    }

    $scope.prevIrbis = function () {
        $scope.indexIrbis = ($scope.indexIrbis > 0) ? --$scope.indexIrbis : $scope.arrIrbis.length - 1;
    }
}]);