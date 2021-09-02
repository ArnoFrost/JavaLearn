package java.other;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/12 11:40
 * @Version 1.0
 */
public class CopyDemo {

    public static void copyFileByStream(File source, File dest) {
        try {
            InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileByChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = new FileInputStream(source).getChannel();
        FileChannel targetChannel = new FileOutputStream(dest).getChannel();
        for (long count = sourceChannel.size(); count > 0; ) {
            long transferred = sourceChannel.transferTo(
                    sourceChannel.position(), count, targetChannel
            );
            count -= transferred;
        }
    }
}
