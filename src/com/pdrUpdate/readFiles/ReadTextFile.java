package com.pdrUpdate.readFiles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTextFile 
{
	public ReadTextFile() throws Exception
	{
		
	}
	private ArrayList<String> CrcValues=new ArrayList<String>();
	Scanner sc = new Scanner(new FileReader(".\\crc.txt"));
	public ArrayList<String> getCrcValues() throws FileNotFoundException 
	{
			while(sc.hasNextLine())
			{
				CrcValues.add(sc.nextLine());
			}
			
			//System.out.println(getCrcValues());
			
			sc.close();
			return CrcValues;
	}
	
}
