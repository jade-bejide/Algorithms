def matrixChain(n, p):
    m = []
    for i in range(0, n):
        msub = [None]*n
        msub[i] = 0
        m.append(msub)

    for l in range(2, n+1):
        for i in range(0, n-l+1):
            j = i + l - 1
            m[i][j] = float("inf")

            for k in range(i, j):
                m[i][j] = min(m[i][j], m[i][k] + m[k+1][j] + (p[i]*p[k+1]*p[j+1]))
                

    return m

def matrixChainP(n, p):
    m = []
    for i in range(0, n):
        msub = [None]*n
        msub[i] = 0
        m.append(msub)

    s = []
    ssub = [None]*n
    for i in range(0, n-1):
        s.append(ssub)

    

    for l in range(2, n+1):
        for i in range(0, n-l+1):
            j = i + l - 1
            m[i][j] = float("inf")

            for k in range(i, j):
                q = m[i][k] + m[k+1][j] + (p[i]*p[k+1]*p[j+1])
                if q < m[i][j]:
                    m[i][j] = q
                    s[i][j] = k        

    return m, s

def prettyMatrix(matrix):
    for row in matrix:
        print(row)

def printOptimalParens(s, i, j):
    if i == j:
        print("A["+str(i)+"]")
    else:
        print("(")
        printOptimalParens(s, i, s[i][j])
        printOptimalParens(s, s[i][j]+1,j)
        print(")")

n = 4
p = [2, 9, 8, 6, 2]

result = matrixChainP(n, p)
prettyMatrix(result[0])

print("")
printOptimalParens(result[1], 0, n-1)
