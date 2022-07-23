def sieveOfErato(limit):
    A = [True] * limit

    for i in range(2, int(n**0.5)):
        if A[i]:
            j = i**2

            while j < n:
                A[j] = False
                j += 1

    final = []
    for i in range(2, len(A)):
        if A[i]: final.append(i)

    return final
