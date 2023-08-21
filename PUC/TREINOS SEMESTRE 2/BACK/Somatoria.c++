#include <iostream>

using namespace std;

//int main()
//{
   // int K,N,S;
   // cout<<"Digite um numero limite N: ";
   // cin>>N;
   // K = 1;
  //  S = 0;
  //  while(K<=N){
     //   S = S + K;
      //  K++;
      //  cout<<"\n"<<K;
   // }
  //  cout<<"\n"<<S;
   // return 0;
//}


//int main()
//{
    //int K,N,S,PAR;
    //cout<<"Digite um numero limite N ( IMPAR OU PAR TANTO FAZ ): ";
    //cin>>N;
    //K = 1;
    //S = 0;
    //PAR = 2;
    //while(K<=(2*N)){
       // K++;
        //S = S + PAR;
        //PAR += 2;
        //cout<<"\n"<<PAR;
   // }
   // cout<<"\n SOMATORIA: "<<S;
    //return 0;
//}

//int main()
//{
    //int K,N,S;
    //cout<<"Digite um numero limite N ( IMPAR OU PAR TANTO FAZ ): ";
    //cin>>N;
   // K = 2;
    //S = 0;
   // while(K<=(2*N)){
       // S += K;
       // K += 2;
       // cout<<"\n"<<K;
    //}
    //cout<<"\n SOMATORIA: "<<S;
    //return 0;
//}

//int main(){
    //int K,N,S,J;
    //cout<<"Digite um numero limite: ";
    //cin>>N;
    //K = 1;
    //S = 0;
    //while(K<=N){
       // cout<<"Digite um numero para somar: ";
       // cin>>J;
       // S += J;
       // K++;
   // }
    
   // cout<<"\n SOMATORIA: "<<S;
   // return 0;

//}

int main(){
    float K,N,S,DEN;
    cout<<"Digite um numero limite: ";
    cin>>N;
    K = 1;
    S = 0;
    DEN = 1;
    while(K<=N){

       S = S + 1/DEN;
       DEN += 1;
       K++;
    }
    
   cout<<"\n SOMATORIA: "<<S;
   return 0;
}
