package game;
/** 
 * Determines the lives that the Person has left and is updated when the bridge fails
 * 
 * @author Samantha Sung
 * @version 5/13
*/

public class LifeCounter {

	protected int lifeCount;
	
	/**
	 * Initalize life count to 2 lives
	 */
	public LifeCounter() {
		lifeCount = 2;
	}
	
	/**
	 * Adds one more life (this is when player has gained 20 points)
	 */
	public void addLife() {
		lifeCount++;
	}
	
	/**
	 * Subtracts one life (this is when the player dies)
	 */
	public void removeLife() {
		lifeCount--;
	}
}
