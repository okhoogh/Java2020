package day24_ClassLoader_Reflect_Module.T02_GetClassInstance;

import day24_ClassLoader_Reflect_Module.Student;

public class ReflectDemo0 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Student> c1 = Student.class;
        System.out.println(c1);

        Class<Student> c2 = Student.class;
        System.out.println(c1 == c2);

        Student s = new Student();
        Class<? extends Student> c3 = s.getClass();
        System.out.println(c1 == c3);

        Class<?> c4 = Class.forName("JavaSE_01.day24_ClassLoader_Reflect_Module.Student");
        System.out.println(c1 == c4);
    }
}
