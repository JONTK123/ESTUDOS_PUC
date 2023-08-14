#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;

//int main()
//{
   
    //int x,y;
    //cout<<"Digite um numero N limite: ";
    //cin>>x;
    //y = 0;
    //while(y<=x)
    //{
        //cout<<"\nY = "<< y;
        //y += 1;

    //}
//}   

//int main(){

    //int x;
    //do{
        //cout<<"Digite o numero secreto: ";
        //cin>>x;
        //if ( x == 5){
            //cout << "Digitou correto parabens ebaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            //break;
        //}
        //cout<<"Digite novamente...\n";
        
    //}while(x != 5);

   //return 0;
//}

int main(){
    
    int x;
    cout<<"Digite o numero secreto: ";
    cin>>x;

    while(x != 5){
        cout<<"Digite o numero secreto: ";
        cin>>x;
        if (x == 5){
            cout << "Digitou correto parabens ebaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            break;
        }
    }



    return 0;
}