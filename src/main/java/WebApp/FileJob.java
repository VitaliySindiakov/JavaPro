package WebApp;

import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileJob {

    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        byte[] byteArray = buffer.toByteArray();
        return byteArray;
    }

    public String getFileName(Part part) {
        String clientFileName = "";
        String[] splitStrings;
        String content = part.getHeader("content-disposition");
        splitStrings = content.split(";");
        for (String str : splitStrings) {
            if (str.contains("filename")) {
                clientFileName = str.substring(str.indexOf("=") + 2, str.length() - 1);
            }
        }
        return clientFileName;
    }

    public byte[] toZip(String fileName, byte[] bytes) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ZipOutputStream zout = new ZipOutputStream(byteArrayOutputStream)) {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zout.putNextEntry(zipEntry);
            zout.write(bytes);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return byteArrayOutputStream.toByteArray();
    }
}
