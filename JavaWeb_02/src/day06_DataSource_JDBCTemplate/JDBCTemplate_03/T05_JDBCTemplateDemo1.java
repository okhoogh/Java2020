package day06_DataSource_JDBCTemplate.JDBCTemplate_03;

import day06_DataSource_JDBCTemplate.Durid_02.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class T05_JDBCTemplateDemo1 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update account set balance = ? where id = ?";
        int cnt = template.update(sql, 5000, 3);
        System.out.println(cnt);
    }
}
