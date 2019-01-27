# Reinforcment_Learning_ValueIteration

<h3> Project Description: </h3>
This below map is a discretized world for an agent which will randomly be in any of these states except for A and B.
An agent can make 4 moves in each state: North, East, West, and South. Each movement is done by probability.
When agent decides to go North, this action can be done with 0.6 probablity and two other actions which are Perpendicular to the
current movement might be done with 0.2 probablity. If any action causes that agent will go out of the map, aget will be punished with 
-1 reward. If agent can get to A and B it will recive 10 and 5 as reward value and then will be directed to C and D. </br>
<h3> Map:</h3>
[Map](https://www.dropbox.com/s/lfr8508m4429zc8/Map.png?dl=0) </br>
<h3> Result: </h3>
Result is an 2d array in which state the policy is stated. It means that if agent is in that state it is recommend that it follows the policy.
<h3> Policy Map </h3>
This is the policy map when the reward value for going out of map is -1 and gamma parameter is 0.1. 
According to the Belman equation, if you increase the gamma parameter then it will take longer for the algorithm to converge.</br>
------------</br>
|E|D|W|C|W|</br>
------------</br>
|E|N|N|N|W|</br>
------------</br>
|E|N|N|N|W|</br>
------------</br>
|E|N|N|N|W|</br>
------------</br>
|N|N|N|N|N|</br>
------------</br>
Then the policy map when the reward value for going out og map is 10. </br>
-----------</br>
|E|D|W|C|W|</br>
-----------</br>
|E|N|W|N|W|</br>
-----------</br>
|E|N|N|N|W|</br>
-----------</br>
|E|N|N|N|W|</br>
-----------</br>
|N|N|N|N|N|</br>
-----------</br>
and when the reward value for going out of map is 0 the policy map is defined as below: </br>
-----------</br>
|E|D|W|C|W|</br>
-----------</br>
|N|N|N|N|N|</br>
-----------</br>
|N|N|N|N|N|</br>
-----------</br>
|N|N|N|N|N|</br>
-----------</br>
|N|N|N|N|N|</br>
-----------</br>

<h3> Algorithm : </h3>
For developing this project Reinforcment Learning is used and Dynamic Programming which is one RL algorithm is implemented.
For defining the Policy we used Vale Iteration. </br>
We have different methods which I will make an explanation for them. </br>
1 - public void intialMap(int PosX, int PosY): </br>
This method will recieve two integer as agent current place and initiliez the map. </br>
2 - public void  UpdateUtility(int Row,int column): </br>
This method will update each poition utility based on Value Iteration and 4 possible moves. </br>
3 - public double Northmove(int Row, int column) and 3 other actions: </br>
These method check that in this postition is this action applicable or not and sets utility for the position. </br>
4 - public void printmap(): </br>
This method pritns tha map. </br>
5 - public void ValueIteration(): </br>
In this method Value Iteration algorithm is implemented. </br>
6 - public static void agentrun(): </br>
Finally in this method we first generate a random position for current Agent place. And we run the algorithm. </br>

<h2> Author:</h2>
Masoud Erfani </br>
Hope you enjoy it.
