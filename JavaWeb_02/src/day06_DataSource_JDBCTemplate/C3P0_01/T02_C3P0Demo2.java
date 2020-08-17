package day06_DataSource_JDBCTemplate.C3P0_01;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class T02_C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        // 1.创建数据库连接池对象(默认配置)
//        DataSource dataSource = new ComboPooledDataSource();
        // 指定配置
        DataSource dataSource = new ComboPooledDataSource("otherc3p0");
        // 2.获取连接对象
        for (int i = 0; i < 11; i++) {
            Connection conn = dataSource.getConnection();
            System.out.println(i + "." + conn);
            if(i == 5)
                conn.close();
        }
    }
}
