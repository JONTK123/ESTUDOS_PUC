#include <iostream>

using namespace std;

int main() {
    float x, y, z;
    cout << "Digite X Y Z: ";
    cin >> x >> y >> z;

    if (x + y > z && y + z > x && x + z > y) {
        if ((x == y && y == z) || (y == x && x == z)) {
            cout << "Equilatero e tambem isoceles";
        } else if (x == y || y == z || x == z) {
            cout << "Isoceles";
        } else {
            cout << "Escaleno";
        }
    } else {
        cout << "Isso nao forma um triangulo... Tente novamente";
    }

    return 0;
}



