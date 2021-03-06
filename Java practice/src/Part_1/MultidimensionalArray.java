package Part_1;

public class MultidimensionalArray {
	//this method : to find largest no. in the column which have minimum no. of 3*3 array
	public void minMax(int arr[][]) {
		int smallest=Integer.MAX_VALUE;
		int largest=Integer.MIN_VALUE;
		int column=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(arr[i][j]<smallest) {
					smallest=arr[i][j];
					column=j;
				}				
			}
		}
		
		for(int i=0;i<3;i++) {
			if(arr[i][column]>largest)
				largest=arr[i][column];
		}
		
		System.out.println("largest no. in the column which have minimum no. of 3*3 array is :" + largest);
	}

	public static void main(String[] args) {
		//to find the smallest no. 3*3 matrix
		
		
		//int[][] arr = new int[3][3]; //2d-array declaration
		
		int[][] arr = {{2,4,5},{3,4,7},{1,2,0}}; //2d-array intialization
		int smallest=Integer.MAX_VALUE;
		//System.out.println(arr[0].length);
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(arr[i][j]<smallest)
					smallest=arr[i][j];
			}
		}
		
		System.out.println("Smallest number is :" + smallest);
		
		new MultidimensionalArray().minMax(arr);
	}

}
