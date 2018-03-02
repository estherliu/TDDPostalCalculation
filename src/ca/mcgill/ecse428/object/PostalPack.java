package ca.mcgill.ecse428.object;

public class PostalPack {
	
	public enum PostalType {
		Regular, Xpress, Priority
	}
	
	/*
	public enum Country{
		US, CANADA, INTERNATIONAL
	}
	*/
	
	public String PostCodeFrom; 
	public String PostCodeTo; 
	public float length; 
	public float width; 
	public float height; 
	public float weight; 
	public PostalType type; 
	
	public PostalPack(String aPostCodeFrom, String aPostCodeTo, String alength, 
			String awidth, String aheight, String aweight, String atype) throws Exception {
		
		try{
		this.PostCodeFrom = aPostCodeFrom; 
		this.PostCodeTo = aPostCodeTo; 
		this.length = Float.parseFloat(alength); 
		this.width = Float.parseFloat(awidth); 
		this.height = Float.parseFloat(aheight); 
		this.weight = Float.parseFloat(aweight); 
		switch(atype){
			case "Regular": this.type=PostalType.Regular;
							break;
			case "Xpress": this.type=PostalType.Xpress;
							break;
			case "Priority": this.type=PostalType.Priority;
							break;
		}
		}
		catch(Exception e){
			throw new Exception("create fails");
		}
		
		
	}

}
