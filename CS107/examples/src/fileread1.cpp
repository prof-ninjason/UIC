// read a file into memory
#include <iostream>     // std::cout
#include <fstream>      // std::ifstream

using namespace std;

int main() {
	string city;
	int hi, lo;
	string fcast;
	int fhi, flo;

	ifstream is;

	is.open("weatherdata.txt", ios::in);

	cout << "before loop" << endl;

	int i = 0;
	string cities[400];

	while (!is.eof()) {
		is >> city >> hi >> lo >> fcast >> fhi >> flo;

		cities[i] = city;
		i++;
		cout << city << ", Hi: " << hi << ", Lo: " << lo << endl;
	}

	for (int a = 0; a < i; a++) {
		cout << a << ". " << cities[a] << endl;
	}

	return 1;
}
