package com.esprit.examen.services;

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


import com.esprit.examen.entities.Facture;

import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.OperateurRepository;

import java.util.Date;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplMock {

	@Mock
	 FactureRepository factureRepository;
	
    @InjectMocks
    FactureServiceImpl factureServicemock;
    

    @Mock
     OperateurRepository operateurRepository;
    
    
    
    @BeforeEach
    public void setup() {
    	MockitoAnnotations.openMocks(this);
    }
    @Test
    public void retrieveAllFactures() {
        when(factureRepository.findAll()).thenReturn(Stream
            .of(new Facture(1L, 10,1000,new Date(),null,null, null, null, null), new Facture(2L, 10,1000,new Date(),null,null, null, null, null))
            .collect(Collectors.toList())
      );
      assertEquals(2, factureServicemock.retrieveAllFactures().size());
    }

    @Test
    public void addFacture() {
        //mock detail facture
    	 Facture facture = new Facture(1L, 10,1000,new Date(),null,null, null, null, null);
      Mockito.when(this.factureRepository.save(Mockito.any())).thenReturn(facture);
      Facture savedFacture = factureServicemock.addFacture(facture);
      assertNotNull(savedFacture.getIdFacture() );
      
    }

    @Test
    public void cancelFacture() {
    	 Facture facture = new Facture(1L, 10,1000,new Date(),null,null, null, null, null);
    	 factureServicemock.cancelFacture(1L);
        assertEquals(facture.getArchivee(), true);
    }

    @Test
    public  void retrieveFacture() {
    	Facture f = new Facture(1L, 10,1000,new Date(),null,null, null, null, null);
    	when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
    	  Facture f1 = factureServicemock.retrieveFacture((long) 2);
    	 assertNotNull(f1);
    	


    }
}
