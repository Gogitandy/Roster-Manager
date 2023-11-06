public class Player {
    // instance variables
	private String name;
	private double attackStat;
	private double blockStat;

	// overload constructor
	public Player (String name, double attackStat, double blockStat) {
		this.name = name;
		this.attackStat = attackStat;
		this.blockStat = blockStat;
	}
	// getters
	public String getName () {
		return name;
	}
	public double getAttackStat () {
		return attackStat;
	}
	public double getBlockStat () {
		return blockStat;
	}
	public String getPlayer () {
		String wholePlayer = ("name: " + name + " attack stat: " + attackStat + " block stat: " + blockStat);
		return wholePlayer;
	}
	// setters
	public void setAttackStat (double attackStat) {
		this.attackStat = attackStat;
	}
	public void setBlockStat (double blockStat) {
		this.blockStat = blockStat;
	}
	// doers
	public void printPlayerInfo () {
		System.out.printf("%s (attack = %.2f, block = %.2f)%n", name, attackStat, blockStat);
	}
}
