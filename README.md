# BowlingAlley
Bowling Alley
Write machine code for a single-lane bowling alley system.
One bowling game will be played by multiple players on a single lane. During the game, players
and their scores will be maintained and shown by the system and the winner will be declared at
the end of the game.
Some rules about bowling:

● The Game of bowling consists of 5 Rounds.

● Each round consists of alternate plays (one by each player), and each player will have
two chances to drop all the “pins”

● The score for a round is the total number of pins knocked down, plus bonuses for
strikes and spares.

● A strike is when the player knocks down all ten pins on the first try. If there is a strike
the player gets 10 bonus points.

● A spare is when the player knocks down all ten pins in two tries. If there is spare the
player gets 5 bonus points.

● In the final round, a player who rolls a spare or a strike is allowed to roll extra 2 balls(not
rounds) to complete the round. This allows for a potential of 7 strikes (5+2) in a single
game.

● Strike is denoted by ‘x’ and spare is denoted by ‘/’. All other pin drop count can be
denoted by 0 - 9 (for ex: 5, if five pins were dropped in a round)

● After the final round, display the Player list in ranked order on the basis of score.
Bonus Point: (Only Attempt If Time Permits)

Changing Bonus Rule: Bonus points are awarded, depending on what is scored in the next 2
balls (for a strike) or next 1 ball (for a spare).

Input:
No. of players
Score Input can be taken from fileInput or console.
Output:
Current position of the running games (Scoreboard) and after the final round, display players in
ranked order on the basis of score.
Example:
Below example is for 3 Rounds
Input:
Number of players: 2
Round 1:
Enter Score for Player1 - Chance1: 8
Enter Score for Player1 - Chance2: 2
*********************************************************
Player1 Score Chance1 - 8pins Chance2 - 2pin
*********************************************************
Scoreboard:
P1: {8,/} -> 15 (10+5)
P2: {} -> 0
Enter Score for Player2 - Chance1: 10
*********************************************************
Player2 Score Chance1 - 10pins
*********************************************************
Scoreboard:
P1: {8,/} -> 15
P2: {X,} -> 20 (10+10)
*********************************************************
Round 2:
Enter Score for Player1 - Chance1: 2
Enter Score for Player1 - Chance2: 7
*********************************************************
Player1 Score Chance1 - 2pins Chance2 - 7pin
*********************************************************
Scoreboard:
P1: {8,/}, {2,7} -> 24 (15+9)
P2: {X,}, {} -> 20
Enter Score for Player2 - Chance1: 6
Enter Score for Player2 - Chance2: 4
*********************************************************
Player2 Score Chance1 - 6pins Chance2 - 4pin
*********************************************************
Scoreboard:
P1: {8,/}, {2,7} -> 24
P2: {X,}, {6,/} -> 35 (20+10+5)
*********************************************************
Round 3:
Enter Score for Player1 - Chance1: 10
Enter Score for Player1 - Chance2: 8
Enter Score for Player1 - Chance3: 2
*********************************************************
Player1 Score Chance1 - 10pins
Player1 Score Chance2 - 8pins Chance3 - 2pin (Extra
chance as all pins were dropped in last round)
*********************************************************
Scoreboard:
P1: {8,/}, {2,7}, {X,}, {8,/} -> 59 (24+(10+10)+(10+5)) P2:
{X, }, {6, /}, {} -> 35
Enter Score for Player2 - Chance1: 3
Enter Score for Player2 - Chance2: 4
*********************************************************
Player2 Score Chance1 - 3pins Chance2 - 4pin
*********************************************************
Scoreboard:
P1: {8,/}, {2,7}, {X, }, {8,/} -> 59 P2: {X, }, {6, /},
{3,4} -> 42 (35+3+4)
*********************************************************
Final Output:
P1 - 59 points (winner)
P2 - 42 points
Example for bonus question:
Strike:
Round 1, ball 1: 10 pins (strike)
Round 2, ball 1: 3 pins
Round 2, ball 2: 6 pins
The total score from these throws is:
Round one: 10 + (3 + 6) = 19
Round two: 3 + 6 = 9
TOTAL = 28
Spare:
Round 1, ball 1: 7 pins
Round 1, ball 2: 3 pins (spare)
Round 2, ball 1: 4 pins
Round 2, ball 2: 2 pins
The total score from these throws is:
Round one: 7 + 3 + 4 (bonus) = 14
Round two: 4 + 2 = 6
TOTAL = 20
