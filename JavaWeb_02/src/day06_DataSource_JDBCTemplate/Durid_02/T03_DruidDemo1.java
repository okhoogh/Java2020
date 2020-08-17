package day06_DataSource_JDBCTemplate.Durid_02;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.util.Properties;

public class T03_DruidDemo1 {
    public static void main(String[] args) throws Exception {
        // 1.导入jar包
        // 2.定义配置文件
        // 3.加载配置文件
        Properties prop = new Properties();
        InputStream is = T03_DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);
        // 4.获取数据库连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        // 5.获取对象
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
