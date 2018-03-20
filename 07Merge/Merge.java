public class Merge{
    public static void merge(int[] aryA, int[] aryB, int[] destination)
    {
        int a = 0, b = 0;
        while (a < aryA.length && b < aryB.length) {
            if (aryA[a] < aryB[b]) {
                destination[a + b] = aryA[a];
                a++;
            } else {
                destination[a + b] = aryB[b];
                b++;
            }
        }
    }
}
