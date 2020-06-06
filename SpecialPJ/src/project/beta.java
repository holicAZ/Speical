package project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class beta {
		
	
	public static void main(String[] args) throws Exception{
		
		
		int max=0;
		File dir = new File("C:/AAA");
		
		
		String[] dirs = dir.list();
		
		
		for(int i = 0; i<dirs.length; i++) {
			FileReader fr = new FileReader(dirs[i]);
			max++;
			System.out.println(dirs[i]);
			System.out.println(max);
			fr.close();
		}
	
		
	}
	
}

