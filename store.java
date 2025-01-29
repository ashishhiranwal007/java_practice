import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class store {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1) Create a connection
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db",
                "java", "Ashish@007");
        // 2) Create statement/query
        Statement stmt = con.createStatement();
        String sql1 = "INSERT INTO Students VALUES(2)";
        // String sql2 = "UPDATE Students SET FirstName='John' where ID = 1";
        // String sql3 = "DELETE from Students where ID=101";
        // 3) Execute statement/query
        stmt.execute(sql1);
        // 4) Close connection
        con.close();
        System.out.println("Data Updated Successfully");
    }
}