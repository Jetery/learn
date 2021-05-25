package operations;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.25
 */
public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("你要借阅的书籍是：");
        String str = scanner.nextLine();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);
            if (str.equals(book.getName()) && !book.isBorrowed()){
                book.setBorrowed(true);
                System.out.println("借阅成功！");
                return;
            }
        }
        System.out.println("没有你要借阅的书籍或已经被借阅！！！");
    }
}
