#include <stdio.h>

void merge(int *a, int l, int mid, int h)
{
    int i = l;
    int j = mid + 1;
    int temp[10];
    int k = 0;
    int s = 0;

    while (i <= mid && j <= h)
    {
        if (a[i] < a[j])
        {
            temp[k] = a[i];
            k++;
            i++;
        }
        else
        {
            temp[k] = a[j];
            k++;
            j++;
        }
    }
    if (i > mid)
    {
        for (; j <= h; j++)
        {
            temp[k] = a[j];
            k++;
        }
    }
    if (j > h)
    {
        for (; i <= mid; i++)
        {
            temp[k] = a[i];
            k++;
        }
    }

    for (s = l; s <= h; s++)
    {
        a[s] = temp[s];
    }
}
void mergeSort(int *a, int l, int h)
{
    int mid = 0;

    if (l < h)
    {
        mid = (l + h) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, h);
        merge(a, l, mid, h);
    }
    return;
}
int main()
{
    int arr[10] = {23, 34, 29, 2, 24, 9, 3, 8, 39, 7};
    mergeSort(arr, 0, 9);
    for (int i = 0; i < 10; i++)
    {
        printf("%d \n", arr[i]);
    }
}