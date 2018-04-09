### Coding Challenge Vitalie Quiz of Emergitel

1- a) Simplify the following method

    public int AMethod(bool first, bool second, bool third)
    {
        if (!first)
        {
            if (second)
            {
                if (third)
                {
                    return OptionOne;
                }
                else if (!second)
                {
                    return OptionTwo;
                }
                else
                {
                    return OptionOne;
                }
            }
            else
            {
                return OptionOne;
            }
        }
        else if (!third)
        {
            if (!second)
            {
                return OptionTwo;
            }
        }
        else if (!second)
        {
            return OptionTwo;
        }
        if (!(third || !second))
        {
            return OptionTwo;
        }
        return OptionOne;
    }


   b) Show how you validated the correctness of your revised AMethod method.

2-  You are working on a system that needs to be able to identify whether a sequence of characters reads the same backward as forward, as in the following examples:

    * 'kayak'
    * 'Able was I ere I saw Elba'

Also note, that the length of the sequence is not restricted only by the available memory.

Given the following implementation:

    public class StringUtils
    {
    public bool IsMirrorSequence(String s)
    { /* body omitted */ throw new NotImplementedException(); }
    }


a. Write a unit test to fully evaluate the correctness of the `IsMirrorSequence(String s)` method.

b. Is the requirement, as stated above, complete or did you have make additional assumptions to implement your tests?

c. Implement the IsMirrorSequence(String s) method based on the requirements and signature given above



---

### Answers

1a) Simplified method
public static int BMethod(boolean first, boolean second, boolean third) {
int OptionOne = 1;
int OptionTwo = 2;
return (first && !(second && !third)) ? OptionTwo : OptionOne;
}

1b) How validated the correctness
Printed the truth table of eight possibilities given the three boolean inputs, recognizing this could be
simplified to a one-liner, especially since there are only two return types, so a ternary statement is
possible.
Looking at the truth table output, I see that whenever first is true, together with whenever either
(second is false or third is false) that OptionTwo should always be returned, and thus in all other cases
this would simply return OptionOne. Hence a ternary operation does the job, and no more complexity is
necessary, multi-line if-statements can be safely discarded. The code is optimized to return OptionTwo
in the case of being true, since that code is simpler. Otherwise the logic would’ve been a little more
complex in the opposite case.

    abc: A B
    111: 1 1
    110: 2 2
    101: 2 2
    100: 2 2
    011: 1 1
    010: 1 1
    001: 1 1
    000: 1 1

I tested it in my IDE and confirmed the output matched in all 8 possibilities. I executed the given
AMethod and my new BMethod, by used a ugly but simple triple-nested for-loop.

    System.out.println("abc: A B ");
    for (int a = 1; a >= 0; a-- ) {
        for (int b = 1; b >= 0; b-- ) {
            for (int c = 1; c >= 0; c-- ){
                System.out.println( a + "" + b + "" + c + ": " + AMethod((a==1),(b==1),(c==1)) + " " +
                BMethod((a==1),(b==1),(c==1)));
            }
        }
    }

2a) Unit Test
import junit.framework.*;
public class JavaTest extends TestCase {
String s1, s2, s3, s4, s5;

    // assigning the values
    protected void setUp() {
        String s1 = "kayak";
        String s2 = "Able was I ere I saw Elba";
        String s3 = "test";
        String s4 = "bananas";
        String s5 = "";
    }
    public void testIsMirrorSequences() {
        assertTrue(IsMirrorSequence(s1));
        assertTrue(IsMirrorSequence(s2));
        assertFalse(IsMirrorSequence(s3));
        assertFalse(IsMirrorSequence(s4));
        assertTrue(IsMirrorSequence(s5));
    }
    
    
2b) No, it is not complete. There are assumptions made. Nothing about case-sensitivity is mentioned,
yet the example clearly demonstrates that that would be an edge case with the capitalization of “A” in
“Able” and “E” in “Elba” but in neither of their opposing letters. I’ve chosen that it was meant to pass.
Another edge case is an empty string, which I’ve also chosen to pass.

2c) Implement the algorithm

    public static boolean IsMirrorSequence(String s)
    {
        try {
            s = s.toLowerCase();
            int sz = s.length();
            //integers round down in java, so 5/2 rounds to 2. as intended here.
            //handles both odd & even lengths
            for (int i = 0; i < sz/2; i++) {
                //if (!s[i].equals(s[i])) {
                if (s.charAt(i) != s.charAt(sz-i- 1)) {
                    return false;
                }
            }
            return true;
        }
        catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }
    
<!-- note - test doesn't compile --> 