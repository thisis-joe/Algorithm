#include <bits/stdc++.h>
using namespace std;

int n,sum;
vector<int> vec;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin>>n;
    for(int i=0;i<n;i++){
        int input;
        cin>>input;
        vec.push_back(input);
    }

    sort(vec.begin(),vec.end());

    for(int i=0;i<n;i++){
        int new_sum=0;
        int previous_sum=0;
        for(int j=0;j<i;j++){
            previous_sum += vec[j];
        }
        sum += previous_sum + vec[i];
    }

    cout<<sum;
    
    return 0;
}