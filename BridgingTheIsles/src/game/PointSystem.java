package game;
/** Determines the points that the player has earned and increments according to the targets on the isle
 * 
 * @author Samantha Sung
 * @version 1
*/
public class PointSystem {

	private int points;
	
	/**
	 * Initializes points to 0
	 */
	public PointSystem() {
		points = 0;
	}
	
	/**Adds n number of points to the total
	 *
	 * @param n Number of points earned
	 * @return New total points
	 */
	public int incrementPoints(int n) {
		points += n;
		return points;
	}
}
