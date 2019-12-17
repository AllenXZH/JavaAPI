package com.example.api.utils;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class ClassLoaderTests {


    public static void main(String[] args) {

        test2();

    }

    private static void test2() {
        String path = "/Users/AllenXZH/Desktop/Timesheet/xxx.jar";//此jar包里还有别的jar包
        try {
            JarFile jarfile = new JarFile(new File(path));
            Enumeration<JarEntry> es = jarfile.entries();

            while (es.hasMoreElements()) {
                JarEntry je = es.nextElement();
                String name = je.getName();

                if(name.endsWith(".jar")){//读取jar包里的jar包
                    File f = new File(name);
                    JarFile j = new JarFile(f);
                    Enumeration<JarEntry> e = j.entries();

                    while (e.hasMoreElements()) {
                        JarEntry jarEntry = (JarEntry) e.nextElement();
                        System.out.println(jarEntry.getName());
                        //.........接下去和上面的方法类似
                    }
                }
                //    System.out.println(je.getName());
                if(je.getName().equals("entity_pk.properties")){
                    InputStream inputStream = jarfile.getInputStream(je);
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    Iterator<Object> ite = properties.keySet().iterator();

                    while (ite.hasNext()) {
                        Object key = ite.next();
                        System.out.println(key + " : " +properties.get(key));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
