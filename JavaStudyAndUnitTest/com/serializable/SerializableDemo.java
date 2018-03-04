import java.io.Serializable;

public class SerializableDemo implements Serializable {
	private Boolean isWrapperClass;
	private boolean isFoundationClass;
	private boolean isWithoutIs;
	private boolean isWithIs;
	
	
	public Boolean getIsWrapperClass() {
		return isWrapperClass;
	}
	public void setIsWrapperClass(Boolean isWrapperClass) {
		this.isWrapperClass = isWrapperClass;
	}
	
	public boolean isFoundationClass() {
		return isFoundationClass;
	}
	public void setFoundationClass(boolean isFoundationClass) {
		this.isFoundationClass = isFoundationClass;
	}
	
	public boolean isWithoutIs() {
		return isWithoutIs;
	}
	public void setWithoutIs(boolean isWithoutIs) {
		this.isWithoutIs = isWithoutIs;
	}
	
	public boolean isIsWithIs() {
		return isWithIs;
	}
	public void setIsWithIs(boolean isWithIs) {
		this.isWithIs = isWithIs;
	}
}
