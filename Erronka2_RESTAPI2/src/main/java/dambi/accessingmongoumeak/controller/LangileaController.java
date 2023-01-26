package dambi.accessingmongoumeak.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dambi.accessingmongoumeak.model.Langilea.Langilea;
import dambi.accessingmongoumeak.model.Langilea.LangileaRepository;
import dambi.accessingmongoumeak.model.Partida.Partida;
import dambi.accessingmongoumeak.model.Partida.PartidaRepository;

@RestController // This means that this class is a Controller baina @Controller bakarrik
				// jarrita, PUT eta DELETEak ez dabiz
@RequestMapping(path = "/langileak") // This means URL's start with /demo (after Application path)
public class LangileaController {
	@Autowired // This means to get the bean called umeaRepository
				// Which is auto-generated by Spring, we will use it to handle the data

	private LangileaRepository langileaRepository;


    @GetMapping(path = "/langileGuztiak")
	public @ResponseBody Iterable<Langilea> getLangileGuztiak() {
		
		return langileaRepository.findAll();
	}
  

	@GetMapping(path = "/langileaByErabiltzailea{erabiltzailea}")
	public @ResponseBody Langilea langileaByUser(String erabiltzailea) {
		// This returns a JSON or XML with the users
		return langileaRepository.langileaByUser(erabiltzailea);
	}



}