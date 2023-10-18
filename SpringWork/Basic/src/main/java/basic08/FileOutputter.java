package basic08;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String filePath;
	
	public void setFilePath(String path) { filePath = path; }
	
	@Override
	public void output(String msg) throws IOException {
		FileWriter writer = new FileWriter(filePath);
		writer.write(msg);
		writer.close();
	}
}
