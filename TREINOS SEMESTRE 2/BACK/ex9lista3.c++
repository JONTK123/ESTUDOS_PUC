#include <iostream>

int main() {
    int n, kg;

    do
    {
        std::cout << "Digita um numero multiplo de 5 para executar: ";
        std::cin >> n;

    } while (n % 5 != 0);

    for (int i = 1; i <= n; i++) {
        if (i % 5 == 0) {
            kg = i * 0.453592;  // Use ponto (.) para representar números decimais, não vírgula (,)
            std::cout << "\n" << i << " libras equivalem a " << kg << " kgs"; 
        }
    }
    return 0;
}
