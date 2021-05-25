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
public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("你要查找的书籍是：");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);
            if(name.equals(book.getName())){
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有你要查找的书籍！！！");
    }
}
