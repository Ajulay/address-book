package ru.bellintegrator.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.dao.organizationdao.OrganizationDao;
import ru.bellintegrator.practice.model.Office;
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
    public String getOfficesByParam(@RequestBody OfficeView officeView) {

        try {
        if (officeView.orgId <= 0) {
            throw new Exception();
        }
        List<OfficeView> listViews = officeService.getOfficesByViewParam(officeView);
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (int i = 0; i < listViews.size(); i++) {
            JsonObjectBuilder builder = Json.createObjectBuilder();
            builder.add("id", listViews.get(i).id);
            builder.add("name", listViews.get(i).name);
            builder.add("isActive", listViews.get(i).isActive);
            arrayBuilder.add(builder);
        }
        return new Response(arrayBuilder.build()).toString();

    } catch (Exception e) {

        return "{error: Change parameters. Parameter 'name' is required always...}";

    }
}

    @GetMapping("/list")
    public String getOfficeById(@RequestParam long id) {

        try{
            if (id <= 0){
                throw new Exception();
            }
            OfficeView officeView = officeService.getOfficeByById(id);
            if(officeView == null){
                return new Response<>("офиса с id: " + id + " не существует").sendResult();
            }
                JsonObjectBuilder builder = Json.createObjectBuilder();
                builder.add("id", officeView.id);
                builder.add("name", officeView.name.trim());
                builder.add("address", officeView.address.trim());
                builder.add("phone", officeView.phone);
                builder.add("isActive", officeView.isActive);

            return  new Response<>(builder.build()).sendResult();
        } catch (Exception e) {

            return "{error: Введите корректный 'id'}";
        }
    }

    @PostMapping("/save")
    public String saveNewOffice(@RequestBody OfficeView officeView){
        if(officeView.name == null || officeView.name.equals("")||
           officeView.address == null || officeView.address.equals("")||
           officeView.orgId <= 0) { //инициатива: на мой взгляд нельзя передавать на сохранение пустые параметры
           return "{error: Введите реквизит: name}";
        }

        try {

            String data = officeService.saveNewOffice(officeView);
            return new Response<>(data).toString();

        } catch (Exception e) {
            return "{error: Данные не сохранены}";

        }
    }

    // “id”:””, //обязательный параметр
    //  “name”:””, //обязательный параметр
    //  “address”:””, //обязательный параметр
    @PostMapping("/update")
    public String officeUpdate(@RequestBody OfficeView officeView) {
        if(officeView.id <= 0 ||
           officeView.name == null || officeView.name.equals("") ||
           officeView.address == null || officeView.address.equals("")) {

            return "{error: Введите реквизит: name}";
        }


        try {
            String data = officeService.officeUpdate(officeView);
            return new Response<>(data).toString();

        } catch (Exception e) {
            return "{error: Введите корректный 'id'}";
        }
    }

}
