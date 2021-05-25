package Book;

/**
 * Created with IntelliJ IDEA
 * Description:
 * user.User: Jetery
 * Date: 2021.05.25
 */
public class BookList {

    private Book[] books = new Book[10];
    private int size;

    public BookList() {
        books[0] = new Book("西游记","吴承恩","小说",100);
        books[1] = new Book("三国演义","罗贯中","小说",66);
        books[2] = new Book("水浒传","施耐庵","小说",77);

        this.size = 3;
    }

    public Book getBooks(int pos) {
        return this.books[pos];
    }

    public void setBooks(int pos,Book book) {
        this.books[pos] = book;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
