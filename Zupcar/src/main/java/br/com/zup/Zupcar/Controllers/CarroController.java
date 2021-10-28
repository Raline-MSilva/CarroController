package br.com.zup.Zupcar.Controllers;


import br.com.zup.Zupcar.Dtos.CarroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/carros")
// Mapea as requisições para o endpoint nele contido
public class CarroController {
    private List<CarroDTO> concessionaria = new ArrayList<>();

    @GetMapping
    public List<CarroDTO> exibirTodosOsCarros(){
        return concessionaria;
    }
    @PostMapping // é o Request Mapping utilizando o Verbo POST do PROTOCOLO HTTP
    public void cadastrarCarro(@RequestBody CarroDTO carroDTO){
        concessionaria.add(carroDTO);
    }
    @GetMapping("/{nomeDoCarro}")
    public CarroDTO exibirCarro(@PathVariable String nomeDoCarro) {
        for (CarroDTO carroDTO: concessionaria){
            if (carroDTO.getModelo().equals(nomeDoCarro)){
                return carroDTO;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{nomeDoCarro}")
    public CarroDTO atualizarCarro(@PathVariable CarroDTO nomeDoCarro){
        for (CarroDTO carroObjeto: concessionaria) {
            if (nomeDoCarro.getModelo().equals(carroObjeto.getModelo()));
            exibirCarro("Fusca");
            cadastrarCarro(carroObjeto);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
