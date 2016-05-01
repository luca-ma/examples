package enumUt;

import equalshash.CheckEquals;

public class UtilEnum2 extends CheckEquals{
	
	public static enum NAME{
		NAME1("aa","bbb"),		
		NAME2("cc","ddd"),
		NAME3("ee","fff");
		
		private String firstName;
		private String lastName;
		private NAME(String firstName) {
			this.firstName =firstName;
			this.lastName ="";
		}
		private NAME(String firstName,String lastName) {
			this.firstName =firstName;
			this.lastName =lastName;
		}
		
		public String getFirstName() {
            return this.firstName;
        }
		public String getLastName() {
            return this.lastName;
        }
	}
	
	public enum AAA {
		D;
		NAME name = NAME.NAME1;
		
	}
	
	public static NAME exName = NAME.NAME1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(exName.name());
		//System.out.println(exName.values().toString());
		System.out.println(exName.getFirstName());
		System.out.println(exName.getLastName());

	}

}
