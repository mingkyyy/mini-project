package Gui;

import java.io.IOException;

import javax.swing.JFrame;

public class Test extends JFrame{
	

	
	public static void main(String[] args) {
		double 위도 = 37.5086936;
		double 경도 = 	127.063165;
		try {
			Runtime.getRuntime().exec(new String[] { 
					"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", 
					String.format("https://map.kakao.com/link/map/%f,%f",위도, 경도)
					
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		System.out.println("aa");
	}
}