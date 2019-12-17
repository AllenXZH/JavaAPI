package com.example.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FilesProperties {

    public void test1 () {

        Properties props = new Properties();
        try {
            props.load(new FileInputStream(
                    new File("/"+ "config/" + "PROP_NAME")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperties(props);
        String className = props.getProperty("options_class");
    }
}
