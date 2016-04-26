/**
 * Lab 11 Solution
 * @author Jason C. Rochon
 */

#include <iostream>

using namespace std;

int add(int num1, int num2) {
	return num1 + num2;
}

int subtract(int num1, int num2) {
	return num1 - num2;
}

int multiply(int num1, int num2) {
	return num1 * num2;
}

int divide(int num1, int num2) {
	return num1 / num2;
}

int main() {
	//input
	int done = 0;
	int num1, num2, result = 0;
	char yn, finish, operand;

	while (!done) {
		cout << "Use memory as first number (Y/N)? ";
		cin >> yn;
		finish = toupper(yn);

		if (finish == 'Y') {
			num1 = result;
		} else {
			cout << "Enter the first number: ";
			cin >> num1;
		}
		cout << "Which operation would you like to perform (+,-,*,/)? ";
		cin >> operand;
		cout << "Enter the second number: ";
		cin >> num2;

		switch (operand) {
		case '+':
			result = add(num1, num2);
			break;
		case '-':
			result = subtract(num1, num2);
			break;
		case '*':
			result = multiply(num1, num2);
			break;
		case '/':
			result = divide(num1, num2);
			break;
		default:
			result = 0;
		}
		cout << "The result of " << num1 << " " << operand << " " << num2
				<< " is " << result << "." << endl;

		cout << "Do you wish to continue (Y/N)? ";
		cin >> yn;
		finish = toupper(yn);

		done = (finish != 'Y');
	}

	return 0;

}
