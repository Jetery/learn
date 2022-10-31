/*
 * Description: 
 * @author: JeffRay
 * @date: 2022.10.29
 */

#include <bits/stdc++.h>

using namespace std;
// whether a >= b
bool cmp(vector<int> &a, vector<int> &b) {
    if (a.size() != b.size()) return a.size() > b.size();
    else {
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a[i] != b[i]) return a[i] > b[i];
        }
    }
    return true;
}

vector<int> add (vector<int> &a, vector<int> &b) {
    vector<int> ret;
    int t = 0;
    for (int i = 0; i < a.size() || i < b.size(); i++) {
        if (i < a.size()) t += a[i];
        if (i < b.size()) t += b[i];
        ret.push_back(t % 10);
        t /= 10;
    }
    if (t) ret.push_back(1);
    return ret;
}

vector<int> sub (vector<int> &a, vector<int> &b) {
    vector<int> ret;
    int t = 0;
    for (int i = 0; i < a.size(); i++) {
        t += a[i];
        if (i < b.size()) t -= b[i];
        ret.push_back((t + 10) % 10);
        if (t < 0) t = -1;
        else t = 0;
    }
    while (ret.size() > 1 && ret[ret.size() - 1] == 0) {
        ret.pop_back();
    }
    return ret;
}

int main() {
    string a, b;
    vector<int> A, B;
    cin >> a >> b;
    for (int i = a.size() - 1; i >= 0; i--) A.push_back(a[i] - '0'); // save from lowest
    for (int i = b.size() - 1; i >= 0; i--) B.push_back(b[i] - '0');
    // add
    auto c = add(A, B);
    for (int i = c.size() - 1; i >= 0; i--) printf("%d", c[i]);
    cout << endl;
    // sub
    if (cmp(A, B)) c = sub(A, B);
    else {
        printf("-");
        c = sub(B, A);
    }
    for (int i = c.size() - 1; i >= 0; i--) printf("%d", c[i]);
    cout << endl;

    return 0;
}
