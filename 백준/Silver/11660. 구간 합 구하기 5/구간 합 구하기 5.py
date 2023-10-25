n,m=map(int,input().split())
A=[[0]*(n+1)]
D=[[0]*(n+1) for _ in range(n+1)]

for i in range(n):
    A_row=[0] + [int(x) for x in input().split()]
    A.append(A_row)

for i in range(1,n+1):
    for j in range(1,n+1):
        D[i][j]=D[i][j-1]+D[i-1][j]-D[i-1][j-1]+A[i][j]

for _ in range(m):
    a,b,c,d=map(int,input().split())
    result=D[c][d]-D[a-1][d]-D[c][b-1]+D[a-1][b-1]
    print(result) 
