package ua.nlu.scan.service;

import ua.nlu.scan.dao.BookDaoImpl;
import ua.nlu.scan.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc8 on 27.11.15.
 */
@Service
public class BookService {

    public BookService() {
    }

    @Autowired
    BookDaoImpl bookDao;

    /**
     * This method returns Book by id
     *
     * @param id
     * @return
     */
    public Book getBook(int id) {

        return bookDao.getBookById(id);

    }

    /**
     * This method returns all the books that need to be processed
     *
     * @return
     */
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
