#include "stdafx.h"
#include <iostream>
#include <string>

using namespace std;

class Synt {
public:
	Synt()
	{
		cout << "set const";
		bdate = 0;
		jdate = 0;
		va = ' ';
		name = "";
	}
	Synt(string n, int b, int j, char v)
	{
		cout << "set const";
		bdate = b;
		jdate = j;
		va = v;
		name = n;
	}
	~Synt()
	{
		cout << "gei xara!";
	}
	//_________set get NAME
	void setName(string n) {
		name = n;
	}

	string getName() const{
		return name;
	}
	//_________set get BDATE
	void setBdate(int b) {
		bdate = b;
	}

	int getBdate() const {
		return bdate;
	}
	//_________set get JDATE
	void setJdate(int b) {
		jdate = b;
	}

	int getJdate() const {
		return jdate;
	}
	//_________set get VA
	void setVa(char b) {
		va = b;
	}

	char getVa() const {
		return va;
	}

	//_________calculate
	int calc() const
	{
		return (va!='y') ? bdate * 2 + jdate : bdate * 2 + jdate +200;
	}

private:
	int bdate, jdate;
	char va;
	string name;
};


int main()
{
	int bdate,jdate;
	char va;
	string name;

	cout << "dwse name";
	cin >> name;

	do {
		cout << "dwse birth date";
		cin >> bdate;
	} while (bdate <=0);

	do {
		cout << "dwse job date";
		cin >> jdate;
	} while (jdate <= 0);

	do {
		cout << "dwse va y or n";
		cin >> va;
	} while (va!='y' && va!='n');

	Synt kurioulis1;

	kurioulis1.setName(name);
	kurioulis1.setBdate(bdate);
	kurioulis1.setJdate(jdate);
	kurioulis1.setVa(va);


	cout<<kurioulis1.getName()<<" tha pareis: "<<kurioulis1.calc()<<endl;


	Synt kurioulis2(name, bdate, jdate, va);
	kurioulis2.setJdate = 45;

	system("pause");
    return 0;
}


