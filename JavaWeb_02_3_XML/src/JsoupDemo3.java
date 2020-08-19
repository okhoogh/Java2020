import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 1.获取所有student对象
        Elements students = document.getElementsByTag("student");
        System.out.println(students);
        System.out.println("------------------");
        // 2.获取属性名为id的元素对象们
        Elements ids = document.getElementsByAttribute("id");
        System.out.println(ids);
        System.out.println("------------------");
        // 3.获取属性名为number,值为a_0001的元素对象
        Elements ebA1 = document.getElementsByAttributeValue("number", "a_0001");
        System.out.println(ebA1);
        System.out.println("------------------");
        // 3.获取id属性值的元素对象
        Element id = document.getElementById("123");
        System.out.println(id);
    }
}
