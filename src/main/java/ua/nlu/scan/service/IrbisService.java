package ua.nlu.scan.service;

import ua.nlu.scan.dao.IrbisDao;
import ua.nlu.scan.entity.BookIrbisHtml;
import ua.nlu.scan.exception.IrbisException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by pc8 on 20.11.15.
 */
@Service
public class IrbisService {

    public IrbisService() {
    }

    @Autowired
    private IrbisDao irbisDao;
    private static final Logger logger = Logger.getLogger(IrbisService.class);

    /**
     * Method removes needless data from answer
     *
     * @return
     */
    public String filterAnswer(String answer) {


        if (answer.contains("IRBIS_BINARY_DATA")) {
            int index = answer.indexOf("IRBIS_BINARY_DATA");
            answer = answer.substring(0, index);
        }
        return answer;
    }

    /**
     * This method removes needless data from list of answer
     *
     * @param answerList
     * @return
     */
    public List<String> filterListAnswer(List<String> answerList) {
        List<String> resultList = new ArrayList<>();
        for (String str : answerList) {
            if (str.contains("IRBIS_BINARY_DATA")) {
                break;
            }
            resultList.add(str);
        }
        return resultList;
    }


    /**
     * method returns search result
     *
     * @param searchExpr
     * @return
     * @throws UnsupportedEncodingException
     */
    public List<BookIrbisHtml> getSearchResBookHtml(String searchExpr) {

        String expr = null;
        try {
            expr = exprEncoding(searchExpr);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
            throw new IrbisException(e);
        }

        List<BookIrbisHtml> bookIrbisHtmlList = irbisDao.find(expr);
        return bookIrbisHtmlList;
    }

    private String exprEncoding(String expr) throws UnsupportedEncodingException {
        byte text[] = expr.getBytes();
        String result = new String(text, "windows-1251");
        return result;
    }

}
