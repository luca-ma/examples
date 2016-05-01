package equalshash;

public class NameEqHash {

	private String privateName;

	public NameEqHash(String privateName) {
		super();
		this.privateName = privateName;
	}

	public String getPrivateName() {
		return privateName;
	}

	public void setPrivateName(String privateName) {
		this.privateName = privateName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((privateName == null) ? 0 : privateName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NameEqHash other = (NameEqHash) obj;
		if (privateName == null) {
			if (other.privateName != null)
				return false;
		} else if (!privateName.equals(other.privateName))
			return false;
		return true;
	}
}
