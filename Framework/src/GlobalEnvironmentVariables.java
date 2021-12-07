import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalEnvironmentVariables {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\guplokes\\selenium\\Framework\\src\\data.properties");
		prop.load(fs);
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		prop.setProperty("browser", "firefox");
		System.out.println(prop.getProperty("browser"));
		
		//to make/store changes in the file
		FileOutputStream fos = new FileOutputStream("C:\\Users\\guplokes\\selenium\\Framework\\src\\data.properties");
		prop.store(fos, null);
		

	}

}
