import java.io.IOException;
import java.util.ArrayList;

public class SampleTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DataDrivenTest obj = new DataDrivenTest();
		ArrayList<String> data = obj.getData("Login");
		for(String m:data) {
			System.out.println(m);
			
		}

	}

}
