#include <bits/stdc++.h>
using namespace std;
#define MAX 1000001

bool isprime[MAX];
int countp[MAX];

void init(int lim){
  // Creating the seive for counting prime factors
  for(int i = 0; i < lim; i++){
    countp[i] = 0;
    isprime[i] = 1;
  }
  isprime[0] = 0;
  isprime[1] = 0;
  isprime[2] = 1;
  for(int i = 2; i < lim; i++){
    if(isprime[i]){
      for(int j = 2 * i; j < lim; j += i){
        isprime[j] = 0;
      }
    }
  }
  countp[0] = 0;
  countp[1] = 0;
  for(int i = 2; i < lim; i++){
    if(isprime[i]){
      countp[i] = 1;
      for(int j = 2 * i; j < lim; j += i){
        countp[j]++;
      }
    }
  }
}

int seq(int arr[], int n, int k){
  deque<int> dq;
  for(int i = 0; i < k; i++){
    while(!dq.empty() && countp[arr[dq.back()]] <= countp[arr[i]]){
      dq.pop_back(); // removing elements with smaller number of prime factors
    }
    dq.push_back(i);
  }
  int min_v = arr[dq.front()];
  for(int i = k; i < n; i++){
    while(!dq.empty() && dq.front() <= i - k){
      dq.pop_front(); // removing elements the are out of the window
    }
    while(!dq.empty() && countp[arr[dq.back()]] <= countp[arr[i]]){
      dq.pop_back();  // remove elements with lesser number of prime factors
    }
    dq.push_back(i);
    min_v = min(min_v, arr[dq.front()]); // Front will always number with largest Prime factors
  }
  return min_v;
}

int main(){
  int n, k;
  cin >> k >> n;
  int arr[n];
  int max_v = INT_MIN;
  for(int i = 0; i < n; i++){
    cin >> arr[i];
    max_v = max(max_v, arr[i]);
  }
  init(max_v + 1);
  cout << seq(arr, n, k) << endl;
  return 0;
}
