import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class Addresser
{
    private static Unsafe unsafe;

    static
    {
        try
        {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static long addressOf(Object o)
            throws Exception
    {
        Object[] array = new Object[] {o};

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch (addressSize)
        {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }

        return(objectAddress);
    }


    static void main(String[] args) throws Exception {
        String a = "abc";
        String b = "abc";
        String d = new String("abc");
        String c = d;
        long addressd = addressOf(d);
        long addressc = addressOf(c);
        long address = addressOf(a);
        long addressb = addressOf(b);
        System.out.println("Addess: " + address);
        System.out.println("Addess: " + addressb);
        System.out.println("Addess: " + addressc);
        System.out.println("Addess: " + addressd);

        //Verify address works - should see the characters in the array in the output
        printBytes(address, 27);

    }

    public static void printBytes(long objectAddress, int num)
    {
        for (long i = 0; i < num; i++)
        {
            int cur = unsafe.getByte(objectAddress + i);
            System.out.print((char)cur);
        }
        System.out.println();
    }
}