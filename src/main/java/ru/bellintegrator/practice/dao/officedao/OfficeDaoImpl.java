package ru.bellintegrator.practice.dao.officedao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.OrganizationView;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) { this.em = em; }

    @Override
    public List<Office> all() {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }

    @Override
    public Office loadById(Long id) {
        OfficeView officeView = new OfficeView();
        officeView.id = id;

        return loadByViewParam(officeView).get(0);
    }
//
    @Override
    public Office loadByName(String name) {
        OfficeView officeView = new OfficeView();
        officeView.name = name;
        return loadByViewParam(officeView).get(0);
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }

    @Override
    public List<Office> loadByViewParam(OfficeView officeView) {
        CriteriaQuery<Office> criteria = buildCriteria(officeView);
        TypedQuery<Office> query  = em.createQuery(criteria);

        return query.getResultList();
    }
    
    private CriteriaQuery<Office> buildCriteria(OfficeView officeView) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteria = builder.createQuery(Office.class);
        Root<Office> office = criteria.from(Office.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        //Проверка на наличие значения в представлении

        if(officeView.id > 0){
            predicates.add(builder.equal(office.get("id"), officeView.id));
        }
        if(officeView.name != null && !officeView.name.equals("")){
            predicates.add(builder.equal(office.get("name"), officeView.name));
        }
        if(officeView.orgId > 0){
            predicates.add(builder.equal(office.get("organization"), officeView.orgId));
        }

        if(officeView.address != null && !officeView.address.equals("")){
            predicates.add(builder.equal(office.get("address"), officeView.address));
        }
        if(officeView.phone != null && !officeView.phone.equals("")){
            predicates.add(builder.equal(office.get("phone"), officeView.phone));
        }
        if(officeView.isActive != null){
            predicates.add(builder.equal(office.get("active"), officeView.isActive));
        }

        criteria.where(predicates.toArray(new Predicate[]{}));

        return criteria;
    }

    public void update(Office office) {
        Office oldOffice = loadById(office.getId());
        oldOffice.setName(office.getName());
        oldOffice.setAddress(office.getAddress());
        if(office.getPhone()!=null && !office.getPhone().equals("")){
            oldOffice.setPhone(office.getPhone());
        }
        if(office.isActive()!=null) {
            oldOffice.setActive(office.isActive());
        }

    }

}
