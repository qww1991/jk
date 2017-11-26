package cn.itcast.jk.test;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		File oldFile = new File("C:\\Users\\lenovo\\Desktop\\文件夹");
		File newFile = new File("d:\\");
		
		
	}
	public void copyFile(File oldf,File newf){
		if(oldf.isDirectory()){
			File file = new File(oldf.getName());
			file.mkdir();
		}
		
		
	}
}
