package ru.bellintegrator.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.services.OfficeService;
import ru.bellintegrator.practice.services.UserService;
import ru.bellintegrator.practice.util.Response;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.UserView;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/api")
@Produces("application/json")
public class UserController {

    private final UserService userServiceService;

    @Autowired
    public UserController(UserService userService) {
        this.userServiceService = userServiceService;
    }


    @PostMapping("/user/list")
    public String getUsersByParam(@RequestBody UserView userView) {

        try {
            if (userView.officeId <= 0) {
                return "{error: Введите корректный id...}";
            }

            List<OfficeView> listViews = userServiceService.getUsersByViewParam(userView);

            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

            for (int i = 0; i < listViews.size(); i++) {
                JsonObjectBuilder builder = Json.createObjectBuilder();
                builder.add("id", listViews.get(i).id);
                builder.add("name", listViews.get(i).name);
                builder.add("isActive", listViews.get(i).isActive);
                 “id”:””,
  “firstName”:””,
  “secondName”:””,
  “middleName”:””,
  “position”:””
  “phone”,””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipName”:””,
  “citizenshipCode”:””,
  “isIdentified”:”true”

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
            OfficeView officeView = userServiceService.getOfficeByById(id);
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

            String data = userServiceService.saveNewOffice(officeView);
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
            String data = userServiceService.officeUpdate(officeView);
            return new Response<>(data).toString();

        } catch (Exception e) {
            return "{error: Введите корректный 'id'}";
        }
    }



}
