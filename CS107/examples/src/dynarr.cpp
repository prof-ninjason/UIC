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
	string *dynarr;
	int daSize = 10;

	dynarr = new string[daSize];

	is >> city;

	while (!is.eof()) {
		is >> hi >> lo >> fcast >> fhi >> flo;

		if (i >= daSize) {
			cout << "Doubling Size of Dyn Arr to " << daSize * 2 << endl;
			string *temp;
			temp = new string[daSize * 2];
			for (int a = 0; a < daSize; a++)
				temp[a] = dynarr[a];
			delete[] dynarr;
			dynarr = temp;
			daSize = daSize * 2;
		}

		cities[i] = city;
		dynarr[i] = city;
		i++;
		cout << city << ", Hi: " << hi << ", Lo: " << lo << endl;

		is >> city;
	}

	for (int a = 0; a < i; a++) {
		cout << a << ". " << cities[a] << ", " << dynarr[a] << endl;
	}

	return 1;
}
