package dambi.accessingrelationaldata;

import java.sql.Date;
import java.util.Optional;

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

@RestController // This means that this class is a Controller baina @Controller bakarrik
				// jarrita, PUT eta DELETEak ez dabiz
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private LangileaRepository langileaRepository;

	@PostMapping(path = "/addLangileak") // Map ONLY POST Requests
	public @ResponseBody String addNewLangilaea(@RequestParam String email,
			@RequestParam String izena,
			@RequestParam String user,
			@RequestParam Date jaiotzadata,
			@RequestParam int taldea) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Langilea n = new Langilea();
		//n.setEmail(email);
		n.setIzena(izena);
		n.setUser(user);
		n.setJaiotzadata(jaiotzadata);
		n.setTaldea(taldea);
		langileaRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Langilea> getAllUsers() {
		// This returns a JSON or XML with the users
		return langileaRepository.findAll();
	}

	@GetMapping(path = "/zenbat")
	public @ResponseBody long countUsers() {
		// This returns a JSON or XML with the users
		return langileaRepository.count();
	}

	@GetMapping(path = "/bat")
	public @ResponseBody Optional<Langilea> get() {
		// This returns a JSON or XML with the users
		return langileaRepository.findById(1);
	}

	/*
	 * @PutMapping(value = "/update/{userId}")
	 * public ResponseEntity<Langilea> updateContact(@Valid @RequestBody Langilea
	 * user, @PathVariable int userId) {
	 * try {
	 * user.setEmail(userId);
	 * userRepository.save(user);
	 * 
	 * return ResponseEntity.ok().build();
	 * 
	 * } catch (Exception ex) {
	 * return ResponseEntity.notFound().build();
	 * }
	 * }
	 * 
	 * 
	 * // https://www.dariawan.com/tutorials/spring/spring-boot-jpa-hibernate-
	 * postgresql-restful-crud-api-example/#rest-controller
	 * 
	 * @DeleteMapping(path = "/delete/{userId}")
	 * public ResponseEntity<Void> deleteUserById(@PathVariable int userId) {
	 * try {
	 * userRepository.deleteById(userId);
	 * return ResponseEntity.ok().build();
	 * 
	 * } catch (Exception ex) {
	 * System.out.println("Errorea " + userId + " userra ezabatzerakoan. ");
	 * return ResponseEntity.notFound().build();
	 * 
	 * }
	 * }
	 * 
	 * @DeleteMapping(path = "/deletedanak")
	 * public void deleteDanak() {
	 * 
	 * userRepository.deleteAll();
	 * 
	 * }
	 * 
	 * // @PostMapping(path = "/saioberria") // Map ONLY POST Requests
	 * // public @ResponseBody String addNewSaioa(@RequestParam int iraupena) {
	 * // // @ResponseBody means the returned String is the response, not a view
	 * name
	 * // // @RequestParam means it is a parameter from the GET or POST request
	 * 
	 * // Saioa s = new Saioa();
	 * // s.setDuration(iraupena);
	 * // userRepository.save(n);
	 * // return "Saved";
	 * // }
	 */
}