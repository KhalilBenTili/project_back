package com.esprit.examen.services;



import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.services.FournisseurServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceImplMock {

	 @Mock
	 FournisseurRepository fournisseurRepository;

	 
	    @InjectMocks
	    FournisseurServiceImpl fournisseurServiceImpl;


	    @BeforeEach
	    public void setup() {
	    	MockitoAnnotations.openMocks(this);
	    }
	    @Test
	    public void addFournisseurTest() {
			
	    	Fournisseur ss = new Fournisseur(1L,"libelle2", "20", null, null, null, null);
	    	when(this.fournisseurRepository.save(Mockito.any())).thenReturn(ss);
	    assertEquals(ss, fournisseurServiceImpl.addFournisseur(ss));
	    }
	       
	    
	       
	        @Test
	    public void deleteFournisseurTest() {
	        	Fournisseur ss = new Fournisseur(1L,"libelle2", "20", null, null, null, null);
	        	when(this.fournisseurRepository.getById((Mockito.any()))).thenReturn(ss);
	        	fournisseurServiceImpl.deleteFournisseur(ss.getIdFournisseur());
	    verify(fournisseurRepository).deleteById(ss.getIdFournisseur());

	    }
	       


}
