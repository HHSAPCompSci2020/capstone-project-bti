package game;

/**
 * Switches between screens
 * @author Riya Gupta
 * @version 5/17
 *
 */
public interface ScreenSwitcher {
	public static final int SCREEN1 = 0;
	public static final int SCREEN2 = 1;
	public static final int SCREEN3 = 2;
	public static final int SCREEN4 = 3;
	
	/**
	 * Switches the screen according to the parameter
	 * @param i the number that represents the screen
	 */
	public void switchScreen(int i);
}
