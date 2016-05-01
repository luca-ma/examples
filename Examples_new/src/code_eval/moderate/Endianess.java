package code_eval.moderate;

import java.nio.ByteOrder;

public class Endianess {

	public static void main(String[] args) {

		if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
			System.out.println("BigEndian");
		} else {
			System.out.println("LittleEndian");
		}
	}

}