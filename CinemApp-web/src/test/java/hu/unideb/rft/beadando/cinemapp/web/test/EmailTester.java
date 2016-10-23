package hu.unideb.rft.beadando.cinemapp.web.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hu.unideb.rft.beadando.cinemapp.web.managedbean.EmailSenderBean;

public class EmailTester {

	private EmailSenderBean emailSenderBean;
	
	@Before
	public void setUp() throws Exception {
		emailSenderBean = new EmailSenderBean();
	}

	@Test
	public void ValidAddressTest() {
		assertEquals(true, emailSenderBean.isValidEmail("sz.nandor.a@gmail.com"));
		assertEquals(false, emailSenderBean.isValidEmail("nemvalidemail.com"));
		assertEquals(true,emailSenderBean.isValidEmail("neptunos@mailbox.unideb.hu"));
	}

	
}
