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
public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("你要删除的书籍是：");
        String name = scanner.nextLine();
        int cur = bookList.getSize();
        for (int i = 0; i < cur; i++) {
            Book book = bookList.getBooks(i);
            if (name.equals(book.getName())) {

                for ( ;i < --cur; i++) {
                    Book book1 = bookList.getBooks(i +1);
                    bookList.setBooks(i,book1);
                }

                bookList.setSize(cur);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("没有你要删除的书籍！！！");
    }
}
