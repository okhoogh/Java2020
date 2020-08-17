package day05_JDBC;

import java.sql.*;
import java.util.Scanner;

public class T10_JDBCDemo10 {

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    
    public static boolean login(String username, String password) {
//        System.out.println(password);
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            resultSet = pre.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pre, resultSet);
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
