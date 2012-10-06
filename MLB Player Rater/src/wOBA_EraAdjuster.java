import java.util.*;

public class wOBA_EraAdjuster {
	
	public static int intRound(double value) {
		int result = (int) Math.round(value);
		return result;
	}
	
	public static double dblRound(double value) {
		double result = Math.round(value);
		return result;
	}
	
	public static double round(double value) {
		double result = (double) Math.round(100 * value) / 100;
		return result;
	}
	
	public static void main(String[] args) {
		int[] eSeventies = {0, 312, 297, 303, 282, 261, 277, 289, 279, 271};
		int[] eEighties = {267, 290, 275, 286, 283, 288, 303, 332, 291, 334};
		int[] eNineties = {330, 332, 317, 356, 379, 361, 354, 354, 334, 343};
		int[] Zeroes = {339, 327, 322, 317, 301, 307, 307, 305, 297, 307};
		int[] Tens = {318, 337, 337, 325, 318, 317, 312, 312, 317, 322};
		int[] Twenties = {335, 347, 348, 347, 348, 354, 345, 346, 344, 353};
		int[] Thirties = {356, 339, 337, 330, 342, 341, 349, 344, 344, 344};
		int[] Fourties = {334, 334, 324, 323, 326, 329, 329, 336, 341, 344};
		int[] Fifties = {346, 337, 337, 336, 333, 332, 331, 324, 325, 324};
		int[] Sixties = {324, 328, 326, 309, 313, 311, 310, 307, 299, 320};
		int[] Seventies = {326, 317, 311, 325, 325, 328, 320, 329, 323, 330};
		int[] Eighties = {326, 320, 324, 325, 323, 323, 326, 331, 317, 319};
		int[] Nineties = {324, 323, 322, 332, 339, 338, 340, 337, 336, 345};
		int[] NewMill = {347, 333, 331, 333, 336, 330, 337, 336, 334, 334};
		int[] nTens = {325, 321, 0, 0, 0, 0, 0, 0, 0, 0};
		
		//Round Up
		
		int[][] eyrWOBA = {eSeventies, eEighties, eNineties};
		int[][] yrWOBA = {Zeroes, Tens, Twenties, Thirties, Fourties, Fifties, Sixties,
							Seventies, Eighties, Nineties, NewMill, nTens};
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Actual wOBA: ");
		double wOBA = in.nextDouble();
		
		System.out.print("First year: ");
		int iYear = in.nextInt();
		
		System.out.print("Final year: ");
		int fYear = in.nextInt();
		
		double wOBAsum = 0;
		
		if (iYear >= 1900) {
			for (int i = iYear; i <= fYear; i++) {
				int decadeNum = (i - 1900) / 10;
				int yearNum = (i - 1900) % 10;
				wOBAsum += yrWOBA[decadeNum][yearNum];
			}
		}
		
		else if (fYear <= 1899) {
			for (int i = iYear; i <= fYear; i++) {
				int decadeNum = (i - 1870) / 10;
				int yearNum = (i - 1870) % 10;
				wOBAsum += eyrWOBA[decadeNum][yearNum];
			}
		}
		
		else if (iYear <= 1899 && fYear >= 1900) {
			for (int i = iYear; i <= 1899; i++) {
				int decadeNum = (i - 1870) / 10;
				int yearNum = (i - 1870) % 10;
				wOBAsum += eyrWOBA[decadeNum][yearNum];
			}
			
			for (int i = 1900; i <= fYear; i++) {
				int decadeNum = (i - 1900) / 10;
				int yearNum = (i - 1900) % 10;
				wOBAsum += yrWOBA[decadeNum][yearNum];
			}
		}
		
		double numYears = fYear - iYear + 1;
		
		double avgWOBA = wOBAsum / numYears;
		double adjWOBA = wOBA * 330 / avgWOBA;
		
		System.out.println("Average wOBA: " + intRound(avgWOBA));
		System.out.println("Adjusted wOBA: " + intRound(adjWOBA));
		
		System.out.print("PA: ");
		double PA = in.nextDouble();
		
		double wRC = ((dblRound(adjWOBA) - 330) / 1150 + .125) * PA;
		System.out.println("wRC: " + intRound(wRC));
		
		double base = 28.00;
		
		if (PA < 5000)
			base *= PA / 5000;
		
		double dominance = dblRound(adjWOBA) / 10;
		double longevity = dblRound(wRC) / 100;
		double offRating = base + dominance + longevity;
		
		System.out.print("Offensive Rating: " + round(offRating));
		
	}

}
