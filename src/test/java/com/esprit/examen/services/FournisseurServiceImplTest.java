package com.esprit.examen.services;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.services.FournisseurServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceImplTest {

	@Autowired
	FournisseurServiceImpl fournisseurService;

	//testing Add method
	@Test
	public void testAddFournisseur(){
	List<Fournisseur> fournisseurs = fournisseurService.retrieveAllFournisseurs();
	int expected = fournisseurs.size();
	Fournisseur o = new Fournisseur();
	o.setCode("code");
	o.setLibelle("20");
	Fournisseur savedFournisseur= fournisseurService.addFournisseur(o);
	assertEquals(expected+1, fournisseurService.retrieveAllFournisseurs().size());
	assertNotNull(savedFournisseur.getLibelle());
	fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());}
	

@Test
public void testUpdateFournisseur() {
Fournisseur o = new Fournisseur();
o.setCode("code");
o.setLibelle("20");
Fournisseur savedFournisseur= fournisseurService.addFournisseur(o);
savedFournisseur.setLibelle("hajer");
fournisseurService.updateFournisseur(savedFournisseur);
assertEquals(o.getLibelle(),savedFournisseur.getLibelle());
fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());
}
	@Test
	public void testRetrieveFournisseurs() {
	Fournisseur o = new Fournisseur();
	o.setCode("code");
	o.setLibelle("20");

	Fournisseur savedFournisseur= fournisseurService.addFournisseur(o);
	Fournisseur getFournisseur= fournisseurService.retrieveFournisseur(savedFournisseur.getIdFournisseur());
	assertNotNull(savedFournisseur.getCode());
	assertNotNull(savedFournisseur.getLibelle());
	assertEquals(savedFournisseur.getIdFournisseur(),getFournisseur.getIdFournisseur());
	fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());


	}
	@Test
	public void testDeleteFournisseur() {
		Fournisseur o = new Fournisseur();
		o.setCode("code");
		o.setLibelle("20");
	
		Fournisseur savedOperateur= fournisseurService.addFournisseur(o);
		fournisseurService.deleteFournisseur(savedOperateur.getIdFournisseur());
	assertNotNull(savedOperateur.getIdFournisseur());

	}

}