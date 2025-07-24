package day5;

public class Examples {
	public static void main(String[] args) {
		//1)Find the sign-up button from the registration form present in the facebook application.(child)
		//div[@id='reg_form_box']/child::div[11]/button
		
		//2)Locate Firstname field from SignUp button in facebook (parent)
		 //button[@id='u_0_n_JX']/parent::*/parent::*/child::div[1]/div/div[1]
		
		//3)Identify the password from mobile number field in facebook (following)
		//input[@id='u_0_h_zT']/following::input[2]
		
		//4) Locate mobilenumber using password (preceding)
		//input[@id='password_step_input']/preceding::input[2]
		
		//5)Locate surename from female radio button in facebook(Ancestor)
		//label[normalize-space()='Female']/ancestor::div[2]/div[1]/div/div[2]
		//label[normalize-space()='Female']/ancestor::div[2]//input[@id='u_0_a_lI']
		
		//6) Identify the search text box from the google search button present in the google search home page (parent)
		//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']/parent::*/parent::*/parent::*/div[1]
		
		//7) Identify the today's Deals link from the amazon search text box present in the amazon home page (following)
		//input[@id='twotabsearchtextbox']/following::a[@href='/deals?ref_=nav_cs_gb']
		
		//8) Identify the hello, Signin from the amazon search text box present in the amazon home page (Following)
		//input[@id='twotabsearchtextbox']/following::span[@id='nav-link-accountList-nav-line-1']
		
		//9) Identify Mobiles link which is part of Menu bar - Amazon (Descendant)
		//div[@id='nav-xshop']/descendant::a[normalize-space()='Mobiles']
		
		
	}

}
