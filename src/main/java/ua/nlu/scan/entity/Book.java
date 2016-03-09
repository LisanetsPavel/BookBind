package ua.nlu.scan.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by pc8 on 03.11.15.
 */

@Entity
@Table(name = "books")
public class Book {

    private int bookId;
    private String ename;
    private String year;
    private String pubPlace;
    private String author;
    private int pageCount;
    private String partName;
    private String keyWords;
    private String indexBbk;
    private Integer mfn;
    private String pubOffice;
    private String bibDesc;

    @Id
    @Column(name = "book_id")
    @JsonProperty("bookId")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Column(name = "ename")
    @JsonProperty("name")
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Column(name = "eyear")
    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Column(name = "pub_place")
    public String getPubPlace() {
        return pubPlace;
    }

    public void setPubPlace(String pubPlace) {
        this.pubPlace = pubPlace;
    }

    @Column(name = "author")
    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "page_count")
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Column(name = "irbis_mfn")
    public Integer getMfn() {
        return mfn;
    }

    public void setMfn(Integer mfn) {
        this.mfn = mfn;
    }

    @Column(name = "part_name")
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Column(name = "key_words")
    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    @Column(name = "index_bbk")
    public String getIndexBbk() {
        return indexBbk;
    }

    public void setIndexBbk(String indexBbk) {
        this.indexBbk = indexBbk;
    }

    @Column(name = "pub_office")
    public String getPubOffice() {
        return pubOffice;
    }

    public void setPubOffice(String pubOffice) {
        this.pubOffice = pubOffice;
    }

    @Column(name = "bib_desc")
    public String getBibDesc() {
        return bibDesc;
    }

    public void setBibDesc(String bibDesc) {
        this.bibDesc = bibDesc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", ename='" + ename + '\'' +
                ", year='" + year + '\'' +
                ", pubPlace='" + pubPlace + '\'' +
                ", author='" + author + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }
}
