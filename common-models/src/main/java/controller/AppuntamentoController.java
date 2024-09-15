package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Appuntamento;
import model.Operazione;
import service.AppuntamentoService;

@RestController
@RequestMapping("/api/appuntamenti")
public class AppuntamentoController {

    @Autowired
    private AppuntamentoService appuntamentoService;

    @GetMapping
    public List<Appuntamento> getAllAppuntamenti() {
        return appuntamentoService.getAllAppuntamenti();
    }

    @GetMapping("/{appuntamentoId}")
    public Optional<Appuntamento> getAppuntamento(@PathVariable String appuntamentoId) {
        return appuntamentoService.getAppuntamento(appuntamentoId);
    }

    @PostMapping
    public Appuntamento createAppuntamento(@RequestBody Appuntamento appuntamento) {
        return appuntamentoService.createAppuntamento(appuntamento);
    }

    @PutMapping("/{appuntamentoId}")
    public Appuntamento updateAppuntamento(@PathVariable String appuntamentoId, @RequestBody Appuntamento appuntamento) {
        return appuntamentoService.updateAppuntamento(appuntamentoId, appuntamento);
    }

    @DeleteMapping("/{appuntamentoId}")
    public void deleteAppuntamento(@PathVariable String appuntamentoId) {
        appuntamentoService.deleteAppuntamento(appuntamentoId);
    }
    
    @PutMapping("/{id}/operazioni")
    public Appuntamento addOperazione(@PathVariable String id, @RequestBody Operazione operazione) {
        return appuntamentoService.addOperazioneToAppuntamento(id, operazione);
    }
}
