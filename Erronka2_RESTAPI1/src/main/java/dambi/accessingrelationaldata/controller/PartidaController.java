package dambi.accessingrelationaldata.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dambi.accessingrelationaldata.model.Langilea;
import dambi.accessingrelationaldata.model.Partida;
import dambi.accessingrelationaldata.services.PartidaServices;

@RestController // This means that this class is a Controller baina @Controller bakarrik
                // jarrita, PUT eta DELETEak ez dabiz
@RequestMapping(path = "/api") // This means URL's start with /demo (after Application path)
public class PartidaController {
    @Autowired
    private PartidaServices partidaServices;

    @PostMapping(path = "/addPartida") // Map ONLY POST Requests
    public @ResponseBody String addNewPartida(@RequestParam String email,
            @RequestParam String izena,
            @RequestParam String erabiltzailea,
            @RequestParam Date jaiotzadata,
            @RequestParam int taldea,
            @RequestParam float puntuazioa,
            @RequestParam Date data) {

        Langilea n = new Langilea();
        n.setEmail(email);
        n.setIzena(izena);
        n.setErabiltzailea(erabiltzailea);
        n.setJaiotza_data(jaiotzadata);
        n.setTaldea(taldea);
        Partida partida = new Partida();
        partida.setLangilea(n);
        partida.setPuntuazioa(puntuazioa);
        partida.setData(data);
        partidaServices.savePartida(partida);
        return "saved";
    }

    @GetMapping(path = "/allPartidak")
    public @ResponseBody Iterable<Partida> readPartidak() {
        return partidaServices.getAllPartidak();
    }

}
