package cmo.merge1;

public class Merge {
	public static void mergeShort(int[] array,int start,int end){
		if(start<end){
			int mid = (start+end)/2;
			mergeShort(array, start, mid);//对左边进行归并
			mergeShort(array, mid + 1, end);//对右边进行归并
			merge(array, start, mid, end);//归并
		}
	}
	public static void merge(int[] array, int start, int mid, int end){
		int[] tempArray = new int [end - start + 1];//开辟大集合
		int i = start, j = mid+1, k = 0;
		while(i <= mid && j <= end){
			if(array[i] <= array[j])
			    tempArray[k++] = array[i++];
			else
				tempArray[k++] = array[j++];
		}
		while(i <= mid){//如果左侧还有剩余，依次放入大集合右侧
			tempArray[k++] = array[i++];
		}
		while(j <= end){//如果右侧还有剩余，依次放入大集合右侧
			tempArray[k++] = array[j++];
		}
		for(int m=0;m < tempArray.length;m++)
		{
			array[m + start]=tempArray[m];
		}
	}
	public static void main(String[] args) {
		int[] array={4,6,1,5,8,2,3,6,8,1,9};
		System.out.print("原数据为:");
		for(int m = 0;m < array.length;m++){
			System.out.print(array[m]+",");
		}
		 mergeShort(array, 0, array.length-1);
		 System.out.println();
		 System.out.print("归并排序后的数据为：");
			for(int r = 0;r < array.length;r++){
				System.out.print(array[r]+",");
			}
	}
	

}
