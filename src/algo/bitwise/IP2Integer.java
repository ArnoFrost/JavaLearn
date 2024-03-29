package algo.bitwise;

public class IP2Integer {

    /**
     * Convert an integer to a IPV4
     *
     * <code>iIPV4</code>'s highest byte represents the first ip seg
     *
     * @param iIPV4
     * @return
     */
    public static String integer2IPV4(int iIPV4) {
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            // right shift each byte of iIPV4 to the rightest side
            // and then use 0xFF to mask this new-gotten integer.
            // So we get the integer value of the rightest byte
            int aSeg = (iIPV4 >> (8 * i)) & 0xFF;
            if (i == 0) {
                sb.append(aSeg);
            } else {
                sb.append(aSeg + ".");
            }
        }
        System.out.println(iIPV4 + "-->" + sb.toString());
        return sb.toString();
    }

    /**
     * Convert a String IPV4 to an integer
     *
     * <code>strIPV4</code>'s first seg is the highest byte of the returned
     * integer
     *
     * @param strIPV4
     * @return
     */
    public static int IPV42Integer(String strIPV4) {
        int iIPV4 = 0x00;
        String[] segArray = strIPV4.split("\\.");
        for (int i = 0; i < segArray.length; i++) {
            // seg <=255, so all the bits except rightest 8 ones are 0
            int seg = Integer.parseInt(segArray[i]);
            // left shift the current iIPV4 1-byte-distance, then "append" the
            // strIPV4Seg to rightest side
            iIPV4 = (iIPV4 << 8) | seg;
        }
        System.out.println(strIPV4 + "-->" + iIPV4);
        return iIPV4;
    }

    public static int ip2Integer(String ipv4) {
        int ip = 0x00;
        String[] segArray = ipv4.split("\\.");
        for (int i = 0; i < segArray.length; i++) {
            int seg = Integer.parseInt(segArray[i]);
            ip = (ip << 8) | seg;
        }
        return ip;
    }

    public static String int2Ipv4(int ip) {
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            int aSeg = (ip >> (8 * i)) & 0xFF;
            if (i == 0) {
                sb.append(aSeg);
            } else {
                sb.append(aSeg + ".");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        integer2IPV4(IPV42Integer("0.0.0.0"));
//		integer2IPV4(IPV42Integer("255.255.255.255"));
//		integer2IPV4(IPV42Integer("127.0.0.1"));
//		integer2IPV4(IPV42Integer("192.168.1.1"));
//		integer2IPV4(IPV42Integer("192.168.0.100"));
//		integer2IPV4(IPV42Integer("255.168.0.100"));
        test();
    }

    private static void test() {
        int a = 129;
//        int b = 128;

//        System.out.println(a & b);
//        System.out.println(a | b);
//        System.out.println(~a);
//        System.out.println(~b);
//        System.out.println(a ^ b);


//        int max = Integer.MAX_VALUE;
//        System.out.println(max);
//        System.out.println(~max);
//        System.out.println(a ^ max);

//        int ip = 0xFF;
//        ip = (ip << 8) | 123;
//        System.out.println(ip);
//        ip = (ip << 8) | 123;
//        System.out.println(ip);
//        ip = (ip << 8) | 123;
//        System.out.println(ip);
//        ip = (ip << 8) | 123;
//        System.out.println(ip);
//
//
//        for (int i = 3; i >= 0; i--) {
//            System.out.println((ip >> (8 * i)) & 0xFF);
//        }
    }
}