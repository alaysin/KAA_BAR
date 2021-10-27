package level.up.kaabar.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMain {
    public static void main(String[] args) {

    //docker-compose up
        //1:07 ResultSet rs = stmt.executeQuery("select * from table");
        //1:17 resultSet close

        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/my_crm", "postgres", "")) {

            System.out.println("connection =" +
                    "" +connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
