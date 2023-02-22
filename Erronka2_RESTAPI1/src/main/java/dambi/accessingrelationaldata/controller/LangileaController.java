package dambi.accessingrelationaldata.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dambi.accessingrelationaldata.model.Langilea;

import dambi.accessingrelationaldata.services.LangileaServices;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController // This means that this class is a Controller baina @Controller bakarrik
				// jarrita, PUT eta DELETEak ez dabiz
@RequestMapping(path = "/api") // This means URL's start with /demo (after Application path)
public class LangileaController {

	@Autowired
	private LangileaServices langileaServices;

	@PostMapping(path = "/addLangileak") // Map ONLY POST Requests
	public @ResponseBody String addNewLangilea(@RequestParam String email,
			@RequestParam String izena,
			@RequestParam String erabiltzailea,
			@RequestParam Date jaiotzadata,
			@RequestParam int taldea) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Langilea n = new Langilea();
		n.setEmail(email);
		n.setIzena(izena);
		n.setErabiltzailea(erabiltzailea);
		n.setJaiotzadata(jaiotzadata);
		n.setTaldea(taldea);
		langileaServices.saveLangilea(n);
		return "Saved";
	}

	@GetMapping(path = "/allLangileak")
	public @ResponseBody Iterable<Langilea> readLangileak() {
		// This returns a JSON or XML with the users
		return langileaServices.getAllLangileak();
	}

	@PutMapping(path = "/updateLangileak{erabiltzailea}") // Map ONLY POST Requests
	public @ResponseBody Langilea updateLangilea(@PathVariable String erabiltzailea,  
	Langilea langilea) {

		langilea.setErabiltzailea(erabiltzailea);

		return langileaServices.saveLangilea(langilea);

	}

	@DeleteMapping(path = "/delete/{erabiltzailea}")
	public ResponseEntity<Void> deleteUserById(@PathVariable String erabiltzailea) {
		try {
			langileaServices.deleteLangilea(erabiltzailea);
			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			System.out.println("Errorea " + erabiltzailea + " userra ezabatzerakoan. ");
			return ResponseEntity.notFound().build();

		}
	}

}
