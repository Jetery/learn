package user;

import Book.BookList;
import operations.IOperation;

/**
 * Created with IntelliJ IDEA
 * Description:
 * user.User: Jetery
 * Date: 2021.05.25
 */
abstract public class User {

    protected String name;
    protected IOperation[] iOperations;

    public User(String name) {
        this.name = name;
    }

    abstract public int menu();

    public void doOperations(int choice, BookList bookList){
        iOperations[choice].work(bookList);
    }
}
