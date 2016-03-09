/**
 * Created by pc8 on 27.11.15.
 */
/**
 * Created by pc8 on 27.11.15.
 */
app.controller('bookController', ['$scope', '$http', 'bookDesc', 'downloadService', '$rootScope', function ($scope, $http, bookDesc, downloadService, $rootScope) {
    $scope._Index = 0;
    $scope._maxIndex = 0;
    $scope.photos = [];
    $scope.index = {
        value: 0
    };

    var callback = function (data) {
        $scope.book = data;
        $scope.photos = [];
        $scope.addImage();
    };

    $scope.getDesc = function () {
        $scope.photos = [];
        bookDesc.getBookDesc($scope.index.value, $scope._Index, $scope.photos, callback);

    }

    $scope.next = function () {
        $scope.increment();
        $scope.getDesc();
        $scope._Index = 0;
        $scope._maxIndex = 0;
        $scope.photos = [];
        $rootScope.$broadcast('nextBook');

    }

    $scope.increment = function () {
        $scope.index.value++;
    }

    $scope.decrement = function () {
        $scope.index.value--;
        $scope.getDesc();
        $scope._Index = 0;
        $scope._maxIndex = 0;
        $scope.photos = [];
        $rootScope.$broadcast('nextBook');
    }

    $scope.init = function () {
        $scope.getDesc();
    }

    $scope.addImage = function () {
        for (var i = 0; i < 10; i++) {
            $scope.photos.push({
                src: 'http://localhost:8080/static/books/' + $scope.book.bookId + '/'
                + ($scope._Index + 1 + i) + '.jpg'
            });
        }
    }

    // if a current image is the same as requested image
    $scope.isActive = function (index) {
        return $scope._Index === index;
    };
    // show prev image
    $scope.showPrev = function () {
        $scope._Index = ($scope._Index > 0) ? --$scope._Index : $scope.photos.length - 1;
    };
    // show next image
    $scope.showNext = function () {
        $scope._Index = ($scope._Index < $scope.photos.length - 1) ? ++$scope._Index : 0;
        if ($scope._maxIndex < $scope._Index) {
            ++$scope._maxIndex;
        }
        console.log($scope._Index + ' & ' + $scope._maxIndex);

        if ($scope._maxIndex === $scope._Index) {
            if ($scope._Index % 10 === 4) {
                console.log($scope._Index + ' + download call');
                downloadService.download($scope.index.value);
            }
            if ($scope._Index % 10 === 6) {
                console.log($scope._Index + ' + add call');
                $scope.addImage();
            }
        }
    };
    // show a certain image
    $scope.showPhoto = function (index) {
        $scope._Index = index;
    };

    $rootScope.$on('binded', function () {
        $scope.next();
    });

}]);

