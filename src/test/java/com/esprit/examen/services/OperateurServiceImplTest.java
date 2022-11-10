package com.esprit.examen.services;


import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {
	@Mock
	OperateurRepository operateurRepository;

	@InjectMocks
	OperateurServiceImpl operateurService;

	  @BeforeEach
	    public void setup() {
	    	MockitoAnnotations.openMocks(this);
	    }
	@Test
	public void  getAllOperaeurTest()
	{
		List<Operateur> list = new ArrayList<Operateur>() {
			{
				add (new Operateur(1L,"test1","tes1","5425",null));
				add (new Operateur(1L,"test11","tes12","56125",null));
				add (new Operateur(1L,"test12","tes11","56125",null));
			}};
		assertTrue(list.size()>0);
		Mockito.when(operateurService.retrieveAllOperateurs()).thenReturn(list);
		List<Operateur> list1 = operateurService.retrieveAllOperateurs();
		assertEquals(list1,list);
	}
	@Test
	public void test_addOperateur() {
		Operateur p= new Operateur();
		p.setIdOperateur(1L);
		Mockito.when(operateurRepository.save(any())).thenReturn(p);
		Operateur op = operateurService.addOperateur(p);
		 assertEquals(op.getIdOperateur(), p.getIdOperateur());
	}
	@Test
	public void delete() {
		Operateur p= new Operateur();
		p.setIdOperateur(1L);
		Operateur op = operateurService.addOperateur(p);
		operateurService.deleteOperateur(op.getIdOperateur());
		assertNotNull(op.getIdOperateur());	
	}
}