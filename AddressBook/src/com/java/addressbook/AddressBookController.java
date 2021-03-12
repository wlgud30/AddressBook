package com.java.addressbook;

import java.util.Scanner;

public class AddressBookController {

	static AddressBookService adressService = new AddressBookService();
	static AddressBookView adressView = new AddressBookView();

	protected static void AddressBook() {

		adressView.AddressViewStart();
		Scanner sc = new Scanner(System.in);
		while (true) {
			adressView.AddressViesMenu();

			switch (sc.nextInt()) {
			case 1:
				adressView.AddressViewList();
				continue;
			case 2:
				adressView.AddressViewInsert();
				adressService.AddressInsert(adressService.AddressInfo(sc));
				System.out.println("[등록되었습니다.]\n");
				continue;
			case 3:
				adressView.AddressViewDelete();
				adressService.AddressDelete(sc.nextInt());
				System.out.println("[삭제되었습니다.]\n");
				continue;
			case 4:
				adressView.AddressViewSearch();
				adressService.AddressSearch(sc.next());
				continue;
			case 5:
				adressView.AddressViewEnd();
				break;
			default:
				adressView.AddressViewEr();
				continue;
			}
			sc.close();
			break;
		}

	}

	/*
	 * 테스트용 강지형,010-2209-8728,02-2123-0910 일지형,010-2209-8728,02-2123-0910
	 * 이지형,010-2209-8728,02-2123-0910 삼지형,010-2209-8728,02-2123-0910
	 */

}
