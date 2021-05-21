AP Computer Science Final Project - README
Bridging the Isles
Authors: Riya Gupta, Kasturi Sinha, and Samantha Sung
Revision: May 21, 2021


Introduction:
Bridging the Isles is an interactive game designed for anyone on a computer who would like to cure their boredom and simulate survival. It is a game that allows players to twiddle their fingers for good, and it brings awareness to the human instinct that kicks in when we go into survival mode. The story  goes like this: 
You, the player, are trapped on a strange isle surrounded by water. The island is tiny, but it is tall, so if you ever fall, you will fall to your death. However, there is a path of isles that you can follow. These isles are the same height, but they vary in area and distance from other isles. Good thing you are equipped with the power of building bridges to go from isle to isle! By testing your estimating powers and abilities, you will build a simple bridge in the vertical direction, and it will fall to its horizontal orientation. If your bridge is the correct length to connect the isle you are currently on to the next one, you survive. If your bridge is too short or too long to land on the isle, you die and lose a life. Continue to build bridges and rack up points. There may be some challenges along the way, but trust in your hands and instincts, because they can guide you to safety!


Instructions:
1. There is a menu where you can choose which level to play: original, invisible bridge, or speeding bridge. You can also exit the program.
2. You will be taken to a deserted isle. Press on the space button for a bridge to build in the vertical direction. The Invisible Bridge will not be shown while built; The Speeding Bridge builds faster the longer you press. 
3. Release once you think the bridge is the correct length to connect the two islands. 
4. The bridge falls, and the endpoint determines if you succeed.
5. If you succeed, the person walks across the bridge to get to the next island, and everything moves left to reveal the next island. Make sure to wait for everything to stop moving before pressing the spacebar to build the next bridge.
6. The closer the bridge lands to the middle of the isle, the more points you receive
7. Every time you get 20 more points, you receive another life. Every time you fall off the isle, you lose a life. When you run out of lives, your points are displayed and you have the option to restart the game, go back to the menu, or exit the program.
8. While playing, you can always choose to restart, go to the menu, or exit.


Features List:
Must-have Features:
* (DONE) There is a person (stick figure) that moves along the bridge that the player draws.
* (DONE) There is a point counter.
   * The player gets a point every time they successfully cross to the next island.
* (DONE) The player can build a bridge by pressing the space button, and the longer the player presses, the longer the bridge gets.
* (DONE) The game automatically builds a new isle
   * Once the player gets to the isle, the screen slides to the left to reveal the next isle
* (DONE) The player loses the game by making the bridge too short (it doesn’t reach the isle) or too long (it goes longer than the right edge of the isle)


Want-to-have Features:
* (DONE) Each isle has a target on it.
   * If the end of the bridge lands in the innermost area, the player gets the most bonus points. Landing in the second “tier” gives them some bonus points, and landing in the outermost “tier” gives them no bonus points
* (DONE) The players have lives, and once they run out of lives, the game ends.
   * Player start with 2 lives and they lose a life when they fail to create a bridge (the bridge is too long or too short)
   * Every 20 points, the player receives an extra chance (aka an extra life).
* The player can choose whether they want to play the easy mode or the hard mode.
   * For the hard mode, the width of the island decreases as the game progresses. 
* (DONE) The invisible bridge version: When pressing the spacebar, the player will not be able to see the length of the bridge that they are drawing.
* (DONE) Speed version: The game speeds up and the bridges are drawn more rapidly as the game progresses.


Stretch Features:
* The isles are different heights, so instead of drawing a 1D bridge, the bridge will be 2D (a  rectangle)
   * The player will need to estimate both the height and the width of the bridge when drawing.
* There is a leaderboard/high score system where players can compare their scores to past rounds.
* The bridges are not horizontal but zig-zag lines, which makes it more difficult to estimate the  appropriate distance for creating a bridge.


Class List:
* Main - contains the main method, creates the window for the game
* Screen (abstract) - represents a screen in the game
   * MenuScreen -  displays the instructions and menu for the levels at the start of the game 
   * GameScreen - displays the objects necessary when playing the game
   * DeadScreen - displays the buttons and points after all lives are lost
* ScreenSwitcher (interface): simply switches between the screens 
   * DrawingSurface implements ScreenSwitcher - “control center” for the screens
* Person - represents the person who is walking across the bridges to the next isle. 
* OriginalBridge - a graphical component that is vertically “built” by the player when he/she presses the space button and once the spacebar is release, falls to horizontally connect the Person to the adjacent isle
   * InvisibleBridge - functions the same as an OriginalBridge but isn’t visible when being built
   * SpeedingBridge - functions the same as an OriginalBridge, but builds faster the longer the player presses the spacebar.
* Isle - rectangular components that appear on the screen once the previous isle has been crossed. They contain “targets,” which check where the bridge ends and assigns points accordingly.
* PointSystem - displays the points on the screen and changes according to where the Person lands on the targets on the isle
* LifeCounter - displays the number of lives that the Person has left at the top-right hand corner of the screen and is updated when the bridge fails.


Credits:
* Riya:
   * Update README when necessary
   * Help with UML Diagram
   * Initial skeleton classes
   * Create structure of the game
   * Set up game to run with different screens
   * Classes: DrawingSurface, Main, MenuScreen, Screen, ScreenSwitcher, 
* Kasturi: 
   * Update README when necessary
   * Help with UML Diagram
   * Create Javadoc comments
   * Target on Isle implementation
   * DeadScreen implementation
   * Classes: GameScreen, Isle, Main, MenuScreen, Person
* Samantha:
   * Updated README when necessary
   * Create jar file and Javadoc html documentation
   * Code classes allowing the game to function (the component’s movements)
   * Classes: GameScreen, InvisibleBridge, Isle, LifeCounter, OriginalBridge, Person, PointSystem, SpeedingBridge


* Use the Processing library for GUI methods
* Use Mr. Shelby’s ProcessingScreenSwitching project to guide the menu graphics
* Mentors: Ankur & Vipul (Riya’s cousins)
   * Helped with brainstorming