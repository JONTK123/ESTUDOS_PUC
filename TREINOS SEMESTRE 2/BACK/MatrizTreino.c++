#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    int n, m, i, j;

    do {
        cout << "DIMENSOES da matriz (linha/coluna): ";
        cin >> n >> m;
    } while (n <= 0 || m <= 0);

    int a[n][m];
    int t[m][n];

    // Preenchendo a matriz original
    for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
            cout << "[" << i + 1 << "][" << j + 1 << "]: ";
            cin >> a[i][j];
        }
    }

    cout << "Matriz lida:" << endl;

    for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }

    cout << "Casas da matriz:" << endl;

    for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
            cout << "[" << i + 1 << "][" << j + 1 << "]  ";
        }
        cout << endl;
    }

    return 0;
}
