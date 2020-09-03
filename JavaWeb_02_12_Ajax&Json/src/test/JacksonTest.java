package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JacksonTest {

    // Java对象转Json字符串
    @Test
    public void test1() throws IOException {
        // 1.创建Person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(20);
        person.setGender("男");

        // 2.创建Jackson核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // 3.转换
        /*
            转换方法:
            writeValue(参数1, obj):
                参数1:
                File:将obj对象转换为JSON字符串，并保存到指定的文件中
                Writer:将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                OutputStream:将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
            writeValueAsString(obj):将对象转为json字符串
        */

        // 将JSON数据写到字符串中
//        String json = mapper.writeValueAsString(person);
//        System.out.println(json);

        // 将JSON数据写到文件中
//        mapper.writeValue(new File("json.txt"), person);

        // 将JSON数据关联到Writer中
        mapper.writeValue(new FileWriter("json2.txt"), person);

    }

    @Test
    public void test2() throws JsonProcessingException {
        // 1.创建Person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(20);
        person.setGender("男");
        person.setBirthday(new Date());

        // 2.获取ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    public void test3() throws JsonProcessingException {
        // 1.创建Person对象
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(20);
        p1.setGender("男");
        p1.setBirthday(new Date());

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p1);
        people.add(p1);

        // 2.获取ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(people);
        System.out.println(json);
    }

    @Test
    public void test4() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 12);
        map.put("gender", "male");
        // 2.获取ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }

    // Json -> Java
    @Test
    public void test5() throws IOException {
        String json = "{\"gender\":\"male\",\"name\":\"张三\",\"age\":12}";
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
