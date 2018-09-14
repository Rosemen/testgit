package com.scau.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

/**
 * ʵ�����"Hello World!"
 * @since 2018/09/09
 * @author chen
 *
 */
public class HelloWorld {
	
	//ʹ��ԭʼ��ʽ
    public void firstPrint() {
    	System.out.println("Hello World!");
    }
    
    //ͨ�����������ȡproperties�ļ�
    public void secondPrint() throws IOException {
    	InputStream in = this.getClass().getClassLoader().getResourceAsStream("message.properties");
    	Properties props = new Properties();
    	props.load(in);
    	String hello = props.getProperty("message.hello");
    	in.close();
    	System.out.println(hello);
    }
    
    //��ͨ�ļ���ȡ��ʽ
    public void thirdPrint() throws Exception {
    	InputStream in = new FileInputStream(new File("src/message.txt"));
    	byte[] data = new byte[1024];
    	int size = in.read(data);
    	in.close();
    	System.out.println(new String(data,0,size));
    }
    
    
    
    //���Է���
    @Test
    public void test() {
    	try {
			thirdPrint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
