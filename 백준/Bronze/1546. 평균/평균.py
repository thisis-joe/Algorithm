n=input()
list1=list(map(int,input().split())) #리스트 공백기준 입력
maxi=max(list1) #최대값 구하기
sum=sum(list1)
print(sum*100/maxi/int(n))