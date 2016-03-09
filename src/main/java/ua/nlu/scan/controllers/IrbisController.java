package ua.nlu.scan.controllers;

import ua.nlu.scan.entity.BookIrbisHtml;
import ua.nlu.scan.service.IrbisService;
import ua.nlu.scan.service.JsonService;
import ua.nlu.scan.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by pc9 on 01.12.15.
 */
@Controller
public class IrbisController {


    @Autowired
    private IrbisService irbisService;
    @Autowired
    private JsonService jsonService;


    /**
     * method returns to the view side search results
     *
     * @param searchExpr
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/search", produces = "text/plain;charset=UTF-8")
    public String IrbisSearch(@RequestParam(value = Constants.SEARCH_EXPR, required = true) String searchExpr) {

        List<BookIrbisHtml> bookIrbisHtmlList = irbisService.getSearchResBookHtml(searchExpr);
        String result = jsonService.getJSONIrbisBookHtml(bookIrbisHtmlList);

        return result;
    }

}
