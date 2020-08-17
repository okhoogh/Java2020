package day24_ClassLoader_Reflect_Module;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class T07_ReflectDemo_exp1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> c = Class.forName("JavaSE_01.day24_ClassLoader_Reflect_Module.Student");
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj, "张三");
        Field age = c.getDeclaredField("age");
        age.setAccessible(true);
        age.set(obj, 30);
        Field address = c.getDeclaredField("address");
        address.setAccessible(true);
        address.set(obj, "西安");
        System.out.println(obj);
    }
}
