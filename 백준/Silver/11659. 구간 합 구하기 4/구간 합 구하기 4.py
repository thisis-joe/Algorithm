n, m =map(int,input().split())
list1 = list(map(int,input().split()))
sumarr=[0]#합배열 저장용
tmp=0

for i in list1:
    tmp =tmp + i
    sumarr.append(tmp) #배열 뒤에 집어넣기

# for i in sumarr:
#     print(i)

for i in range(m):
    a,b=map(int,input().split())
    print(sumarr[b]-sumarr[a-1])