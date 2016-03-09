/**
 * Created by pc8 on 10.12.15.
 */
app.service('irbisService', function ($http) {

    this.getDesc = function (keyword, callback) {
        $http.get('http://localhost:8080/search', {params: {searchExpr: keyword}})
            .success(callback)
            .error(function (err) {
                return err;
            });
    }
});
