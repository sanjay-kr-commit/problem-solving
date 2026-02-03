int peakIndexInMountainArray(int *arr, int arrSize) {
  int l = 1, r = arrSize - 2, m;
  while (l <= r) {
    m = l + (r - l) / 2;
    if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1])
      return m;
    else if (arr[m] > arr[m + 1] && arr[m] < arr[m - 1])
      r = m - 1;
    else
      l = m + 1;
  }
  return l;
}
