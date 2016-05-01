package util;

public class EnumEx {

	/**
	 * @param args
	 */
	
	private enum AddCommandsType {
		ADD_LIST_REQ(1, "ServiceProviderDnAddListRequest"),
		GROUP_ADD_REQ(2, "GroupAddRequest"),
		GROUP_DN_REQ(3, "GroupDnAssignListRequest");
		//FIXME add complete commands list 

		private Integer commandOrder;
		private String commandNamemsg;

		private AddCommandsType(Integer code, String msg) {
			this.commandOrder = code;
			this.commandNamemsg = msg;
		}

		public Integer getCommandOrder() {
			return commandOrder;
		}

		public String getCommandNamemsg() {
			return commandNamemsg;
		}

		//		public String codeMessage() {
		//			return commandOrder + "#" + commandNamemsg;
		//		}
	}
	public static void main(String[] args) {
		AddCommandsType[] values = AddCommandsType.values();
		for(AddCommandsType value : values) {
			System.out.println("val:"+value.getCommandOrder());
		}

	}

}
