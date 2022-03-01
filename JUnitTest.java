import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

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

        assertArrayEquals(bag3.toArray(), bag1.union(bag2).toArray());
    }

    @Test   //Test2
    void TestResizableBagArrayUnionWithEmptyBags()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(0);
        BagInterface<String> bag2 = new ResizableArrayBag<>(0);
        BagInterface<String> bag3 = new ResizableArrayBag<>(0);

        assertArrayEquals(bag3.toArray(), bag1.union(bag2).toArray());
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

        assertArrayEquals(bag3.toArray(), bag1.union(bag2).toArray());
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

        assertArrayEquals(bag3.toArray(), bag1.intersection(bag2).toArray());
    }

    @Test   //Test5
    void TestResizableBagArrayIntersectionWithEmptyBags()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(0);
        BagInterface<String> bag2 = new ResizableArrayBag<>(0);
        BagInterface<String> bag3 = new ResizableArrayBag<>(0);

        assertArrayEquals(bag3.toArray(), bag1.intersection(bag2).toArray());
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

        assertArrayEquals(bag3.toArray(), bag1.intersection(bag2).toArray());
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

        assertArrayEquals(bag3.toArray(), bag1.difference(bag2).toArray());
    }

    @Test   //Test8
    void TestResizableBagArrayDifferenceWithEmptyBags()
    {
        BagInterface<String> bag1 = new ResizableArrayBag<>(0);
        BagInterface<String> bag2 = new ResizableArrayBag<>(0);
        BagInterface<String> bag3 = new ResizableArrayBag<>(0);

        assertArrayEquals(bag3.toArray(), bag1.difference(bag2).toArray());
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

        assertArrayEquals(bag3.toArray(), bag1.difference(bag2).toArray());
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
        
        bag3.add("e");
        bag3.add("d");
        bag3.add("b");
        bag3.add("b");
        bag3.add("c");
        bag3.add("b");
        bag3.add("a");

        assertArrayEquals(bag3.toArray(), bag1.union(bag2).toArray());
    }

    @Test   //Test11
    void TestLinkedBagUnionWithEmptyBags()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();

        assertArrayEquals(bag3.toArray(), bag1.union(bag2).toArray());
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
        
        bag3.add("c");
        bag3.add("b");
        bag3.add("a");
        bag3.add("c");
        bag3.add("b");
        bag3.add("a");

        assertArrayEquals(bag3.toArray(), bag1.union(bag2).toArray());
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

        assertArrayEquals(bag3.toArray(), bag1.intersection(bag2).toArray());
    }

    @Test   //Test14
    void TestLinkedBagIntersectionWithEmptyBags()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();

        assertArrayEquals(bag3.toArray(), bag1.intersection(bag2).toArray());
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
        
        bag3.add("c");
        bag3.add("b");
        bag3.add("a");

        assertArrayEquals(bag3.toArray(), bag1.intersection(bag2).toArray());
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
        
        bag3.add("c");
        bag3.add("a");

        assertArrayEquals(bag3.toArray(), bag1.difference(bag2).toArray());
    }

    @Test   //Test17
    void TestLinkedBagDifferenceWithEmptyBags()
    {
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();

        assertArrayEquals(bag3.toArray(), bag1.difference(bag2).toArray());
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

        assertArrayEquals(bag3.toArray(), bag1.difference(bag2).toArray());
    }
    //check
}
