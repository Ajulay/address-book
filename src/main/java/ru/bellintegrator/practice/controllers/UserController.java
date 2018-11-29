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

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user/list")
    public String getUsersByParam(@RequestBody UserView userView) {

        try {
            if (userView.officeId <= 0) {
                return "{error: Введите корректный id...}";
            }

            List<UserView> listViews = userService.getUsersByViewParam(userView);
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

            for (int i = 0; i < listViews.size(); i++) {
                arrayBuilder.add(getJsonUserView(listViews.get(i)));
            }
            return new Response(arrayBuilder.build()).toString();

        } catch (Exception e) {

          //  return "{error: Change parameters. Parameter 'name' is required always...}";
            return e.getMessage();

        }
    }

    @GetMapping("/list")
    public String getUserById(@RequestParam long id) {
        if (id <= 0){
            return "{error: Введите корректный 'id'}";
        }

        try{


            UserView userView = userService.findById(id);


            if(userView == null){
                return new Response<>("сотрудника с id: " + id + " не существует").sendResult();
            }
            JsonObjectBuilder builder = getJsonUserView(userView);
            return new Response<>(builder.build()).sendResult();
        } catch (Exception e) {

            return "{error:  Ошибка при получениии данных}";
        }
    }

    @PostMapping("/save")
    public String saveNewUser(@RequestBody UserView userView){

        if(userView.firstName == null || userView.firstName.equals("")||
                userView.officeId <= 0 ||
                userView.position == null || userView.firstName.equals("")
                ) {
            return "{error: Введите обязательные реквизиты...}";
        }

        try {

            String data = userService.saveNewUser(userView);
            return new Response<>(data).toString();

        } catch (Exception e) {
            return "{error: Данные не сохранены}";

        }
    }

    @PostMapping("/update")
    public String userUpdate(@RequestBody UserView userView) {
        if(userView.id <= 0 ||
                userView.firstName == null || userView.firstName.equals("") ||
                userView.position == null || userView.position.equals("")) {

            return "{error: Введите обязательные реквизит: id, firstName, position}";
        }


        try {
            String data = userService.userUpdate(userView);
            return new Response<>(data).toString();

        } catch (Exception e) {
            return "{error: Введите корректный 'id'}";
        }
    }

        private JsonObjectBuilder getJsonUserView(UserView userView){
        JsonObjectBuilder builder = Json.createObjectBuilder();
            builder.add("id", userView.id);
            builder.add("firstName", userView.firstName);
            builder.add("secondName", userView.secondName);
            builder.add("middleName", userView.middleName);
            builder.add("position", userView.position);
            builder.add("phone", userView.phone);
            builder.add("docName", userView.docName);
            builder.add("docNumber", userView.docNumber);
            builder.add("docDate", userView.docDate);
            builder.add("citizenshipName", userView.citizenshipName);
            builder.add("citizenshipCode", userView.citizenshipCode);
            builder.add("isIdentified", userView.isIdentified);

        return builder;}

}
