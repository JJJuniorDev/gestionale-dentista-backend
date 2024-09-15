package service;


import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Appuntamento;
import model.Operazione;
import repository.AppuntamentoRepository;

@Service
public class AppuntamentoService {

    @Autowired
    private AppuntamentoRepository appuntamentoRepository;

    public List<Appuntamento> getAllAppuntamenti() {
        return appuntamentoRepository.findAll();
    }

    public Optional<Appuntamento> getAppuntamento(String id) {
        ObjectId objectId = new ObjectId(id);
        return appuntamentoRepository.findById(objectId);
    }

    public Appuntamento createAppuntamento(Appuntamento appuntamento) {
        return appuntamentoRepository.save(appuntamento);
    }

    public void deleteAppuntamento(String id) {
        ObjectId objectId = new ObjectId(id);
        appuntamentoRepository.deleteById(objectId);
    }

    public Appuntamento updateAppuntamento(String id, Appuntamento newAppuntamento) {
        ObjectId objectId = new ObjectId(id);
        return appuntamentoRepository.findById(objectId)
            .map(appuntamento -> {
            	   try {
                       if (newAppuntamento.getDataEOrario() != null) {
                           appuntamento.setDataEOrario(newAppuntamento.getDataEOrario());
                       }
                       if (newAppuntamento.getCodiceFiscalePaziente() != null) {
                           appuntamento.setCodiceFiscalePaziente(newAppuntamento.getCodiceFiscalePaziente());
                       }
                       if (newAppuntamento.getTrattamento() != null) {
                           appuntamento.setTrattamento(newAppuntamento.getTrattamento());
                       }
                       if (newAppuntamento.getNote() != null) {
                           appuntamento.setNote(newAppuntamento.getNote());
                       }
                       if (newAppuntamento.getOperazioni() != null) {
                           appuntamento.setOperazioni(newAppuntamento.getOperazioni());
                       }
                       return appuntamentoRepository.save(appuntamento);
                   } catch (Exception e) {
                       System.out.printf("Error during mapping: {}", e.getMessage());
                       throw e; // Re-throw the exception after logging
                   }
               })
            .orElseGet(() -> {
                newAppuntamento.setId(id);
                return appuntamentoRepository.save(newAppuntamento);
            });
    }
        public Appuntamento addOperazioneToAppuntamento(String appuntamentoId, Operazione operazione) {
            ObjectId objectId = new ObjectId(appuntamentoId);
            Optional<Appuntamento> optionalAppuntamento = appuntamentoRepository.findById(objectId);
            if (optionalAppuntamento.isPresent()) {
                Appuntamento appuntamento = optionalAppuntamento.get();
                appuntamento.getOperazioni().add(operazione);
                return appuntamentoRepository.save(appuntamento);
            } else {
                throw new RuntimeException("Appuntamento non trovato con ID: " + appuntamentoId);
            }
        }
    }

