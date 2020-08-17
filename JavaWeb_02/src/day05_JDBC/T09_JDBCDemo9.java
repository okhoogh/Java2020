package day05_JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T09_JDBCDemo9 {

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    
    public static boolean login(String username, String password) {
//        System.out.println(password);
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            statement = conn.createStatement();
            String sql = "select * from user where username = '" + username + "' and password = '" + password + "' ";
            resultSet = statement.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, statement, resultSet);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String u, p;
        System.out.println("请输入用户名和密码:");
        while (sc.hasNext()) {
            u = sc.nextLine();
            if(u.equals("exit")) {
                System.out.println("退出成功！！！");
                break;
            }
            p = sc.nextLine();
            if (login(u, p)) {
                System.out.println("登录成功！！！");
            } else {
                System.out.println("登录失败！！！");
            }
        }
    }
}
