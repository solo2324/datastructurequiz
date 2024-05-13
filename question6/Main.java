package question6;


public class Main {
    public static void main(String[] args) {
        int[] array = {3, 7, 1, 9, 4};
        int index = 2;
        int[] modifiedArray = deleteElement(array, index);
        for (int i = 0; i < modifiedArray.length; i++) {
            System.out.print(modifiedArray[i] + " ");
        }
    }

    public static int[] deleteElement(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            System.out.println("Invalid index.");
            return array;
        }
        
        int[] modifiedArray = new int[array.length - 1];
        int modifier = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (i != index) {
                modifiedArray[i - modifier] = array[i];
            } else {
                modifier = 1;
            }
        }
        
        return modifiedArray;
    }
}
