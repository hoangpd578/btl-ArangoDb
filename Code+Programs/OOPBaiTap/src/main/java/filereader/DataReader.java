/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package filereader;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Laptop88
 */
public class DataReader extends AFileReader<String>{

	public DataReader(String path) {
		super(path);
	}

	public DataReader() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<String> readFile() {
		file = new File(path);
		ArrayList<String> listData = new ArrayList<String>();
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine())  {
				listData.add(scanner.nextLine().replace(" ", "_"));
			}
		} catch (Exception e) { e.printStackTrace(); }
		return listData;
	}

}