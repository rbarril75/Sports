
public class Scorer {

	static int calculateScore (String[] winners, String[] picks) {		
		int week_score = 0;
		int ototal_score = Integer.parseInt(picks[1]);
		int ntotal_score;
		
		if (picks.length != winners.length)
			ntotal_score = ototal_score;
		else {
			for (int i = 2; i < winners.length; i++) {
				if (winners[i].equals(picks[i]) && !winners[i].equals(""))
					week_score++;
			}
		
			ntotal_score = ototal_score + week_score;
		}
		
		System.out.println(week_score + " (" + 
				ntotal_score + ") - " + picks[0]);
		
		return 1;
	}
	
	public static void main(String[] args) {		
		String[] winners = {
				"Winners", "Score", "Rams", "Falcons Redskins", "Eagles Steelers", "Packers Colts", 
				"Browns Giants", "Titans Vikings", "DolphinsBengals", "Ravens Chiefs", "Seahawks Panthers", 
				"Bears Jaguars", "Broncos Patriots", "Bills 49ers", "Chargers Saints", "Texans Jets"
		};
		
		String[] picks0 = {
				"Favorites", "25", "Cardinals", "Falcons", "Steelers", "Packers", "Giants", "Vikings", 
				"Bengals", "Ravens", "Panthers", "Bears", "Patriots", "49ers", "Saints", "Texans"
		};
		
		String[] picks5 = {
				"RR 823", "30", "Cardinals", "Falcons", "Steelers", "Packers", "Browns", "Titans", 
				"Bengals", "Ravens", "Seahawks", "Bears", "Broncos", "49ers", "Chargers", "Texans"};
		
		String[] picks6 = {
				"Basel", "29", "Rams", "Falcons", "Eagles", "Packers", "Giants", "Vikings", 
				"Bengals", "Ravens", "Panthers", "Bears", "Patriots", "49ers", "Chargers", "Texans"	};
		
		String[] picks1 = {
				"Floods", "33", "Cardinals", "Falcons", "Eagles", "Packers", "Giants", "Vikings", 
				"Bengals", "Ravens", "Panthers", "Bears", "Patriots", "Bills", "Saints", "Jets"	};
		
		String[] picks4 = {
				"scdn", "31", "Cardinals", "Redskins", "Steelers", "Packers", "Giants", "Titans", 
				"Dolphins", "Ravens", "Seahawks", "Bears-Jags", "Patriots", "Bills", "Saints", "Texans"	};
		
		String[] picks11 = {
				"TheAnswer", "21", "Cardinals", "Falcons", "Eagles", "Packers", "Giants", "Titans", 
				"Bengals", "Ravens", "Panthers", "Bears", "Broncos", "49ers", "Saints", "Texans"};
		
		String[] picks12 = {
				"Kaas", "19", "Panthers", "Rams", "Buccaneers", "49ers", "Lions", "Redskins", "Jets", "Saints", "Bills", 
				"Colts", "Eagles", "Chargers", "Texans", "Steelers", "Ravens", "Packers"	};
		
		String[] picks7 = {
				"BlueBaron", "28", "Cardinals", "Falcons", "Eagles", "Packers", "Giants", "Vikings", 
				"Bengals", "Ravens", "Seahawks", "Bears", "Patriots", "49ers", "Chargers", "Texans"	};
		
		String[] picks2 = {
				"Cris", "32", "Rams", "Redskins", "Eagles", "Colts", "Browns", "Vikings", 
				"Bengals", "Ravens", "Seahawks-Panthers", "Bears", "Patriots", "49ers", "Saints", "Texans"	};
		
		String[] picks8 = {
				"hobojoe", "26", "Rams", "Falcons", "Eagles", "Packers", "Giants", "Vikings", 
				"Bengals", "Ravens", "Panthers", "Bears", "Broncos", "49ers", "Saints", "Jets"	};
		
		String[] picks9 = {
				"KingJoseus", "24", "Cardinals", "Falcons", "Steelers", "Colts", "Giants", "Vikings", 
				"Bengals", "Ravens", "Panthers", "Bears", "Broncos", "49ers", "Saints", "Texans"	};
		
		String[] picks13 = {
				"ATLien", "12"	};
		
		String[] picks3 = {
				"kbdullah", "32", "Cardinals", "Falcons", "Steelers", "Packers", "Giants", "Vikings", 
				"Bengals", "Ravens", "Panthers", "Bears", "Broncos", "49ers", "Chargers", "Texans"	};
		
		String[] picks10 = {
				"Knicks4life", "24", "Cardinals", "Falcons", "Steelers", "Colts", "Browns", "Vikings", 
				"Bengals", "Ravens", "Seahawks", "Jaguars", "Broncos", "Bills", "Chargers", "Jets"};
		
		calculateScore(winners, picks0);
		calculateScore(winners, picks1);
		calculateScore(winners, picks2);
		calculateScore(winners, picks3);
		calculateScore(winners, picks4);
		calculateScore(winners, picks5);
		calculateScore(winners, picks6);
		calculateScore(winners, picks7);
		calculateScore(winners, picks8);
		calculateScore(winners, picks9);
		calculateScore(winners, picks10);
		calculateScore(winners, picks11);
		calculateScore(winners, picks12);
		calculateScore(winners, picks13);
	}

}
