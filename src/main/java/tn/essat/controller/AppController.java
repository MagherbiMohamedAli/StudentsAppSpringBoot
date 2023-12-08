package tn.essat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.dao.IEtudiant;
import tn.essat.model.Etudiant;

@RestController
public class AppController {

	@Autowired
	IEtudiant dao;
	
	@GetMapping("/etudiants")
	public List<Etudiant> f1(){
		return dao.findAll();
	}
	
	@PostMapping("/addEtudiant")
	public Etudiant f2(@RequestBody Etudiant etd) {
		dao.save(etd);
		return etd;	
	}
	
	@DeleteMapping("/deleteEtudiant/{id}")
	public String f3(@PathVariable("id") int id) {
		dao.deleteById(id);
		return "supprimé avec succèes";
	}
	
	
}
