/**
*@author	Mateo Zoto
*@contact	mateozoto@gmail.com
*@UCID		10082263
*@classname	Sorting
*@since		Nov 27th 2012
*/

import java.util.Arrays;
import java.util.Random;


public class Sorting {
	public static int heapsize;
	/**
	 * Sorts an input array in-place using the default Java sorting method as
	 * defined in the Arrays.sort() function.
	 *
	 * @param A The array to be sorted
	 */
	public static void javaSort(int[] A) {
		Arrays.sort(A);
	}

	/**
	 * Implementation of insertion sort which is used to order the array.
	 *
	 * @param A The array to be sorted
	 * @return A sorted array
	 */
	public static void insertionSort(int[] A) {
		int n = A.length;
		int j;
		int temp;
		for (int i = 1; i < n; i++){
			j = i;
			while (j > 0 && A[j] < A[j-1]){
				temp = A[j];
				A[j] = A[j-1];
				A[j-1] = temp;
				j--;
			}
		}
	}
	
	/**
	 * Implementation of insertion sort which is used to order the array. 
	 * This implemention is strictly used with Quick Sort improved
	 *
	 * @param A The array to be sorted, the lowest value of the array and the highest.
	 * @return A sorted array
	 */	
	public static void insertionSort(int[] A, int low, int high){
		int n = high;
		int j = low;
		int temp;
		for (int i = low; i <= n; i++){
			j = i;
			while ((j > 0) && (A[j] < A[j-1])){
				temp = A[j];
				A[j] = A[j-1];
				A[j-1] = temp;
				j--;
			}
		}
	}
	
	/**
	 * Implementation of heap sort which is used to order the array.
	 *
	 * @param A The array to be sorted
	 * @return A sorted array
	 */
	public static void heapSort(int[] A) {
		heapsize = 1;
		int i = 1;
		int largest;
                try{
                    while (i < A.length){
                        insert(A,A[i]);
                        i++;
                    }
                    i = A.length - 1;
                    while (i > 0){
                        largest = deleteMax(A);
                        A[i] = largest;
                        i--;
                    }
                }
                catch(Exception e){}
        }
        
	/**
	 * Inserts a key into the heap
	 *
	 * @param A The array and the key
	 * @return Key inserted into the heap.
	 */
	public static void insert(int[] A, int key) throws FullHeapException{
		int j;
		int temp;
		if (heapsize < A.length){
			A[heapsize] = key;
			heapsize++;		//heapsize = heapsize + 1;
			j = heapsize - 1;
			while (j > 0 && A[j] > A[parent(j)]){
				temp = A[j];
				A[j] = A[parent(j)];
				A[parent(j)] = temp;
				j = parent(j);
			}
		}
		else{
			throw new FullHeapException();
		}
	}
        

	/**
	 * Deletes the max from the heap
	 *
	 * @param  The array of which we will find the max from
	 * @return The max
	 */	
	public static int deleteMax(int[] A) throws EmptyHeapException{
		int l;
		int r;
		int largest;
		if (heapsize > 0){
			int max = A[0];
			A[0] = A[heapsize - 1];
			heapsize --;		//heapsize = heapsize - 1;
			int j = 0;
			while (j < heapsize){
				l = left(j);
				r = right(j);
				largest = j;
				if (l < heapsize && A[l] > A[largest]){
					largest = l;
				}
				if (r < heapsize && A[r] > A[largest]){
					largest = r;
				}
				if (largest != j){
					int temp = A[j];
					A[j] = A[largest];
					A[largest] = temp;
                                        j = largest;
				}
				else{
					j = heapsize;
				}
			}
			return max;
		}
		else{
			throw new EmptyHeapException();
		}
	}
	
	/**
	 * Calculates value for left
	 *
	 * @param  counter value
	 * @return The value of left
	 */	
	public static int left(int i){
		int l = (2*i) + 1;
		return l;
	}
	
	/**
	 * Calculates value for right
	 *
	 * @param  counter value
	 * @return The value of right
	 */	
	public static int right(int i){
		int r = (2*i) + 2;
		return r;
	}

	/**
	 * Calculates value for parent
	 *
	 * @param  counter value
	 * @return The value of parent
	 */	
	public static int parent(int i){
		int p = (i-1)/2;
		return p;
	}

	/**
	 * Implementation of quick sort which is used to order the array.
         * We pass the low and high to quickSort thats overwritten.
	 *
	 * @param A The array to be sorted
	 * @return A sorted array
	 */
	public static void quickSort(int[] A) {
		int low = 0;
                int high = A.length-1;
                quickSort(A,low,high);
	}
	
	/**
	 * Implementation of quick sort which is used to order the array.
         * We pass the low and high to quickSort thats overwritten.
         * Worst Case Running Time - O(nlogn)
	 *
	 * @param A The array to be sorted
	 * @return A sorted array
	 */
	public static void quickSortBonus(int[] A) {
		int low = 0;
                int high = A.length-1;
                quickSortBonus(A,low,high);
	}
	
