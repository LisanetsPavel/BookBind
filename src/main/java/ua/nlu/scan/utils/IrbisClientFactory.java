package ua.nlu.scan.utils;

import ua.nlu.scan.irbis.IrbisClient64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by pc8 on 18.11.15.
 */
@Service
public class IrbisClientFactory {

    public IrbisClientFactory() {
    }

    @Value("${irbis.url}")
    private String URL;
    @Value("${irbis.port}")
    private String PORT;
    @Value("${irbis.username}")
    private String USERNAME;
    @Value("${irbis.password}")
    private String PASSWORD;
    @Value("${irbis.database}")
    private String DATABASE;

    /**
     * Method return instance of IrbisClient using specified configurations
     *
     * @param url
     * @param port
     * @param username
     * @param password
     * @param database
     * @return
     */
    public IrbisClient64 getIrbisClient(String url, Integer port, String username, String password, String database) {
        return new IrbisClient64(url, port, username, password, database);
    }

    /**
     * Method returns instance of IrbisClient using default configurations
     *
     * @return
     */
    public IrbisClient64 getIrbisClient() {
        return new IrbisClient64(URL, Integer.parseInt(PORT), USERNAME, PASSWORD, DATABASE);
    }

}
