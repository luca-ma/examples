package ldap;

public enum LdapUsers {
	SIMPLE_USER("simple"),
	ONLY_LYNC_USER("onlyLYNC"),
	SMART_USER("smart");

	private String userName;

	private LdapUsers(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

}
