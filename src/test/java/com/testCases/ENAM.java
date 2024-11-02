package com.testCases;

import com.Enums.Severity;

public class ENAM {
	public static void main(String[] args) {
		
		System.out.println(Severity.MEDIUM);

		Severity resource=Severity.valueOf("LOW");
		System.out.println(resource);
		System.out.println(resource.getResources());
	}

}
