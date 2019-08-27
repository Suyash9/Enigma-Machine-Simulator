import java.io.*;

/**This class reads the content of a given file, encodes it and then writes the content onto a different file.
 * @author Suyash
 *
 */

public class EnigmaFile {
	
	// variables and objects
	private EnigmaMachine enigmaMac = new EnigmaMachine();
	
	
	// method to read content from a file
	public void readFile() throws IOException, Exception{
		// path needs to be changed as required
		String path = "C:\\Users\\Suyash\\Documents\\Work\\COMP1202 - Programming 1\\Coursework\\test.txt";
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		try {
			while((line = reader.readLine()) !=null){
				encodeFile(line.toUpperCase());
			}
			reader.close();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	
	// method to encode contents of a file 
	public void encodeFile(String line) throws IOException, Exception{
		char[] charArray = line.toCharArray();
		char[] encodedArray = new char[line.length()];
		
		for (int i =0; i<charArray.length; i++) {
			if((int)charArray[i] >= 65 && (int)charArray[i] <= 90) {
                encodedArray[i] = enigmaMac.encodeLetter(charArray[i]);
            }else{
                encodedArray[i] = charArray[i];
            }
        }
		System.out.print(String.valueOf(encodedArray));
        writeFile(String.valueOf(encodedArray));
	}
	
	
	// method that writes decode message onto a file
	public void writeFile(String line) throws IOException{
		// path needs to be changed as required
        File newFile = new File("C:\\Users\\Suyash\\Documents\\Work\\COMP1202 - Programming 1\\Coursework\\testout.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFile, true));

        try {
            if(newFile.exists() && !newFile.isDirectory()) {
                writer.write(line);
                writer.close();
            }else{
            	// path needs to be changed as required
                PrintWriter pwriter = new PrintWriter("C:\\Users\\Suyash\\Documents\\Work\\COMP1202 - Programming 1\\Coursework\\testout.txt");
                pwriter.println(line);
                pwriter.close();
            }
        } catch(IOException e2){
            e2.printStackTrace();
        }
    }
	
	
	// method that runs the start method for a file
    public void setup() throws Exception{
        enigmaMac.start();
    }

}
