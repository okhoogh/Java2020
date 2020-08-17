package day06_DataSource_JDBCTemplate.Durid_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class T04_DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into account values(null, ?, ?)";
            pre = conn.prepareStatement(sql);
            pre.setString(1, "王五");
            pre.setDouble(2, 3000);
            int cnt = pre.executeUpdate();
            System.out.println(cnt);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           JDBCUtils.close(conn, pre);
        }
    }
}
