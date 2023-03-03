#include <bits/stdc++.h>
using namespace std;

int n;
int arr[2200][2200];
int cnt[3]; 
bool isSame(int a, int b, int n){
    for(int i=a;i<a+n;i++){
        for(int j=b;j<b+n;j++){
            if(arr[i][j]!=arr[a][b]) return false;
        }
    }
    return true;
}

void cut(int a, int b, int z){
    if( isSame(a,b,z) ){
        cnt[arr[a][b] + 1] += 1;
        return;
    }
    else{
        int n = z/3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                cut( a+i *n, b+j *n, n);
            }
        }
    }
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin>>n;

    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++){
            cin>>arr[i][j];
        }
    }

    cut(0,0,n);

    for(int i=0;i<3;i++) cout<<cnt[i]<<'\n';

    return 0;
}
