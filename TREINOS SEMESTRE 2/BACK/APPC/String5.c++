#include <iostream>
#include <cstring> // Include the correct header for string operations

using namespace std;

int main()
{
    char string[9999];
    char stringip[9999] = {'\0'}; // Inicialize com caracteres nulos

    cout << "Digite o nome da pessoa: ";
    cin.getline(string, 10);

    if (strlen(string) % 2 == 0) {
        for (int i = 0; i < strlen(string); i++) {
            if (i % 2 == 0) {
                stringip[i] = string[i + 1];
                stringip[i + 1] = string[i];
            }
        } 

    } else {

        for (int i = 0; i < strlen(string); i++) {
            if (i % 2 == 0) {
                stringip[i] = string[i + 1];
                stringip[i + 1] = string[i];
            }
        }

        stringip[strlen(string)-1]= string[strlen(string)-1];
        stringip[strlen(string)]='\0';

    }




    cout << "String Gerada: " << stringip << endl;

    return 0;
}
