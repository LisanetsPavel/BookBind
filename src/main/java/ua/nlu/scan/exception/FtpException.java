package ua.nlu.scan.exception;

/**
 * Created by pc8 on 03.03.16.
 */
public class FtpException extends RuntimeException {

    public FtpException() {
    }

    public FtpException(String s) {
        super(s);
    }

    public FtpException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public FtpException(Throwable throwable) {
        super(throwable);
    }

    public FtpException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
