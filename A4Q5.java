/**
*@author	Mateo Zoto
*@contact	mateozoto@gmail.com
*@UCID		10082263
*@classname	A4Q5
*@since		Nov 28th 2012
*/
import java.util.Random;

public class A4Q5 {
    int len;
    int arrnum;
    
    public A4Q5(int arrayamount, int length){
        len = length;
	arrnum = arrayamount;
    }
    
    public void createRandomArrays(){
        Random generator = new Random();
        int i = 0;
        int j = 0;
        int r;
        //size = 128
        while (i < arrnum){
            int[] array = new int[len];
            j = 0;
            while (j < len){
                //(high-low) + low
                r = generator.nextInt();
                array[j] = r;
                j++;
            }
            int[] array1 = Sorting.duplicate(array);
            int[] array2 = Sorting.duplicate(array);
            int[] array3 = Sorting.duplicate(array);
            int[] array4 = Sorting.duplicate(array);
            int[] array5 = Sorting.duplicate(array);
            Sorting.insertionSort(array1);
            //System.out.println("[Insertion Sort] Iteration #: " + (i+1) + "; Size of array: " + len + "; Is sorted: " + Sorting.isSorted(array1));
            Sorting.heapSort(array2);
            //System.out.println("[Heap Sort] Iteration #: " + (i+1) + "; Size of array: " + len + "; Is sorted: " + Sorting.isSorted(array2));
            Sorting.quickSort(array3);
            //System.out.println("[Quick Sort] Iteration #: " + (i+1) + "; Size of array: " + len +"; Is sorted: " + Sorting.isSorted(array3));
            Sorting.quickSortImproved(array4);
            //System.out.println("[Quick Sort Improved] Iteration #: " + (i+1) + "; Size of array " + len +  "; Is sorted: " + Sorting.isSorted(array4));
            Sorting.javaSort(array5);
            //System.out.println("[Java Sort] Iteration #: " + (i+1) + "; Size of array " + len +  "; Is sorted: " + Sorting.isSorted(array5));
	    //Sorting.quickSortBonus(array);
            //System.out.println("[Quick Sort Bonus] Iteration #: " + (i+1) + "; Size of array " + len +  "; Is sorted: " + Sorting.isSorted(array));
            i++;
        }
    }
    public static void main(String[]args){
	int arrayamount = 0;
	int length = 0;
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
        A4Q5 Q5 = new A4Q5(arrayamount, length);                
        Q5.createRandomArrays();
    }
}