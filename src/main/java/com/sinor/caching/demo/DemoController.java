package com.sinor.caching.demo;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping(path = "/demo/asd")
    private String asd() {
        return "asd";
    }

    @GetMapping(path = "/demo/tojson")
    private ResponseEntity<String> toJson() throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("key", "value");
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jo.toString());
    }

    @GetMapping(path = "/demo/responsebody")
    @ResponseBody
    public Map<String, Object> responseBody() {
        return Map.of("key", "value");
    }

    @PostMapping(path = "/demo/echobody")
    @ResponseBody
    public Map<String, Object> echoBody(@RequestBody Map<String, Object> body) {
        return body;
    }

    @GetMapping(path = "/demo/getfirstuser")
    @ResponseBody
    public DemoUserDto getFirstUser() {
        return demoService.getFirstUser();
    }

}

