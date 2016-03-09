package ua.nlu.scan.irbis;

/**
 * Created by pc8 on 29.10.15.
 */
public class SearchTest {
    public static void main(String... args) {
        IrbisClient64 irbisClient64 = new IrbisClient64(); ;

        try {

            irbisClient64.connect();


          //  List<Integer> searchRes = irbisClient64.search("A=12$");

          //  System.out.println(searchRes);

            //System.err.println(irbisClient64.readFormatedRecord(1, "@IBISW"));

            irbisClient64.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            irbisClient64.disconnect();
        }
    }
}