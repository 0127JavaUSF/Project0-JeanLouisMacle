
package com.revature.pages;

public class Header {
	public static String title;

	public Header()
	{
		title = StringExternalizationUtility.getString("Header.Title"); //$NON-NLS-1$
		
	}
	
	public String toString() {
		return title;
	}
	
	public static void setHeader(String headerString) {
		Header.title = title;
	}
	
	
	

	

}
