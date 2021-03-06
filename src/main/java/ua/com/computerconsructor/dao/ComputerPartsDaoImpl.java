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
        ComputerParts computerParts = sessionFactory.getCurrentSession().load(ComputerParts.class, partId);
        if (!computerParts.equals(null)) {
            sessionFactory.getCurrentSession().delete(computerParts);
        }
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

    @Override
    @SuppressWarnings("unchecked")
    public List<ComputerParts> listParts(String param) {
        String query;

        if (param == null || param.equals("allParts")) {
            query = "FROM ComputerParts";
        } else if (param.equals("mandatory")) {
            query = "FROM ComputerParts E WHERE E.mandatory = true";
        } else if (param.equals("optional")) {
            query = "FROM ComputerParts E WHERE E.mandatory = false";
        } else {
            query = "FROM ComputerParts E WHERE E.partName like '%" + param + "%'";
        }

        Session session = this.sessionFactory.getCurrentSession();
        List<ComputerParts> partList = session.createQuery(query).list();

        return partList;
    }
}