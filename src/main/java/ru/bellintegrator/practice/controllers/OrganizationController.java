package ru.bellintegrator.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.dao.organizationdao.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.services.OrganizationService;
import ru.bellintegrator.practice.util.Response;
import ru.bellintegrator.practice.view.OrganizationView;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/organization")
@Produces("application/json")
public class OrganizationController {

    private final OrganizationService organizationService;
    //testing
    private final OrganizationDao dao;
    private final MapperFacade fasade;

    @Autowired
    public OrganizationController(OrganizationService organizationService, OrganizationDao dao, MapperFacade fasade) {
        this.organizationService = organizationService;
        this.dao = dao;
        this.fasade = fasade;
    }

    @PostMapping("/list")
    public String organizations(@RequestBody OrganizationView organizationView) {
        try {
            if (organizationView.name == null || organizationView.name.trim().equals("")) {
                throw new Exception();
            }


            List<OrganizationView> listViews = organizationService.getOrganizationByViewParam(organizationView);
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

            for (int i = 0; i < listViews.size(); i++) {
                JsonObjectBuilder builder = Json.createObjectBuilder();
                builder.add("id", listViews.get(i).id);
                builder.add("name", listViews.get(i).name.trim());
                builder.add("isActive", listViews.get(i).active);
                arrayBuilder.add(builder);
            }

            return new Response(arrayBuilder.build()).toString();

        } catch (Exception e) {

            return "{error: Change parameters. Parameter 'name' is required always...}";
        }


        // return organizationService.getOrganizationByViewParam(organizationView).toString();
    }




    @GetMapping("/test")
    public String persons() {
        return "{" + "ura2" + "}";
    }


    @GetMapping("/")
    public String getOrganizationById(@RequestParam long id) {

        try{
      if (id==0){
          throw new Exception();
      }
      OrganizationView organizationView = new OrganizationView();
      organizationView.id= id;
      List<OrganizationView> list = organizationService.getOrganizationByViewParam(organizationView);
      OrganizationView view = list.get(0);
        return  new Response<>(view).sendResult();
        } catch (Exception e) {

    return "{error: Введите корректный 'id'}";
}
    }

    @PostMapping("/update")
    public String getOrganizationById(@RequestBody OrganizationView organizationView) {

        try {

            String data = organizationService.update(organizationView);
            return new Response<>(data).toString();

        } catch (Exception e) {
            return "{error: Введите корректный 'id'}";
        }
    }

    @PostMapping("/save")
    public String saveNewOrganization(@RequestBody OrganizationView organizationView){
        try {

            String data = organizationService.save(organizationView);
            return new Response<>(data).toString();

        } catch (Exception e) {
            return "{error: Введите корректный 'id'}";
        }
    }

}
