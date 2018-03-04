package ca.mcgill.ecse428.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.mcgill.ecse428.object.PostalPack;
import ca.mcgill.ecse428.postalratecalculator.PostalCalculation;

public class TestPostalCalculation {

	PostalPack p;
	PostalCalculation pc;

	public void setUp() {
		pc = new PostalCalculation();
	}

	@Test
	public void test_postal_cal_001() {
		// check if the input is not enough
		String[] args = { "150", "100" };
		PostalCalculation.checkInput(args);
		assertEquals(PostalCalculation.getResultMessage(), "arguments too few");
	}

	@Test
	public void test_postal_cal_002() {
		// check if the input exceeds what we need
		String[] args = { "150", "100", "H2H2H2", "H2X3F4", "150", "100", "100", "100", "Regular" };
		PostalCalculation.checkInput(args);
		assertEquals(PostalCalculation.getResultMessage(), "arguments too many");
	}

	@Test
	public void test_postal_cal_003() {
		// check if length is smaller than 140
		String[] args = { "H2H2H2", "H2X3F4", "10", "100", "100", "100", "Regular" };
		PostalCalculation.checkInput(args);
		assertEquals(PostalCalculation.getResultMessage(), "length too small");
	}

	@Test
	public void test_postal_cal_004() {
		// check if length is bigger than 380
		String[] args = { "H2H2H2", "H2X3F4", "500", "100", "100", "100", "Regular" };
		PostalCalculation.checkInput(args);
		assertEquals(PostalCalculation.getResultMessage(), "length too big");

	}

	@Test
	public void test_postal_cal_005() {
		// check if the length input is a number
		String[] args = { "H2H2H2", "H2X3F4", "length", "100", "100", "100", "Regular" };
		PostalCalculation.checkInput(args);
		assertEquals(PostalCalculation.getResultMessage(), "invalid length");
	}

	@Test
	public void test_postal_cal_006() {
		// check if width is smaller than 140
		String[] args = { "H2H2H2", "H2X3F4", "150", "10", "100", "100", "Regular" };
		PostalCalculation.checkInput(args);
		assertEquals(PostalCalculation.getResultMessage(), "width too small");

	}

	@Test
	public void test_postal_cal_007() {
		// check if width is bigger than 270
		String[] args = { "H2H2H2", "H2X3F4", "150", "500", "100", "100", "Regular" };
		PostalCalculation.checkInput(args);
		assertEquals(PostalCalculation.getResultMessage(), "width too big");
	}

	@Test
	public void test_postal_cal_008() {
		// check if the width input is a number
		String[] args = { "H2H2H2", "H2X3F4", "150", "width", "100", "100", "Regular" };
		PostalCalculation.checkInput(args);
		assertEquals(PostalCalculation.getResultMessage(), "invalid width");
	}

	@Test
	public void test_postal_cal_009() {
		// check if weight is smaller than 3
		String[] args = { "H2H2H2", "H2X3F4", "150", "100", "100", "1", "Regular" };
		PostalCalculation.checkInput(args);
		assertEquals(PostalCalculation.getResultMessage(), "weight too small");

	}

	@Test
	public void test_postal_cal_010() {
		// check if weight is bigger than 500
		String[] args = { "H2H2H2", "H2X3F4", "150", "100", "100", "800", "Regular" };
		PostalCalculation.checkInput(args);
		assertEquals(PostalCalculation.getResultMessage(), "weight too big");

	}

	@Test
	public void test_postal_cal_011() {
		// check if the weight input is a number
		String[] args = { "H2H2H2", "H2X3F4", "150", "100", "100", "weight", "Regular" };
		PostalCalculation.checkInput(args);
		assertEquals(PostalCalculation.getResultMessage(), "invalid weight");

	}

	public void test_postal_cal_012() {

	}

	public void test_postal_cal_013() {

	}

	public void test_postal_cal_014() {

	}

	public void test_postal_cal_015() {

	}

	public void test_postal_cal_016() {

	}

	public void test_postal_cal_017() {

	}

	public void test_postal_cal_018() {

	}


	public void tearDown() {

	}

}
