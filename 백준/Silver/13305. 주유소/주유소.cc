/*
km당 1리터
도로 길이 상이
주유소마다 리터당 기름가격 다름

필요한 기름양 = 도로길이
첫번째 길이 
*/

#include <bits/stdc++.h>
using namespace std;
#define ll long long

int n;
vector<int> road;
vector<int> station;
ll res;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin>>n;
    for(int i=0;i<n-1;i++){
        int input; cin>>input;
        road.push_back(input);
    }
    for(int i=0;i<n;i++){
        int input; cin>>input;
        station.push_back(input);
    }
   
    res=station[0]*road[0]; //최초 주유
    for(int i=1; i<n; i++){
        if(station[i]<station[i+1]){
            res+=station[i]*road[i];
        }
        else {
            res+=station[i-1]*road[i]; //넘어가면 안됨 ..continue가 아니고,, 
        }
    }
    cout<<res;
    

    return 0;
}
