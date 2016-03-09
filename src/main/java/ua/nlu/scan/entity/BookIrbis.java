package ua.nlu.scan.entity;

/**
 * Created by pc8 on 19.11.15.
 */

public class BookIrbis {

    private int mfn;
    private String name;
    private String authors;
    private String publishinOffice;
    private String publishinCity;
    private String publishingYear;
    private String keyWords;
    private String libDescription;
    private String formatInfo;
    private String indexBbk;
    private String partName;
    private String countPage;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishinOffice() {
        return publishinOffice;
    }

    public void setPublishinOffice(String publishinOffice) {
        this.publishinOffice = publishinOffice;
    }

    public String getPublishinCity() {
        return publishinCity;
    }

    public void setPublishinCity(String publishinCity) {
        this.publishinCity = publishinCity;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getFormatInfo() {
        return formatInfo;
    }

    public void setFormatInfo(String formatInfo) {
        this.formatInfo = formatInfo;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getLibDescription() {
        return libDescription;
    }

    public void setLibDescription(String libDescription) {
        this.libDescription = libDescription;
    }


    public int getMfn() {
        return mfn;
    }

    public void setMfn(int mfn) {
        this.mfn = mfn;
    }


    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }


    public String getCountPage() {
        return countPage;
    }

    public void setCountPage(String countPage) {
        this.countPage = countPage;
    }


    public String getIndexBbk() {
        return indexBbk;
    }

    public void setIndexBbk(String indexBbk) {
        this.indexBbk = indexBbk;
    }


    @Override
    public String toString() {
        return "BookIrbis{" +
                "name='" + name + '\'' +
                ", authors='" + authors + '\'' +
                ", publishinOffice='" + publishinOffice + '\'' +
                ", publishinCity='" + publishinCity + '\'' +
                ", publishingYear='" + publishingYear + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", libDescription='" + libDescription + '\'' +
                ", formatInfo='" + formatInfo + '\'' +
                '}';
    }
}
