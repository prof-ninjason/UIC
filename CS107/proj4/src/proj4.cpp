/*
 * proj4.cpp
 *
 *  Created on: Apr 28, 2016
 *      Author: jcrochon
 */
/*
 The following is to determine if a word exists in the boggle grid.
 It is a recursive algorithm.  Note this is given in psuedo-code,
 so you will need to translate it to match how you have implemented
 the rest of your program.

 It uses two functions and only one is recursive.  The first
 function looks for the first letter in the given word, then calls
 the second function to determine if the remaining letters actually
 exist in the boggle grid.

 Note: this does not solve for the Q/Qu case.  A modification is
 needed that will be discussed during lecture.

 bgboard is assumed to be a 2D array of characters
 word is assumed to be a string


 bool bgfind1 (bgboard, word)
 {
 Set all letters to unused

 For (i = 1; i <= 4; i++ )
 For (j = 1; j <= 4; j++ )
 If ( bgboard [i][j] == word.at(0) )
 {
 if (bgfind (bgboard, i, j, word, 1) == true)
 Return true
 }

 Return false
 }


 bool bgfind ( bgboard, x, y, word, pos)
 {
 If (word.length == pos)
 Return true

 Bgboard[x][y] is set to used

 For (i = -1; i <= 1; i++ )
 For (j = -1; j <= 1; j++ )
 If ( bgboard[x+i][y+j] is unused &&
 bgboard[x+i][y+j] == word.at(pos) )
 If ( bgfind (bgboard, x+i, y+j, word, pos+1) == true )
 Return true

 Bgboard[x][y] is set to unused
 Return false
 }

 */
#include <stdlib.h>
#include <stdio.h>
#include <iostream>
#include <ctime>

using namespace std;

void printAuthor(int proj) {
	// Print information about the author
	cout << "Author: Jason C. Rochon" << endl;
	cout << "UIN:    123456789" << endl;
	cout << "CS 107 - Summer 2015" << endl;
	cout << "Lab Assignment " << proj << endl;
	cout << "Lab Time: Wednesday at 10am" << "\n\n\n";
}

int main(void) {
	time_t now, then;
	double seconds;
	// get the starting time
	time(&now);

	printAuthor(4);

	// get the ending time
	time(&then);
	seconds = difftime(then, now);
	cout << "This took " << seconds << " seconds." << endl;
	return (0);
}
