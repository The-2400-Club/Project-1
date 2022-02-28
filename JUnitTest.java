import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JUnitTest
{
    //Tests for ResizableBagArray

    @Test   //Test1
    void TestResizableBagArrayUnion()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(3);
        BagInterface<String> bag2 = new ResizableArrayBag<>(4);
        BagInterface<String> bag3 = new ResizableArrayBag<>(7);
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        bag3.add("a");
        bag3.add("b");
        bag3.add("c");
        bag3.add("b");
        bag3.add("b");
        bag3.add("d");
        bag3.add("e");

        assertEquals(bag3, bag1.union(bag2));
    }

    @Test   //Test2
    void TestResizableBagArrayUnionWithEmptyBags()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(0);
        BagInterface<String> bag2 = new ResizableArrayBag<>(0);
        BagInterface<String> bag3 = new ResizableArrayBag<>(0);

        assertEquals(bag3, bag1.union(bag2));
    }

    @Test   //Test3
    void TestResizableBagArrayUnionWithSameBags()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(3);
        BagInterface<String> bag2 = new ResizableArrayBag<>(3);
        BagInterface<String> bag3 = new ResizableArrayBag<>(6);
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("a");
        bag2.add("b");
        bag2.add("c");
        bag3.add("a");
        bag3.add("b");
        bag3.add("c");
        bag3.add("a");
        bag3.add("b");
        bag3.add("c");

        assertEquals(bag3, bag1.union(bag2));
    }

    @Test   //Test4
    void TestResizableBagArrayIntersection()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(3);
        BagInterface<String> bag2 = new ResizableArrayBag<>(4);
        BagInterface<String> bag3 = new ResizableArrayBag<>(7);
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        bag3.add("b");

        assertEquals(bag3, bag1.intersection(bag2));
    }

    @Test   //Test5
    void TestResizableBagArrayIntersectionWithEmptyBags()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(0);
        BagInterface<String> bag2 = new ResizableArrayBag<>(0);
        BagInterface<String> bag3 = new ResizableArrayBag<>(0);

        assertEquals(bag3, bag1.intersection(bag2));
    }

    @Test   //Test6
    void TestResizableBagArrayIntersectionWithSameBags()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(3);
        BagInterface<String> bag2 = new ResizableArrayBag<>(3);
        BagInterface<String> bag3 = new ResizableArrayBag<>(3);
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("a");
        bag2.add("b");
        bag2.add("c");
        bag3.add("a");
        bag3.add("b");
        bag3.add("c");

        assertEquals(bag3, bag1.intersection(bag2));
    }

    @Test   //Test7
    void TestResizableBagArrayDifference()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(3);
        BagInterface<String> bag2 = new ResizableArrayBag<>(4);
        BagInterface<String> bag3 = new ResizableArrayBag<>(2);
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        bag3.add("a");
        bag3.add("c");

        assertEquals(bag3, bag1.difference(bag2));
    }

    @Test   //Test8
    void TestResizableBagArrayDifferenceWithEmptyBags()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(0);
        BagInterface<String> bag2 = new ResizableArrayBag<>(0);
        BagInterface<String> bag3 = new ResizableArrayBag<>(0);

        assertEquals(bag3, bag1.difference(bag2));
    }

    @Test   //Test9
    void TestResizableBagArrayDifferenceWithSameBags()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(3);
        BagInterface<String> bag2 = new ResizableArrayBag<>(3);
        BagInterface<String> bag3 = new ResizableArrayBag<>(0);
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("a");
        bag2.add("b");
        bag2.add("c");

        assertEquals(bag3, bag1.difference(bag2));
    }

    //Tests for LinkedBag

    @Test   //Test10
    void TestLinkedBagUnion()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        bag3.add("a");
        bag3.add("b");
        bag3.add("c");
        bag3.add("b");
        bag3.add("b");
        bag3.add("d");
        bag3.add("e");

        assertEquals(bag3, bag1.union(bag2));
    }

    @Test   //Test11
    void TestLinkedBagUnionWithEmptyBags()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();

        assertEquals(bag3, bag1.union(bag2));
    }

    @Test   //Test12
    void TestLinkedBagUnionWithSameBags()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("a");
        bag2.add("b");
        bag2.add("c");
        bag3.add("a");
        bag3.add("b");
        bag3.add("c");
        bag3.add("a");
        bag3.add("b");
        bag3.add("c");

        assertEquals(bag3, bag1.union(bag2));
    }

    @Test   //Test13
    void TestLinkedBagIntersection()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        bag3.add("b");

        assertEquals(bag3, bag1.intersection(bag2));
    }

    @Test   //Test14
    void TestLinkedBagIntersectionWithEmptyBags()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();

        assertEquals(bag3, bag1.intersection(bag2));
    }

    @Test   //Test15
    void TestLinkedBagIntersectionWithSameBags()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("a");
        bag2.add("b");
        bag2.add("c");
        bag3.add("a");
        bag3.add("b");
        bag3.add("c");

        assertEquals(bag3, bag1.intersection(bag2));
    }

    @Test   //Test16
    void TestLinkedBagDifference()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        bag3.add("a");
        bag3.add("c");

        assertEquals(bag3, bag1.difference(bag2));
    }

    @Test   //Test17
    void TestLinkedBagDifferenceWithEmptyBags()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();

        assertEquals(bag3, bag1.difference(bag2));
    }

    @Test   //Test18
    void TestLinkedBagDifferenceWithSameBags()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("a");
        bag2.add("b");
        bag2.add("c");

        assertEquals(bag3, bag1.difference(bag2));
    }
}