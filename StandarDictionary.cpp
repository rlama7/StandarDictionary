/**
 * @file		main.cpp
 * @author		Ratna Lama
 * @author 		Jerry Wong
 * @brief 		CSC 340 : Part III
 * 
 * @section		DESCRIPTION
 * 
 * A progrm to implement interactive dictionary using data structure
 * 
 */
#include<iostream>
#include<fstream>
#include<sstream>
#include<vector>
#include<algorithm>
using namespace std;

bool containsInt(string);


int main() {

	//
	// Opens file, loads data, and closes file.
	// Reads file by line, parses based off that line spacers and 
	// stores everything into the string vector.After that’s done, 
	// store that string vector inside the parent vector.
	//

	vector<vector<string>> dictionary;
	ifstream file("../Data.CS.SFSU.txt");	// Very important this path name works on Codelite IDE
	string line, data;						// In other you might need to omit "../"

	cout << "! Opening data file... ./Data.CS.SFSU.txt" << endl;
	if (!file) return 0;

	cout << "! Loading data..." << endl;
	while (getline(file, line)) {
		vector<string> entry;
		stringstream ss(line);
		while (getline(ss, data, '|')) {
			entry.push_back(data);
		}
		dictionary.push_back(entry);
	}
	cout << "! Loading completed..." << endl;
	
	cout << "! Closing data file... ./Data.CS.SFSU1.txt" << endl;
	file.close();

	cout << "\n-----DICTIONARY 340 C++-----\n" << endl;

	while (true) {

		int found = 0;
		string input, s1, s2, s3, pos, spacer, definition;

		//
		// Get userinput and splits it up into three categories.
		// The first one is for the actual search word, the second
		// is for the pos, and the third one is to check if the user
		// entered too many words.
		//

		cout << "Search: ";
		getline(cin, input);
		transform(input.begin(), input.end(), input.begin(), ::tolower);
		stringstream stream(input);
		stream >> s1 >> s2 >> s3;

		//
		// Goes through checks to see if the user wants to quit, if the 
		// input is valid, and if the pos is valid. 
		// If everything checks out then perform a search.
		//
		// The search output behaves differently depending if the user inputs 
		// a pos or not. If user does, it prints out only those entries. If user 
		// doesn’t, it prints out everything. Return message if word isn’t found.
		//

		if (s1 == "!q") {
			cout << "\n-----THANK YOU-----\n";
			break;
		} 
		
		cout  << "\t|" << endl;
		if (!s3.empty() || s1.empty()) {
			cout << "\t <Please enter a search key (and a part of speech).>" << endl;
		} else if (!s2.empty() && s2 != "noun" && s2 != "adjective" && s2 != "verb") {
			cout << "\t <2nd argument must be a part of speech.>" << endl;
		} else {
			for (size_t i = 0; i < dictionary.size(); i++) {
				if (dictionary[i][0].compare(s1) == 0) {
					for (size_t j = 1; j < dictionary[i].size(); j++) {

						stringstream ss(dictionary[i][j]);
						ss >> pos >> spacer;
						getline(ss, definition);
						string word = dictionary[i][0];

						if (containsInt(word)) {
							transform(word.begin(), word.end(), word.begin(), ::toupper);
						} else {
							word[0] = toupper(word[0]);
						}

						if (!s2.empty() && s2.compare(pos) == 0) {
							cout << "\t " << word << " [" << pos << "] :" << definition << endl;
							found++;
						}
						else if (s2.empty()) {
							cout << "\t " << word << " [" << pos << "] :" << definition << endl;
							found++;
						}

					}
					break;
				}
			}
			if (found == 0) {
				cout << "\t <Not found.>" << endl;
			}
		}
		cout << "\t|" << endl;
	}
}


// Funtion containsInt
bool containsInt(string s) {
	for (size_t i = 0; i < s.length(); i++) {
		if (!isalpha(s[i])) return true;
	}
	return false;
}