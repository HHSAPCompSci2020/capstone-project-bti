package game;
/**
 * Switches between screens
 * @author Samantha Sung
 * @version 5/13
 *
 */

public interface ScreenSwitcher {
	public static final int SCREEN1 = 0;
	public static final int SCREEN2 = 1;
	
	public void switchScreen(int i);
}
