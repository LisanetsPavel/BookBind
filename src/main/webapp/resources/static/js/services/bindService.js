/**
 * Created by pc8 on 09.12.15.
 */

app.service('bindService', function ($http) {

    this.bind = function (bookId, mfn) {

        console.log("bind, bookId =  " + bookId + "and mfn = " + mfn);
        $http.get('http://localhost:8080/bindBook', {

            params: {
                bookId: bookId,
                mfn: mfn
            }
        }).success(function (data) {

        }).error(function (err) {
            return err;
        });

    }

    this.noBook = function (bookId) {
        $http.get('http://localhost:8080/noBook', {
            params: {
                bookId: bookId
            }
        })
            .success(function (data) {

            })
            .error(function (err) {
                return err;
            });
    }

});