package streams;

import java.io.*;

public class FileCopyPerformance {
    private static final int CHUNK = 4096;  

    public static void main(String[] args) {
        String input = "largefile.dat";       
        String buffered = "bufferedCopy.dat";
        String unbuffered = "unbufferedCopy.dat";
 
        long st1 = System.nanoTime();
        copybuf(input, buffered);
        long er1 = System.nanoTime();
        long timeBuffered = (er1 - st1) / 1_000_000;
 
        long st2 = System.nanoTime();
        copyunbuf(input, unbuffered);
        long et2 = System.nanoTime();
        long timeUnbuffered = (et2 - st2) / 1_000_000;

        System.out.println("Time with Buffered Stream: " + timeBuffered + " ms");
        System.out.println("Time with Unbuffered Stream: " + timeUnbuffered + " ms");
    }
 
    private static void copybuf(String fromFile, String toFile) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fromFile));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(toFile))) {

            byte[] buffer = new byte[CHUNK];
            int n;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }

        } catch (IOException e) {
            System.out.println("Error while copying (buffered): " + e.getMessage());
        }
    }
 
    private static void copyunbuf(String fromFile, String toFile) {
        try (FileInputStream in = new FileInputStream(fromFile);
             FileOutputStream out = new FileOutputStream(toFile)) {

            byte[] buffer = new byte[CHUNK];
            int n;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }

        } catch (IOException e) {
            System.out.println("Error while copying (unbuffered): " + e.getMessage());
        }
    }
}
