package co.edu.iudigital.helpmeiud.service.impl;

import co.edu.iudigital.helpmeiud.dto.request.DelitoDTORequest;
import co.edu.iudigital.helpmeiud.dto.response.DelitoDTO;
import co.edu.iudigital.helpmeiud.model.Delito;
import co.edu.iudigital.helpmeiud.repository.IDelitoRepository;
import co.edu.iudigital.helpmeiud.service.iface.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class DelitoServiceImpl implements IDelitoService {
    private IDelitoRepository delitoRepository;

    @Autowired // Inyección de Dependencias por constructor
    public DelitoServiceImpl(IDelitoRepository delitoRepository){
        this.delitoRepository = delitoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DelitoDTO> consultarTodos() {
        List<Delito> delitos = delitoRepository.findAll();
        return delitos.stream()
                .map(delito ->
                    DelitoDTO.builder()
                            .id(delito.getId())
                            .nombre(delito.getNombre())
                            .descripcion(delito.getDescripcion())
                            .build()
                ).collect(Collectors.toList());
    }

    @Override
    public DelitoDTO consultarPorId(Long id) {
        return null;
    }

    @Override
    public DelitoDTO guardarDelito(DelitoDTORequest delitoDTORequest) {
        return null;
    }

    @Override
    public void borrarDelitoPorId(Long id) {

    }
}
