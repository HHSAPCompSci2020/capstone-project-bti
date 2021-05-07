AP Computer Science Final Project - README


Instructions:
The first step in creating an excellent APCS final project is to write up a README. At this stage, this README file acts as your project proposal. Once you’ve filled in all components, Shelby will read through it and suggest edits. Ultimately, you need a document that adequately describes your project idea and we must agree on this plan.


Have one member of your group make a copy of this Google Doc. Then, they should share it with all other members and with Mr. Shelby so that every group member has edit permissions, and Shelby can add comments on your ideas.


There’s a lot of parts of this document that you might not have full answers for yet. Because you haven’t written the program yet, it’s difficult to think about the instructions or which group members will do which parts. Even though this is hard to think about, you must have something in these sections that acts as your current plan. However, during the course of the project, you’ll continuously update this document. This means that you will not be held to exactly what you put here - components of this document can change (and it’s pretty common!).


There is one exception: the Features List section. Once Shelby OKs your README, the Features List section cannot be modified. For this reason, it is most important that you get a solid idea of what you want to make and the primary features it will have now.


Talk with your group. Consider drawing some pictures of what you think your project might look like. Be precise. When you’re ready, fill this out together. Each component in brackets below ( [these things] ) should be replaced with your ideas. Note that there are several sample READMEs posted on this assignment for you to use as guidance.


-------------------When README is finalized, remove everything above this line--------------------


Bridging the Isles
Authors: Riya Gupta, Kasturi Sinha, and Samantha Sung
Revision: May 4, 2021


Introduction:
[In a few paragraphs totaling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:
What does your program do?
What problem does it solve? Why did you write it?
What is the story?
What are the rules? What is the goal?
Who would want to use your program?
What are the primary features of your program?]
Bridging the Isles is an interactive game designed for anyone on a computer who would like to cure their boredom and simulate survival. It is a game that allows players to twiddle their fingers for good, and it brings awareness to the human instinct that kicks in when we go into survival mode. The story goes like this: 
You, the player, are trapped on a strange isle surrounded by water. The land is tiny, but it is tall, so if you ever fall, you will fall to your death. However, there is a path of isles that can follow. These isles are the same height, but they vary in area and distance from other isles. Good thing you are equipped with the power of building bridges to go from isle to isle! By testing your estimating powers and abilities, you will create a simple bridge in the vertical direction, and it will fall to its horizontal orientation. If your bridge is the correct length to connect the isle you are currently on to the next one, you survive. If your bridge is too short or too long to land on the isle, you die and lose a life[a][b][c]. Continue to build bridges and rack up points. There may be some challenges along the way, but trust in your hands and instincts, because they can guide you to safety!


Instructions:
[Explain how to use the program. This needs to be specific: 
Which keyboard keys will do what? 
Where will you need to click? 
Will you have menus that need to be navigated? What will they look like? 
Do actions need to be taken in a certain order?]
1. On the starting screen, you have the option to choose the easy mode or the hard mode. Click on the button of the level you choose
2. Once the game starts, you (a stick figure) are automatically placed on the first isle with the second one to the right. The points on the top left corner display 0.
3. Press on the ‘space’ button for the bridge to continue to get built. It gets longer in the vertical direction.
4. Stop pressing the ‘space button’ once you think the bridge is the correct length
5. The bridge falls so that its starting point is on the edge of the isle, and the bridge is now in the horizontal direction
6. The end point of the bridge determines the course of the game. Steps 7-10 are if you live and Steps 11-12 are if you die.
7. You live if your bridge connects to the next island, and you receive a point. You receive bonus points based on how close you get to the middle of the isle.
8. You move across the bridge to stand in the middle of the next island. 
9. The isles shift to the left and another isle appears. In the easy mode, the isles are random sizes, and in the hard mode, the isle continually gets smaller.
10. Repeat steps 3-6
11. You die if your bridge is either too short or too long to connect the two isles. You do not receive a point and fall into the water
12. Once you die, you are reverted back to the starting screen. Your point score is displayed at the top.
**Click on the ‘X’ button on the top right hand corner to exit the game. You go back to the starting screen to try the other level of just stop completely


Features List:
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
* There is a person (stick figure) that moves along the bridge that the player draws.
* There is a point counter.
   * The player gets a point every time they successfully cross to the next island.
* The player can build a bridge by pressing the space button, and the longer the player presses, the longer the bridge gets.[d][e]
* The game automatically builds a new isle
   * Once the player gets to the isle, the screen slides to the left to reveal the next isle
* The player loses the game by making the bridge too short (it doesn’t reach the isle) or too long (it goes longer than the right edge of the isle)


Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
* Each isle has a target on it.
   * If the end of the bridge lands in the innermost area, you get the most bonus points. Landing in the second “tier” gives you some bonus points, and landing in the outermost “tier” gives you no bonus points
* Players have lives, and once they run out of lives, the game ends.
   * Players start with 2 lives and you lose a life when you fail to create a bridge (the bridge is too long or too short)
   * Every 20 points, you receive an extra chance (aka an extra life).
* The player can choose whether they want to play the easy mode or the hard mode.
   * For the hard mode, the width of the island decreases as the game progresses. 
* The invisible bridge version: When pressing the spacebar, the player will not be able to see the length of the bridge that they are drawing.
* Speed version: The game speeds up and the bridges are drawn more rapidly as the game progresses.




Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
* The isles are different heights, so instead of drawing a 1D bridge, the bridge will be 2D (a rectangle)
   * The player will need to estimate both the height and the width of the bridge when drawing.
* There is a leaderboard/high score system where players can compare their scores to past rounds.
* The bridges are not horizontal but zig-zag lines, which makes it more difficult to estimate the appropriate distance for creating a bridge.


Class List:
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]
* Main - contains the main method, creates GameWindow
* MenuPanel - the window that displays the game and contains the initial drop-down menu to choose the level 
* DrawingSurface - displays the instructions at the start of the game and any other button necessary during the game, sets the background at the start of the game 
* MovingImage (superclass) - class that represents any object in the game that moves or shifts to the left after one level is completed
   * Subclasses: Person, Bridges, Isle
* Person - representing the person who is walking across the bridges and isles 
* OriginalBridge (superclass) - a graphical component that is vertically “built” by the player when he/she presses the space button and horizontally falls to connect the Person to the adjacent Isle
   * As the game speeds up, the bridges are built faster
   * Subclasses: Types of Bridges (ex. Invisible Bridge, 2D Bridge, Zig-Zag Bridge)
      * Each subclass is graphically different than the OriginalBridge, but otherwise works in the same way[f][g]
* Isle - rectangular components that appear on the screen once the previous isle has been crossed
   * Width of Isle depends on Game “mode”
   * Contain “targets,” checks where the bridge ends and assigns points accordingly
* PointSystem - displays the points on the DrawingSurface and changes according to the targets on the isle
* LifeCounter - displays the lives that the Person has left at the top-right hand corner of the screen and is updated when the bridge fails.




Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]
* Riya:
   * Building the bridge
      * Includes variations like building an invisible bridge, etc.
   * Calculating points & lives
   * Classes: OriginalBridge, PointSystem, LifeCounter
* Kasturi: 
   * Isle-related methods
      * GUI
      * Target
      * Moving to the left every time the player successfully crosses an isle 
   * Classes: Isles, Main, DrawingSurface
* Samantha:
   * GUI for the person
   * Instructions for the game
   * Methods deciding if the player has lost or can continue the game
   * Classes: Person, GameWindow, Panels
* Using the Processing library for GUI methods 
* Mentors: Ankur & Vipul (Riya’s cousins)
   * Helped with brainstorming


