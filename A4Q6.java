/**
*@author	Mateo Zoto
*@contact	mateozoto@gmail.com
*@UCID		10082263
*@classname	A4Q6
*@since		Nov 29th 2012
*/

import java.util.Random;

public class A4Q6 {
    int len;
    int arrnum;
    
    public A4Q6(int arrayamount, int length){
        len = length;
	arrnum = arrayamount;
    }
    
    public void doSortedGeneratedArrays(){
        int i = 0;
        int j = 0;
        int r;
        while (i < 100){
            int[] array = new int[len];
            j = 0;
            while (j < len){
                    array[j] = j;
		    j++;
            }
            Sorting.insertionSort(array);
            ///System.out.println("[Insertion Sort] Iteration #: " + (i+1) + "; Size of array: " + len + "; Is sorted: " + Sorting.isSorted(array));
            Sorting.heapSort(array);
            //System.out.println("[Heap Sort] Iteration #: " + (i+1) + "; Size of array: " + len + "; Is sorted: " + Sorting.isSorted(array));
            Sorting.quickSort(array);
            //System.out.println("[Quick Sort] Iteration #: " + (i+1) + "; Size of array: " + len +"; Is sorted: " + Sorting.isSorted(array));
            Sorting.quickSortImproved(array);
            //System.out.println("[Quick Sort Improved] Iteration #: " + (i+1) + "; Size of array " + len +  "; Is sorted: " + Sorting.isSorted(array));
            Sorting.javaSort(array);
            //System.out.println("[Java Sort] Iteration #: " + (i+1) + "; Size of array " + len +  "; Is sorted: " + Sorting.isSorted(array));
	    //Sorting.quickSortBonus(array);
            //System.out.println("[Quick Sort Bonus] Iteration #: " + (i+1) + "; Size of array " + len +  "; Is sorted: " + Sorting.isSorted(array));
            i++;
        }
    }

    public static void main(String[] args){
	int length = 0;
        int arrayamount = 0;
	try{
		arrayamount = Integer.parseInt(args[0]);
	}
        catch (NumberFormatException e){
		System.out.println("You have inputed an invalid argument.");
		System.exit(0);
        }
	try{
		length = Integer.parseInt(args[1]);
	}
        catch (NumberFormatException e){
		System.out.println("You have inputed an invalid argument.");
		System.exit(0);
        }
        A4Q6 Q6 = new A4Q6(arrayamount, length);                
        Q6.doSortedGeneratedArrays();
    }
}
