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

2-  You are working on a system that needs to be able to identify whether a sequence of
characters reads the same backward as forward, as in the following examples:

    * 'kayak'
    * 'Able was I ere I saw Elba'

Also note, that the length of the sequence is not restricted only by the available
memory.

Given the following implementation:

    public class StringUtils
    {
    public bool IsMirrorSequence(String s)
    { /* body omitted */ throw new NotImplementedException(); }
    }


a. Write a unit test to fully evaluate the correctness of the
`IsMirrorSequence(String s)` method.

b. Is the requirement, as stated above, complete or did you have make
additional assumptions to implement your tests?

c. Implement the IsMirrorSequence(String s) method based on the
requirements and signature given above