package com.di02;

public class Insert {
	public static void main(String[] args) {
		int[] array = {5,8,2,4,9,7,6,23,7,9,6};
		System.out.println("排序之前的数据为：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println();
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			if(temp >= array[j]){
			for(;j >= 0 && temp <= array[j];j--){
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
			}
		}
		System.out.println("排序好的数据为：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
		System.out.println();
	}

}
