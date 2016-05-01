package enumUt;

public class UtilEnum3 {
	public enum CommCodes {
		CREATE_NAT("1"),
		UPDATE_NAT("2"),
		DELETE_NAT("3"),
		CREATE_FWD("4"),
		DELETE_FWD("5"),
		DUMP_STATS("6"),
		RESET_STATS("7"),
		VIEW_FWD("8"),
		EXIT("0"),
		HELP("H");

		public String getCommCode() {
			return commCode;
		}

		public void setCommCode(String commCode) {
			this.commCode = commCode;
		}

		private String commCode;

		private CommCodes(String commCode) {
			this.commCode = commCode;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(CommCodes.valueOf("1"));

		System.out.println(CommCodes.values());

	}

}
