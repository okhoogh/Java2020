package day24_ClassLoader_Reflect_Module;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class T05_ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("JavaSE_01.day24_ClassLoader_Reflect_Module.Student");
        Constructor<?> con = c.getDeclaredConstructor(String.class);
        // 取消访问检查
        con.setAccessible(true);
        Object obj = con.newInstance("小米");
        System.out.println(obj);
    }
}
