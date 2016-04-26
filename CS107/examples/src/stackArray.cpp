#include <iostream>

using namespace std;

struct stack {
	int *arr;     // The dynamic array to store the values
	int size;    // How many positions the dynamic array current holds
	int top; // Indicating the number of values currently stored in the dynamic array
};

// set the stack so it can initially hold 10 values
// set the Top of the Stack to be zero (zero values currently stored on the stack)
void init(stack & s) {
	s.arr = new int[10];
	s.size = 10;
	s.top = 0;
}

// the value in top also tells how many values are currently
// stored on the stack
bool isEmpty(stack s) {
	if (s.top == 0)
		return true;
	else
		return false;
}

// return the value at the top-1st position
//   but first verify the stack is not empty
int top(stack s) {
	if (isEmpty(s) == false)
		return (s.arr[s.top - 1]);   // note: the value of top does NOT change!
	else
		return -999;
}

// add a value to the stack
//   grow the array if needed
void push(stack & s, int val) {
	if (s.top == s.size) {
		// grow the array
		int *temp;
		temp = new int[s.size * 2];
		for (int a = 0; a < s.size; a++)
			temp[a] = s.arr[a];
		delete[] s.arr;
		s.arr = temp;
		s.size = s.size * 2;
	}

	s.arr[s.top] = val;
	s.top++;
}

// if the stack is not empty decrement the value of top
void pop(stack & s) {
	if (isEmpty(s) == false)
		s.top--;
}

int main() {
	stack s1;

	init(s1);

	// add a single value to the stack
	push(s1, 5);

	cout << top(s1) << endl;

	// clear the stack
	while (isEmpty(s1) == false) {
		cout << top(s1) << endl;
		pop(s1);
	}

	// add the value 10, 20, 30 ... 80, 90
	for (int i = 1; i < 10; i++) {
		push(s1, i * 10);
	}

	// remove all of the values from the stack
	// note the values are removed in the reverse of
	//   how they were pushed onto the stack
	while (isEmpty(s1) == false) {
		cout << top(s1) << endl;
		pop(s1);
	}

	// prompt the user to enter some values
	// quit when a negative value is entered
	// push all non-negative values onto the stack
	int val;

	do {
		cout << "Enter a value to push onto the stack (negative to stop): ";
		cin >> val;

		if (val >= 0)
			push(s1, val);
	} while (val >= 0);

	// remove all of the values from the stack
	// note the values are removed in the reverse of
	//   how they were pushed onto the stack
	while (isEmpty(s1) == false) {
		cout << top(s1) << endl;
		pop(s1);
	}

	return 1;
}

