

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import dataAccess.DataAccess;
import test.TestDataAccess;

public class DiruaSartuDAB {

	static DataAccess sut = new DataAccess(true);
	
	static TestDataAccess testDA = new TestDataAccess();
	
	@Test
	public void test1() {
		try {
			testDA.open();
			Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
			Date data = myCalendar.getTime();
			testDA.register("Ander", "pass", 10, data, true, 50, 40);
			testDA.close();
	
			sut.open(false);
			boolean ema = sut.diruaSartu("Ander", 55);			
			assertEquals(ema, false);
		
		} catch(Exception e) {
			fail();
		} finally {
			testDA.open();
			testDA.deleteBezeroa("Ander");
	        testDA.close();
	        sut.close();
	        }
	}
	
	@Test
	public void test2() {
		try {
			testDA.open();
			Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
			Date data = myCalendar.getTime();
			testDA.register("Ander", "pass", 10, data, true, 50, 40);
			testDA.close();
	
			sut.open(false);
			boolean ema = sut.diruaSartu(null, 20);			
			assertEquals(ema, false);
		
		} catch(Exception e) {
			fail();
		} finally {
			testDA.open();
			testDA.deleteBezeroa("Ander");
	        testDA.close();
	        sut.close();
	        }
	}
	
	@Test
	public void test3() {
		try {
			testDA.open();
			Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
			Date data = myCalendar.getTime();
			testDA.register("Jon", "pass", 10, data, true, 50, 40);
			testDA.close();
	
			sut.open(false);
			boolean ema = sut.diruaSartu("Ander", 20);			
			assertEquals(ema, false);
		
		} catch(Exception e) {
			fail();
		} finally {
			testDA.open();
			testDA.deleteBezeroa("Ander");
	        testDA.close();
	        sut.close();
	        }
	}
	
	@Test
	public void test4() {
		try {
			testDA.open();
			Date data = new Date();
			testDA.register("Ander", "pass", 10, data, true, 50, 40);
			testDA.close();
	
			sut.open(false);
			boolean ema = sut.diruaSartu("Ander", 9);			
			assertEquals(ema, true);
		
		} catch(Exception e) {
			fail();
		} finally {
			testDA.open();
			testDA.deleteBezeroa("Ander");
	        testDA.close();
	        sut.close();
	        }
	}
	
	@Test
	public void test5() {
		try {
			testDA.open();
			Date data = new Date();
			testDA.register("Ander", "pass", 10, data, true, 50, 40);
			testDA.close();
	
			sut.open(false);
			boolean ema = sut.diruaSartu("Ander", 10);			
			assertEquals(ema, true);
		
		} catch(Exception e) {
			fail();
		} finally {
			testDA.open();
			testDA.deleteBezeroa("Ander");
	        testDA.close();
	        sut.close();
	        }
	}
	
	@Test
	public void test6() {
		try {
			testDA.open();
			Date data = new Date();
			testDA.register("Ander", "pass", 10, data, true, 50, 40);
			testDA.close();
	
			sut.open(false);
			boolean ema = sut.diruaSartu("Ander", 11);			
			assertEquals(ema, false);
		
		} catch(Exception e) {
			fail();
		} finally {
			testDA.open();
			testDA.deleteBezeroa("Ander");
	        testDA.close();
	        sut.close();
	        }
	}
	
	

}
