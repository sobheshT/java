import java.io.*;

public class SimpleEncryption {
	static int count=0;
void encrypt(String source,String dest,int shiftSize) throws FileNotFoundException
{
BufferedReader reader;
BufferedWriter writer;
 
try {
	reader=new BufferedReader(new FileReader(source));
	writer=new BufferedWriter(new FileWriter(dest));
	String line =reader.readLine();
	int data;
	int vow=0;
	while(line!=null) {
		for(int i=0;i<line.length();i++) {
			data=(int) line.charAt(i)+shiftSize;
			vow=vowel(line.charAt(i));
			writer.write(data);
		}
		writer.write(","+vow);
		writer.write((int)'\n');
		line=reader.readLine();
	}
	reader.close();
	writer.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	System.out.println("Failed encrypting the file content");
}

}
public void viewFileContent(String filename) {
	BufferedReader reader;
	try {
		reader=new BufferedReader(new FileReader(filename));
		String line=reader.readLine();
		while(line!=null) {
			System.out.println(line);
			line=reader.readLine();
		}
		reader.close();
	} catch ( IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Failed to open file for reading");
	}
}
public int vowel(char data) {
	if(data=='a'||data=='e'||data=='i'||data=='o'||data=='u') {
		count++;
	}
	return count;
	
}
}