	/**
	 * Implementation of quick sort which is used to order the array.
	 *
	 * @param A The array to be sorted
	 * @return A sorted array
	 */
        public static void quickSort(int[] A, int low, int high){
            int q;
            if (low < high){
                q = DPartion(A, low, high);
                quickSort(A, low, q-1);
                quickSort(A, q+1, high);
            }
        }
	/**
	 * Implementation of quick sort which is used to order the array.
	 * WORST CASE RUNNING TIME - o(nlogn)
	 * @param A The array to be sorted
	 * @return A sorted array
	 */
        public static void quickSortBonus(int[] A, int low, int high){
            int q;
            if (low < high){
                q = RPartion(A, low, high);
                quickSort(A, low, q-1);
                quickSort(A, q+1, high);
            }
        }	
	/**
	 * Partions the array to be used with QuickSort
	 *
	 * @param A The array to be partioned
	 * @return i
	 */
	public static int DPartion(int[] A, int low, int high){
		int p = A[high];
		int i = low;
		int j = high - 1;
                int tempone;
                int temptwo;
		while (i <= j){
			while (i <= j && A[i] <= p){
				i++;
			}
			while (j >= i && A[j] >= p){
				j--;
			}
			if (i < j){
                                tempone = A[i];
                                A[i] = A[j];
                                A[j] = tempone;
			}
		}
                temptwo = A[i];
                A[i] = A[high];
                A[high] = temptwo;
		return i;
	}
	/**
	 * Partions the array to be used with QuickSortBonus
	 * What this does is it creates random numbers between the high and low and depending on where it lands
	 * it will swap the number it landed on with the high. afterwords it proceeds with normal partition.
	 * 
	 * @param A The array to be partioned
	 * @return i
	 */	
	public static int RPartion(int[] A, int low, int high){
		Random generator = new Random();
		//generate numbers between the inputted low and high
		int x = generator.nextInt(high-low)+low;
		int p = A[x];
		int temp = A[x];
		A[x] = A[high];
		A[high] = temp;
		int i = low;
		int j = high-1;
		while (i <= j){
			while (i <= j && A[i] <= p){
				i++;
			}
			while (j >= i && A[j] >= p){
				j--;
			}
			if (i < j){
				int temptwo = A[i];
				A[i] = A[j];
				A[j] = temptwo;
			}
		}
		int tempthree = A[i];
		A[i] = A[high];
		A[high] = tempthree;
		return i;
	}
        
	/**
	 * Implementation of the improved quick sort which is used to order the array.
	 *
	 * @param  The array to be sorted to be passed it into the improved quicksort.
	 * @return A sorted array
	 */
	public static void quickSortImproved(int[] A) {
            int n = A.length;
            int low = 0;
            int high = n-1;
            quickSortImproved(A, low, high);
	}
                        
	/**
	 * Implementation of the improved quick sort which is used to order the array. (override)
	 *
	 * @param  The array to be sorted
	 * @return A sorted array
	 */
	public static void quickSortImproved(int[] A, int low, int high){
		int middle = (low+high) / 2;
		if ((high - low) < 64){
			insertionSort(A, low, high);
		}
                else{
			doMedian(A, low, high, middle);
			int tempmid = A[middle];
			A[middle] = A[high-1];
			A[high-1] = tempmid;
			if (low < high){
				int q = DPartion(A, low, high);
				quickSortImproved(A, low, q-1);
				quickSortImproved(A, q+1, high);
			}	
		}		
	}
	/**
	 * Swaps out the median value in the array (takes into account 3! possibilities)
	 *
	 * @param  The array being used, low value, high value and the middle value
	 * @return An array of which the median, low and high are set to their corrosponding places.
	 */	
	public static void doMedian(int[] A, int low, int high, int middle){
		if (A[high] < A[middle] && A[high] > A[low]){
			int temp = A[middle];
			A[middle] = A[high];
			A[high] = temp;
		}
		else if (A[high] > A[middle] && A[high] < A[low]){
			int temp = A[low];
			A[low] = A[middle];
			A[middle] = temp;
				
			int temp2 = A[middle];
			A[middle] = A[high];
			A[high] = temp2;
		}
		else if (A[low] < A[middle] && A[low] > A[high]){
			int temp = A[middle];
			A[middle] = A[high];
			A[high] = temp;
				
			int temp2 = A[low];
			A[low] = A[middle];
			A[middle] = temp2;
		}
		else if (A[low] > A[middle] && A[low] < A[high]){
			int temp = A[low];
			A[low] = A[middle];
			A[middle] = temp;
		}
		else if (A[middle] < A[low] && A[middle] > A[high]){
			int temp = A[low];
			A[low] = A[middle];
			A[middle] = temp;
				
			int temp2 = A[middle];
			A[middle] = A[high];
			A[high] = temp2;
				
			int temp3 = A[low];
			A[low] = A[middle];
			A[middle] = temp3;
		}
	}

	/**
	 * Utility function to return a duplicate of an array.
	 *
	 * @param A The array to be copied
	 * @return A copy of the array
	 */
	public static int[] duplicate(int[] A) {
		int[] B = new int[A.length];
		System.arraycopy(A, 0, B, 0, A.length);
		return B;
	}

	/**
	 * Utility function to determine if an array is sorted. Returns true if it
	 * is sorted and false otherwise.
	 *
	 * @param A The array to test if it's sorted
	 * @return true if the array is sorted; false otherwise
	 */
	public static boolean isSorted(int[] A) {
		for (int i = 1; i < A.length; i++) {
			if (A[i-1] > A[i]) {
				return false;
			}
		}
		return true;
	}

       /**
	 * Utility function to output array to String
	 *
	 * @param A The array to make into a String
	 * @return The String form of the array A
	*/
	public static String arrayToString(int[] A) {
        String s = ("[");
        for (int i = 0; i < A.length; i++) {
            s += (A[i]);
            if (i != A.length - 1) {
                s += (", ");
            }
        }
        s += "]";
        return s;
        }

        /**
	 * Utility function to determine if two arrays are equal
	 *
	 * @param A The array to test if equal to array B
	 * @param B The array to test if equal to array A
	 * @return true if the arrays are equal, false otherwise
	 */
	public static boolean arrayEquals(int[] A, int[] B) {
        if (A == B) {
            return true;
        }
        if (A.length != B.length) {
            return false;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
        }
}