package ua.nlu.scan.entity;

/**
 * Created by pc8 on 26.11.15.
 */
public class BookIrbisHtml {

    private int mfn;
    private String Html;

    public BookIrbisHtml(int mfn, String html) {
        this.mfn = mfn;
        Html = html;
    }

    public int getMfn() {
        return mfn;
    }

    public void setMfn(int mfn) {
        this.mfn = mfn;
    }

    public String getHtml() {
        return Html;
    }

    public void setHtml(String html) {
        Html = html;
    }

    @Override
    public String toString() {
        return "BookIrbisHtml{" +
                "mfn=" + mfn +
                ", Html='" + Html + '\'' +
                '}';
    }
}
