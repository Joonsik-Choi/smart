package com.gwnu.smart.interfaces;

import com.gwnu.smart.domain.Light;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.*;

@RestController
public class ArduinoController {
    ServerSocket server;
    Socket socket;
    ArduinoController() throws IOException {
    }

    @PostMapping("/arduino")
    public String hello(@RequestBody Light light) throws IOException {
            DatagramSocket sender=new DatagramSocket();
            String data="{on:"+light.getState()+"}";
            byte[] buffer=data.getBytes();
            DatagramPacket dp=new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 5000);
            sender.send(dp);
            //            bout.write("{ on:true}\r\n");
//            bout.flush();
        return "ok";
    }
}
