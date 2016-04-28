/*
 * proj2.cpp
 *
 *  Created on: Apr 27, 2016
 *      Author: jcrochon
 */

#include <stdlib.h>
#include <stdio.h>
#include <iostream>

using namespace std;

void printAuthor(void) {
	// Print information about the author
	cout << "Author: Jason C. Rochon" << endl;
	cout << "UIN:    123456789" << endl;
	cout << "CS 107 - Summer 2015" << endl;
	cout << "Lab Assignment 1" << endl;
	cout << "Lab Time: Wednesday at 10am" << "\n\n\n";
}

int main() {
	printAuthor();

	const int ARRSIZE = 4;
	int code[ARRSIZE];
	int guess[ARRSIZE];
	int i, num, numCorrect = 0;
	srand(time(0));

	// to generate the code:
	for (i = 0; i < ARRSIZE; i++) {
		code[i] = rand() % 6 + 1; //formula to generate a value from 1 to 6.
	}

	// to print the code:
	for (i = 0; i < ARRSIZE; i++) {
		cout << code[i] << " ";
	}

	// ask user for their guess
	for (i = 0; i < ARRSIZE; i++) {

		cout << "Please enter a number between 1 and 6: ";
		cin >> num;
		guess[i] = num;

		if (num < 0 || num > 7) {
			cout << "Please enter a number between 1 and 6: ";
			cin >> num;

		}
	}

	for (i = 0; i < ARRSIZE; i++) {
		if (code[i] == guess[i])
			numCorrect = numCorrect + 1;
	}

	cout << "The number of correct code values in their correct "
			<< "positions are: " << numCorrect << endl;

	return (0);
}
