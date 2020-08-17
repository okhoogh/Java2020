package day06_DataSource_JDBCTemplate.JDBCTemplate_03;

import day06_DataSource_JDBCTemplate.Durid_02.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class T06_JDBCTemplateExp {

    // 1.修改1号数据的salary为10000
    @Test
    public void Exp1() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update emp set salary = ? where id = ?";
        int cnt = template.update(sql, 10000, 1001);
        System.out.println(cnt);
    }

    // 2.添加一条记录
    @Test
    public void Exp2() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into emp(id, ename, dept_id) values(?, ?, ?)";
        int cnt = template.update(sql, 1015, "郭靖", 10);
        assert cnt == 1;
    }

    // 3.删除刚才添加的记录
    @Test
    public void Exp3() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "delete from emp where id = ?";
        int cnt = template.update(sql, 1015);
        assert cnt == 1;
    }

    // 4.查询id为1的记录,将其封装为Map集合
    // 注意：结果集长度只能是1
    @Test
    public void Exp4() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }

    // 5.查询所有记录，将其封装为List
    @Test
    public void Exp5() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from emp";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    // 6.查询所有记录，将其封装为Emp对象的List集合1(自己实现封装)
    @Test
    public void Exp6() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from emp";
        List<Emp> emps = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rSet, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rSet.getInt("id");
                String ename = rSet.getString("ename");
                int job_id = rSet.getInt("job_id");
                int mgr = rSet.getInt("mgr");
                Date joindate = rSet.getDate("joindate");
                double salary = rSet.getDouble("salary");
                double bonus = rSet.getDouble("bonus");
                int dept_id = rSet.getInt("dept_id");
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    // 6.查询所有记录，将其封装为Emp对象的List集合(采用提供的实现类)
    @Test
    public void Exp7() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from emp";
        List<Emp> emps = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    // 7.查询总记录数
    @Test
    public void Exp8() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
