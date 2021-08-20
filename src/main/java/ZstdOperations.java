import com.github.luben.zstd.ZstdInputStream;
import com.github.luben.zstd.ZstdOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ZstdOperations {

    public void compress() {
        byte[] buff = new byte[1024];

        try {
            ZstdOutputStream zstdOutputStream = new ZstdOutputStream(new FileOutputStream("Compressed.zst"));
            FileInputStream fileInputStream = new FileInputStream("UncompressedText.txt");
            int length;
            while ((length = fileInputStream.read(buff)) > 0) {
                zstdOutputStream.write(buff, 0, length);
            }
            fileInputStream.close();
            zstdOutputStream.close();
        }catch (IOException exception){
            System.out.println("Encountered an exception while compressing the file :"+exception);
        }
    }

    public void decompress() {
        byte[] buff = new byte[1024];

        try {
            ZstdInputStream zstdInputStream = new ZstdInputStream(new FileInputStream("Compressed.zst"));
            FileOutputStream fileOutputStream = new FileOutputStream("NewUncompressed.txt");
            int length;
            while ((length = zstdInputStream.read(buff)) > 0) {
                fileOutputStream.write(buff, 0, length);
            }
            zstdInputStream.close();
            fileOutputStream.close();
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
