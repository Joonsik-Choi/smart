package com.gwnu.smart.interfaces;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.*;

@RestController
public class SpkerController {
    ServerSocket server;
    Socket socket;
    @PostMapping("/spker/answer.test")
    public String test(@RequestBody String jsonStr){
        System.out.println(jsonStr);
        String s="{\n" +
                "  \"version\": \"2.0\",\n" +
                "  \"resultCode\": \"OK\",\n" +
                "  \"output\": {\n" +
                "    \"content\": \"안녕\",\n" +
                "    \"name\": \"수인\",\n" +
                "    \"response\" :\"ㅎㅇㅎㅇ\"\n" +
                "  }\n" +
                "}";
        return s;
    }
    @PostMapping("/spker/answer.light")
    public String lightTest(@RequestBody String jsonStr) throws IOException, ParseException {
        System.out.println(jsonStr);
        JSONParser jsonParser = new JSONParser();

        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonStr);
        jsonObject=(JSONObject)jsonObject.get("action");
        jsonObject=(JSONObject)jsonObject.get("parameters");
        jsonObject=(JSONObject)jsonObject.get("state");
        String type=(String)jsonObject.get("type");
        String value=(String)jsonObject.get("value");
        System.out.print("type : " +type+"\n");
        System.out.print("value : " +value+"\n");
        boolean state=(value.equals("불켜줘"))?true:false;
        String light_state=(state)?"켜졌습니다":"꺼졌습니다";
        String s="{\n" +
                "  \"version\": \"2.0\",\n" +
                "  \"resultCode\": \"OK\",\n" +
                "  \"output\": {\n" +
                "   \"light_state\" :\""+light_state+"\"\n" +
                "  }\n" +
                "}";
        DatagramSocket sender=new DatagramSocket();

        String data="{on:"+state+"}";
        byte[] buffer=data.getBytes();
        DatagramPacket dp=new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 5000);
        sender.send(dp);
        return s;
    }
}
