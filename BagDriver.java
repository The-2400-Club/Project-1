public class BagDriver
{
    public static void main(String[] args)
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(3);
        BagInterface<String> bag2 = new ResizableArrayBag<>(4);

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        //Union
        BagInterface<String> bag3 = bag1.union(bag2);
        Object[] bag3Array = bag3.toArray();
        System.out.println("Union: ");
        for(int i = 0; i < bag3Array.length; i++)
        {
            System.out.print(bag3Array[i] + " ");
        }
        System.out.println("");

        //Intersection
        BagInterface<String> bag4 = bag1.intersection(bag2);
        Object[] bag4Array = bag4.toArray();
        System.out.println("Intersection: ");
        for(int i = 0; i < bag4Array.length; i++)
        {
            System.out.print(bag4Array[i] + " ");
        }
        System.out.println("");

        //Difference
        BagInterface<String> bag5 = bag1.difference(bag2);
        Object[] bag5Array = bag5.toArray();
        System.out.println("Difference: ");
        for(int i = 0; i < bag5Array.length; i++)
        {
            System.out.print(bag5Array[i] + " ");
        }
    }
}