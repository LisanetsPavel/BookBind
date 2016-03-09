package ua.nlu.scan;

import ua.nlu.scan.dao.BookDaoImpl;
import ua.nlu.scan.entity.Book;

import java.util.List;

/**
 * Created by pc8 on 03.11.15.
 */
public class HibernateSpringExample {

    public static void main(String[] args) {

 //       List<Book> list = new BookDaoImpl().getAllBooks();

      //  Book book = new BookDaoImpl().updateMfn();
        BookDaoImpl bookDao = new BookDaoImpl();
//        BookIrbis bookIrbis = new BookIrbis();
//        bookIrbis.setName("TestBookOne");
//        bookIrbis.setPublishingYear("2016");
//        bookIrbis.setPublishinCity("KharkivTest");
//        bookIrbis.setPublishinOffice("OfficeTest");
//        bookIrbis.setKeyWords("KeyWordTest");
//        bookIrbis.setIndexBbk("randomIndex");
//        bookIrbis.setPartName("Someone name");
//        bookIrbis.setAuthors("TestAuthor");
//        bookIrbis.setMfn(1207);
//        bookIrbis.setLibDescription("BiblDestForTest");
//        bookDao.updateBook(9219,bookIrbis);

    List<Book> list = bookDao.getAllBooks();
        for (Book book : list){
            System.out.println(book);
        }
   //     bookDao.updateName(9219, "TEST_BOOK");
     //   System.out.println(book);
//        for(Book book : list){
//            System.out.println(book);
//        }

    }



}
