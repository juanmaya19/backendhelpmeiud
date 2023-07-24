package co.edu.iudigital.helpmeiud.controller;


import co.edu.iudigital.helpmeiud.dto.response.DelitoDTO;
import co.edu.iudigital.helpmeiud.service.iface.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/delitos")
public class DelitoController {

    @Autowired
    IDelitoService delitoService;

    @GetMapping
    public ResponseEntity<List<DelitoDTO>> index(){
        return ResponseEntity
                .ok()
                .body(
                        delitoService.consultarTodos()
                );
    }
}
