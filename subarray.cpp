#include <bits/stdc++.h> 
using namespace std; 
int countSubarrays(int arr[], 
				int n, int k) 
{ 
	int start = 0, end = 0, 
		count = 0, sum = arr[0]; 
	int cnt[n + 1] = {0};
	while (start < n && end < n) { 

		if (sum < k) { 
			end++; 

			if (end >= start){ 
				count += end - start; 
            	cnt[end - start]++;
            }

			if (end < n) 
				sum += arr[end]; 
		} 

	else { 
			sum -= arr[start]; 
			start++; 
		} 
	} 
  for(int i = n - 1; i >= 1; i--){
  	cnt[i] += cnt[i +1];
  }
  for(int i = 1; i<= n; i++){
  	cout << cnt[i] << " ";
  }
  cout << endl;

	return count; 
} 

// Driver Code 
int main() 
{ 
	int array[] = { 1, 11, 2, 3, 15 }; 
	int k = 10; 
	int size = sizeof(array) / sizeof(array[0]); 
	cout << countSubarrays(array, size, k); 
} 
