import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Roster {
    // instance variables
	private ArrayList<Player> players;

	// default constructor
	public Roster () {
		this.players = new ArrayList<Player>();
	}
	// overload constructor
	public Roster (String fileName) throws IOException {
		// new Array
		this.players = new ArrayList<Player>();
		// read input file
		File inputFile = new File(fileName);
		Scanner in = new Scanner(inputFile);
		// write file to array
		while (in.hasNext()) {
			String firstName = in.next();
			String lastName = in.next();
			String fullName = (firstName + " " + lastName);
			double attackStat = in.nextDouble();
			double blockStat = in.nextDouble();
			addPlayer (fullName, attackStat, blockStat);
		}
		in.close();
	}
	// getters
	public Player getPlayerByName (String fullName) {
		Player tempPlayer = null;
		for (int i = 0; i < players.size(); i++) {
			if (fullName.equals((players.get(i).getName()))) {
				tempPlayer = players.get(i);
			}
		}
		return tempPlayer;
	}
	// doers
	public void addPlayer (String name, double attackStat, double blockStat) {
		Player player = new Player (name, attackStat, blockStat);
		players.add(player);
	}
	public int countPlayers () {
		return players.size();
	}
	public void printTopAttackers () {
		Player topAttacker1 = players.get(0);
		Player topAttacker2 = players.get(1);
		for (int i = 1; i < players.size(); i++) {
			if (players.get(i).getAttackStat() > topAttacker1.getAttackStat()) {
				topAttacker2 = topAttacker1;
				topAttacker1 = players.get(i);
			}
			else if (players.get(i).getAttackStat() > topAttacker2.getAttackStat()) {
				topAttacker2 = players.get(i);
			}
		}
		topAttacker1.printPlayerInfo();
		topAttacker2.printPlayerInfo();
	}
	public void printTopBlockers () {
		Player topBlocker1 = players.get(0);
		Player topBlocker2 = players.get(1);
		for (int i = 1; i < players.size(); i++) {
			if (players.get(i).getBlockStat() > topBlocker1.getBlockStat()) {
				topBlocker2 = topBlocker1;
				topBlocker1 = players.get(i);
			}
			else if (players.get(i).getBlockStat() > topBlocker2.getBlockStat()) {
				topBlocker2 = players.get(i);
			}
		}
		topBlocker1.printPlayerInfo();
		topBlocker2.printPlayerInfo();
	}
	public void printAllPlayers () {
		for ( int i = 0; i < players.size(); i++) {
			players.get(i).printPlayerInfo();
		}
	}
	public void writeNewFile () throws IOException {
		PrintWriter writer = new PrintWriter("new_roster.txt", "UTF-8");
		for (int i = 0; i < players.size(); i++) {
			writer.println(players.get(i).getPlayer());
		}
		writer.close();
	}
}
