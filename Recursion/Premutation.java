class Premutation {
    public static void printPermutation(String str, String perm, int idx) {
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < str.length(); i++) {// here we are treversing each and every element of the array
            char currChar = str.charAt(i);// we will take the character at index i
            String newStr = str.substring(0, i) + str.substring(i + 1);// we will create a new string
                                                                       // but will not include the charecter at ith
                                                                       // index in new string
            printPermutation(newStr, perm + currChar, idx + 1);// now we will pass the newString and teh
                                                               // permutaionString by concatinating with currentChar
                                                               // so trere will be n-1 char in new String and n+1 char
                                                               // in currChar

        } // in secoud we will take the charecter form another index and perform the same
          // task

    }

    public static void main(String[] args) {
        String str = "ABC";
        printPermutation(str, "", 0);
    }
}