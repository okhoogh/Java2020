package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import redis.clients.jedis.Jedis;
import service.ProvinceService;
import utils.JedisPoolUtils;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    // 声明dao
    private ProvinceDaoImpl dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        // 1.先从redis查询数据
        // 1.1获取redis连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        System.out.println("redis有数据，查询redis...");
        // 2.如果redis中没有province的数据(判断province_json是否为null)
        if(province_json == null || province_json.length() == 0) {
            System.out.println("redis没数据，查询数据库...");
            List<Province> list = dao.findAll();
            // 序列化list为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            // 将json数据存入redis
            jedis.set("province", province_json);
            jedis.close();
        }
        return province_json;
    }
}
