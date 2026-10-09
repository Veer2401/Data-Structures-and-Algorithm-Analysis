
#include <iostream>
#include <string>
#include <vector>
using namespace std;

string clean(string s) {
    int i = 0;
    while (i < s.length() - 1 && s[i] == '0')
        i++;
    return s.substr(i);
}

string add(string a, string b) {
    string r = "";
    int i = a.size() - 1, j = b.size() - 1, c = 0;

    while (i >= 0 || j >= 0 || c) {
        int s = c;
        if (i >= 0) s += a[i--] - '0';
        if (j >= 0) s += b[j--] - '0';
        r = char(s % 10 + '0') + r;
        c = s / 10;
    }
    return clean(r);
}

string sub(string a, string b) {
    string r = "";
    int i = a.size() - 1, j = b.size() - 1, borrow = 0;

    while (i >= 0) {
        int x = a[i--] - '0' - borrow;
        int y = 0;
        if (j >= 0) y = b[j--] - '0';

        if (x < y) {
            x += 10;
            borrow = 1;
        } else {
            borrow = 0;
        }

        r = char(x - y + '0') + r;
    }
    return clean(r);
}

string multiply(string a, string b) {
    vector<int> v(a.size() + b.size(), 0);

    for (int i = a.size() - 1; i >= 0; i--)
        for (int j = b.size() - 1; j >= 0; j--)
            v[i + j + 1] += (a[i] - '0') * (b[j] - '0');

    for (int i = v.size() - 1; i > 0; i--) {
        v[i - 1] += v[i] / 10;
        v[i] %= 10;
    }

    string r = "";
    for (int x : v) r += char(x + '0');
    return clean(r);
}

string zeros(string s, int n) {
    if (s == "0") return s;
    while (n--) s += '0';
    return s;
}

string karatsuba(string n) {
    n = clean(n);

    if (n.size() <= 9) {
        long long x = stoll(n);
        return to_string(x * x);
    }

    int m = n.size() / 2;
    string a = n.substr(0, n.size() - m);
    string b = n.substr(n.size() - m);

    string p1 = karatsuba(a);
    string p2 = karatsuba(b);
    string p3 = karatsuba(add(a, b));

    string middle = sub(sub(p3, p1), p2);

    return add(add(zeros(p1, 2 * m), zeros(middle, m)), p2);
}

int main() {
    string n;
    cout << "Enter a 20-digit number: ";
    cin >> n;

    if (n.size() != 20) {
        cout << "Please enter exactly 20 digits.";
        return 0;
    }

    for (char c : n) {
        if (c < '0' || c > '9') {
            cout << "Invalid input.";
            return 0;
        }
    }

    string result = karatsuba(n);
    string normal = multiply(n, n);

    cout << "N = " << n << endl;
    cout << "N^2 = " << result << endl;
    cout << "Digits in N^2: " << result.size() << endl;
    cout << "Method: Karatsuba Divide and Conquer" << endl;
    cout << "Schoolbook result = " << normal << endl;

    if (result == normal)
        cout << "Verification: Correct result" << endl;
    else
        cout << "Verification: Incorrect result" << endl;

    return 0;
}