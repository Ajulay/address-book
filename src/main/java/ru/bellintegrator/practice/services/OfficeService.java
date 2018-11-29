package ru.bellintegrator.practice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.officedao.OfficeDao;
import ru.bellintegrator.practice.dao.organizationdao.OrganizationDao;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.OrganizationView;

import java.util.List;

@Service
public class OfficeService {
    private final OfficeDao dao;
    private final MapperFacade mapperFacade;
    private final OrganizationDao organizationDao;

    @Autowired
    public OfficeService(OfficeDao dao, MapperFacade mapperFacade, OrganizationDao organizationDao) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
        this.organizationDao = organizationDao;
    }


    @Transactional(readOnly = true)
    public List<OfficeView> offices() {
        List<Office> all = dao.all();
        return mapperFacade.mapAsList(all, OfficeView.class);
    }
    @Transactional(readOnly = true)
    public List<OfficeView> getOfficesByViewParam(OfficeView officeView) {
        List<Office> offices = dao.loadByViewParam(officeView);

        return mapperFacade.mapAsList(offices, OfficeView.class);
    }
    @Transactional(readOnly = true)
    public OfficeView getOfficeByById(long id) {
        OfficeView officeView = new OfficeView();
        officeView.id = id;
        List<Office> offices = dao.loadByViewParam(officeView);
        officeView = mapperFacade.map(offices.get(0), OfficeView.class);
        return officeView;

    }
    @Transactional
    public String saveNewOffice(OfficeView officeView) {
        Office office = new Office();
        Organization organization = organizationDao.loadById(officeView.orgId);
        office.setOrganization(organization);
        office.setName(officeView.name);
        office.setAddress(officeView.address);
        office.setPhone(officeView.phone);
        office.setActive(officeView.isActive);

        dao.save(office);

        return "success";
    }
    @Transactional
    public String officeUpdate(OfficeView officeView) {
       // Organization organization = mapperFacade.map(organizationView, Organization.class);
        Office office = mapperFacade.map(officeView, Office.class);
        //при маппинге 'id' не добавляется
        Organization organization = organizationDao.loadById(officeView.orgId);
        office.setOrganization(organization);
        office.setActive(officeView.isActive);
        dao.update(office);

        return "success";
    }

//    @Transactional(readOnly = true)
//    public List<OrganizationView> getOrganizationByViewParam (OrganizationView organizationView){
//        List<Organization> organizations = dao.loadByViewParam(organizationView);
//
//        return mapperFacade.mapAsList(organizations, OrganizationView.class);
//    }
//
//    @Transactional
//    public String update(OrganizationView organizationView){
//        Organization organization = mapperFacade.map(organizationView, Organization.class);
//        //при маппинге 'id' не добавляется
//        organization.setId(organizationView.id);
//        dao.update(organization);
//
//        return "success";}
//
//    @Transactional
//    public String save(OrganizationView organizationView){
//        Organization organization = mapperFacade.map(organizationView, Organization.class);
//        //при маппинге 'id' не добавляется
//        //organization.setId(organizationView.id);
//        dao.save(organization);
//
//        return "success";}

}
