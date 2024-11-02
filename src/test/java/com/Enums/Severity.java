package com.Enums;

public enum Severity {

	CRITICAL("criti"), HIGH("hi"), MEDIUM("me"), LOW("low"){
		private void syso() {
			// TODO Auto-generated method stub

			System.out.println("Enum");
		}
	};

	private String res;
	Severity(String string) {
		// TODO Auto-generated constructor stub
		this.res=string;
	}
	public String getResources()
	{
		return res;
	}
}
