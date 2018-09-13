package ua.com.computerconsructor.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.computerconsructor.model.ComputerParts;

import java.util.List;


@Transactional
@Repository
public class ComputerPartsDaoImpl implements ComputerPartsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addPart(ComputerParts part) {
        sessionFactory.getCurrentSession().saveOrUpdate(part);
    }

    @Override
    public void deletePart(Integer partId) {
        sessionFactory.getCurrentSession().delete(partId);
    }

    @Override
    public ComputerParts updatePart(ComputerParts part) {
        sessionFactory.getCurrentSession().update(part);
        return part;
    }

    @Override
    public ComputerParts getPart(int partId) {
        return (ComputerParts)
                sessionFactory.getCurrentSession().get(ComputerParts.class, partId);
    }

    @SuppressWarnings("unchecked")
    public List<ComputerParts> getAllParts() {
        return session().createQuery("from ComputerParts").list();

    }
}
