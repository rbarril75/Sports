import java.util.*;

public class SalaryCalculator {

	public static final double LGWOBA = .334;
	public static final double WOBASCALE = 1.15;
	
	public static final double FIRST = -12.5;
	public static final double SECOND = 2.5;
	public static final double THIRD = 2.5;
	public static final double SHORT = 7.5;
	public static final double CORNER = -7.5;
	public static final double CENTER = 2.5;
	public static final double CATCHER = 12.5;
	public static final double DH = -17.5;
	public static final double REP = 20;
	
	public static double round(double value) {
		double result = (double) Math.round(100 * value) / 100;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Expected wOBA: ");
		double wOBA = in.nextDouble() / 1000;
		
		System.out.print("Expected PA: ");
		double PA = (double) in.nextInt();
		double wRAA = (wOBA - LGWOBA) / WOBASCALE * PA;
		System.out.println("wRAA: " + round(wRAA));
		
		System.out.print("Expected UZR/150: ");
		double UZR = in.nextDouble();
		
		System.out.print("Position: ");
		String position = in.next().toUpperCase();
		double POS = 0;
		if (position.equals("1B")) POS = FIRST;
		if (position.equals("2B")) POS = SECOND;
		if (position.equals("3B")) POS = THIRD;
		if (position.equals("SS")) POS = SHORT;
		if (position.equals("LF") || position.equals("RF")) POS = CORNER;
		if (position.equals("CF")) POS = CENTER;
		if (position.equals("C")) POS = CATCHER;
		if (position.equals("DH")) POS = DH;
		
		double prUZR = PA / 650 * UZR;
		double prREP = PA / 650 * REP;
		double prPOS = PA / 650 * POS;
		double valueInRuns = wRAA + prUZR + prREP + prPOS;
		System.out.println("WAR: " + round((valueInRuns - prPOS) / 10));
		System.out.println("posWAR: " + round(valueInRuns / 10));
		
		System.out.print("Contract Length: ");
		int years = in.nextInt();
		double yearFactor = 0.50;
		
		if (years == 1)
			yearFactor = 0.40;
		else if (years > 1)
			yearFactor = 0.40 - 0.01 * years;
		
		double valueInAAV;
		
		if (position.equals("C"))
			valueInAAV = round(.80 * valueInRuns * yearFactor);
		else
			valueInAAV = round(valueInRuns * yearFactor);
		
		if (valueInAAV < 0.4)
			valueInAAV = 0.4;
		
		double totalAmount = (double) round(100 * years * valueInAAV) / 100;
		
		System.out.println("Contract: $" + totalAmount + "M / " + years + "yrs");
		System.out.println("AAValue: $" + valueInAAV + "M");
	}

}
