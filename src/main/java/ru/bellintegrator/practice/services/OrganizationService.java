package ru.bellintegrator.practice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.organizationdao.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.OrganizationView;

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
       List<OrganizationView> organizationViews =  mapperFacade.mapAsList(organizations, OrganizationView.class);
       // mapper не перекидывает Boolean
       for (int i = 0; i < organizations.size(); i++) {
            organizationViews.get(i).isActive = organizations.get(i).isActive();
        }
       return organizationViews;
    }

    @Transactional
    public String update(OrganizationView organizationView){
        Organization organization = mapperFacade.map(organizationView, Organization.class);
        organization.setActive(organizationView.isActive);
        dao.update(organization);

    return "success";}

    @Transactional
    public String save(OrganizationView organizationView){
        Organization organization = new Organization();
        organization.setName(organizationView.name);
        organization.setFullName(organizationView.fullName);
        organization.setInn(organizationView.inn);
        organization.setKpp(organizationView.kpp);
        organization.setAddress(organizationView.address);
        organization.setPhone(organizationView.phone);
        organization.setActive(organizationView.isActive);

        dao.save(organization);

        return "success";
        }

}


