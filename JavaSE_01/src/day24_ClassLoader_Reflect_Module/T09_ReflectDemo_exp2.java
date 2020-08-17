package day24_ClassLoader_Reflect_Module;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class T09_ReflectDemo_exp2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("JavaSE_01.day24_ClassLoader_Reflect_Module.Student");
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        Method method1 = c.getMethod("method1");
        method1.invoke(obj);
        Method method2 = c.getMethod("method2", String.class);
        method2.invoke(obj, "张三");
        Method method3 = c.getMethod("method3", String.class, int.class);
        Object ss = method3.invoke(obj, "张三", 20);
        System.out.println(ss);
        Method function = c.getDeclaredMethod("function");
        function.setAccessible(true);
        function.invoke(obj);
    }
}
