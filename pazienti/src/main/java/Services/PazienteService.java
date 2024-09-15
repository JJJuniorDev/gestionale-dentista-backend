package Services;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.Paziente;
import Repository.PazienteRepository;

@Service
public class PazienteService {

	 @Autowired
	    private PazienteRepository pazienteRepository;

	    public List<Paziente> getAllPazienti() {
	        return pazienteRepository.findAll();
	    }

	    public List<Paziente> getPazientiByDentistaId(String dentistaId) {
	        return pazienteRepository.findByDentistaId(dentistaId);
	    }


	    public Optional<Paziente> getPaziente(String id) {
	    	return pazienteRepository.findById(id);
	    }

	    public Paziente addPaziente(Paziente paziente) {
	        return pazienteRepository.save(paziente);
	    }

	    public void deletePaziente(String id) throws AccountNotFoundException {

				if (pazienteRepository.existsById(id)) {
				        pazienteRepository.deleteById(id);
				    } else {
				        throw new AccountNotFoundException ("Paziente con ID " + id + " non trovato.");
				    }
			}
	    }

	    // Altri metodi di servizio per la logica di business, ad esempio aggiungi, modifica, cancella

