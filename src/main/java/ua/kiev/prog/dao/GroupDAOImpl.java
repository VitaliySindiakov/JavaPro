package ua.kiev.prog.dao;

import org.springframework.stereotype.Repository;
import ua.kiev.prog.model.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GroupDAOImpl implements GroupDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Group group) {
        entityManager.persist(group);
    }

    @Override
    public void delete(String name) {
        removeFromList(name);
    }

    @Override
    public Group findOne(long id) {
        return entityManager.getReference(Group.class, id);
    }

    @Override
    public List<Group> list() {
        TypedQuery<Group> query = entityManager.createQuery("SELECT g FROM Group g", Group.class);
        return query.getResultList();
    }

    public void removeFromList(String name){
        TypedQuery<Group> query = entityManager.createQuery("SELECT g FROM Group g WHERE g.name=:name", Group.class);
        query.setParameter("name",name);
        entityManager.remove(query.getSingleResult());
    }
}
