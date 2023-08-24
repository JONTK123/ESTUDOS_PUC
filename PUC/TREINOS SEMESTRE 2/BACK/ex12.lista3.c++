#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main(){

    for(int i = 1000; i <= 2000; i++){
        if(i % 11 == 5){
            cout<<"\n"<<i<<endl;
        }
    }
    return 0;
}
