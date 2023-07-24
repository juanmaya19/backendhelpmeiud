package co.edu.iudigital.helpmeiud.controller;

import co.edu.iudigital.helpmeiud.dto.CasoDTO;
import co.edu.iudigital.helpmeiud.model.Caso;
import co.edu.iudigital.helpmeiud.service.iface.ICasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/casos")
public class CasoController {

    @Autowired
    private ICasoService casoService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<CasoDTO>> index(){
        return ResponseEntity
                .ok()
                .body(
                        casoService.consultarTodos()
                );
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Caso> create(
            @RequestBody @Valid CasoDTO casoDTO
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        casoService.crear(casoDTO)
                );
    }
}
