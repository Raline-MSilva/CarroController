package br.com.zup.Zupcar.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("Motos")
public class MotoController {

    @GetMapping("/vespa")

    public HashMap<String, String> ExibirVespa() {
        HashMap<String, String> vespa = new HashMap<>();
        vespa.put("Cor", "Mel");
        vespa.put("Ano", "1900");
        vespa.put("Motor", "1.0");

        return vespa;
    }
}
