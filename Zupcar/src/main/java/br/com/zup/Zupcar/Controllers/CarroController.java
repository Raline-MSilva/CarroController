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
    public List<CarroDTO> exibirTodosOsCarros() {
        return concessionaria;
    }

    @PostMapping // é o Request Mapping utilizando o Verbo POST do PROTOCOLO HTTP
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCarro(@RequestBody CarroDTO carroDTO) {
        concessionaria.add(carroDTO);
    }

    @GetMapping("/{nomeDoCarro}")
    public CarroDTO exibirCarro(@PathVariable String nomeDoCarro) {
        for (CarroDTO carroDTO : concessionaria) {
            if (carroDTO.getModelo().equals(nomeDoCarro)) {
                return carroDTO;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{nomeDoCarro}")
    public CarroDTO atualizarCarro(@PathVariable String nomeDoCarro, @RequestBody CarroDTO carroDTO) {
        for (CarroDTO carroObjeto : concessionaria) {
            if (carroObjeto.getModelo().equalsIgnoreCase(nomeDoCarro)) {
                carroObjeto.setAno(carroDTO.getAno());
                carroObjeto.setMotor(carroDTO.getMotor());
                carroObjeto.setCor(carroDTO.getCor());
                return carroObjeto;
            }

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{nomeDoCarro}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCarro(@PathVariable String nomeDoCarro) {

        //criando variavel do tipo DTO sendo igual null
        CarroDTO excluirCarro = null;

        for (CarroDTO carro : concessionaria) {
            if (carro.getModelo().equals(nomeDoCarro)) {

                //armazenando o objeto referencia na variavel
                excluirCarro = carro;

            }
        }
        //excluindo o carro (objeto referencia que agora tem o valor excluir carro)
        concessionaria.remove(excluirCarro);

        if (excluirCarro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
