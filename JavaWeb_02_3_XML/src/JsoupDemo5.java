import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 1.查询name标签
        Elements names = document.select("name");
        System.out.println(names);
        System.out.println("------------");
        // 2.查询id为123的元素
        Elements id = document.select("#123");
        System.out.println(id);
        System.out.println("------------");
        // 3.获取student标签并且number属性值为a_0002的age子标签
        Elements elements = document.select("student[number='a_0002']>age");
        System.out.println(elements);
    }
}
