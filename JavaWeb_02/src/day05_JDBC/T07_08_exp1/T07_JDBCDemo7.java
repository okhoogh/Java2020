package day05_JDBC.T07_08_exp1;

import day06_DataSource_JDBCTemplate.JDBCTemplate_03.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 */

public class T07_JDBCDemo7 {

    /**
     * 查询所有Emp对象
     * @return
     */

    public static List<Emp> findAll() {
        Connection conn = null;
        Statement statement = null;
        ResultSet rSet = null;
        List<Emp> emps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            statement = conn.createStatement();
            String sql = "select * from emp";
            rSet = statement.executeQuery(sql);
            Emp emp;
            emps = new ArrayList<>();
            while (rSet.next()) {
                int id = rSet.getInt("id");
                String ename = rSet.getString("ename");
                int job_id = rSet.getInt("job_id");
                int mgr = rSet.getInt("mgr");
                Date joindate = rSet.getDate("joindate");
                double salary = rSet.getDouble("salary");
                double bonus = rSet.getDouble("bonus");
                int dept_id = rSet.getInt("dept_id");
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                emps.add(emp);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(rSet != null) {
                try {
                    rSet.close();
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
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return emps;
    }

    public static void main(String[] args) {
        List<Emp> emps = findAll();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }
}
