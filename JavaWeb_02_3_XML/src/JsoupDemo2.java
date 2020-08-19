import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        // 1.导入Jsoup的jar包
        // 2.获取Document对象
        // 2.1获取student.xml的path
        String path = JsoupDemo2.class.getClassLoader().getResource("student.xml").getPath();
        // 2.2解析xml文档，加载文档进内存，获取DOM树
        Document document = Jsoup.parse(new File(path), "utf-8");
//        System.out.println(document);
        String html = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<users>\n" +
                "    <user id='1'>\n" +
                "        <name>zhangsan</name>\n" +
                "        <age>23</age>\n" +
                "        <gender>male</gender>\n" +
                "    </user>\n" +
                "    <user id='2'>\n" +
                "        <name>lisi</name>\n" +
                "        <age>24</age>\n" +
                "        <gender>female</gender>\n" +
                "    </user>\n" +
                "</users>";
        Document document1 = Jsoup.parse(html);
//        System.out.println(document1);

        URL url = new URL("https://www.baidu.com");
        Document document2 = Jsoup.parse(url, 10000);
        System.out.println(document2);
    }
}
