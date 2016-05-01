package util;

public class EqualExample {

	private String name;
	public EqualExample(String name) {
		super();
		this.name = name;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EqualExample ex1 = new EqualExample("aa");
		EqualExample ex2 = new EqualExample("aa");
		
		System.out.println("equals:"+ex1.equals(ex2));
		System.out.println("hash 1:"+ex1.hashCode());
		System.out.println("hash 2:"+ex2.hashCode());

	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EqualExample other = (EqualExample) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
