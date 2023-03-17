
#include <bits/stdc++.h>
using namespace std;
#define X first 
#define Y second 

int n;
pair<int, int> s[100005];
int ans,t;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin>>n;
    for(int i=0;i<n;i++){
        cin>>s[i].Y>>s[i].X;
    }

    sort(s,s+n); //first기준 정렬됨
    
    for(int i=0;i<n;i++){
        if(t>s[i].Y) continue;
        else{
            ans++;
            t=s[i].X;
        }
    }
    
    cout<<ans;


    return 0;
}