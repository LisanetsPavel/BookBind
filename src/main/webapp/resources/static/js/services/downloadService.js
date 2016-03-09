/**
 * Created by pc8 on 27.11.15.
 */

app.service('downloadService', function ($http) {

    this.download = function (bookIndex) {

        $http.get('http://localhost:8080/download', {params: {bookIndex: bookIndex}})
            .success(function (data) {
            })
            .error(function (err) {
                return err;
            });
    }

});