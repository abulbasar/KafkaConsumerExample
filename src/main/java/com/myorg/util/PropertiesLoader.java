package com.myorg.util;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;


public class PropertiesLoader {
	public static Properties getKafkaProperties(String groupId){
		Properties props = new Properties();
		String filename = "kafka.properties";
        try {
            InputStream is = PropertiesLoader.class.getClassLoader().getResourceAsStream(filename);
        	props.load(is);
            props.setProperty("group.id",groupId);
        } catch (IOException e) {
          e.printStackTrace();
        }
        return props;
	}
	
	public static void main(String args[]) {
		System.out.println(PropertiesLoader.getKafkaProperties("test").getProperty("zookeeper.connect").toString());
	}
}
