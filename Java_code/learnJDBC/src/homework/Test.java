package homework;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.10.11
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/ebook?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");

        Connection connection = dataSource.getConnection();


        //search(connection);
        //request2(connection);
        //request3(connection);
        request4(connection);

        connection.close();
    }

    private static void request4(Connection connection) throws SQLException {
        // TODO  删除id最大的一条借阅记录
        String sql = "delete from borrow_info where id = ?";

        // TODO get the max ID
        int id = 0;
        String getID = "select id from borrow_info";
        PreparedStatement statement = connection.prepareStatement(getID);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            id = Math.max(id, resultSet.getInt("id"));
        }
        resultSet.close();

        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        int ret = statement.executeUpdate();
        System.out.println(ret);

        statement.close();

    }

    private static void request3(Connection connection) throws SQLException {
        // TODO 修改图书《深入理解Java虚拟机》的价格为 61.20
        String sql = "update book set price = ? where name = ?";
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要修改的图书");
        String name = sc.nextLine();
        System.out.println("输入该图书的价格");
        float price = sc.nextFloat();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setFloat(1, price);
        statement.setString(2, name);
        int ret = statement.executeUpdate();
        System.out.println(ret);
        statement.close();
    }

    private static void request2(Connection connection) throws SQLException{
        // TODO  查询计算机分类下的图书借阅信息

        // TODO first get the aimed ID
        String findCategory = "select id from category where name = '计算机'";
        int categoryId = 0;
        try (PreparedStatement helper = connection.prepareStatement(findCategory);
             ResultSet result = helper.executeQuery()) {
            while (result.next()) {
                categoryId = result.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "select * from borrow_info where book_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, categoryId);
        ResultSet result = statement.executeQuery();
        while(result.next()){
            int id = result.getInt("id");
            int book_id = result.getInt("book_id");
            int student_id = result.getInt("student_id");
            String start_time = result.getString("start_time");
            String end_time = result.getString("end_time");
            System.out.println(id + "\t" + book_id + "\t" + student_id + "\t" + start_time + "\t" +end_time);
        }
        result.close();
        statement.close();
    }


    private static void search(Connection connection) throws SQLException {

        //        | id | book_id | student_id | start_time          | end_time            |
        //        +----+---------+------------+---------------------+---------------------+

        // TODO   新增  貂蝉  同学的借阅记录：  诗经  从2019年9月25日17:50到2019年10月25日17:50
        String sql = "insert into borrow_info values(null, ?, ?, ?, ?)";


        PreparedStatement statement = connection.prepareStatement(sql);
        
        String findStudentId = "select id from student where name = '貂蝉'";
        int student_id = 0;
        PreparedStatement helper = connection.prepareStatement(findStudentId);
        ResultSet result = helper.executeQuery();
        while (result.next()){
            student_id = result.getInt("id");
        }
        String findBookId = "select id from book where name = '诗经'";
        int bookId = 0;
        helper = connection.prepareStatement(findBookId);
        result = helper.executeQuery();
        while (result.next()){
            bookId = result.getInt("id");
            System.out.println(bookId);
        }
        result.close();
        helper.close();


        statement.setInt(1, bookId);
        statement.setInt(2, student_id);
        statement.setString(3, "2019-09-25 17:50");
        statement.setString(4,"2019-10-25 17:50");

        int ret = statement.executeUpdate();
        System.out.println(ret);

        statement.close();
    }
}
