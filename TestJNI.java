public class TestJNI
{
    static 
    {
        System.loadLibrary("testjni");
    }

    private native void simpleCall(int a);
    private native void primitiveArrayCall(int[] a);

    public static void main(String[] args)
    {
        TestJNI instance = new TestJNI();

        instance.simpleCall(10);

        int[] intArray = new int[10];
        instance.primitiveArrayCall(intArray);

        System.out.println("Returned Array");
        for(int i : intArray)
        {
            System.out.println(i);
        }
    }
}
