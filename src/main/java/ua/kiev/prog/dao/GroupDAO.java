package ua.kiev.prog.dao;

import ua.kiev.prog.model.Group;

import java.util.List;

public interface GroupDAO {
    void add(Group group);
    void delete(String name);
    Group findOne(long id);
    List<Group> list();
}
