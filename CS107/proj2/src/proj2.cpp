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
int doit(void);

int main() {

	srand(time(0));
	int num = 0;
	cout << "Please enter a num: ";

	cin >> num;

	cout << "num: " << num << endl;

	cout << "rand: " << doit();
	return (0);
}

int doit(void) {

	for (int i = 0; i < 33; i++) {
		int number = rand() % 10;
		cout << number << endl;
	}

	return (0);
}
