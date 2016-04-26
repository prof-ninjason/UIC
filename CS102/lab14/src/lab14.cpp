/*
 * lab14.cpp
 *
 *  Created on: Apr 26, 2016
 *      Author: jcrochon

 Sample Run of the initial version:

 CS 102 Lab 14:
 This program reads in integers and stores them in a linked list.
 Enter as many integers > 0 as you would like followed by the value -1.

 The numbers are: 3
 5
 7
 9
 -1

 List contains: 9 7 5 3

 Please select the number of one of these options:
 1. Sum the numbers in the list
 2. Local code to display and remove front element from the list
 3. Function to display and remove front element from the list
 4. Exit the program.

 Your choice: 1
 Answer is: 24

 For a lab score of 1: Add a menu option to find sum of only odd numbers in the list
 For a lab score of 2: Implement the code in place inside the switch statement to
 print and then remove the first element (the head) of the list.
 For a lab score of 3: Same as #2, except now write this in a function.

 */

#include <iostream>
#include <cstdlib>

using namespace std;

struct Node {
	int data;
	Node *nextPtr;
};

void displayList(Node *head) {
	Node *tempPtr = head;  // Used to traverse list without destroying head
	cout << "\n List contains: ";
	while (tempPtr != NULL) {
		cout << tempPtr->data << " ";
		tempPtr = tempPtr->nextPtr;
	}
	cout << "\n\n";
}

long processNumbers(Node *head) {
	Node *tempPtr = head;
	long result = 0;

	while (tempPtr != NULL) {
		result += tempPtr->data;
		tempPtr = tempPtr->nextPtr; 	// Advance to next list member
	}

	return result;
}

// For lab grade of 1:
// Write the code in the method below to find and return the sum of only the
// odd numbers in the list
long sumOddNumbers(Node *pHead) {
	Node *tempPtr = pHead;
	long result = 0;

	while (tempPtr != NULL) {
		result += tempPtr->data % 2 ? tempPtr->data : 0;
		tempPtr = tempPtr->nextPtr; 	// Advance to next list member
	}

	return result;
}

// For lab grade of 3:
// Declare the     displayAndRemoveFirstElement( ...)   function here.
// You will need to figure out the return type, any parameters and
// the code in the body of the function as well.
// ...
// There were several options for this, but the easiest would be to pass a pointer by reference
// If you would like to know about other solutions, ask Sean.
void displayAndRemoveFirstElement(Node* &pHead) {
	cout << "First number in list is: " << pHead->data;
	pHead = pHead->nextPtr;
}

int main() {
	int number = 0;      // Used to store numbers read in
	Node *pHead = NULL;   // head of linked list
	Node *tempPtr;       // Temporary node pointer used in reversing list
	int menuChoice;      // Menu choice

	cout << "CS 102 Lab 14: \n"
			<< "This program reads in integers and stores them in a linked list.\n"
			<< "Enter as many integers > 0 as you would like followed by the value -1.\n\n"
			<< "The numbers are: ";

	// loop to read in numbers
	while (number != -1) {
		cin >> number;
		if (number != -1) {
			tempPtr = new Node;
			// Insert each new input number at head of list
			tempPtr->data = number;
			tempPtr->nextPtr = pHead;
			pHead = tempPtr;
		}
	}
	displayList(pHead);

	cout << "Please select the number of one of these options: \n";
	cout << "   1. Sum the numbers in the list\n";
	cout << "   2. Sum only the odd numbers in the list\n";
	cout
			<< "   3. Local code to display and remove front element from the list \n";
	cout
			<< "   4. Function to display and remove front element from the list \n";
	cout << "   5. Exit the program.\n\n";
	cout << "Your choice: ";
	cin >> menuChoice;

	switch (menuChoice) {
	case 1:  // Sum numbers in list
		cout << "Answer is: " << processNumbers(pHead) << "\n";
		break;
	case 2:  // sum only the odd numbers in the list
		cout << "Sum of odd numbers is: " << sumOddNumbers(pHead) << "\n";
		break;

	case 3:  // For lab grade of 2 display and then remove first list element
		//if it was dynamically allocated Node* pTemp = pHead;
		cout << "First number in list is: " << pHead->data;
		pHead = pHead->nextPtr;
		//if it was dynamically allocated delete(pTemp);
		break;

	case 4: // For lab grade of 3 write a function to display and then remove first list element
		displayAndRemoveFirstElement(pHead);
		break;

	case 5:  // Exit the program
		exit(0);
		break;
	}
	displayList(pHead);

	// pause output display
	char c;
	cin >> c;

	return 0;
}
