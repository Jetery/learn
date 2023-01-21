/*
 * Description: 
 * @author: JeffRay
 * @date: 2022.10.24
 */

#include <bits/stdc++.h>

using namespace std;
void quick_sort(int q[], int l, int r) {
    if (l >= r) return;
    int x = q[(l + r) >> 1], i = l - 1, j = r + 1;
    while (i < j) {
        while (q[ ++ i] < x);
        while (q[ -- j] > x);
        if (i < j) swap(q[i], q[j]);
    }
    quick_sort(q, l, j);
    quick_sort(q, j + 1, r);
}

int main() {
    int n;
    scanf("%d", &n);
    int q[n];
    for (int i = 0; i < n; i++) scanf("%d", &q[i]);
    quick_sort(q, 0, n - 1);
    for (int i = 0; i < n; i++) printf("%d ", q[i]);
    return 0;
}
