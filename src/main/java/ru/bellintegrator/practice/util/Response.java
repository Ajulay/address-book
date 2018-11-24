package ru.bellintegrator.practice.util;

import java.util.List;

public class Response <D>{
   private D view;

    public Response(D view) {
        this.view = view;
    }

    public String sendResult(){
        return "{\"result\":" +
                view.toString() +
                "}" ;
    }

    @Override
    public String toString() {

        return "{\"data\":" +
                view.toString() +
                "}" ;
    }
}
