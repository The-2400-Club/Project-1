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

        //BagInterface<String> bag3 = bag1.union(bag2);
        //BagInterface<String> bag4 = bag1.intersection(bag2);
        BagInterface<String> bag5 = bag1.difference(bag2);

        Object[] bagArray = bag5.toArray();
        for (int i = 0; i < bagArray.length; i++)
        {
           System.out.print(bagArray[i] + " ");
        }
    }
}