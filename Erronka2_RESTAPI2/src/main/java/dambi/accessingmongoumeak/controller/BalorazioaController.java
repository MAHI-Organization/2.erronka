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

import dambi.accessingmongoumeak.model.Jokoa;
import dambi.accessingmongoumeak.model.Balorazioa.Balorazioa;
import dambi.accessingmongoumeak.model.Balorazioa.BalorazioaRepository;
import dambi.accessingmongoumeak.model.Langilea.Langilea;
import dambi.accessingmongoumeak.model.Langilea.LangileaRepository;
import dambi.accessingmongoumeak.model.Partida.Partida;
import dambi.accessingmongoumeak.model.Partida.PartidaRepository;

@RestController // This means that this class is a Controller baina @Controller bakarrik
				// jarrita, PUT eta DELETEak ez dabiz
@RequestMapping(path = "/balorazioak") // This means URL's start with /demo (after Application path)
public class BalorazioaController {
	@Autowired // This means to get the bean called umeaRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private BalorazioaRepository balorazioaRepository;

	@PostMapping(path = "/balorazioBerria") // Map ONLY POST Requests
	public @ResponseBody String addKomentarioBerria(@RequestParam String erabiltzailea,@RequestParam int jokoaID,
		@RequestParam String jokoarenIzena,@RequestParam float balorazioa) {
				
		Jokoa jokoa = new Jokoa(jokoaID, jokoarenIzena);
		Balorazioa gordetzekoBalorazioa = new Balorazioa(erabiltzailea,jokoa,balorazioa);
		balorazioaRepository.save(gordetzekoBalorazioa);
		return "Saved";
	}

	@GetMapping(path = "/batazBestekoBalorazioa")
	public @ResponseBody float getJokoarenBatazBestekoa(String jokoarenIzena) {
		return balorazioaRepository.batazBestekoBalorazioa(jokoarenIzena);
	}

	@GetMapping(path = "/jokoarenBalorazioak")
	public @ResponseBody List<Balorazioa> getJokoarenBalorazioak(String jokoarenIzena) {
		return balorazioaRepository.jokoarenBalorazioa(jokoarenIzena);
	}

	/*@GetMapping(path = "/balorazioaByIzena")
	public @ResponseBody Balorazioa getBalorazioaByIzena(String izena,String jokoa) {
		return balorazioaRepository.findByErabiltzaileaJokoa(izena,jokoa);
	}*/

	@PutMapping(value = "/balorazioaAldatu/{erabiltzailea}/{jokoarenIzena}")
	public ResponseEntity<Balorazioa> updateBalorazioa(@Valid @RequestBody float balorazioBerria, @PathVariable String erabiltzailea,@PathVariable String jokoarenIzena) {
		try {
			Balorazioa balorazioa = balorazioaRepository.findByErabiltzaileaJokoa(erabiltzailea,jokoarenIzena);
			balorazioa.setBalorazioa(balorazioBerria);
			balorazioaRepository.deleteByErabiltzaileaJokoa(erabiltzailea, jokoarenIzena);
			balorazioaRepository.save(balorazioa);
			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
}