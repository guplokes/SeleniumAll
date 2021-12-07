package Part_1;

public class Loops1 {
	/*
	 * Pyramid
	 ***************
	 * 1 2 3 4
	 * 5 6 7
	 * 8 9
	 ********/
	public static void main(String[] args) {
		
		int num=1,n=4;
		int m=n+1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				System.out.print(num + "\t");
				num++;
			}
			//m--;
			System.out.print("\n");
		}
		
		
	}

}
