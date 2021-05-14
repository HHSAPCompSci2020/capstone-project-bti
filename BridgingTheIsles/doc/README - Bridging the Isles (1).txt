AP Computer Science Final Project - README
Bridging the Isles
Authors: Riya Gupta, Kasturi Sinha, and Samantha Sung
Revision: May 14, 2021


Introduction:
Bridging the Isles is an interactive game designed for anyone on a computer who would like to cure
their boredom and simulate survival. It is a game that allows players to twiddle their fingers for good,
and it brings awareness to the human instinct that kicks in when we go into survival mode. The story 
goes like this: 
You, the player, are trapped on a strange isle surrounded by water. The land is tiny, but it is tall, so if 
you ever fall, you will fall to your death. However, there is a path of isles that can follow. These isles 
are the same height, but they vary in area and distance from other isles. Good thing you are equipped 
with the power of building bridges to go from isle to isle! By testing your estimating powers and 
abilities, you will create a simple bridge in the vertical direction, and it will fall to its horizontal 
orientation. If your bridge is the correct length to connect the isle you are currently on to the next one, 
you survive. If your bridge is too short or too long to land on the isle, you die and lose a life[a][b][c][d][e]. Continue 
to build bridges and rack up points. There may be some challenges along the way, but trust in your 
hands and instincts, because they can guide you to safety!


Instructions:
1. On the starting screen, you have the option to choose the easy mode or the hard mode. Click
on the button of the level you choose
2. Once the game starts, you (a stick figure) are automatically placed on the first isle with the
second one to the right. The points on the top left corner display 0.
3. Press on the ‘space’ button for the bridge to continue to get built. It gets longer in the vertical
direction.
4. Stop pressing the ‘space button’ once you think the bridge is the correct length
5. The bridge falls so that its starting point is on the edge of the isle, and the bridge is now in the
horizontal direction
6. The end point of the bridge determines the course of the game. Steps 7-10 are if you live and
Steps 11-12 are if you die.
7. You live if your bridge connects to the next island, and you receive a point. You receive bonus
points based on how close you get to the middle of the isle.
8. You move across the bridge to stand on the second isle. You will stop once you get off the bridge.
9. The isles shift to the left and another isle appears. In the easy mode, the isles are random sizes, and in the hard mode, the isle continually gets smaller.
10. Repeat steps 3-6
11. You die if your bridge is either too short or too long to connect the two isles. You do not receive
a point and fall into the water
12. Once you die, you are reverted back to the starting screen. Your point score and life counter is displayed at the
top.
**Click on the ‘X’ button on the top right hand corner to exit the game. You go back to the
starting screen to try the other level of just stop completely


Features List:
Must-have Features:
* (DONE) There is a person (stick figure) that moves along the bridge that the player draws.
* (DONE) There is a point counter.
   * The player gets a point every time they successfully cross to the next island.
* (DONE) The player can build a bridge by pressing the space button, and the longer the player presses,
 the longer the bridge gets.
* (DONE) The game automatically builds a new isle
   * Once the player gets to the isle, the screen slides to the left to reveal the next isle
* (DONE) The player loses the game by making the bridge too short (it doesn’t reach the isle) or too long (it goes longer than the right edge of the isle)


Want-to-have Features:
* (DONE) Each isle has a target on it.
   * If the end of the bridge lands in the innermost area, the player gets the most bonus points. Landing in the second “tier” gives them some bonus points, and landing in the outermost “tier” gives them no bonus points
* (WORKING ON) The players have lives, and once they run out of lives, the game ends.
   * Player start with 2 lives and they lose a life when they fail to create a bridge (the bridge is too long or too short)
   * Every 20 points, the player receives an extra chance (aka an extra life).
* The player can choose whether they want to play the easy mode or the hard mode.
   * For the hard mode, the width of the island decreases as the game progresses. 
* The invisible bridge version: When pressing the spacebar, the player will not be able to see the length of the bridge that they are drawing.
* Speed version: The game speeds up and the bridges are drawn more rapidly as the game 
progresses.


Stretch Features:
* The isles are different heights, so instead of drawing a 1D bridge, the bridge will be 2D (a 
rectangle)
   * The player will need to estimate both the height and the width of the bridge when 
drawing.
* There is a leaderboard/high score system where players can compare their scores to past 
rounds.
* The bridges are not horizontal but zig-zag lines, which makes it more difficult to estimate the 
appropriate distance for creating a bridge.


Class List:
* Main - contains the main method, creates GameWindow
* Screen (abstract) 
   * MenuScreen -  displays the instructions and menu (for the levels) at the start of the game 
   * GameScreen - displays the objects necessary when playing the game
* ScreenSwitcher (interface): simply switches between the screen 
   * DrawingSurface implements ScreenSwitcher - “control center” for the screens
* Person - representing the person who is walking across the bridges and isles 
* OriginalBridge (superclass) - a graphical component that is vertically “built” by the player when 
he/she presses the space button and horizontally falls to connect the Person to the adjacent 
Isle
   * As the game speeds up, the bridges are built faster
   * Subclasses: Types of Bridges (ex. Invisible Bridge, 2D Bridge, Zig-Zag Bridge)
      * Each subclass is graphically different than the OriginalBridge, but otherwise works in the same way[j][k]
* Isle - rectangular components that appear on the screen once the previous isle has been 
crossed
   * Width of Isle depends on Game “mode”
   * Contain “targets,” checks where the bridge ends and assigns points accordingly
* PointSystem - displays the points on the DrawingSurface and changes according to the targets 
on the isle
* LifeCounter - displays the lives that the Person has left at the top-right hand corner of the 
screen and is updated when the bridge fails.




Credits:
* Riya:
   * Help with UML Diagram
   * Initial skeleton classes
   * Building the bridge
      * Includes variations like building an invisible bridge, etc.
   * Calculating points & lives
   * Classes: OriginalBridge, PointSystem, LifeCounter
* Kasturi: 
   * Updated README when necessary
   * Help with UML Diagram
   * Create all of the Javadoc comments
   * Isle-related methods and implementation
      * Target
      * Moving to the left every time the player successfully crosses an isle 
   * Classes: Isles, Main, DrawingSurface, GameScreen 
* Samantha:
   * Help with UML Diagram
   * Create jar file and javadoc html documentation
   * Code classes allowing the basic game to function (the component’s movements)
   * Classes: Person, OriginalBridge, Isle, DrawingSurface, PointSystem, LifeCounter
   * Instructions for the game


* Using the Processing library for GUI methods
* Used Mr. Shelby’s AnimationDemoProcessing project to guide the initial graphics
* Mentors: Ankur & Vipul (Riya’s cousins)
   * Helped with brainstorming

