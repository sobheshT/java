package comm.sort;
import java.util.Collections;
import java.util.Arrays;

public class Sort {
public static void main(String[] args) {
	Integer arr[]= {
			100,1,-20,30,0
	};
	Arrays.sort(arr);
	
	for (int i:arr) {
		System.out.print(i+" ");
	}
	//System.out.printf("Sorted Array:%s",Arrays.toString(arr));
}
}
