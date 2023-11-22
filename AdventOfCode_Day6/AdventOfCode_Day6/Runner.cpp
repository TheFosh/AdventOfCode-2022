#include <iostream>
#include <fstream>
using namespace std;

string const FILEPATH = "PuzzleInput.txt";

int main(){

	ifstream inFile;

	try {
		inFile.open(FILEPATH);
		string errorMessage;
		if (inFile.fail())
			errorMessage = FILEPATH + "not found.";
			throw errorMessage;
	}
	catch (string e) {
		cout << e << endl;
	}




	return 0;
}