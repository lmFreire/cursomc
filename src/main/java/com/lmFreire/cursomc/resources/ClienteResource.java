package com.lmFreire.cursomc.resources;

import com.lmFreire.cursomc.domain.Cliente;
import com.lmFreire.cursomc.dto.ClienteDTO;
import com.lmFreire.cursomc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping("{id}")
    public ResponseEntity<Cliente> find(@PathVariable Integer id){
        Cliente obj = service.find(id);

        return ResponseEntity.ok(obj);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id) {
        Cliente obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> findall(){
        List<Cliente> list = service.findAll();
        List<ClienteDTO> listDto = list.stream().map(ClienteDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(listDto);
    }

    @GetMapping("page")
    public ResponseEntity<Page<ClienteDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ){
        Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listDto = list.map(ClienteDTO::new);

        return ResponseEntity.ok(listDto);
    }


}
