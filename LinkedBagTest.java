public class LinkedBagTest
{
    public static void main(String[] args)
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        BagInterface<String> bag3 = bag1.union(bag2);
        BagInterface<String> bag4 = bag1.intersection(bag2);
        BagInterface<String> bag5 = bag1.difference(bag2);

        Object[] bagArray3 = bag3.toArray();
        for (int i = 0; i < bagArray3.length; i++)
        {
           System.out.print(bagArray3[i] + " ");
        }

        System.out.println();

        Object[] bagArray4 = bag4.toArray();
        for (int i = 0; i < bagArray4.length; i++)
        {
           System.out.print(bagArray4[i] + " ");
        }

        System.out.println();

        Object[] bagArray5 = bag5.toArray();
        for (int i = 0; i < bagArray5.length; i++)
        {
           System.out.print(bagArray5[i] + " ");
        }
    }
}