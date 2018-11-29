package ru.bellintegrator.practice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.dao.officedao.OfficeDao;
import ru.bellintegrator.practice.dao.organizationdao.OrganizationDao;
import ru.bellintegrator.practice.dao.userdao.UserDao;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.User;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.model.util.Country;
import ru.bellintegrator.practice.model.util.Doc;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.UserView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserDao dao;
    private final MapperFacade mapperFacade;
    private final OfficeDao officeDao;

    @Autowired
    public UserService(UserDao dao, MapperFacade mapperFacade, OfficeDao officeDao) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
        this.officeDao = officeDao;
    }

    public List<UserView> getUsersByViewParam(UserView userViewParam) {
        List<User> users = dao.loadByViewParam(userViewParam);
        return getUserViewList(users);
    }

    private List<UserView> getUserViewList(List<User> users) {
        List<UserView> userViews = new ArrayList<>();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

        for (User user:users) {
            UserView userView = new UserView();
            userView.id = user.getId();
            userView.officeId = user.getOffice().getId();
            userView.firstName = user.getFirstName();
            userView.secondName = user.getSecondName();
            userView.middleName = user.getMiddleName();
            userView.position = user.getPosition();
            userView.phone = user.getPhone();
            userView.docName = user.getStatusUser().getDoc().getName();
            userView.docDate = formatDate.format(user.getStatusUser().getDocDate());
            userView.docNumber = user.getStatusUser().getDocNumber();
            userView.docCode = user.getStatusUser().getDoc().getCode();
            userView.citizenshipName = user.getStatusUser().getCountry().getName();
            userView.citizenshipCode = user.getStatusUser().getCountry().getCode();
            userView.isIdentified = user.isIdentified();
            userViews.add(userView);
        }

    return userViews;}


    public UserView findById(long id) {
        UserView userViewParam = new UserView();
        userViewParam.id = id;
        return getUsersByViewParam(userViewParam).get(0);

    }

    public String saveNewUser(UserView userView) {
        User user = new User();
        setUserDataFromUserView(user, userView);

        dao.save(user);

        return "success";
    }

    public String userUpdate(UserView userView) {
        User user = dao.loadById(userView.id);
        setUserDataFromUserView(user, userView);
        dao.update(user);

        return "success";
    }

    private User setUserDataFromUserView(User user, UserView userView){
        Office office = officeDao.loadById(userView.officeId);
        Doc doc = new Doc();
        Country country = new Country();

        doc.setCode(userView.docCode);
        doc.setName(userView.docName);
        user.setOffice(office);
        user.setFirstName(userView.firstName);
        user.setSecondName(userView.secondName);
        user.setMiddleName(userView.middleName);
        user.setPosition(userView.position);
        user.setPhone(userView.phone);
        user.getStatusUser().setDoc(doc);
        user.getStatusUser().setCountry(country);
        user.setFirstName(userView.firstName);
        user.setFirstName(userView.firstName);

        return user;
    }
}
