package packageOne;

import java.util.Arrays;

public class FundTransfer {

	public static void main(String[] args) {
	  //linear search
		int [] arr = {1,2,3,4,5,8,9,10};
		//linear search
		int key=8;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key) {
				System.out.println(key+"present at index"+i);
			}
		}
		Arrays.sort(arr);
		int low=0;
		int high=arr.length-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(arr[mid]==key) {
				System.out.println(key+"present at index"+mid);
				break;
			}else if(key<arr[mid]) {
				high=mid-1;
			}else {
				low=mid+1;
			}
			
		}
		
		

	}

}
