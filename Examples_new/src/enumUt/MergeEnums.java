package enumUt;


public class MergeEnums {

	public enum Ph{
		LOGIN_VPBX,
		AddCommandsType,
		LOGOUT_VPBX;
	}
	
	public enum AddCommandsType {
		ADD_LIST_REQ(1, "ServiceProviderDnAddListRequest"),
		GROUP_ADD_REQ(2, "GroupAddRequest"),
		GROUP_DN_REQ(3, "GroupDnAssignListRequest"),
		GROUP_EXT_LEN_REQ(4, "GroupExtensionLengthModifyRequest17"),
		GROUP_MOD_REQ(5, "GroupModifyRequest"),
		GROUP_SER_MOD_AUTH_REQ(6, "GroupServiceModifyAuthorizationListRequest"),
		GROUP_SER_LIST_REQ(7, "GroupServiceAssignListRequest"),
		GROUP_PROC_MOD_REQ(8, "GroupCallProcessingModifyPolicyRequest15Sp2");

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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 AddCommandsType[] values = AddCommandsType.values();
		 for(AddCommandsType commType:values) {
			 System.out.println("comm:"+commType.commandNamemsg+", order:"+commType.commandOrder);
		 }
		 
		 
		 Ph[] ph = Ph.values();
		 for(Ph phVal:ph) {
			 System.out.println("comm:"+phVal.name()+", order:"+phVal.ordinal());
		 }
		 
	}

}
