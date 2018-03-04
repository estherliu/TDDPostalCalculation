package ca.mcgill.ecse428.postalratecalculator;

import ca.mcgill.ecse428.object.PostalPack;

public class PostalCalculation {

	/*
	 * // String PostCodeFrom = "H2X2H2"; String PostCodeTo = "H2X3F4"; double
	 * length = 100; double width = 100; double height = 100; double weight = 1000;
	 * PostalType type = PostalType.Regular; Country c = Country.CANADA; PostalPack
	 * p = new PostalPack(PostCodeFrom, PostCodeFrom, length, width, height, weight,
	 * type, c); static double[] rateTireCAD = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
	 * static double[] rateTireUS = {1.5, 2.5, 3.5, 4.5, 5.5, 6.5}; static double[]
	 * rateTireINT = {3.0, 4.0, 5.0, 6.0, 7.0, 8.0}; static double XpressMulti;
	 * static double PriMulti;
	 */

	// argument example: H2H2H2 H2X3F4 150 100 100 100 Regular

	private static String resultMessage = "Successful";

	public static void main(String[] args) {
		if (checkInput(args)) {
			try {
				PostalPack p = new PostalPack(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
				System.out.println(calculateRate(p));
			} catch (Exception e) {
				System.out.println("create fails");
			}

		} else {
			System.out.println(resultMessage);
		}

	}

	public static String getResultMessage() {
		return resultMessage;
	}

	public static boolean checkInput(String[] args) {
		if (args.length < 7) {
			resultMessage = "arguments too few";
			return false;
		}
		if (args.length > 7) {
			resultMessage = "arguments too many";
			return false;
		}

		if (checkPostalCode(args[0]) && checkPostalCode(args[1]) && checkLength(args[2]) && checkWidth(args[3])
				&& checkHeight(args[4]) && checkWeight(args[5]) && checkPostType(args[6])) {
			return true;
		}
		return false;

	}

	// T3,T4,T5
	public static boolean checkLength(String length) {

		try {
			Float lengthnum = Float.parseFloat(length);
			if (lengthnum < 140.0) {
				resultMessage = "length too small";
				return false;
			}

			else if (lengthnum > 380.0) {
				resultMessage = "length too big";
				return false;
			}

			else
				return true;
		} catch (NumberFormatException e) {
			resultMessage = "invalid length";
			return false;
		}

	}

	// T6,T7,T8
	public static boolean checkWidth(String width) {

		try {
			Float widthnum = Float.parseFloat(width);
			if (widthnum < 90.0) {
				resultMessage = "width too small";
				return false;
			} else if (widthnum > 270.0) {
				resultMessage = "width too big";
				return false;
			} else
				return true;
		} catch (NumberFormatException e) {
			resultMessage = "invalid width";
			return false;
		}

	}

	// T9,T10,T11
	public static boolean checkWeight(String weight) {
		try {
			Float weightnum = Float.parseFloat(weight);
			if (weightnum < 3.0) {
				resultMessage = "weight too small";
				return false;
			}

			else if (weightnum > 500.0) {
				resultMessage = "weight too big";
				return false;
			} else
				return true;
		} catch (NumberFormatException e) {
			resultMessage = "invalid weight";
			return false;
		}

	}

	// T12,T13,T14
	// height range unknown...
	// TO BE CONTINUED
	public static boolean checkHeight(String height) {
		try {
			Float heightnum = Float.parseFloat(height);
			if (heightnum < 0.0) {
				resultMessage = "height too small";
				return false;
			} else
				return true;
		} catch (NumberFormatException e) {
			resultMessage = "invalid height";
			return false;
		}
	}

	// T15,T16
	public static boolean checkPostalCode(String PostCode) {
		if (PostCode.length() == 6 && Character.isLetter(PostCode.charAt(0)) && Character.isLetter(PostCode.charAt(2))
				&& Character.isLetter(PostCode.charAt(4)) && Character.isDigit(PostCode.charAt(1))
				&& Character.isDigit(PostCode.charAt(3)) && Character.isDigit(PostCode.charAt(5))) {

			return true;
		}
		resultMessage="invalid postal code";
		return false;
	}

	// T17
	private static boolean checkPostType(String atype) {
		switch (atype) {
		case "Regular":
			return true;
		case "Xpress":
			return true;
		case "Priority":
			return true;
		default:
			resultMessage = "invalid post type";
			return false;
		}

	}

	// T18 
	// should we take height, address and postal type into consideration?
	// TO BE CONTINUED
	private static float calculateRate(PostalPack p) {
		float postage = 0;
		if (p.length >= 140 && p.length <= 245 && p.width >= 90 && p.width <= 156) {
			if (p.weight >= 3 && p.weight <= 30)
				postage = (float) 0.49;
			else if (p.weight > 30 && p.weight <= 50)
				postage = (float) 0.8;
			else if (p.weight > 50 && p.weight <= 100)
				postage = (float) 0.98;
			else
				postage = (float) 2.4;
		} else if (p.length > 245 && p.length <= 380 && p.width >= 90 && p.width <= 156) {
			if (p.weight >= 3 && p.weight <= 100)
				postage = (float) 0.98;
			else if (p.weight > 100 && p.weight <= 500)
				postage = (float) 2.4;
		} else if (p.length >= 140 && p.length <= 380 && p.width > 156 && p.width <= 270) {
			if (p.weight >= 3 && p.weight <= 100)
				postage = (float) 0.98;
			else if (p.weight > 100 && p.weight <= 500)
				postage = (float) 2.4;
		} else {
			resultMessage = "domain not found";
		}
		return postage;

	}

	/*
	 * public static boolean checkDimension(double dimension) { if (dimension > 0) {
	 * return true; } return false; }
	 * 
	 * 
	 * public static boolean checkCountry(Country c) { if (c.equals(Country.CANADA)
	 * || c.equals(Country.US) || c.equals(Country.INTERNATIONAL)) { return true; }
	 * return false; }
	 * 
	 * public static double matchTire(PostalPack p, double[] rates) {
	 * 
	 * switch (p.type) { case Regular: return matchWeight(p, rates); case Xpress:
	 * for (int i = 0; i < rates.length; i++) { rates[i] = rates[i] * XpressMulti; }
	 * return matchWeight(p, rates); case Priority: for (int i = 0; i <
	 * rates.length; i++) { rates[i] = rates[i] * PriMulti; } return matchWeight(p,
	 * rates); }
	 * 
	 * return 0.0; }
	 * 
	 * public static double matchWeight(PostalPack p, double[] rates) { if (p.weight
	 * <= 100) { return rates[0]; } else if (p.weight > 100 && p.weight <= 200) {
	 * return rates[1]; } else if (p.weight > 200 && p.weight <= 300) { return
	 * rates[2]; } else if (p.weight > 300 && p.weight <= 400) { return rates[3]; }
	 * else if (p.weight > 400 && p.weight <= 500) { return rates[4]; } else if
	 * (p.weight > 500) { return rates[5]; } return 0.0;
	 * 
	 * }
	 * 
	 * public static double calculateRate(PostalPack p) throws Exception { if
	 * (!checkPostalCode(p.PostCodeFrom)) { throw new
	 * Exception("PostCodeFrom is invalid"); } else if
	 * (!checkPostalCode(p.PostCodeTo)) { throw new
	 * Exception("PostCodeIn is invalid"); } else if (!checkDimension(p.height)) {
	 * throw new Exception("Height is invalid"); } else if
	 * (!checkDimension(p.length)) { throw new Exception("Length is invalid"); }
	 * else if (!checkDimension(p.width)) { throw new Exception("Width is invalid");
	 * } else if (!checkDimension(p.weight)) { throw new
	 * Exception("Weight is invalid"); } else if (!checkPostalType(p.type)) { throw
	 * new Exception("Type of Service is invalid"); } else if
	 * (!checkCountry(p.country)) { throw new
	 * Exception("Destinating Country is invalid"); } else { if
	 * (p.country.equals(Country.US)) { return p.weight * matchTire(p, rateTireUS);
	 * } else if (p.country.equals(Country.CANADA)) { return p.weight * matchTire(p,
	 * rateTireCAD); } else { return p.weight * matchTire(p, rateTireINT); }
	 * 
	 * }
	 * 
	 * }
	 */

}
