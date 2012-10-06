import java.util.*;

//tRA Calculator
//Stats Needed: ER, IP, TBF, HR, BB, HBP, K, LD%, GB%, IFB%
/*
ER 
IP
TBF 
HR 
BB 
HBP 
K 
LD% 
GB% 
IFB% 
*/

public class tRACalculator {
	
	public static final double LD_OUT = .305;
	public static final double GB_OUT = .812;
	public static final double OFB_OUT = .830;
	public static final double IFB_OUT = .985;
	
	/*
	public static final double K_RUN = -.105;
	public static final double BB_RUN =.329;
	public static final double HR_RUN = 1.394;
	public static final double HBP_RUN = .345;
	public static final double LD_RUN = .384;
	public static final double GB_RUN = .053;
	public static final double OFB_RUN = .046;
	public static final double IFB_RUN = -.096;
	*/
	
	
	public static final double K_RUN = -.113;
	public static final double BB_RUN =.355;
	public static final double HR_RUN = 1.409;
	public static final double HBP_RUN = .355;
	public static final double LD_RUN = .391;
	public static final double GB_RUN = .045;
	public static final double OFB_RUN = .029;
	public static final double IFB_RUN = -.088;
	
	
	public static double round(double value) {
		double result = (double) Math.round(100 * value) / 100;
		return result;
	}
	
	public static double tRound(double value) {
		double result = (double) Math.round(1000 * value) / 1000;
		return result;
	}
	
	public static int intRound(double value) {
		int result = (int) Math.round(value);
		return result;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("ER: ");
		double ER = in.nextDouble();
		
		System.out.print("IP: ");
		double IP = in.nextDouble();
		
		System.out.print("TBF: ");
		double TBF = in.nextDouble();
		
		System.out.print("HR: ");
		double HR = in.nextDouble();

		System.out.print("BB: ");
		double BB = in.nextDouble();
		
		System.out.print("HBP: ");
		double HBP = in.nextDouble();
		
		System.out.print("K: ");
		double K = in.nextDouble();
		
		double BIP = TBF - HR - BB - HBP - K;
		
		System.out.print("LD%: ");
		double LDPCT_BIP = in.nextDouble() / 100;
		
		System.out.print("GB%: ");
		double GBPCT_BIP = in.nextDouble() / 100;
		
		System.out.print("IFB%: ");
		double IFBPCT_BIP = in.nextDouble() / 100;
		
		double BUNTPCT_BIP = .02;
		
		double OFBPCT_BIP = 1.00 - LDPCT_BIP - GBPCT_BIP - IFBPCT_BIP - BUNTPCT_BIP;
		System.out.println("OFB%: " + tRound(100* OFBPCT_BIP));
		
		double LD = LDPCT_BIP * BIP;
		double GB = GBPCT_BIP * BIP;
		double IFB = IFBPCT_BIP * BIP;
		double OFB = OFBPCT_BIP * BIP;
		double FB = IFB + OFB;
		
		double xRuns = HR * HR_RUN + BB * BB_RUN + HBP * HBP_RUN + K * K_RUN
						+ LD * LD_RUN + GB * GB_RUN + IFB * IFB_RUN + OFB * OFB_RUN;
		double xOuts = K + LD * LD_OUT + GB * GB_OUT + IFB * IFB_OUT + OFB * OFB_OUT;
		int actRuns = (int) ER;
		int actOuts = (int) IP * 3;
		int runDef = intRound(xRuns) - actRuns;
		int outDef = actOuts - intRound(xOuts);
		
		double xHR = .1 * FB;
		double nxRuns = xRuns + (xHR - HR) * HR_RUN;

		//All Stats are representations of Runs Allowed / 27 Outs
		double ERA = ER / IP * 9;
		double FIP = (13*HR + 3*BB - 2*K) / IP + 3.20; //HR, BB, K only
		double xFIP = (13*xHR + 3*BB - 2*K) / IP + 3.20; //BB, K only, HR = .1 * FB
		double tRA = xRuns / xOuts * 27; //All Events including Batted Ball data
		double xtRA = nxRuns / xOuts * 27; //All Events including Batted Ball data, HR = .1 * FB
		
		double pRAA = 4.50 * xOuts / 27 - nxRuns;
		double REP = .50 * xOuts / 27;
		double DUR_BONUS = 5 * IP / 250;
		double ERA_BONUS = 0;
		
		if (IP > 150) {
			
		if (ERA < 0.50)
			ERA_BONUS = 27;
		else if (ERA < 1.00)
			ERA_BONUS = 24;
		else if (ERA < 1.50)
			ERA_BONUS = 21;
		else if (ERA < 2.00)
			ERA_BONUS = 18;
		else if (ERA < 2.50)
			ERA_BONUS = 15;
		else if (ERA < 3.00)
			ERA_BONUS = 12;
		else if (ERA < 3.50)
			ERA_BONUS = 9;
		else if (ERA < 4.00)
			ERA_BONUS = 6;
		else if (ERA < 4.50)
			ERA_BONUS = 3;
		};
		
		System.out.print("Contract Length: ");
		int years = in.nextInt();
		double yearFactor = 0.50;
		
		if (years == 1)
			yearFactor = 0.40;
		else if (years > 1)
			yearFactor = 0.40 - 0.01 * years;
		
		System.out.println("Durability Bonus: $" + round(DUR_BONUS) + "M");
		System.out.println("Performance Bonus: $" + round(ERA_BONUS) + "M");
		double valueInAAV = round(((pRAA + REP) * 0.5 + DUR_BONUS + ERA_BONUS) * yearFactor / 0.40);
		
		if (valueInAAV < 0.4)
			valueInAAV = 0.4;
		
		double totalAmount = (double) round(100 * years * valueInAAV) / 100;
		
		System.out.println("Contract: $" + totalAmount + "M / " + years + "yrs");
		System.out.println("AAValue: $" + valueInAAV + "M");
		
		System.out.println();
		System.out.print("xRuns: " + intRound(xRuns) + " / actRuns: " + actRuns);
		
		if (runDef > 0)
			System.out.println(" (Defense/Park +" + runDef + ")");
		else 
			System.out.println(" (Defense/Park " + runDef + ")");
		
		System.out.print("xOuts: " + intRound(xOuts) + " / actOuts: " + actOuts);
		
		if (outDef > 0)
			System.out.println(" (Defense/Park +" + outDef + ")");
		else 
			System.out.println(" (Defense/Park " + outDef + ")");
		
		System.out.println("ERA: " + round(ERA));
		System.out.println("FIP: " + round(FIP) + " / xFIP: " + round(xFIP));
		System.out.println("tRA: " + round(tRA) + " / xtRA: " + round(xtRA));
		System.out.println();
		System.out.println("pRAA: " + round(pRAA));
		System.out.println("Contract: $" + totalAmount + "M / " + years + "yrs");
		System.out.println("AAValue: $" + valueInAAV + "M");
		
	}

}

