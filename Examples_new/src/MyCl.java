
public class MyCl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr [][] = new int[3][4];
		
		for(int idx=0;idx<3;idx++){
			arr[idx][idx+1]=2;
		}
		int sum =0;
		for(int i =0;i<3;i++){
			for(int j =0;j<4;j++){
				sum+=arr[i][j];
			}
		}
		System.out.println("sum:"+sum);
	}

}
