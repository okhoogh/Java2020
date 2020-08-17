package day19_IoStream_PropertiesSet.SetToFile;

/*
    需求：键盘录入5个学生信息(姓名,语文成绩,数学成绩,英语成绩)。要求按照成绩总分从高到低写入文本文件
          格式：姓名,语文成绩,数学成绩,英语成绩	举例：林青霞,98,99,100

    思路：
        1:定义学生类
        2:创建TreeSet集合，通过比较器排序进行排序
        3:键盘录入学生数据
        4:创建学生对象，把键盘录入的数据对应赋值给学生对象的成员变量
        5:把学生对象添加到TreeSet集合
        6:创建字符缓冲输出流对象
        7:遍历集合，得到每一个学生对象
        8:把学生对象的数据拼接成指定格式的字符串
        9:调用字符缓冲输出流对象的方法写数据
        10:释放资源
*/

import java.io.PrintStream;
import java.util.Scanner;

public class TreeSetToFileDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintStream ps = System.out;
        ps.println();
    }
}
