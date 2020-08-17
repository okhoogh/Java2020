package day24_ClassLoader_Reflect_Module;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class T06_ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("JavaSE_01.day24_ClassLoader_Reflect_Module.Student");
//        Field[] fields = c.getFields();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("------------");
        Field address = c.getField("address");
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        address.set(obj, "北京");
        System.out.println(obj);
    }
}
