package com.gwnu.smart.interfaces;
import com.gwnu.smart.application.Medicine1Service;
import com.gwnu.smart.domain.Medicine1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class Medicine1Controller {
    @Autowired
    private Medicine1Service medicine1Service;
    @GetMapping(value = "/medicine1/find",produces = "application/json;charset=utf-8")
    public List<Medicine1> list(@RequestParam String shape, @RequestParam String formula,
                                @RequestParam String color, @RequestParam String line){
        System.out.println("shape : "+ shape +",formula : "+formula +",color : "+color+",line : "+line+"\n" );
        //return medicine1Service.getList(shape, formula, color, line);
        return medicine1Service.getList("원형", formula, "하양", "-");
    }
    @PostMapping("/medicine1")
    public ResponseEntity<?> create(@RequestBody Medicine1 resource) throws URISyntaxException {
        medicine1Service.create(resource);
        URI location = new URI("/medicine1/"+resource.getId());
        return ResponseEntity.created(location).body("{}");
    }
    @PostMapping("/medicine1/createList")
    public ResponseEntity<?> addList(@RequestBody List<Medicine1> medicine1s) throws URISyntaxException {
        medicine1Service.addList(medicine1s);
        return ResponseEntity.created(new URI("/medeicine1/createList")).body("{}");
    }
    @PostMapping("/medicine1/uploadImage")
    public String fileUpload(@RequestPart MultipartFile files){
        try {
            String baseDir = "C:\\Users\\wnstl";
            files.transferTo(new File(baseDir + "\\"+ files.getOriginalFilename()));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    return "ok";
    }
}
