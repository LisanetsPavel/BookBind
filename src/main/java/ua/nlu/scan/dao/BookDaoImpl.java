package ua.nlu.scan.dao;

import ua.nlu.scan.entity.Book;
import ua.nlu.scan.entity.BookIrbis;
import ua.nlu.scan.exception.DaoException;
import ua.nlu.scan.utils.CloseableSession;
import ua.nlu.scan.service.HibernateService;


import org.apache.log4j.Logger;

import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc8 on 03.11.15.
 */
@Repository
public class BookDaoImpl extends HibernateDaoSupport implements BookDao {
    private static final Logger logger = Logger.getLogger(BookDaoImpl.class);

    public BookDaoImpl() {
        setSessionFactory(HibernateService.createSessionFactory());
    }

    /**
     * Metod returns Book by id
     *
     * @param id
     * @return
     */
    @Override
    public Book getBookById(int id) {

        Book book = null;
        try (CloseableSession closeableSession = new CloseableSession(HibernateService.createSessionFactory().openSession())) {
            book = (Book) closeableSession.getSession().createCriteria(Book.class).add(Restrictions.eq("bookId", id)).uniqueResult();
        } catch (Exception e) {
            logger.error("could not get book by id", e);
            throw new RuntimeException("could not get book by id", e);
        }
        return book;
    }

    /**
     * Method returns all books without mfn
     *
     * @return
     */
    @Override
    public List<Book> getAllBooks() {

        List<Book> bookList = null;


        try (CloseableSession closeableSession = new CloseableSession(getSessionFactory().openSession())) {
            bookList = closeableSession.getSession().createCriteria(Book.class).add(Restrictions.isNull("mfn")).addOrder(Order.asc("bookId")).list();
        } catch (Exception e) {
            logger.error("could not get book list", e);
            throw new DaoException("could not get book list", e);
        }
        return bookList;
    }

    /**
     * Method changes field mfn of the Book
     *
     * @param bookId
     * @param mfn
     */
    @Override
    public void updateMfn(int bookId, int mfn) {
        Book book;
        Transaction tx = null;
        try (CloseableSession closeableSession = new CloseableSession(HibernateService.createSessionFactory().openSession())) {
            tx = closeableSession.getSession().beginTransaction();
            book = (Book) closeableSession.getSession().load(Book.class, bookId);
            book.setMfn(mfn);
            closeableSession.getSession().update(book);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("could not update mfn", e);
            throw new DaoException("could not update mfn", e);
        }
    }

    /**
     * Method changes field name of the Book
     *
     * @param bookId
     * @param name
     */
    @Override
    public void updateName(int bookId, String name) {
        Book book;
        Transaction tx = null;
        try (CloseableSession closeableSession = new CloseableSession(HibernateService.createSessionFactory().openSession())) {
            tx = closeableSession.getSession().beginTransaction();
            book = (Book) closeableSession.getSession().load(Book.class, bookId);
            book.setEname(name);
            closeableSession.getSession().update(book);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("could not get book's name", e);
            throw new DaoException("could not get book's name", e);
        }
    }

    /**
     * Method writes into book table column from irbis
     *
     * @param bookId
     * @param bookIrbis
     */
    @Override
    public void updateBook(int bookId, BookIrbis bookIrbis) {
        Book book;
        Transaction tx = null;

        try (CloseableSession closeableSession = new CloseableSession(HibernateService.createSessionFactory().openSession())) {
            tx = closeableSession.getSession().beginTransaction();
            book = (Book) closeableSession.getSession().load(Book.class, bookId);
            book.setMfn(bookIrbis.getMfn());
            book.setEname(bookIrbis.getName());
            book.setPartName(bookIrbis.getPartName());
            book.setAuthor(bookIrbis.getAuthors());
            book.setPubPlace(bookIrbis.getPublishinCity());
            book.setPubOffice(bookIrbis.getPublishinOffice());
            book.setYear(bookIrbis.getPublishingYear());
            book.setKeyWords(bookIrbis.getKeyWords());
            book.setBibDesc(bookIrbis.getLibDescription());
            book.setIndexBbk(bookIrbis.getIndexBbk());
            closeableSession.getSession().update(book);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.error("could not update book", e);
            throw new DaoException("could not update book", e);
        }

    }

}
