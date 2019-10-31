#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'countPerms' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER n as parameter.
#
def countPerms(n):
    # Write your code here
        arr = [[1,1,1,1,1]]
        for i in range(1, n):
            lis = arr[i-1]
            temp = [lis[1]% (1000000007), (lis[0] + lis[2])% (1000000007), (lis[0] + lis[1] +\
                    lis[3] + lis[4])% (1000000007), (lis[2] + lis[4])% (1000000007), lis[0]% (1000000007)]
            arr.append(temp)
        return sum(arr[-1]) % (1000000007)
       