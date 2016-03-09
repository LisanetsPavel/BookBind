/**
 * Created by pc8 on 10.12.15.
 */
app.filter('trust', [
    '$sce',
    function ($sce) {
        return function (value, type) {
            // Defaults to treating trusted text as `html`
            return $sce.trustAs(type || 'html', text);
        }
    }
]);