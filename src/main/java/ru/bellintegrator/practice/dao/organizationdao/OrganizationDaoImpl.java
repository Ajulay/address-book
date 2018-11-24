package ru.bellintegrator.practice.dao.organizationdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.Organization2;
import ru.bellintegrator.practice.model.Test;
import ru.bellintegrator.practice.view.OrganizationView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }

    @Override
    public Organization loadById(Long id) {
       Organization organization = em.find(Organization.class, id);
        return organization;
    }

    @Override
    public Organization loadByName(String name) {


        return null;
    }

    @Override
    public void save(Organization organization) {

        Query query = em.createNativeQuery("INSERT INTO organization(" +
                "name, fullname, inn, kpp, address, phone, active)" +
                "VALUES ('" + organization.getName() + "', '" + organization.getFullName() + "', '" +
                        organization.getInn() + "', '" + organization.getKpp()  + "','"  +
                organization.getAddress() +"', '" + organization.getPhone() +"', true)");
            query.executeUpdate();

    }

    public List<Organization> loadByViewParam(OrganizationView organizationView) {
        CriteriaQuery<Organization> criteria = buildCriteria(organizationView);
        TypedQuery<Organization> query = em.createQuery(criteria);


        return query.getResultList();
    }

    private CriteriaQuery<Organization> buildCriteria(OrganizationView organizationView) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

        Root<Organization> organization = criteria.from(Organization.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        //Проверка на наличие значения в представлении

       if(organizationView.id > 0){
            predicates.add(builder.equal(organization.get("id"), organizationView.id));
        }
        if(organizationView.name != null && !organizationView.name.equals("")){
            predicates.add(builder.equal(organization.get("name"), organizationView.name));
        }
        if(organizationView.fullName != null && !organizationView.fullName.equals("")){
            predicates.add(builder.equal(organization.get("fullname"), organizationView.fullName));
        }
        if(organizationView.inn != null && !organizationView.inn.equals("")){
            predicates.add(builder.equal(organization.get("inn"), organizationView.inn));
        }
        if(organizationView.kpp != null && !organizationView.kpp.equals("")){
           predicates.add(builder.equal(organization.get("kpp"), organizationView.kpp));
        }
        if(organizationView.address != null && !organizationView.address.equals("")){
            predicates.add(builder.equal(organization.get("address"), organizationView.address));
        }
        if(organizationView.phone != null && !organizationView.phone.equals("")){
            predicates.add(builder.equal(organization.get("phone"), organizationView.phone));
        }
        if(organizationView.active != null){
            predicates.add(builder.equal(organization.get("active"), organizationView.active));
        }

        criteria.where(predicates.toArray(new Predicate[]{}));

        return criteria;
    }

    public List<Organization2> testing() {
        TypedQuery<Organization2> query = em.createQuery("SELECT o FROM Organization2 o", Organization2.class);
        return query.getResultList();
    }
    public void update(Organization organization) {

            Organization oldOrg = loadById(organization.getId());
            oldOrg.setName(organization.getName());
            oldOrg.setFullName(organization.getFullName());
            oldOrg.setInn(organization.getInn());
            oldOrg.setKpp(organization.getKpp());
            oldOrg.setAddress(organization.getAddress());
            if(organization.getPhone()!=null && !organization.getPhone().equals("")){
                oldOrg.setPhone(organization.getPhone());
            }
            if(organization.isActive()!=null) {
                oldOrg.setActive(organization.isActive());
            }

    }

}
