package com.bjtu.sortTest;

/**
 * 排序算法总结：
 * 冒泡排序： 稳定排序			最差、平均都是O(n^2)最好是O(n)				空间复杂度O(1)
 * 插入排序： 稳定排序			最差、平均都是O(n^2)最好是O(n)				空间复杂度O(1)
 * 归并排序： 稳定排序			最差、平均和最好都是O(nlogn)				空间复杂度O(n)
 * 
 * 
 * 
 * 选择排序：不稳定排序		最差，平均都是O（n^2）						空间复制度是1
 * 希尔排序：不稳定排序		O（nlogn）								空间复杂度是1
 * 堆排序：不稳定排序			O（nlogn）								空间复杂度是1
 * 快速排序：不稳定排序		平均和最好是O（nlogn），最坏是O（n^2）		空间复杂度是O（logn）
 * @author cuijianglin
 *
 */
public class Sorts {

	public static void main(String[] args) {
		int[] a = {4,2,1,6,3,6,0,-5,1,1};
		//int[] b = {16,4,10,14,7,9,3,2,8,1};
		//bubbleSort(a);
		//selectSort(a);
		//insertSort(a);
		//ShellSort(a);
		//quicksort(a,0,a.length-1);
		//heapSort(a);
		for(int i = 0; i < a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
	//二分排序
	public static void binarySort(int[] source)
	{
		
	}
	
	
	//堆排序
	public static void heapSort(int[] source)
	{
		int length = source.length;
		buildMaxHeap(source);
		
		for(int i = source.length - 1; i > 0; --i)
		{
			swap(source,0,i);
			length = length - 1;
			maxHeap(source,0,length);
		}
	}
	
	
		//构造大顶堆
	public static void buildMaxHeap(int[] source)
	{
		int length = source.length;
		
		for(int i = length / 2 - 1; i >= 0; --i)
		{
			maxHeap(source,i,length);
		}
	}
	
	private static void maxHeap(int[] source,int i,int length)
	{
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		int largest = 0;
	
		if(left < length && source[i] < source[left])
		{
			largest = left;
		}
		else
		{
			largest = i;
		}
		
		if(right < length && source[largest] < source[right])
		{
			largest = right;
		}
		
		if(largest != i)
		{
			swap(source,largest,i);
			maxHeap(source,largest,length);
		}
	}
	
	
	//快排序
	public static void quicksort(int[] source,int p,int r)
	{
		if(p < r)
		{
			int q = partition(source,p,r);
			quicksort(source,p,q-1);
			quicksort(source,q+1,r);
		}
	}
	
	private static int partition(int[] source,int p,int r)
	{
		int pivot = source[r];
		int i = p - 1;
		for(int j = p; j < r; j++)
		{
			if(source[j] < pivot)
			{
				i = i+1;
				swap(source,i,j);
			}
		}
		swap(source,i+1,r);
		return i+1;
	}
	
	//希尔排序
	public static void ShellSort(int[] source)
	{
		int increment = 5;
		do
		{
			increment = increment/3 + 1;
			ShellPass(source,increment);
		}while(increment > 1);
	}
	
	private static void ShellPass(int[] source,int increment)
	{
		for(int i = increment ; i < source.length; ++i)
		{
			if(source[i] < source[i - increment])
			{
				int j = i - increment;
				int temp = source[i];
				while((j >= 0 && temp < source[j]))
				{
					source[j + increment] = source[j];
					j = j - increment;
				}
				source[j + increment] = temp;
			}
		}
	}
	
	//插入排序
	public static void insertSort(int[] source)
	{
		for(int i = 1; i < source.length; i++)
		{
			for(int j = i; (j > 0 && (source[j] < source[j-1])); j--)
			{
				swap(source,j,j-1);
			}
		}
	}
	
	//选择排序
	public static void selectSort(int[] source)
	{
		for(int i = 0; i < source.length; i++)
		{
			for(int j = i + 1; j < source.length; j++)
			{
				if(source[i] > source[j])
				{
					swap(source,i,j);
				}
			}
		}
	}
	
	//冒泡排序
	public static void bubbleSort(int[] source)
	{
		for(int i = source.length - 1; i > 0; i--)
		{
			boolean change = false;
			for(int j = 0; j < i; j++)
			{
				if(source[j] > source[j+1])
				{
					swap(source,j,j+1);
					change = true;
				}
			}
			
			if(!change)
			{
				return;
			}
		}
	}
	
	
	private static void swap(int[] source,int x,int y)
	{
		int temp = source[x];
		source[x] = source[y];
		source[y] = temp;
	}
}
