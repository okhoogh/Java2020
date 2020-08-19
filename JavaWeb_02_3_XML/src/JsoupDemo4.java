import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;

public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 1.通过Document们获取name标签
        Elements names = document.getElementsByTag("name");
        System.out.println(names.size());

        // 2.通过Element获取name标签
        Element student1 = document.getElementsByTag("student").get(0);
        Elements name1 = student1.getElementsByTag("name");
        System.out.println(name1.size());

        // 3.通过student1获取属性值
        String number = student1.attr("number");
        System.out.println(number);

        // 4.获取文本内容
        String text = student1.text();
        String html = student1.html();
        System.out.println(text);
        System.out.println("------------");
        System.out.println(html);
    }
}
