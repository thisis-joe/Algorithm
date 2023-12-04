# 갑옷은 2개의 재료로 만든다
# 2가지 재료의 고유한 번호를 합쳐서 M이 되면 된다
# 2개 합이 M이 되면 된다
# 아 배열처럼 늘어뜨려 놓고 투포인터로 짚어가면서 2개 합 = M인 거 count하면 되는구나 .. 바로나오죠 ㅇㅇ 

n=int(input())
m=int(input())
lst = list(map(int,input().split()))
lst.sort()
start_idx=0  
end_idx=n-1 # 이번에는 양쪽 끝에서 시작한다. 어떻게 움직이지? 0.일단 오름차순 정렬부터하고, 1.합=m이면 start++, end--해야한다. 둘다 다시 볼 필요없다. 2. 합<m이면 start++, 하고, 3.합>m이면 end-- 하자.
sum=0 
cnt=0 # 2018번 문제와 다르게 무조건 2개의 합이기 때문에 자기자신을 카운트 하고 시작하지 않는다 

while start_idx<end_idx: #이것도 못봣다 
    sum=lst[start_idx]+lst[end_idx] 
    if sum==m:
        cnt+=1
        start_idx+=1
        end_idx-=1
    elif sum<m:
        start_idx+=1
    else :
        end_idx-=1
        
print(cnt)