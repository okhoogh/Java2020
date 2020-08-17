package day06_DataSource_JDBCTemplate.C3P0_01;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class T01_C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        // 1.创建数据库连接池对象
        DataSource dataSource = new ComboPooledDataSource();
        // 2.获取连接对象
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }
}
