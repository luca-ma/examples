package equalshash;

public class NameEqNoHash {

	private String privateName;

	public NameEqNoHash(String privateName) {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NameEqNoHash other = (NameEqNoHash) obj;
		if (privateName == null) {
			if (other.privateName != null)
				return false;
		} else if (!privateName.equals(other.privateName))
			return false;
		return true;
	}
}
