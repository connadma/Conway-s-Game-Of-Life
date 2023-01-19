Info About Each Of Classes Here:

Cell Class:
This File Simply defines a cell on the grid of the game of life, giving it properties like being alive or dead.

Drawing Panel Class:
NOTE: I DID NOT WRITE THIS. This class was originally written by people at the University Of Stanford. It allows the use of a drawing panel
which is used in the Life GUI View to create a simple interactive way to run the Game Of Life.

Life Model:
This class contains methods that apply the rules of the game to cell, creates a copy of the grid, counts the alive neighbors of each cell as
well as a main method I used to test the methods within this, using a file named glider.dat. The file creading constructor uses .dat files so
make sure you have one in your source folder.

Life Console View:
This is the first way the project can be run. This diplays a text based menu in the console of your shell. It alows you to provide a .dat file,
increment that file by 1 or 100 generations, and stop the simulation whenever.

Life App:
this is just a quick method used to run Life GUI View for the drawing panel version of this porject.

Life GUI View:
This class is used to run the Drawing Panel which allows you to click cells to set them as alive and then press a red buttonin the top left to go
ahead one generation at a time. The green button next to the red button resets the board state.

Note:
You need a properly formatted .dat file to run this in your source folder otherwise this will not work. (At least the console version). 

:)
