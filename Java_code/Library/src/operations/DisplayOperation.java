package operations;

import Book.Book;
import Book.BookList;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.25
 */
public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);
            System.out.println(book);
        }
    }
}
