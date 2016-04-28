/*
 * proj3.cpp
 *
 *  Created on: Apr 28, 2016
 *      Author: jcrochon
 */

#include <stdlib.h>
#include <stdio.h>
#include <iostream>

using namespace std;

void printAuthor(int proj) {
	// Print information about the author
	cout << "Author: Jason C. Rochon" << endl;
	cout << "UIN:    123456789" << endl;
	cout << "CS 107 - Summer 2015" << endl;
	cout << "Lab Assignment " << proj << endl;
	cout << "Lab Time: Wednesday at 10am" << "\n\n\n";
}

void foo(int &p) {
	cout << "p: " << p << endl;
	p = 1;
	cout << "p: " << p << endl;
}

int main(void) {
	printAuthor(3);

	int a = 7;
	cout << "a: " << a << endl;
	foo(a);
	cout << "a: " << a << endl;

	return (0);
}
