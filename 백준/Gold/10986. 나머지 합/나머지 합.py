n,m=map(int,input().split())
S=[0]*n # 합배열 초기화 
C=[0]*m # 왜필요???????????????????/?//////? 아./. 인덱스로써 나머지 몇개 있는지 저장하자.
lst1 = list(map(int,input().split()))
S[0]=lst1[0] #이걸 해줘야함.. 
cnt = 0 #정답 count 

#구간합을 위한 누적합배열을 구하자
for i in range(1,n):
    S[i] = lst1[i] + S[i-1]

#나머지 배열을 구하자
for i in range(n):
    if S[i]%m ==0:
        cnt+=1
    C[(S[i]%m)] += 1

for i in range (m):
   # if C[i]>1: #왜 필요?
    cnt += (C[i]*(C[i]-1))//2


print(cnt)