package DBApp;


import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "filetosave")
public class FileEntity {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Long cshId;

    @Column
    private byte[] zipFile;
    @Column
    private String name;

    public FileEntity() {
    }
    public FileEntity(String name) {
        this.zipFile = zipFile;
        this.name = name;
    }
    public FileEntity(byte[] zipFile, String name) {
        this.zipFile = zipFile;
        this.name = name;
    }

    public byte[] getZipFile() {
        return zipFile;
    }

    public void setZipFile(byte[] zipFile) {
        this.zipFile = zipFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "cshId=" + cshId +
                ", zipFile=" + Arrays.toString(zipFile) +
                ", name='" + name + '\'' +
                '}';
    }}

