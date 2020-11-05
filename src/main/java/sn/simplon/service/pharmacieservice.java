package sn.simplon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.simplon.entities.Pharmacie;
import sn.simplon.pharmaciedao.IPharmacie;

import java.util.List;

@RestController
public class pharmacieservice {

    @Autowired
    private IPharmacie pharmaciedao;

    @RequestMapping(value = "/pharmacie/list", method = RequestMethod.GET)
    public List<Pharmacie> getAll(){
        return pharmaciedao.findAll();
    }

    /*@RequestMapping(value = "/pharmacie/listQuartier/{quatier}", method = RequestMethod.GET)
    public List<Pharmacie> getAllByQuartier(@PathVariable String quartier){
        return pharmaciedao.getAllByQuartier(quartier);
    }*/
    @RequestMapping(value = "/pharmacie/listQuartier/{quartier}", method = RequestMethod.GET)
    public List<Pharmacie> getAllByQuartier(@PathVariable String quartier){
        return pharmaciedao.getAllByQuartier(quartier);
    }

    @RequestMapping(value = "/pharmacie/listVille/{ville}", method = RequestMethod.GET)
    public List<Pharmacie> getAllByVille(@PathVariable String ville){
        return pharmaciedao.getAllByVille(ville);
    }

    @RequestMapping(value = "/pharmacie/save", method = RequestMethod.POST)
    public List<Pharmacie> save(Pharmacie pharmacie){
        pharmaciedao.save(pharmacie);
        return pharmaciedao.findAll();
    }

    @RequestMapping(value = "/pharmacie/delete/{id}", method = RequestMethod.DELETE)
    public List<Pharmacie> delete(@PathVariable int id){
        if (pharmaciedao.getById(id) != null){
            pharmaciedao.delete(pharmaciedao.getById(id));
        }
        return pharmaciedao.findAll();
    }

    @RequestMapping(value = "/pharmacie/get/{id}", method = RequestMethod.GET)
    public Pharmacie getById(@PathVariable int id){
        return pharmaciedao.getById(id);
    }

    @RequestMapping(value = "/pharmacie/update/{id}", method = RequestMethod.PUT)
    public List<Pharmacie> update(@PathVariable int id, Pharmacie pharmacie){
        pharmacie.setId(id);
        pharmaciedao.save(pharmacie);
        return pharmaciedao.findAll();
    }

    @RequestMapping(value = "/pharmacie/listNom/{nom}", method = RequestMethod.GET)
    public List<Pharmacie> getAllByNom(@PathVariable String nom){
        return pharmaciedao.getAllByNom(nom);
    }

    @RequestMapping(value = "/pharmacie/ouverte/{etat}", method = RequestMethod.GET)
    public List<Pharmacie> getAllByOuverte(@PathVariable int etat){
        return pharmaciedao.getAllByOuverte(etat);
    }
}
