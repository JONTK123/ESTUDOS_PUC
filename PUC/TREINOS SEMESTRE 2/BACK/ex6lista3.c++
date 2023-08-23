#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main() {

  float x,y,z;
  cout<<"Digite X Y Z: ";
  cin>> x >> y >> z;

    if ( x + y > z && y + z > 1 && x + z > y ){
        if ( x == y == z){
            cout<<"Equilatero e tambem isoceles";
        }
        else if (x == y || y == z || x == z){
            cout<<"Isoceles"
        }





    }

    return 0;
}
