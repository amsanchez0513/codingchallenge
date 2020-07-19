package com.codingchallenge;

public class Singleton {
		  private static Singleton INSTANCE;
		  private static String sortBy="variety";
		  private Singleton() {
		  }

		  public static Singleton getInstance() {
		     if (getINSTANCE() == null) {
		    	 setINSTANCE(new Singleton());
		     }
		     return getINSTANCE();
		  }


		public static String getSortBy() {
			return sortBy;
		}

		public static void setSortBy(String sortBy) {
			Singleton.sortBy = sortBy;
		}

		public static Singleton getINSTANCE() {
			return INSTANCE;
		}

		public static void setINSTANCE(Singleton iNSTANCE) {
			INSTANCE = iNSTANCE;
		}

		  
}