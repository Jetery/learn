import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.10.11
 */
public class TestJDBC2 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java100?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");
        Connection con = dataSource.getConnection();

        String sql = "select canteenId from canteen where canteenName = '三食堂'";
        PreparedStatement statement  = con.prepareStatement(sql);

        ResultSet result = statement.executeQuery();


        while (result.next()){
            int id = result.getInt("canteenId");
//            String name = result.getString("canteenName");
//            System.out.println(id + "\t" + name);

            System.out.println(id);
        }


        result.close();
        statement.close();
        con.close();
    }
}
