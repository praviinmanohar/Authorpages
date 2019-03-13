package co.swipepages.authorpages;

public class Books {

    public String bookname;
    public int image;

    public Books(String bookname, int image) {
        this.bookname = bookname;
        this.image = image;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
