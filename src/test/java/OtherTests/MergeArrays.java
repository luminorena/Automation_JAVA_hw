package OtherTests;

import java.util.Arrays;

public class MergeArrays {
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int [] arrayC = new int[a1.length + a2.length];
        int positionA = 0, positionB = 0;
        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == a1.length){
                arrayC[i] = a2[i - positionB];
                positionB++;
            } else if (positionB == a2.length) {
                arrayC[i] = a1[i - positionA];
                positionA++;
            } else if (a1[i - positionA] < a2[i - positionB]) {
                arrayC[i] = a1[i - positionA];
                positionB++;
            } else {
                arrayC[i] = a2[i - positionB];
                positionA++;
            }
        }
        return arrayC;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 2, 2}, new int[]{1, 3})));
    }
}
