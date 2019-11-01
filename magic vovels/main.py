#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'longestVowelSubsequence' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#

def longestVowelSubsequence(s):
    # Write your code here
    dp ={'a':0, 'e':0, 'i':0, 'o':0, 'u':0}
    isa =0
    ise=0
    isi=0
    iso=0
    isu=0
    for i in range(0, len(s)):
        if s[i]=='a':
            dp['a'] +=1
            isa =1
        elif s[i]=='e' and isa==1:
            dp['e'] = max(dp['a']+1, dp['e']+1)
            ise =1
        elif s[i]=='i' and ise==1:
            dp['i'] = max(dp['e']+1, dp['i']+1)
            isi =1
        elif s[i]=='o' and isi==1:
            dp['o'] = max(dp['i']+1, dp['o']+1)
            iso =1
        elif s[i]=='u' and iso==1:
            dp['u'] = max(dp['o']+1, dp['u']+1)
            isu =1
    if isu:
        return dp['u']
    return 0

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = longestVowelSubsequence(s)

    fptr.write(str(result) + '\n')

    fptr.close()
