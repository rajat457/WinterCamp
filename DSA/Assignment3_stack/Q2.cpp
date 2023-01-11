#include <bits/stdc++.h>
using namespace std;

bool isBalanced(string exp) {
	bool flag = true;
	int count = 0;

	for (int i = 0; i < exp.length(); i++) {

		if (exp[i] == '(') {
			count++;
		}
		else {
			count--;
		}
		if (count < 0) {

			flag = false;
			break;
		}
	}

	if (count != 0) {
		flag = false;
	}

	return flag;
}

int main()
{
	string exp1 = "((()))()()";
    cout<<"exp1 "<<exp1<<" is ";
	if (isBalanced(exp1))
		cout << "Balanced \n";
	else
		cout << "Not Balanced \n";

	string exp2 = "())((())";
    cout<<"exp2 "<<exp2<<" is ";
	if (isBalanced(exp2))
		cout << "Balanced \n";
	else
		cout << "Not Balanced \n";

	return 0;
}