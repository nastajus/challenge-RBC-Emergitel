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
        return (first || (!second && !third)) ? OptionOne : OptionTwo;
        //return (first || !(second && third)) ? OptionOne : OptionTwo;
    }

}
