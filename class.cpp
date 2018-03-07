#include <iostream>
#include <string>

using namespace std;


class Dms {
public:
	Dms()
	{
		cout << "kalimera";
		age = 0;
		height = 0;
		name = "";
	}
	Dms(string n, int a, float h)
	{
		cout << "kalimera";
		age = a;
		height = h;
		name = n;
	}
	~Dms()
	{
		cout<<"pethanes"<<endl;
	}
	
	string getName() const
	{
		return name;
	}
	
	int getAge() const
	{
		return age;
	}
	
	float getHeight() const
	{
		return height;
	}
	
	void setName(string n)
	{
		name = n;
	}
	
	void setAge(int a)
	{
		age = a;
	}
	
	void setHeight(float h)
	{
		height = h;
	}
	
	string xontros() const
	{
		
		return (2*age > 10) ? "xontros" : "leptos";
	}
	
private:
	string name;
	int age;
	float height;
};

int main()
{
	string name;
	int age;
	float height;
	
	cout<<"dwse"<<endl;
	cin>>name;
	cout<<"dwse"<<endl;
	cin>>age;
	cout<<"dwse"<<endl;
	cin>>height;
	
	Dms pel1;
	pel1.setName(name);
	pel1.setAge(age);
	pel1.setHeight(height);
	
	cout<<pel1.xontros();
	
	
	
	

return 0;	
}


