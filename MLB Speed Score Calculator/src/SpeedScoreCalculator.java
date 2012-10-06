import java.util.*;

//Speed Score Calculator
//Stats Needed: SB, CS, 1B, 2B, 3B, HR, BB, HBP, AB, K, R, GIDP
/*
SB 
CS 
1B 
2B 
3B 
HR 
BB 
HBP 
AB 
K 
R 
GIDP 
 */

public class SpeedScoreCalculator {

	public static double round(double value) {
		double result = (double) Math.round(100 * value) / 100;
		return result;
	}
	
	public static double min(double[] arr) {
		double min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		return min;
	}
	
	public static double sum(double [] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//Speed Score 1: Stolen Base Percentage
		System.out.print("SB: ");
		double SB = in.nextDouble();
		
		System.out.print("CS: ");
		double CS = in.nextDouble();
		
		double SCR1 = ((SB+3)/(SB+CS+7)-0.4)*20;
		
		System.out.println("SB% Score: " + round(SCR1));
		
		//Speed Score 2: Stolen Base Attempts
		System.out.print("1B: ");
		double SNGL = in.nextDouble();
		
		System.out.print("2B: ");
		double DBL = in.nextDouble();
		
		System.out.print("3B: ");
		double TRPL = in.nextDouble();
		
		System.out.print("HR: ");
		double HR = in.nextDouble();
		
		double H = SNGL + DBL + TRPL + HR;
		
		System.out.print("BB: ");
		double BB = in.nextDouble();
		
		System.out.print("HBP: ");
		double HBP = in.nextDouble();
		
		double SCR2 = Math.sqrt((SB+CS)/((H-DBL-TRPL-HR)+BB+HBP))/0.07;
		
		System.out.println("SB Attempts Score: " + round(SCR2));
		
		//Speed Score 3: Triples
		System.out.print("AB: ");
		double AB = in.nextDouble();
		
		System.out.print("K: ");
		double K = in.nextDouble();
		
		double SCR3 = TRPL/(AB-HR-K)/0.02*10;
		
		System.out.println("Triples Score: " + round(SCR3));
		
		//Speed Score 4: Runs Per Time on Base
		System.out.print("R: ");
		double R = in.nextDouble();
		
		double SCR4 = ((R-HR)/(H+BB-HR-HBP)-0.1)/0.04;
		
		System.out.println("Runs / Time On Base Score: " + round(SCR4));
		
		//Speed Score 5: Ground Into Double Plays
		System.out.print("GIDP: ");
		double GIDP = in.nextDouble();
		
		double SCR5 = (0.055-GIDP/(AB-HR-K))/0.005;
		
		System.out.println("GIDP Score: " + round(SCR5));
		
		double[] scores = {SCR1, SCR2, SCR3, SCR4, SCR5};
		double min = min(scores);
		double sum = sum(scores);
		
		double SPD_SCR = (sum - min) / 4;
		
		double GRD_SCR = (SPD_SCR - 5) * 10 + 75;
		
		System.out.println();
		System.out.println("Speed Score: " + round(SPD_SCR));
		System.out.print("Grade Score: " + round(GRD_SCR));
		
		if (GRD_SCR >= 100)
			System.out.print(" - Speed Demon");
		else if (GRD_SCR >= 90)
			System.out.print(" - Fast");
		else if (GRD_SCR >= 80)
			System.out.print(" - Above Average");
		else if (GRD_SCR >= 70)
			System.out.print(" - Average");
		else if (GRD_SCR >= 60)
			System.out.print(" - Below Average");
		else if (GRD_SCR >= 50)
			System.out.print(" - Slow");
		else
			System.out.print(" - Turtle");
		
	}

}
