package Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Model.Paziente;
import Services.PazienteService;

@RestController
@RequestMapping("/api/pazienti")
public class PazienteController {

	 @Autowired
	    private PazienteService pazienteService;

	    @GetMapping
	    public List<Paziente> getAllPazienti() {
	        return pazienteService.getAllPazienti();
	    }
	    
	    @GetMapping("/{pazienteid}")
	    public Optional<Paziente> getPaziente(@PathVariable String pazienteId) {
	        return pazienteService.getPaziente(pazienteId);
	    }
	    
	    @PostMapping
	    public Paziente createPaziente(@RequestBody Paziente paziente) {
	    	return pazienteService.addPaziente(paziente);
	    }
}
