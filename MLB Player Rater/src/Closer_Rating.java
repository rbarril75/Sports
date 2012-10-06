import java.util.Scanner;

public class Closer_Rating {
	
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
		double[] eSeventies = {0, 4.22, 3.73, 3.25, 3.02, 2.46, 2.31, 2.81, 2.30, 2.50};
		double[] eEighties = {2.37, 2.77, 2.78, 3.22, 3.11, 3.03, 3.36, 4.17, 2.94, 3.93};
		double[] eNineties = {3.71, 3.53, 3.28, 4.66, 5.32, 4.78, 4.36, 4.31, 3.60, 3.85};
		double[] Zeroes = {3.70, 3.49, 3.17, 3.11, 2.66, 2.82, 2.65, 2.50, 2.37, 2.53};
		double[] Tens = {2.77, 3.36, 3.37, 3.06, 2.75, 2.83, 2.71, 2.68, 2.76, 3.06};
		double[] Twenties = {3.46, 4.03, 4.06, 3.98, 4.05, 4.33, 3.92, 4.02, 4.01, 4.47};
		double[] Thirties = {4.81, 4.12, 4.18, 3.81, 4.28, 4.24, 4.53, 4.26, 4.28, 4.27};
		double[] Fourties = {4.11, 3.89, 3.48, 3.33, 3.52, 3.58, 3.46, 3.89, 4.11, 4.12};
		double[] Fifties = {4.36, 4.04, 3.70, 4.14, 3.89, 4.00, 3.96, 3.83, 3.86, 3.90};
		double[] Sixties = {3.81, 4.02, 3.95, 3.46, 3.58, 3.50, 3.52, 3.30, 2.98, 3.61};
		double[] Seventies = {3.88, 3.46, 3.25, 3.74, 3.62, 3.70, 3.51, 3.98, 3.66, 3.97};
		double[] Eighties = {3.81, 3.57, 3.83, 3.84, 3.79, 3.86, 3.95, 4.27, 3.71, 3.69};
		double[] Nineties = {3.85, 3.87, 3.71, 4.18, 4.50, 4.44, 4.60, 4.38, 4.44, 4.71};
		double[] NewMill = {4.77, 4.41, 4.28, 4.40, 4.46, 4.28, 4.52, 4.46, 4.32, 4.32};
		double[] nTens = {4.07, 3.94, 0, 0, 0, 0, 0, 0, 0, 0};
		
		double[][] eyrERA = {eSeventies, eEighties, eNineties};
		double[][] yrERA = {Zeroes, Tens, Twenties, Thirties, Fourties, Fifties, Sixties,
							Seventies, Eighties, Nineties, NewMill, nTens};
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Actual ERA: ");
		double ERA = in.nextDouble();
		
		System.out.print("First year: ");
		int iYear = in.nextInt();
		
		System.out.print("Final year: ");
		int fYear = in.nextInt();
		
		double ERAsum = 0;
		
		if (iYear >= 1900) {
			for (int i = iYear; i <= fYear; i++) {
				int decadeNum = (i - 1900) / 10;
				int yearNum = (i - 1900) % 10;
				ERAsum += yrERA[decadeNum][yearNum];
			}
		}
		
		else if (fYear <= 1899) {
			for (int i = iYear; i <= fYear; i++) {
				int decadeNum = (i - 1870) / 10;
				int yearNum = (i - 1870) % 10;
				ERAsum += eyrERA[decadeNum][yearNum];
			}
		}
		
		else if (iYear <= 1899 && fYear >= 1900) {
			for (int i = iYear; i <= 1899; i++) {
				int decadeNum = (i - 1870) / 10;
				int yearNum = (i - 1870) % 10;
				ERAsum += eyrERA[decadeNum][yearNum];
			}
			
			for (int i = 1900; i <= fYear; i++) {
				int decadeNum = (i - 1900) / 10;
				int yearNum = (i - 1900) % 10;
				ERAsum += yrERA[decadeNum][yearNum];
			}
		}
		
		double numYears = fYear - iYear + 1;
		
		double avgERA = ERAsum / numYears;
		double adjERA = ERA * 3.80 / avgERA;
		double modERA = adjERA + 0.50;
		
		System.out.println("Average ERA: " + round(avgERA));
		System.out.println("Adjusted ERA: " + round(adjERA));
		System.out.println("Modern Adjusted ERA: " + round(modERA));
		
		System.out.print("SV: ");
		double SV = in.nextDouble();
		
		System.out.print("IP: ");
		double IP = in.nextDouble();
		
		double RS = (5.00 - adjERA) * (IP / 9);
		double wRS = 2 * RS;
		System.out.println("wRS: " + intRound(wRS));
		
		double base = 24.00;
		
		if (IP < 1000)
			base *= IP / 1000;
		
		double dominance = (3.80 - adjERA) * 15;
		double longevity = dblRound(RS) / 25;
		double SVrating = SV / 50;
		
		double rawRating = dominance + longevity + SVrating;
		double adjustment = (100 - rawRating) / 3;
		double closerRating = base + rawRating + adjustment;
		
		System.out.print("Closer Rating: " + round(closerRating));
		
	}

}
