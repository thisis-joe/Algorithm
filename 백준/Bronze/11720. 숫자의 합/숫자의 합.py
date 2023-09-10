n=input()
list1=list(input()) #리스트 입력
ans=0

for i in list1: 
    ans = ans + int(i) #리스트가 자리수 형변환 후 더하기

print(ans)