package cripto_courseI;

public class TwoPad {
	static String msg0 = "attack at dawn";
	static String cript0Exa = "09e1c5f70a65ac519458e7e53f36";
	static String msg1 = "attack at dusk";
	public static void main(String[] args) {
		String cript0 = UtilsCripto.hexToASCII(cript0Exa);
		System.out.println("cript0: " + cript0);
		String key = UtilsCripto.stringExOR(msg0, cript0);
		System.out.println("key: " + key);
		System.out.println("checkMsg: " + UtilsCripto.stringExOR(key, cript0));
		String cripto1 = UtilsCripto.stringExOR(msg1, key);
		System.out.println("cripto1: " + cripto1);
		System.out
		.println("cripto1Ex: " + UtilsCripto.toHexAsciiArray(cripto1));
		System.out
		.println("criptoori: " + cript0Exa);
	}
}
