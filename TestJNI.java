public class TestJNI
{
    static 
    {
        System.loadLibrary("testjni");
    }

    private native void simpleCall(int a);
    private native void primitiveArrayCall(int[] a);
    private native void stringArrayCall(String[] a);

    public static void main(String[] args)
    {
        TestJNI instance = new TestJNI();

        instance.simpleCall(10);

        int[] intArray = new int[10];
        instance.primitiveArrayCall(intArray);

        System.out.println("Returned Int Array");
        for(int i : intArray)
        {
            System.out.println(i);
        }

        String[] stringArray = new String[10];
        for(int i = 0; i < 10; i++)
        {
            stringArray[i] = "Hello from Java " + i + "!";
        }
        instance.stringArrayCall(stringArray);

        System.out.println("Returned String Array");
        for(String s : stringArray)
        {
            System.out.println(s);
        }
    }
}
