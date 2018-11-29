package ru.bellintegrator.practice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.dao.officedao.OfficeDao;
import ru.bellintegrator.practice.dao.organizationdao.OrganizationDao;
import ru.bellintegrator.practice.dao.userdao.UserDao;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.User;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.UserView;

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

    public List<UserView> getUsersByViewParam(UserView userView) {
        List<User> users = dao.loadByViewParam(userView);
        List<UserView> userViews = mapperFacade.mapAsList(users, UserView.class);

        return userViews;


    }
}
