package ru.bellintegrator.practice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.organizationdao.OrganizationDao;
import ru.bellintegrator.practice.dao.testdao.TestDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.Test;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.util.Response;
import ru.bellintegrator.practice.view.OrganizationView;
import ru.bellintegrator.practice.view.TestView;

import java.util.List;
@Service
public class OrganizationService {
    private final OrganizationDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationService(OrganizationDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }


    @Transactional(readOnly = true)
    public List<OrganizationView> organizations() {
        List<Organization> all = dao.all();
        return mapperFacade.mapAsList(all, OrganizationView.class);
    }

    @Transactional(readOnly = true)
    public List<OrganizationView> getOrganizationByViewParam (OrganizationView organizationView){
       List<Organization> organizations = dao.loadByViewParam(organizationView);

       return mapperFacade.mapAsList(organizations, OrganizationView.class);
    }

    @Transactional
    public String update(OrganizationView organizationView){
        Organization organization = mapperFacade.map(organizationView, Organization.class);
        //при маппинге 'id' не добавляется
        organization.setId(organizationView.id);
        dao.update(organization);

    return "success";}

    @Transactional
    public String save(OrganizationView organizationView){
        Organization organization = mapperFacade.map(organizationView, Organization.class);
        //при маппинге 'id' не добавляется
        //organization.setId(organizationView.id);
        dao.save(organization);

        return "success";}

}


