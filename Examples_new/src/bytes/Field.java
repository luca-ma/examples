package bytes;

public class Field {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Field fld = new Field(4, "");
		fld.setValue(new String ("aas"));

		System.out.println(fld.toString());
		fld.RightAlign =false;
		fld.setValue(new String ("aas"));
		
		System.out.println(fld.toString());
	}
	
	int length;
    String value;
    Boolean RightAlign = true; //filling chars added on left;
    Character fillingChar ='0';

    public Field(int length, String initialValue) {
        // omitted error check for length > 0
        this.length = length;
        setValue(initialValue);
    }
    public Field(int length, String initialValue, Character filChar) {
        // omitted error check for length > 0
        this.length = length;
        this.fillingChar = filChar;
        setValue(initialValue);
        
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (value != this.value) {
            if (value == null)
                value = "";
            if (value.length() > length)
                value = value.substring(0, length);
            else if (value.length()>0){
           // String form = String.format("%%0%dd", length);
           // 	System.out.println(value);
            	if (this.RightAlign) {
            		value =String.format("%" + length + "s", value).replace(' ', fillingChar);
            	}else {
            		value =String.format("%-" + length + "s", value).replace(' ', fillingChar);

            	}
             }
            this.value = value;
            
        }
    }
    @Override
    public String toString() {
    	
    	if((this.value==null)||(this.length==0)) {
    		return "";
    		
    	}else {
    		return this.value;
    	}
    }
}
