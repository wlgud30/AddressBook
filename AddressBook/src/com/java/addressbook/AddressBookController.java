package com.java.addressbook;

import java.util.Scanner;

public class AddressBookController {


	protected static void AddressBook() {
		AddressBookView.AddressViewStart();
		Scanner sc = new Scanner(System.in);
		while (true) {
			AddressBookView.AddressViesMenu();

			switch (sc.nextInt()) {
			case 1:
				AddressBookView.AddressViewList();
				continue;
			case 2:
				AddressBookView.AddressViewInsert();
				AddressBookService.AddressInsert(AddressBookService.AddressInfo(sc));
				System.out.println("[등록되었습니다.]");
				continue;
			case 3:
				AddressBookView.AddressViewDelete();
				AddressBookService.AddressDelete(sc.nextInt());
				System.out.println("[삭제되었습니다.]");
				continue;
			case 4:
				AddressBookView.AddressViewSearch();
				AddressBookService.AddressSearch(sc.next());
				continue;
			case 5:
				AddressBookView.AddressViewEnd();
				break;
			default:
				AddressBookView.AddressViewEr();
				continue;
			}
			sc.close();
			break;
		}

	}

	

}
