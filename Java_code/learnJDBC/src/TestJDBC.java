import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.10.07
 */
public class TestJDBC {

    public static void main(String[] args) {
        DataSource dataSource = new MysqlDataSource();
        ///////////////////////
        //  告知程序数据库服务器在哪，通过一个URL来描述服务器的地址
        //noinspection CastCanBeRemovedNarrowingVariableType
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java100?characterEncoding=utf8&useSSL=false");
        //  jdbc:mysql:   协议名，固定
        //  127.0.0.1     数据库的IP地址(本机)
        //  3306          端口号
        //  java100       数据库名字
//characterEncoding=utf8  当前程序按照什么字符集来理解数据库服务器的数据
        //  useSSL        是否对传输的数据进行加密

        //  设置访问数据库的用户名
        //noinspection CastCanBeRemovedNarrowingVariableType
        ((MysqlDataSource) dataSource).setUser("root");

        //  告知访问数据库的密码
        //noinspection CastCanBeRemovedNarrowingVariableType
        ((MysqlDataSource) dataSource).setPassword("1234");

        //////////////
        //  建立连接
        try {
            Connection connection = dataSource.getConnection();

            //////////////
            //  构造 SQL 语句#
            // 静态语句  和编译期相关
            // String sql = "insert into canteen values(null, '三食堂')";

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入ID");
            int id = sc.nextInt();
            System.out.println("请输入name");
            String name = sc.next();

            // 动态语句  和运行时有关
            //  ?  表示占位符
            String sql = "insert into canteen values( ? , ? )";

            PreparedStatement statement = connection.prepareStatement(sql);
            ////////////
            //  替换占位符
            statement.setInt(1,id);
            statement.setString(2, name);



            //////////////
            //  执行 SQL 语句
            //  有两种  execute
            // 1. executeUpdate    use it for insert, delete, update  -> return int
            // 2. executeQuery     use it for select  ->  return  ResultSet
            int ret = statement.executeUpdate();
            System.out.println(ret);


            //////////////
            //  释放相关资源
            statement.close();
            connection.close();
            //  如果不关闭，容易资源泄露


        } catch (SQLException e) {
            e.printStackTrace();
        }





        /*

        [牺牲了移植性]
        MysqlDataSource datasource  = new MysqlDataSource();
        datasource.setUrl();
        datasource.setUser();
        datasource.setPassword();

        */
    }


    //  another way to get connection
    public void test() throws SQLException{
        DataSource dataSource = new MysqlDataSource();
        //noinspection CastCanBeRemovedNarrowingVariableType
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java100?characterEncoding=utf8&useSSL=false");
        //noinspection CastCanBeRemovedNarrowingVariableType
        ((MysqlDataSource)dataSource).setUser("root");
        //noinspection CastCanBeRemovedNarrowingVariableType
        ((MysqlDataSource)dataSource).setPassword("1234");
        Connection connection = dataSource.getConnection();
    }

}
