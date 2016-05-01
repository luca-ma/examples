enum Metal {
	COPPER, GOLD,AA;
	Metal() {
		System.out.print("constructor:");
	}
	static {
		System.out.print("static:");
	}
	public static void main(String args[]) {
		//System.out.print(Metal.COPPER + ":");
	}
}
