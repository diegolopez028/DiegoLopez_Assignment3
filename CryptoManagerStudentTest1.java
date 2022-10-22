import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerStudentTest1 {
	CryptoManager CryptoManger;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testsIStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("JAVA"));
		assertTrue(CryptoManager.isStringInBounds("\"JAVA IS FUN\""));
		
		
		
	}

	@Test
	void testCaesarEncryption() {
		assertEquals("UFTUJOHTT", CryptoManager.caesarEncryption("TESTINGSS", 1));
		assertEquals("SBWFOT!XJO!UIF!TVQFSCPXM", CryptoManager.caesarEncryption("RAVENS WIN THE SUPERBOWL", 1));
		assertEquals("0513;", CryptoManager.caesarEncryption("DIEGO", 300));
		
	}

	@Test
	void testBellasoEncryption() {
		assertEquals("UN)HQ 3ZL[3WKR3VX]XU#O\"ZO", CryptoManager.bellasoEncryption("RAVENS WIN THE SUPER BOWL", "CMSC"));
	}

	@Test
	void testCaesarDecryption() {
		assertEquals("RAVENS WIN THE SUPERBOWL", CryptoManager.caesarDecryption("SBWFOT!XJO!UIF!TVQFSCPXM", 1));
	}

	@Test
	void testBellasoDecryption() {
				assertEquals("RAVENS WIN THE SUPER BOWL", CryptoManager.bellasoDecryption("UN)HQ 3ZL[3WKR3VX]XU#O\"ZO", "CMSC"));
				assertEquals("RAVENS WIN THE SUPERBOWL LAMAR J_", CryptoManager.bellasoDecryption("$B,J\\&?)J$%\"[$2T+US%!!X\"%ZT,SS6O-", "RAVENS_"));
	}

	

	

}
