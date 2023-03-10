public static void radixSort(int[] arr) {
    int radix = 10; // radix of decimal system
    int maxDigit = getMaxDigit(arr);

    for (int digit = 0; digit < maxDigit; digit++) {
        int[] count = new int[radix];

        for (int i = 0; i < arr.length; i++) {
            int digitValue = getDigitValue(arr[i], digit);
            count[digitValue]++;
        }

        for (int i = 1; i < radix; i++) {
            count[i] += count[i - 1];
        }


        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int digitValue = getDigitValue(arr[i], digit);
            sorted[--count[digitValue]] = arr[i];
        }

  
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }
}

private static int getMaxDigit(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return (int) Math.ceil(Math.log10(max));
}

private static int getDigitValue(int num, int digit) {
    return (int) ((num / Math.pow(10, digit)) % 10);
}
