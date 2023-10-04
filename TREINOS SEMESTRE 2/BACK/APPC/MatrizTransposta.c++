#include <iostream>
#include <stdio.h>
#include <cmath>
#include <iomanip>

using namespace std;

int main() {

    int m,n,i,j;
    cout<<"Digite o parametro da matriz: ";
    cin>>n>>m;

    int a[n][m];
    int t[m][n];

//MATRIZ ORIGINAL --------------------------------------------

    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            cout<<"["<< i+1 << "][" << j + 1 << endl;
            cin>>a[i][j];
        }
        cout<<endl;
    }


//MATRIZ TRANSPOSTA --------------------------------------------

    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            cout<<"["<< j+1 << "][" << i + 1 << endl;
            cin>>t[i][j];
        }
        cout<<endl;
    } 

//MATRIZ TRANSPOSTA METODO 2 --------------------------------------------

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (a[i][j] == t[j][i]) {
               printf("Matriz T eh transposta de A");
            }}}