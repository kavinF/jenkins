package org.pom;


public class POMManager {
	public static POMManager pomManager;
	private LoginPage loginPage;
	private POMManager() {
	}

	public static POMManager getPomManager() {
      if (pomManager==null) {
    	  pomManager = new POMManager();
	}
		return pomManager;
	}
	
	public  LoginPage getLoginPage() {
			loginPage=new LoginPage();		
		return loginPage;
	}
}
