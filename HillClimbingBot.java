import java.util.*;

public class HillClimbingBot {
    // The DoTurn function is where your code goes. The PlanetWars object
    // contains the state of the game, including information about all planets
    // and fleets that currently exist. Inside this function, you issue orders
    // using the pw.IssueOrder() function. For example, to send 10 ships from
    // planet 3 to planet 8, you would say pw.IssueOrder(3, 8, 10).
    //
    // There is already a basic strategy in place here. You can use it as a
    // starting point, or you can throw it out entirely and replace it with
    // your own. Check out the tutorials and articles on the contest website at
    // http://www.ai-contest.com/resources.
    public static void DoTurn(PlanetWars pw) {
    	//Hill-climbing tentative:
    	// 1. Generate children
    	// 2. Sort children, remove worst
    	// 3. If children not empty, choose best
    	
    	
    	int[][] scores = new int[pw.MyPlanets().size()][pw.NotMyPlanets().size()];
    	
    	Planet bestMine = null;
    	Planet bestNotMine = null;
    	int maxScore = Integer.MIN_VALUE;
    	
    	for (Planet mine : pw.MyPlanets()) {
    		for (Planet notMine : pw.NeutralPlanets()) {
    			//simulate mine->notmine issuing    			
    			int score = mine.NumShips()/2 - notMine.NumShips();    			
    			if (score > maxScore) {
    				maxScore = score;
    				bestMine = mine;
    				bestNotMine = notMine;
    			}
    		}
    	}
    	if (bestMine != null && bestNotMine != null) {
    		pw.IssueOrder(bestMine, bestNotMine);
    	}   	
    	
    	
    	/*
	// (1) If we currently have a fleet in flight, just do nothing.
	if (pw.MyFleets().size() >= 1) {
	    return;
	}
	// (2) Find my strongest planet.
	Planet source = null;
	double sourceScore = Double.MIN_VALUE;
	for (Planet p : pw.MyPlanets()) {
	    double score = (double)p.NumShips();
	    if (score > sourceScore) {
		sourceScore = score;
		source = p;
	    }
	}
	// (3) Find the weakest enemy or neutral planet.
	Planet dest = null;
	double destScore = Double.MIN_VALUE;
	for (Planet p : pw.NotMyPlanets()) {
	    double score = 1.0 / (1 + p.NumShips());
	    if (score > destScore) {
		destScore = score;
		dest = p;
	    }
	}
	// (4) Send half the ships from my strongest planet to the weakest
	// planet that I do not own.
	if (source != null && dest != null) {
	    //int numShips = source.NumShips() / 2;
	    pw.IssueOrder(source, dest);
	}
	*/
    }

    public static void main(String[] args) {
	String line = "";
	String message = "";
	int c;
	try {
	    while ((c = System.in.read()) >= 0) {
		switch (c) {
		case '\n':
		    if (line.equals("go")) {
			PlanetWars pw = new PlanetWars(message);
			DoTurn(pw);
		        pw.FinishTurn();
			message = "";
		    } else {
			message += line + "\n";
		    }
		    line = "";
		    break;
		default:
		    line += (char)c;
		    break;
		}
	    }
	} catch (Exception e) {
	    // Owned.
	}
    }
}

