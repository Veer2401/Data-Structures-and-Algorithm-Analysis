#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

string add(string a, string b){
    string r = "";
    int i = a.size()-1, j = b.size()-1, c = 0;

    while(i>=0 || j>=0 || c){
        int s = c;
        if(i>=0) s+= a[i--]-'0';
        if(j>=0) s+= b[j--]-'0';
        r += char(s%10+'0');
        c = s/10;
    }
    reverse(r.begin(), r.end());
    return r;
}

string square(string n){
    int len = n.size();

    if(len <=9)
        return to_string(stoll(n) * stoll(n));

    int m = len/2;
    string a = n.substr(0,len-m);
    string b = n.substr(len-m);

    string x = square(a);
    string y = square(b);
    string z = square(add(a,b));
    
    string middle = to_string(stoll(z)-stoll(x)-stoll(y));

    for(int i=0;i<2*m;i++) x += "0";
    for(int i=0;i<m;i++) middle += "0";

    return add(add(x,middle),y);
}

int main(){
    string n;
    cout << "Enter a 20-digit number: ";
    cin >> n;

    cout << "Square: " << square(n);
    return 0;
}