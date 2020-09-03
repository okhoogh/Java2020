package test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import utils.JedisPoolUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    // 入门
    @Test
    public void test1() {
        // 1.获取连接
        Jedis jedis = new Jedis("localhost",  6379);
        // 2.操作
        jedis.set("username", "zhangsan");
        // 3.关闭连接
        jedis.close();
    }

    // string数据结构操作
    @Test
    public void test2() {
        // 1.获取连接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值"localhost"，6379端口

        // 2.操作
        jedis.set("username", "zhangsan");
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储可以指定过期时间的key value
        //activeCode: hi键值对存入redis， 并且10秒后自动删除该键值对
        jedis.setex("activeCode", 10, "hi");

        // 3.关闭连接
        jedis.close();
    }

    // hash数据结构操作
    @Test
    public void test3() {
        // 1.获取连接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值"localhost"，6379端口

        // 2.操作
        // 存储hash
        jedis.hset("user", "name", "zhangsan");
        jedis.hset("user", "age", "12");
        jedis.hset("user", "gender", "male");

        // 获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);

        // 获取hash的所有map中的数据
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }
        // 3.关闭连接
        jedis.close();
    }

    // list数据结构操作
    @Test
    public void test4() {
        // 1.获取连接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值"localhost"，6379端口

        // 2.操作
        // list存储
        jedis.lpush("l1", "a", "b", "c");
        jedis.rpush("l1", "d", "e", "f");
        // list范围获取
        List<String> l1 = jedis.lrange("l1", 0, -1);
        System.out.println(l1);
        // list弹出
        String lpop = jedis.lpop("l1");
        System.out.println(lpop);
        List<String> l2 = jedis.lrange("l1", 0, -1);
        System.out.println(l2);
        // 3.关闭连接
        jedis.close();
    }

    // set数据结构操作
    @Test
    public void test5() {
        // 1.获取连接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值"localhost"，6379端口

        // 2.操作
        // set存储
        jedis.sadd("s1", "java", "php", "c++", "c++");
        // set获取
        Set<String> s1 = jedis.smembers("s1");
        System.out.println(s1);

        // 3.关闭连接
        jedis.close();
    }

    // sortedset数据结构操作
    @Test
    public void test6() {
        // 1.获取连接
        Jedis jedis = new Jedis();  //如果使用空参构造，默认值"localhost"，6379端口

        // 2.操作
        // sortedset存储
        jedis.zadd("z1", 3, "张");
        jedis.zadd("z1", 2, "李");
        jedis.zadd("z1", 1, "王");
        // sortedset获取
        Set<String> z1 = jedis.zrange("z1", 0, -1);
        System.out.println(z1);

        // 3.关闭连接
        jedis.close();
    }

    // jedis连接池使用
    @Test
    public void test7() {
        // 0.创建一个配置对象
        JedisPoolConfig Config = new JedisPoolConfig();
        Config.setMaxTotal(50);
        Config.setMaxIdle(10);
        // 1.创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(Config, "localhost", 6379);
        // 2.获取连接
        Jedis jedis = jedisPool.getResource();
        // 3.使用
        jedis.set("test7", "emmm");
        // 4.关闭
        jedis.close();
    }

    // jedis连接池工具类的使用
    @Test
    public void test8() {
        // 1.通过Jedis连接池工具类获取连接
        Jedis jedis = JedisPoolUtils.getJedis();
        // 3.使用
        jedis.set("test8", "emmm");
        // 4.关闭
        jedis.close();
    }
}
