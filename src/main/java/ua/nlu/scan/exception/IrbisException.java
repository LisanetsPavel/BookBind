package ua.nlu.scan.exception;

/**
 * Created by pc8 on 09.03.16.
 */
public class IrbisException extends RuntimeException {

    public IrbisException() {
    }

    public IrbisException(String s) {
        super(s);
    }

    public IrbisException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public IrbisException(Throwable throwable) {
        super(throwable);
    }

    public IrbisException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
