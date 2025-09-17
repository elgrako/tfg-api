package com.api.tfg.controller.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/mensaje")
    @SendTo("/topic/respuesta")
    public String enviarMensaje(String mensaje) {
        return "Mensaje recibido: " + mensaje;
    }
}
