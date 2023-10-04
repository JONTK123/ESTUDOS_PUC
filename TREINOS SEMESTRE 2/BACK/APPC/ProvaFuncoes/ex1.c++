#include <stdio.h>
#include <iostream>
#include <math.h>
#include <iomanip>

using namespace std;

#define pi 3.14

void calcula_volume(float *r, float *h){
    float v;
    cin >> *r;
    cin >> *h;
    v = (pi*pow(*r,2)*(*h));
    cout << "Seu volume eh: " << v << endl;
}

int main() {
    
    float raio, alt, vol;
    calcula_volume(&raio,&alt); 

return 0;
}

// #include <iostream>
// #include <cmath> // Use cmath instead of math.h
// #include <iomanip>

// #define pi 3.14

// float calcula_volume(float r, float h) {
//     float v;
//     v = (pi * pow(r, 2) * h);
//     return v;
// }

// int main() {

//     float raio, alt, vol;
//     cin >> raio;
//     cin >> alt;
//     vol = calcula_volume(raio, alt);
//     cout << "Seu volume eh: " << vol << endl;

//     return 0;
//}