public class SBuf2_CompareStringBufferStringBuilder {
    public static void main(String[] args) {
        int n = 1000000;

        StringBuilder sb = new StringBuilder();
        long startSb = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
        long endSb = System.nanoTime();

        StringBuffer sbuf = new StringBuffer();
        long startSbuf = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sbuf.append("hello");
        }
        long endSbuf = System.nanoTime();

        System.out.println("StringBuilder time (ns): " + (endSb - startSb));
        System.out.println("StringBuffer time (ns): " + (endSbuf - startSbuf));
    }
}
