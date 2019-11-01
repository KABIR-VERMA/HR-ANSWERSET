def util(X, Y, Z, turns, rem):
    if (turns == 0):
        return max(0,(X-Z))
    else:
        if rem == 0:
            new_Z = Z - int(Y/turns)
            new_X = (turns-1)*Y
            return util(new_X, Y, new_Z, turns-1, rem)
        else:
            new_Z = Z - int(rem/(turns + 1))
            new_X = turns*Y
            return util(new_X, Y, new_Z, turns, 0)

def findMaxWeapons(X, Y, Z):
    # Write your code here
    if (X>Y):
        turns = int(X/Y)
        rem = X%Y
        return util(X,Y,Z,turns,rem)
    else:
        return max(0, X-Z)
    return 0
