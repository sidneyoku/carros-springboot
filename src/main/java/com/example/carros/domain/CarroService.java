package com.example.carros.domain;

import com.example.carros.api.exception.ObjectNotFoundException;
import com.example.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    /**
     * Aula 25: JPA - Lista de Carros de banco de dados
     */
//    public Iterable<Carro> getCarros() {
//        return carroRepository.findAll();
//    }

    /**
     * Aula 38: Data Transfer Object - JPARepository
     */
//    public List<CarroDTO> getCarros() {
//
//        //Maneira 1)
////        List<Carro> carros = carroRepository.findAll();
////        List<CarroDTO> list = carros.stream().map(c -> new CarroDTO(c)).collect(Collectors.toList());
////        return list;
//
//        //Maneira 2)
//        return carroRepository.findAll().stream().map(CarroDTO::new).collect(Collectors.toList());
//    }

    /**
     * Aula 41: POST - 201 Created - URI location
     */
    public List<CarroDTO> getCarros() {
        return carroRepository.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    /**
     * Aula 20: Lista de Carros básico
     */
//    public List<Carro> getCarrosFake() {
//        List<Carro> carros = new ArrayList<>();
//
//        carros.add(new Carro(1L, "Fusca"));
//        carros.add(new Carro(2L, "Brasília"));
//        carros.add(new Carro(3L, "Chevette"));
//
//        return carros;
//    }

    /**
     * Aula 27: Get Carro by Id
     */
//    public Optional<Carro> getCarroById(Long id) {
//        return carroRepository.findById(id);
//    }

    /**
     * Aula 39: DTO parte 2 - lambda
     */
//    public Optional<CarroDTO> getCarroById(Long id) {
//        //Maneira 1)
////        Optional<Carro> optional = carroRepository.findById(id);
////
////        if (optional.isPresent()) {
////            return Optional.of(new CarroDTO(optional.get()));
////        } else {
////            return null;
////        }
//
//        //Maneira 2)
////        Optional<Carro> optional = carroRepository.findById(id);
////        return optional.map(c -> Optional.of(new CarroDTO((optional.get())))).orElse(null);
//
//        //Maneira 3)
//        return carroRepository.findById(id).map(CarroDTO::new);
//    }

    /**
     * Aula 41: POST - 201 Created - URI location
     */
//    public Optional<CarroDTO> getCarroById(Long id) {
//        return carroRepository.findById(id).map(CarroDTO::create);
//    }

    /**
     * Aula 54: ResponseStatus
     */
    public CarroDTO getCarroById(Long id) {
        return carroRepository.findById(id)
                .map(CarroDTO::create)
                .orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado."));
    }

    /**
     * Aula 28: Get Carro by Tipo
     */
//    public Iterable<Carro> getCarroByTipo(String tipo) {
//        return carroRepository.findByTipo(tipo);
//    }

    /**
     * Aula 35: GET - 204 No content (CrudRepository)
     */
//    public List<Carro> getCarroByTipo(String tipo) {
//        return carroRepository.findByTipo(tipo);
//    }

    /**
     * Auça 38: DTO - Data Transfer Object JPARepository
     */
//    public List<CarroDTO> getCarroByTipo(String tipo) {
//        return carroRepository.findByTipo(tipo).stream().map(CarroDTO::new).collect(Collectors.toList());
//    }

    /**
     * Aula 41: POST - 201 Created - URI location
     */
    public List<CarroDTO> getCarroByTipo(String tipo) {
        return carroRepository.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    /**
     * Aula 29: POST - Salvar Carro
     */
//    public Carro save(Carro carro) {
//        return carroRepository.save(carro);
//    }

    /**
     * Aula 30: PUT - Atualizar o Carro
     */
//    public Carro insert(Carro carro) {
//        Assert.isNull(carro.getId(), "Não foi possível inserir o registro.");
//        return carroRepository.save(carro);
//    }

    /**
     * Aula 41: POST - 201 Created - URI location
     */
    public CarroDTO insert(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possível inserir o registro.");
        return CarroDTO.create(carroRepository.save(carro));
    }

    /**
     * Aula 30: PUT - Atualizar o Carro
     */
//    public Carro update(Carro carro, Long id) {
//        Assert.notNull(id, "Não foi possível atualizar o carro.");
//
//        Optional<Carro> optional = getCarroById(id);
//        if (optional.isPresent()) {
//            Carro db = optional.get();
//            db.setNome(carro.getNome());
//            db.setTipo(carro.getTipo());
//            System.out.println("Carro Id " + db.getId());
//
//            carroRepository.save(db);
//            return db;
//        } else {
//            throw new RuntimeException("Não foi possível atualizar o registro");
//        }
//
//        /*getCarroById(id).map(db -> {
//           db.setNome(carro.getNome());
//           db.setTipo(carro.getTipo());
//           System.out.println("Carro Id: " + db.getId());
//
//           carroRepository.save(db);
//           return db;
//        }).orElseThrow(() -> new RuntimeException("Não foi possível atualizar o registro"));*/
//    }

    /**
     * Aula 39: DTO - parte 2 - lambdas
     */
//    public Carro update(Carro carro, Long id) {
//        Assert.notNull(id, "Não foi possível atualizar o carro.");
//
//        Optional<Carro> optional = carroRepository.findById(id);
//        if (optional.isPresent()) {
//            Carro db = optional.get();
//            db.setNome(carro.getNome());
//            db.setTipo(carro.getTipo());
//            System.out.println("Carro Id " + db.getId());
//
//            carroRepository.save(db);
//            return db;
//        } else {
//            throw new RuntimeException("Não foi possível atualizar o registro");
//        }
//    }

    /**
     * Aula 42: PUT
     */
    public CarroDTO update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o carro.");

        Optional<Carro> optional = carroRepository.findById(id);
        if (optional.isPresent()) {
            Carro db = optional.get();
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro Id " + db.getId());

            carroRepository.save(db);
            return CarroDTO.create(db);
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    /**
     * Aula 31: DELETE - Excluir um Carro
     */
//    public void delete(Long id) {
//        Optional<Carro> optional = getCarroById(id);
//        if (optional.isPresent()) {
//            carroRepository.deleteById(id);
//        }
//    }

    /**
     * Aula 39: DTO - parte 2 - lambda
     */
//    public void delete(Long id) {
//        if (getCarroById(id).isPresent()) {
//            carroRepository.deleteById(id);
//        }
//    }

    /**
     * Aula 43: DELETE
     */
//    public boolean delete(Long id) {
//        if (getCarroById(id).isPresent()) {
//            carroRepository.deleteById(id);
//            return true;
//        }
//
//        return false;
//    }

    /**
     * Aula 52: ExceptionHandler - parte 1
     */
    public void delete(Long id) {
        carroRepository.deleteById(id);
    }
}
