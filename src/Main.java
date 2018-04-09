public class Main {

    public static void main(String[] args) {
        System.out.println("abc: A B ");
        for (int a = 1; a >= 0; a--) {
            for (int b = 1; b >= 0; b--) {
                for (int c = 1; c >= 0; c--){
                    System.out.println( a + "" + b + "" + c + ": " + AMethod((a==1),(b==1),(c==1)) + " " + BMethod((a==1),(b==1),(c==1)));
                }
            }
        }

        String s1 = "kayak";
        String s2 = "Able was I ere I saw Elba";
        String s3 = "test";
        String s4 = "bananas";
        String s5 = "";

        System.out.println(s1 + " is: " + String.valueOf(IsMirrorSequence(s1)));
        System.out.println(s2 + " is: " + IsMirrorSequence(s2));
        System.out.println(s3 + " is: " + IsMirrorSequence(s3));
        System.out.println(s4 + " is: " + IsMirrorSequence(s4));
        System.out.println(s5 + " is: " + IsMirrorSequence(s5));

    }

    public static int AMethod(boolean first, boolean second, boolean third) {
        int OptionOne = 1;
        int OptionTwo = 2;

        if (!first) {
            if (second) {
                if (third) {
                    return OptionOne;
                } else if (!second) {
                    return OptionTwo;
                } else {
                    return OptionOne;
                }
            } else {
                return OptionOne;
            }
        } else if (!third) {
            if (!second) {
                return OptionTwo;
            }
        } else if (!second) {
            return OptionTwo;
        }
        if (!(third || !second)) {
            return OptionTwo;
        }
        return OptionOne;

    }

    public static int BMethod(boolean first, boolean second, boolean third) {
        int OptionOne = 1;
        int OptionTwo = 2;

        //return (first && !(second && !third)) ?  OptionTwo : OptionOne;

        return !(first && (!second || !third)) ?  OptionOne : OptionTwo;

    }

    public static boolean IsMirrorSequence(String s)
    {
        try {
            s = s.toLowerCase();
            int sz = s.length();

            //integers round down in java, so 5/2 rounds to 2.  as intended here.
            //handles both odd & even lengths
            for (int i = 0; i < sz/2; i++) {
                //if (!s[i].equals(s[i])) {
                if (s.charAt(i) != s.charAt(sz-i-1)) {
                    return false;
                }
            }
            return true;

        }
        catch (Exception e){
            throw new UnsupportedOperationException();
        }

    }

}
