package ua.nlu.scan.controllers;


import ua.nlu.scan.service.*;
import ua.nlu.scan.utils.Constants;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by pc9 on 01.12.15.
 */


@Controller
public class BindController {
    private static final Logger logger = Logger.getLogger(BindController.class);

    @Autowired
    private BindService bindService;


    /**
     * method imports book info from IRBIS DB to the postgre DB
     * & bind link to page of current book at http://oldlib.nlu.edu.ua/
     *
     * @param bookId
     * @param mfn
     * @param session
     */
    @ResponseBody
    @RequestMapping(value = "/bindBook", method = RequestMethod.POST)
    public void doBind(@RequestParam(value = Constants.BOOK_ID, required = true) Integer bookId,
                       @RequestParam(value = Constants.MFN, required = true) Integer mfn, HttpSession session) {

        bindService.bind(bookId, mfn, session);

        if (logger.isDebugEnabled()) {
            logger.debug("Book bound: post bookId = " + bookId + ", IRBIS mfn = " + mfn);
        }

    }

    /**
     * method delete current book from list
     * (for case when no match found)
     *
     * @param bookId
     * @param session
     */
    @ResponseBody
    @RequestMapping(value = "/noBook", method = RequestMethod.POST)
    public void resetBook(@RequestParam(value = Constants.BOOK_ID, required = true) Integer bookId, HttpSession session) {

        bindService.reset(bookId, session);

        if (logger.isDebugEnabled()) {
            logger.debug("No march found for bookId " + bookId);
        }

    }


}
