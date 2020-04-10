package tests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import btp.model.MaitreOeuvre;
import btp.persistence.IMaitreOeuvreRepository;
import btp.persistence.IUtilisateurRepository;

public class TestUser {

	@Autowired
	private IUtilisateurRepository utilisateurDao;
	
	@Autowired
	private IMaitreOeuvreRepository moeuvreDao;
	
	@Test
	public void maitreoeuvre() {
		
		
		MaitreOeuvre bob2 = new MaitreOeuvre("Bob", "14521256431", "0649753159", "boblebricleur@gmail.fr", "354f435f41f");
		bob2 = moeuvreDao.save(bob2);
		
				
		
	}
}
