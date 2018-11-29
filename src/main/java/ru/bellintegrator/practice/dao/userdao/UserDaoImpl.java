package ru.bellintegrator.practice.dao.userdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization2;
import ru.bellintegrator.practice.model.User;
import ru.bellintegrator.practice.model.util.Country;
import ru.bellintegrator.practice.model.util.Doc;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.UserView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) { this.em = em; }

    @Override
    public List<User> all() {

        return null;
    }

    @Override
    public User loadById(Long id) {
        return null;
    }

    @Override
    public User loadByName(String name) {
        return null;
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public List<User> loadByViewParam(UserView userView) {
        CriteriaQuery<User> criteria = buildCriteria(userView);
        TypedQuery<User> query  = em.createQuery(criteria);
       // List<User> list = query.getResultList();
        TypedQuery<User> query2 = em.createQuery("SELECT o FROM User o", User.class);
        List<User> list = query2.getResultList();

        return list;
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    private CriteriaQuery<User> buildCriteria(UserView userView) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        //Проверка на наличие значения в представлении

//        if(userView.id > 0){
//            predicates.add(builder.equal(userRoot.get("id"), userView.id));
//        }

//        if(userView.officeId > 0){
//          //  predicates.add(builder.equal(userRoot.get("office_id"), userView.officeId));
//        }
//
//        if(userView.firstName != null && !userView.firstName.equals("")){
//            predicates.add(builder.equal(userRoot.get("first_name"), userView.firstName));
//        }
//
//        if(userView.secondName != null && !userView.secondName.equals("")){
//            predicates.add(builder.equal(userRoot.get("second_name"), userView.secondName));
//        }
//
//        if(userView.middleName != null && !userView.middleName.equals("")){
//            predicates.add(builder.equal(userRoot.get("middle_name"), userView.middleName));
//        }
//
//        if(userView.position != null && !userView.position.equals("")){
//            predicates.add(builder.equal(userRoot.get("position"), userView.position));
//        }
//
//        if(userView.phone != null && !userView.phone.equals("")){
//            predicates.add(builder.equal(userRoot.get("phone"), userView.phone));
//        }
//
//        if(userView.docNumber != null && !userView.docNumber.equals("")){
//            predicates.add(builder.equal(userRoot.get("doc_number"), userView.docNumber));
//        }
//
//        if(userView.docDate != null && !userView.docDate.equals("")){
//            predicates.add(builder.equal(userRoot.get("doc_date"), userView.docDate));
//        }
//
//        if(userView.docName != null && !userView.docName.equals("") ||
//           userView.docCode != null && !userView.docCode.equals("")
//                ){
//            predicates.add(builder.equal(userRoot.get("doc_id"), getIdDoc(userView.docCode, userView.docName)));
//        }
//
//        if(userView.citizenshipName != null && !userView.citizenshipName.equals("") ||
//                userView.citizenshipCode != null && !userView.citizenshipCode.equals("")
//                ){
//            predicates.add(builder.equal(userRoot.get("country_id"), getIdCountry(userView.citizenshipName, userView.citizenshipCode)));
//        }
//
//        if(userView.isIdentified != null){
//            predicates.add(builder.equal(userRoot.get("identified"), userView.isIdentified));
//        }

      //  criteria.where(predicates.toArray(new Predicate[]{}));
        criteria.select(userRoot);
        return criteria;
    }

    private Long getIdDoc(String docCode, String docName) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Doc> criteria = builder.createQuery(Doc.class);
        Root<Doc> docRoot = criteria.from(Doc.class);
        if(docCode != null && !docCode.equals("")) {
            criteria.where(builder.equal(docRoot.get("code"), docCode));
        }
        else if(docName != null && !docName.equals("")) {
            criteria.where(builder.equal(docRoot.get("name"), docName));
        }

        TypedQuery<Doc> query  = em.createQuery(criteria);
        Long id = query.getSingleResult().getId();

        return id;
    }

    private Long getIdCountry(String citizenshipName, String citizenshipCode) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = builder.createQuery(Country.class);
        Root<Country> countryRoot = criteria.from(Country.class);
        if(citizenshipName != null && !citizenshipName.equals("")) {
            criteria.where(builder.equal(countryRoot.get("code"), citizenshipName));
        }
        else if(citizenshipCode != null && !citizenshipCode.equals("")) {
            criteria.where(builder.equal(countryRoot.get("name"), citizenshipCode));
        }
        TypedQuery<Country> query  = em.createQuery(criteria);

        return query.getSingleResult().getId();
    }

}
