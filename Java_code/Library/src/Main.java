import Book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * user.User: Jetery
 * Date: 2021.05.25
 */
public class Main {
    public static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        System.out.println("身份是：1 -> 管理员   0 -> 普通用户");
        int choice = scanner.nextInt();
        while (true){
            if (1 == choice){
                return new AdminUser(name);
            } else if (0 == choice){
                return new NormalUser(name);
            } else {
                System.out.println("错误输入！请重新输入");
            }
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while (true) {
            int choice = user.menu();
            user.doOperations(choice,bookList);
        }
    }
}
