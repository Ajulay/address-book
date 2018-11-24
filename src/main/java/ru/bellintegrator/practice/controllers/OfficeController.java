package ru.bellintegrator.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.dao.organizationdao.OrganizationDao;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.services.OfficeService;
import ru.bellintegrator.practice.services.OrganizationService;
import ru.bellintegrator.practice.util.Response;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.OrganizationView;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/office")
@Produces("application/json")
public class OfficeController {


    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }


    @PostMapping("/list")
    public String getAllOffices(@RequestBody OfficeView officeView) {

        try {
        if (officeView.orgId <= 0) {
            throw new Exception();
        }
        List<OfficeView> listViews = officeService.getOfficesByViewParam(officeView);
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

}
