package DBApp;

import WebApp.FileJob;
import WebApp.Upload;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

public class TransactionController {
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    private Upload upload = new Upload();
    private FileJob fileJob = new FileJob();
    private List<Part> list = upload.getList();

    public TransactionController() {
    }

    public void toDataBase() throws IOException {
        for (Part part : list) {
            byte[] fileInByte = fileJob.getBytes(part.getInputStream());
            String name = fileJob.getFileName(part);
            FileEntity entityFile = new FileEntity(fileJob.toZip(name, fileInByte), name);
            doTransaction(entityFile);
        }
    }
    private void doTransaction(FileEntity object) {
        entityManagerFactory = Persistence.createEntityManagerFactory("archiveConfig");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(object);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

}
