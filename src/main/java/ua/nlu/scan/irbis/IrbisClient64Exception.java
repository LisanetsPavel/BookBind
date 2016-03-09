package ua.nlu.scan.irbis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: usr
 * Date: 29.11.2014
 * Time: 6:20:35
 * To change this template use File | Settings | File Templates.
 */
public class IrbisClient64Exception extends Exception {
    /** */
    private static Map<String, String> errorMsgMap = new HashMap<String, String>(20);

    /** */
    public static final String ERROR_ZERO = "0";

    /** */
    public static final String SERVER_EXECUTE_ERROR = "-1111";

    /** */
    public static final String WRONG_PROTOCOL = "-2222";

    /** */
    public static final String CLIENT_NOT_IN_LIST = "-3333";

    /** */
    public static final String CLIENT_NOT_IN_USE = "-3334";

    /** */
    public static final String CLIENT_IDENTIFIER_WRONG = "-3335";

    /** */
    public static final String CLIENT_NOT_ALLOWED = "-3336";

    /** */
    public static final String CLIENT_ALREADY_EXISTS = "-3337";

    /** */
    public static final String WRONG_PASSWORD = "-4444";

    /** */
    public static final String FILE_NOT_EXISTS = "-5555";

    /** */
    public static final String SERVER_OVERLOAD = "-6666";

    /** */
    public static final String PROCESS_ERROR = "-7777";

    /** */
    public static final String READ_WRONG_MFN = "-100";

    /** */
    public static final String REC_DELETE = "-600";

    /** */
    public static final String REC_PHYS_DELETE = "-601";

    /** */
    public static final String ERR_RECLOCKED = "-602";

    /** */
    public static final String REC_DELETE1 = "-603";

    /** */
    public static final String AUTOIN_ERROR = "-607";

    /** */
    public static final String ERR_DBEWLOCK = "-300";

    /** */
    public static final String ERR_FILEMASTER = "-400";

    /** */
    public static final String ERR_FILEINVERT = "-401";

    /** */
    public static final String ERR_WRITE = "-402";

    /** */
    public static final String ERR_ACTUAL = "-403";

    /** */
    public static final String TERM_NOT_EXISTS = "-202";

    /** */
    public static final String TERM_LAST_IN_LIST = "-203";

    /** */
    public static final String TERM_FIRST_IN_LIST = "-204";

    /** */
    public static final String OTHER_ERROR = "111111";

    static {
        errorMsgMap.put("0", "Нормальное завершение");
        errorMsgMap.put("-1111", "SERVER_EXECUTE_ERROR");
        errorMsgMap.put("-2222", "WRONG_PROTOCOL");
        errorMsgMap.put("-3333", "незарегистрированный клиент");
        errorMsgMap.put("-3334", "незарегистрированный клиент не сделал irbis-reg");
        errorMsgMap.put("-3335", "неправильный уникальный идентификатор");
        errorMsgMap.put("-3336", "нет доступа к командам АРМа");
        errorMsgMap.put("-3337", "клиент уже зарегистрирован");
        errorMsgMap.put("-4444", "неверный пароль");
        errorMsgMap.put("-5555", "Файл не существует");
        errorMsgMap.put("-6666", "сервер перегружен достигнуто максимальное число потоков обработки");
        errorMsgMap.put("-7777", "не удалось запустить/прервать поток администратора");
        errorMsgMap.put("-100", "-1 - заданный MFN вне пределов БД");
        errorMsgMap.put("-602", "запись заблокирована на ввод");
        errorMsgMap.put("-607", "ошибка autoin.gbl");
        errorMsgMap.put("-300", "монопольная блокировка БД");
        errorMsgMap.put("-400", "ошибка при открытии файла mst или xrf");
        errorMsgMap.put("-401", "ошибка при открытии trm файлов");
        errorMsgMap.put("-402", "ошибка при записи");
        errorMsgMap.put("-403", "ошибка при актуализации");
        errorMsgMap.put("-202", "Термин не существует");
        errorMsgMap.put("-203", "Последний термин в списке");
        errorMsgMap.put("-204", "Первый термин в списке");
    } // static    

    /** */
    private String errorCode = ERROR_ZERO;

    /** */
    private String errorMessage = null;

    /**
     * @param errorCode
     */
    public IrbisClient64Exception(String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMsgMap.get(errorCode);
    }

    public IrbisClient64Exception(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     *
     * @param cause
     * @param errorCode
     * @param errorMessage
     */
    public IrbisClient64Exception(Throwable cause, String errorCode, String errorMessage) {
        super(cause);
        this.errorMessage = cause.getMessage();
        this.errorCode = OTHER_ERROR;
    }

    /**
     *
     * @param cause
     */
    public IrbisClient64Exception(Throwable cause) {
        super(cause);
        errorMessage = cause.getMessage();
        errorCode = OTHER_ERROR;
    }

    /**
     * @return
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @return
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String getMessage() {
        if (OTHER_ERROR.equals(errorCode)) {
            Throwable cause = this.getCause();

            if (cause != null) {
                return cause.getMessage();
            }
            else {
                return errorCode;
            } // if
        } // if

        return errorMsgMap.get(errorCode);
    } // getMessage

    /**
     *
     * @param code
     * @throws IrbisClient64Exception
     */
    public static void checkReturnCode(String code) throws IrbisClient64Exception {
        if (ERROR_ZERO.equals(code)) {
            return;
        }

        String msg = errorMsgMap.get(code);

        if (msg != null) {
            throw new IrbisClient64Exception(code, msg);
        }
    } // checkReturnCode
} // IrbisClient64Exception
