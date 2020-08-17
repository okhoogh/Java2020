package day05_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class T11_JDBCDemo11 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pre1 = null;
        PreparedStatement pre2 = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql1 = "update account set balance = balance - ? where NAME = ?";
            pre1 = conn.prepareStatement(sql1);
            double money = 50;
            pre1.setDouble(1, money);
            pre1.setString(2, "张三");
            String sql2 = "update account set balance = balance + ? where NAME = ?";
            pre2 = conn.prepareStatement(sql2);
            pre2.setDouble(1, money);
            pre2.setString(2, "李四");
            pre1.executeUpdate();
            int i = 1 / 0;
            pre2.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                if(conn != null)
                    conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, pre1);
            JDBCUtils.close(conn, pre2);
        }
    }
}
