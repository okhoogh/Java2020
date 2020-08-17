package day05_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class T01_JDBCDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.导入驱动jar包
        // 2.注册驱动 mysql5之后可以不用写
        Class.forName("com.mysql.jdbc.Driver");
        // 3.获取数据库连接对象
//        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
        // 本地可以省略主机名和端口号
        Connection connect = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
        // 4.定义sql语句
        String sql = "update account set balance = 1000";
        // 5.获取执行sql的对象Statement
        Statement statement = connect.createStatement();
        // 6.执行sql语句
        int cnt = statement.executeUpdate(sql);
        // 7.处理结果
        System.out.println(cnt);
        // 8.释放资源
        statement.close();
        connect.close();
    }
}
