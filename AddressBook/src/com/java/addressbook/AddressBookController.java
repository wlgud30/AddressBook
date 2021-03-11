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
				System.out.println("[등록되었습니다.]\n");
				continue;
			case 3:
				AddressBookView.AddressViewDelete();
				AddressBookService.AddressDelete(sc.nextInt());
				System.out.println("[삭제되었습니다.]\n");
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

	/*테스트용
	 * 강지형,010-2209-8728,02-2123-0910 
	 * 일지형,010-2209-8728,02-2123-0910
	 * 이지형,010-2209-8728,02-2123-0910 
	 * 삼지형,010-2209-8728,02-2123-0910
	 */

}
