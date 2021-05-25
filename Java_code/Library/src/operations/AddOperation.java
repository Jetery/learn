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
public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("添加的书名是：");
        String name = scanner.nextLine();
        System.out.println("书的作者是：");
        String author = scanner.nextLine();
        System.out.println("书的类型是：");
        String type = scanner.nextLine();
        System.out.println("书的价格是：");
        int price = scanner.nextInt();
        int cur = bookList.getSize();
        for (int i = 0; i < cur; i++) {
            Book book = bookList.getBooks(i);
            if(name.equals(book.getName())){
                System.out.println("此书已存在，不可以重复添加！！！");
                return;
            }
        }
        bookList.setBooks(cur++,new Book(name,author,type,price));
        bookList.setSize(cur);
        System.out.println("添加成功");
    }
}
