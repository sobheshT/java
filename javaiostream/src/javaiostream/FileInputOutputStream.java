package javaiostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.*;

public class FileInputOutputStream {
public static void main(String[] args) throws IOException {
	File inputFile=new File("Demo.txt");
	File outFile=new File("Outgain.txt");
	FileReader in=new FileReader(inputFile);
	FileWriter out=new FileWriter(outFile);
	int c;
	while((c=in.read())!=-1) {
		System.out.println( c);
		out.write(c);
	}
	System.out.println("FileInputStream is used to read a file and FileOutputStream is used to write in a file");
	in.close();
	out.close();
}
}