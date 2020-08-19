import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        // 1.导入Jsoup的jar包
        // 2.获取Document对象
        // 2.1获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        // 2.2解析xml文档，加载文档进内存，获取DOM树
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 3.获取Element
        Elements names = document.getElementsByTag("name");
        System.out.println(names.size());
        // 3.1获取第一个Element对象
        Element name1 = names.get(0);
        String name = name1.text();
        System.out.println(name);
    }
}
