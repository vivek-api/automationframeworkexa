package workingwithdatabases.workingwithmysqldatabases;

import org.testng.annotations.Test;

public class GenerateAlphaNumericCharacters {

	@Test
	public  void generateAlphaNumericCharacters() {
		int n=20;
		String alphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuffer sB=new StringBuffer(n);
		
		for(int i=0;i<n;i++) {
			int index=(int)(alphaNumericString.length()*Math.random());
			sB.append(alphaNumericString.charAt(index));
			
		}
		System.out.println(sB);

	}

}
