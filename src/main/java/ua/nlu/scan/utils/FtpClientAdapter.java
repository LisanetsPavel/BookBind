package ua.nlu.scan.utils;

import ua.nlu.scan.exception.FtpException;
import it.sauronsoftware.ftp4j.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pc8 on 05.11.15.
 */
@Service
public class FtpClientAdapter {
    public FtpClientAdapter() {
    }

    private String login;
    private String password;
    private String localpath;
    private FTPClient ftpClient = new FTPClient();
    private static final Logger logger = Logger.getLogger(FtpClientAdapter.class);


    public FtpClientAdapter(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * This method connects to the FTP server
     *
     * @param host
     * @throws FTPException
     * @throws IOException
     * @throws FTPIllegalReplyException
     */
    public void connect(String host) throws FTPException, IOException, FTPIllegalReplyException {
        try {

            this.ftpClient.connect(host);
            this.ftpClient.login(login, password);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This method disconnect to he FTP server
     *
     * @throws FTPException
     * @throws IOException
     * @throws FTPIllegalReplyException
     */
    public void disconnect() throws FTPException, IOException, FTPIllegalReplyException {
        if (ftpClient != null) {
            ftpClient.disconnect(true);
        }

    }

    /**
     * This method downloads specific file
     *
     * @param file
     * @throws FTPException
     * @throws IOException
     * @throws FTPIllegalReplyException
     * @throws FTPAbortedException
     * @throws FTPDataTransferException
     * @throws FTPListParseException
     */
    public void download(String file) throws FTPException, IOException, FTPIllegalReplyException, FTPAbortedException, FTPDataTransferException, FTPListParseException {
        if (ftpClient != null) {
            this.ftpClient.download(file, new File(localpath + "/" + file));
        }
    }

    /**
     * This method changes current directory in FTP server
     *
     * @param dir
     * @throws FTPException
     * @throws IOException
     * @throws FTPIllegalReplyException
     */
    public void changeDirectory(String dir) throws FTPException, IOException, FTPIllegalReplyException {
        try {
            if (ftpClient != null) {
                ftpClient.changeDirectory(dir);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new FtpException(e);
        }
    }

    /**
     * This method sets path to the work directory in local computer
     *
     * @param localpath
     */
    public void setLocalpath(String localpath) {
        this.localpath = localpath;
    }

    /**
     * This method change directory up in the FTP server
     *
     * @throws FTPException
     * @throws IOException
     * @throws FTPIllegalReplyException
     */
    public void changeDirectoryUp() throws FTPException, IOException, FTPIllegalReplyException {

        this.ftpClient.changeDirectoryUp();

    }

    /**
     * This method returns list names of current directory
     *
     * @return
     * @throws FTPException
     * @throws IOException
     * @throws FTPDataTransferException
     * @throws FTPListParseException
     * @throws FTPIllegalReplyException
     * @throws FTPAbortedException
     */
    public List<String> listNames() throws FTPException, IOException, FTPDataTransferException, FTPListParseException, FTPIllegalReplyException, FTPAbortedException {
        return Arrays.asList(this.ftpClient.listNames());
    }

}