package runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;



public class codetesting {
	
	public static HashMap<String, String> prop;

	public static void main(String[] args){
	
		HashMap<String, String> hashMap = new HashMap<>();
		String propFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "config.properties";

		try {
		BufferedReader reader = new BufferedReader(new FileReader(propFilePath));
		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
			hashMap.put(line.split("=")[0], line.split("=")[1]);
		}
		reader.close();

		
		}
		catch(Exception e) {
			
		}
		prop = hashMap;
		System.out.println(hashMap.get("e"));
	}

}
