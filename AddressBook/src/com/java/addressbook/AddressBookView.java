package com.java.addressbook;

public class AddressBookView {
	
	
	public static void AddressViewStart() {
		System.out.println("********************************");
		System.out.println("*       전화번호 관리 프로그램       *");
		System.out.println("********************************");
		
	}
	
	public static void AddressViesMenu() {
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("--------------------------------");
		System.out.println(">메뉴 번호 : ");
	}
	
	public static void AddressViewEnd() {
		System.out.println("********************************");
		System.out.println("*           감사합니다            *");
		System.out.println("********************************");
	}
	
	public static void AddressViewEr() {
		System.out.println("[다시 입력해주세요.]");
	}
	
	public static void AddressViewList() {
		System.out.println("<1. 리스트>");
		AddressBookService.AddressList();
		System.out.println();
	}
	
	public static void AddressViewInsert() {
		System.out.println("<2. 등록>");
	}
	
	public static void AddressViewDelete() {
		System.out.println("<3. 삭제>");
		System.out.print(">번호 : ");
	}
	
	public static void AddressViewSearch() {
		System.out.println("<4. 검색>");
		System.out.print(">이름 : ");
	}
	
}
