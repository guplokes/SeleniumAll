package Part_1;


/*pyramid..
 ***********
1
2 3
4 5 6
7 8 9 10
 *********/
public class Loops2 {

	public static void main(String[] args) {
		int num=1,n=7;
		for(int i=1;i<n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(num + "\t");
				num++;
			}
			System.out.println();
		}
	}

}
