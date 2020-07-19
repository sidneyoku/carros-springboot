package com.example.carros.api;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import com.example.carros.domain.dto.CarroDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarroService carroService;

//    @GetMapping
//    public List<Carro> getCarrosFake() {
//        return carroService.getCarrosFake();
//    }

    /**
     * Aula 25: JPA - Lista de Carros de banco de dados
     */
//    @GetMapping
//    public Iterable<Carro> get() { return carroService.getCarros(); }

    /**
     * Aula 33: ResponseEntity
     */
//    @GetMapping
//    public ResponseEntity<Iterable<Carro>> get() {
//        // Maneira 1)
////        return new ResponseEntity<>(carroService.getCarros(), HttpStatus.OK);
//
//        // Maneira 2)
//        return ResponseEntity.ok(carroService.getCarros());
//    }

    /**
     * Aula 38: DTO - Data Transfer Object e JPARepository
     */
    @GetMapping
    public ResponseEntity<List<CarroDTO>> get() {
        return ResponseEntity.ok(carroService.getCarros());
    }

    /**
     * Aula 27: Get Carro by Id
     */
//    @GetMapping("/{id}")
//    public Optional<Carro> get(@PathVariable("id") Long id) {
//        return carroService.getCarroById(id);
//    }

    /**
     * Aula 34: GET - 404 Not Found
     */
//    @GetMapping("/{id}")
//    public ResponseEntity get(@PathVariable("id") Long id) {
//        Optional<Carro> optional = carroService.getCarroById(id);
//
//        // Maneira 1)
////        if (optional.isPresent()) {
////            Carro c = optional.get();
////            return ResponseEntity.ok(c);
////        } else {
////            return ResponseEntity.notFound().build();
////        }
//
//        // Maneira 2) Conceito e if ternário
////        return optional.isPresent() ?
////                ResponseEntity.ok(optional.get()) :
////                ResponseEntity.notFound().build();
//
//        // Maneira 3) Conceita de lambda
////        return optional.map(c -> ResponseEntity.ok(optional))
////                .orElse(ResponseEntity.notFound().build());
//        return optional.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    /**
     * Aula 39: DTO - parte 2 - lambda
     */
//    @GetMapping("/{id}")
//    public ResponseEntity get(@PathVariable("id") Long id) {
//        Optional<CarroDTO> optional = carroService.getCarroById(id);
//        return optional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }

    /**
     * Aula 54: ResponseStatus
     */
    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        CarroDTO carroDTO = carroService.getCarroById(id);
        return ResponseEntity.ok(carroDTO);
    }

    /**
     * Aula 28: Get Carro by Tipo
     */
//    @GetMapping("/tipo/{tipo}")
//    public Iterable<Carro> get(@PathVariable("tipo") String tipo) {
//        return carroService.getCarroByTipo(tipo);
//    }

    /**
     * Aula 35: GET - 204 No Content (CrudRepository)
     */
//    @GetMapping("/tipo/{tipo}")
//    public ResponseEntity get(@PathVariable("tipo") String tipo) {
//        List<Carro> lista = carroService.getCarroByTipo(tipo);
//
//        return  lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
//    }

    /**
     * Aula 38: DTO - Data Transfer Object e JPARepository
     */
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<CarroDTO>> get(@PathVariable("tipo") String tipo) {
        List<CarroDTO> lista = carroService.getCarroByTipo(tipo);

        return  lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }




    /**
     * Aula 29: POST - Salvar carro
     */
//    @PostMapping
//    public String post(@RequestBody Carro carro) {
//        Carro c = carroService.save(carro);
//        return "Carro salvo com sucesso: " + c.getId();
//    }

    /**
     * Aula 30: PUT - Atualizar o Carro
     * Mas aqui é salvar foi mudado nessa aula 30
     */
//    @PostMapping
//    public String post(@RequestBody Carro carro) {
//        Carro c = carroService.insert(carro);
//        return "Carro salvo com sucesso: " + c.getId();
//    }

    /**
     * Aula 41: POST - 201 Created - URI location
     */
//    @PostMapping
//    public ResponseEntity post(@RequestBody Carro carro) {
//        try {
//            CarroDTO c = carroService.insert(carro);
//
//            URI uri = getUri(c.getId());
//            return ResponseEntity.created(uri).build();
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().build();
//        }
//    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    /**
     * Aula 53: ExceptionHandler - parte 2
     */
    @PostMapping
    @Secured({ "ROLE_ADMIN" })
    public ResponseEntity post(@RequestBody Carro carro) {
        CarroDTO carroDTO = carroService.insert(carro);

        URI location = getUri(carroDTO.getId());
        return ResponseEntity.created(location).build();

    }

    /**
     * Aula 30: PUT - Atualizar o Carro
     */
//    @PutMapping("/{id}")
//    public String put(@PathVariable("id") Long id, @RequestBody Carro carro) {
//        Carro c = carroService.update(carro, id);
//        return "Carro atualizado com sucesso: " + c.getId();
//    }

    /**
     * Aula 42: PUT
     */
    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Carro carro) {
        CarroDTO c = carroService.update(carro, id);
        URI location = getUri(id);
        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    /**
     * Aula 31: DELETE - Exclui um Carro
     */
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        carroService.delete(id);
//        return "Carro deletado com sucesso.";
//    }

    /**
     * Aula 43: DELETE
     */
//    @DeleteMapping("/{id}")
//    public ResponseEntity delete(@PathVariable("id") Long id) {
//        boolean ok = carroService.delete(id);
//        return ok ?
//                ResponseEntity.ok().build() :
//                ResponseEntity.notFound().build();
//    }

    /**
     * Aula 52: ExceptionHandler - parte 1
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        carroService.delete(id);
        return ResponseEntity.ok().build();
    }
}
