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

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImplTestMock {
	@Mock
	ProduitRepository produitRepository;

	@InjectMocks
	ProduitServiceImpl produitService;
	  @BeforeEach
	    public void setup() {
	    	MockitoAnnotations.openMocks(this);
	    }
	@Test
	public void retrieveAllproduitsTest() {
		when(produitRepository.findAll()).thenReturn(Stream.of(
                new Produit((long)1),
                new Produit((long)2), 
				new Produit((long)3))
                .collect(Collectors.toList()));
		assertEquals(3,produitService.retrieveAllProduits().size());
		
	}

	@Test
	public void addproduitTest() {
		Produit op = new Produit();
		op.setIdProduit(1L);		
		when(produitRepository.save(op)).thenReturn(op);
		assertEquals(op, produitService.addProduit(op));
	}

	@Test
	public void retreiveproduitTest() {
		Produit op = new Produit();
		op.setIdProduit(1L);
		when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
		Produit op1 = produitService.retrieveProduit((long) 2);
		assertNotNull(op1);

	}

	@Test
	public void deleteproduitTest() {
		Produit op = new Produit();
		op.setIdProduit(1L);
		produitService.deleteProduit((long) 1);
		verify(produitRepository).deleteById((long) 1);

	}

	@Test
	public void updatetproduitTest() {
		Produit op = new Produit((long)1);
		when(produitRepository.save(Mockito.any(Produit.class))).thenReturn(op);
		op.setLibelleProduit("mohamed");;
		Produit exisitingOp= produitService.updateProduit(op) ;
		
		assertNotNull(exisitingOp);
		assertEquals("mohamed", op.getLibelleProduit());
	}


}