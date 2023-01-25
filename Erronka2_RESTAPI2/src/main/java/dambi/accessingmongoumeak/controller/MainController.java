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
@RequestMapping(path = "/jolasak") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called umeaRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private PartidaRepository partidaRepository;
	private LangileaRepository langileaRepository;

	@GetMapping(path = "/langileGuztiak")
	public @ResponseBody Iterable<Langilea> getAllLangileak() {
		return langileaRepository.findAll();
	}

	@GetMapping(path = "/partidaGuztiak")
	public @ResponseBody Iterable<Partida> getAllPartida() {
		return partidaRepository.findAll();
	}

	@PostMapping(path = "/langileBerria") // Map ONLY POST Requests
	public @ResponseBody String addNewLangilea(@RequestParam String emaila, @RequestParam String izena,
			String erabiltzailea, Date jaiotzadata, int taldea) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Langilea u = new Langilea();
		u.setEmail(emaila);
		u.setIzena(izena);
		u.setErabiltzailea(erabiltzailea);
		u.setJaiotzadata(jaiotzadata);
		u.setTaldea(taldea);
		langileaRepository.save(u);
		return "Saved";
	}

	@PostMapping(path = "/partidaBerria") // Map ONLY POST Requests
	public @ResponseBody String addNewPartida(@RequestParam int id, @RequestParam String erabiltzailea,
			int puntuazioa, Date data) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Partida u = new Partida();
		u.setId(id);
		u.setErabiltzailea(erabiltzailea);
		u.setPuntuazioa(puntuazioa);
		u.setData(data);
		partidaRepository.save(u);
		return "Saved";
	}
/* 
	@PutMapping(value = "/opariberria/{umeaId}")
	public ResponseEntity<Partida> updateUmea(@Valid @RequestBody String opBerria, @PathVariable String umeaId) {
		try {
			Partida umea = umeaRepository.findById(umeaId);
			List<String> opariak = umea.getOpariak();
			opariak.add(opBerria);
			umea.setOpariak(opariak);
			umeaRepository.save(umea);

			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = "/delete/{LangilearenIzena}")
	public ResponseEntity<Void> deleteLangilea(@PathVariable String langilearenIzena) {
		try {
			long zenbat = langileaRepository.delete(langilearenIzena);
			System.out.println("Ezabatutako ume kopurua🔆: " + zenbat);
			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			System.out.println("Errorea " + umearenIzena + " umea ezabatzerakoan. ");
			return ResponseEntity.notFound().build();
		}
	}
*/
}