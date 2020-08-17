package day05_JDBC;

import java.sql.*;

public class T06_JDBCDemo6 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet set = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            statement = conn.createStatement();
            String sql = "select * from account";
            set = statement.executeQuery(sql);
            // 处理结果
            // 1.让游标向下移动一行
            while (set.next()) {
                // 2.获取数据
                int id = set.getInt(1);
                String name = set.getString("name");
                double balance = set.getDouble(3);
                System.out.println(id + "---" + name + "---" + balance);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
