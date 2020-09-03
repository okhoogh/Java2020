package dao.impl;

import dao.ProvinceDao;
import domain.Province;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    // 声明一个jdbcTemplate
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        String sql = "select * from province";
        List<Province> list = null;
        try {
            list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }
}
