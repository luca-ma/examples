package reflect;

public class ExBEan {
	private Boolean receivedResponse=true;
	
	public ExBEan (String par) {
		
	}
public ExBEan () {
		
	}
	
	public Boolean getReceivedResponse() {
		return receivedResponse;
	}
	public void setReceivedResponse(Boolean receivedResponse) {
		this.receivedResponse = receivedResponse;
	}
	private String id ="ID_01";
	private String errorCode ="121";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
