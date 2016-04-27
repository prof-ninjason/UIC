/* This program is to do something
 *
 * Writeen by:   Some Person
 * on:           Some Date
 * for:          Some Class
 *
 */

#include <iostream>

using namespace std;

int main() {
	double weight, factor = 0;
	string planet;

	cout << "Begin Execution" << endl;

	// Print information about the author
	cout << "Author: Jason C. Rochon" << endl;
	cout << "UIN:    123456789" << endl;
	cout << "CS 107 - Summer 2015" << endl;
	cout << "Lab Assignment 1" << endl;
	cout << "Lab Time: Wednesday at 10am" << endl;

	cout << "Please enter your weight: ";
	cin >> weight;

	cout << "Please enter the planet: ";
	cin >> planet;

	if (planet == "Mercury") {
		factor = 0.4155;
	}
	else if (planet == "Venus") {
		factor = 0.8975;
	}
	else if (planet == "Earth") {
		factor = 1.0;
	}
	else {
		cout << "Planet does not exist..." << endl;
		cout << "End Execution" << endl;
		return (0);
	}

	cout <<"On planet "<< planet << " you would weight: " << (weight * factor) << " lbs." << endl;
	cout << "End Execution" << endl;
	return 0;
}

/*
 Mercury	0.4155
 Venus		0.8975
 Earth		1.0
 Moon		0.166
 Mars		0.3507
 Jupiter	2.5374
 Saturn		1.0677
 Uranus		0.8947
 Neptune	1.17794
 Pluto		0.0899
 */
