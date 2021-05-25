package Book;

/**
 * Created with IntelliJ IDEA
 * Description:
 * user.User: Jetery
 * Date: 2021.05.25
 */
public class Book {

    private String name;
    private String author;
    private String type;
    private int price;
    private boolean isBorrowed;

    public Book(String name, String author, String type, int price) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price + '\'' +
                ((isBorrowed == false) ? ", 未借出 " : ", 已借出 ") +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
