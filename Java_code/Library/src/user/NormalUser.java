package user;

import operations.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * user.User: Jetery
 * Date: 2021.05.25
 */
public class NormalUser extends User {

    public NormalUser(String name) {
        super(name);
        this.iOperations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
        };
    }

    @Override
    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==================普通用户菜单==================");
        System.out.println("hello " + this.name + "!");
        System.out.println("1.查找书籍");
        System.out.println("2.借阅书籍");
        System.out.println("3.归还书籍");
        System.out.println("0.退出系统");
        System.out.println("你的选择是：");
        while (true){
            int choice = scanner.nextInt();
            if (choice >= 0 && choice <= 3){
                return choice;
            } else {
                System.out.println("输入错误！重新输入");
            }
        }
    }
}
