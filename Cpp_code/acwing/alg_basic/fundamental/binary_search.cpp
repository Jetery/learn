/*
 * Description: 
 * @author: JeffRay
 * @date: 2022.10.24
 */

#include <bits/stdc++.h>
using namespace std;

const int N = 100010;
int q[N];
int n, x, k;


int binary_search_l(int q[], int l, int r) {
    while (l < r) {
        int mid = l + r >> 1;
        if (q[mid] >= x) r = mid;
        else l = mid + 1;
    }
    return l;
}

int binary_search_r(int q[], int l, int r) {
    while (l < r) {
        int mid = l + r + 1 >> 1;
        if (q[mid] <= x) l = mid;
        else r = mid - 1;
    }
    return l;
}

int main() {
    scanf("%d%d", &n, &k);
    for (int i = 0; i < n; i++) scanf("%d", &q[i]);
    while (k-- > 0) {
        scanf("%d", &x);
        int l = binary_search_l(q, 0, n - 1);
        if (q[l] != x) cout << "-1 -1" << endl;
        else {
            cout << l << " ";
            int r = binary_search_r(q, 0, n - 1);
            cout << r << endl;
        }
    }
    return 0;
}