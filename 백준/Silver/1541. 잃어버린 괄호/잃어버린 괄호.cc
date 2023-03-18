// 값을 최소로 만들려면
// 작은값 - (큰값 + 큰값)
// 작은값 - 큰값
// 작은값 + 작은값

// 규칙 
// - 뒤에 다시 -가 나오기 전까지는 다 더한다. A-(B+C+D)
// - 가 없으면 괄호칠 필요 없다
// - 뒤에 +가 없으면 괄호 칠 필요 없다
// ...

// 입력 : 문자열. 문자열 길이 <= 50 

#include <bits/stdc++.h>
using namespace std;


//아이디어 : -가 한번이라도 나오면 나머지는 다 뺄셈 처리 한다.

/*
55-50+40-30+10
55-(50+40)-(30+10)
55-50-40-30-10
*/

string str;
int ans,tmp; 
int sign=1;  

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin>>str; 
    // 55-40+20-11
    for(char c: str){
        if(c=='+' || c=='-'){
            ans += tmp * sign; 
            if(c=='-') sign=-1;  // - 나오면 sign:  -1 
            tmp=0; //tmp를 0으로 바꿈(다시 숫자를 세기 위함)
        }
        else{
            tmp*=10; //연산자가 아니므로 다음 숫자가 1의자리가 되고, 10의자리씩 늘어난다
            tmp+=c-'0'; //문자를 숫자로 바꾼다
        }
    }
    ans += tmp*sign;
    cout<<ans;

    return 0;
}

