#include <bits/stdc++.h>
using namespace std;


vector<pair<int, int>> schedule;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n,end,begin;

    cin>>n;
    for(int i=0;i<n;i++){
        cin>>begin>>end;
        schedule.push_back(make_pair(end,begin)); //종료지점에 대해 정렬하기 위해..
    }
    
    sort(schedule.begin(),schedule.end()); //end에 대해 정렬  (종료지점에 대해 정렬)
    
    int time = schedule[0].first;  //가장 빠른 종료시점
    int ans = 1; // 최초 1개 무조건 등록
    for(int i=1;i<n;i++){
        if(time <= schedule[i].second) {
            ans++;
            time=schedule[i].first;
        }
    }
    
    cout<<ans;
    return 0;
}