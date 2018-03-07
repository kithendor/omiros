#include <iostream>
#include <vector>
using namespace std;

void fillvector(vector<int>& n)
{
	int x = 0;
	do{
		cout<<"dwse"<<endl;
		cin>>x;
		n.push_back(x);
	}while(x!=-1);
	
}

void printvector(vector<int>& n)
{
	for(unsigned int i = 0; i< n.size();i++)
	{
		cout<<n[i]<<" ";
	}
}


int main()
{

	vector<int> num;
	vector<int> num2;	
	
	fillvector(num2);
	printvector(num2);
	/*
	//add in the end
	num.push_back(5);
	num.push_back(15);
	num.push_back(25);
	num.push_back(35);
	
	//print vector
	for(unsigned int i = 0; i< num.size();i++)
	{
		cout<<num[i]<<" ";
	}
	
	//insert in 2nd 
	num.insert(num.begin() + 1,5);
	
	cout<<endl;
	
	for(unsigned int i = 0; i< num.size();i++)
	{
		cout<<num[i]<<" ";
	}
	
	//erase 3rd
	num.erase(num.begin() + 2);
	
		cout<<endl;
	
	for(unsigned int i = 0; i< num.size();i++)
	{
		cout<<num[i]<<" ";
	}
	
	num.clear();
	cout<<endl;
	if (num.empty())
	{
		cout<<"tipota!";
	}
	
	*/
	
	
	
	
}
