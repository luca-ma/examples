package chars;

public class ExOr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		String message =  "attack at dawn";
		String cipher = "09e1c5f70a65ac519458e7e53f3";
		
		String asciiMsg = Ascii.convInAScii(message);
		//String binMsg = Ascii.convInASciiBin(message);
		System.out.println("msg ascii:" + asciiMsg);
		byte[] msgBytes = asciiMsg.getBytes();
		byte[] cipBytes = cipher.getBytes();
		//System.out.println("msg ascii bin:" + binMsg);
		//System.out.println("msg ascii bin len:" + binMsg.length());
		
//		String binCip = Ascii.convInASciiBin(cipher);
//		System.out.println("cip bin:" + binCip);
//		System.out.println("cip  bin len:" + binCip.length());
//		//String binaryCip = Integer.toBinaryString(Integer.parseInt(cipher,16));
		
		//System.out.println("msg len:"+binaryMsg.length()+"cip len:"+binaryCip.length());
		
		System.out.println("msg bytes len :" + msgBytes.length);
		System.out.println("cip bytes len :" + cipBytes.length);
		//0^9;
		//System.out.println(""+);
	}

}
