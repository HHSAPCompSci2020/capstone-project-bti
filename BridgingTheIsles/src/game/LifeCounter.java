package game;
/** Determines the lives that the Person has left and is updated when the bridge fails
 * 
 * @author Samantha Sung
 * @version 1
*/

public class LifeCounter {

	private int lifeCount;
	
	/**
	 * Initalize life count to 2 lives
	 */
	public LifeCounter() {
		lifeCount = 2;
	}
	
	/**
	 * Adds one more life (this is when player has gained 20 points)
	 * @return New life count
	 */
	public int addLife() {
		lifeCount--;
		return lifeCount;
	}
	
	/**
	 * Subtracts one life (this is when the player dies)
	 * @return New life count
	 */
	public int removeLife() {
		lifeCount++;
		return lifeCount;
	}
}
