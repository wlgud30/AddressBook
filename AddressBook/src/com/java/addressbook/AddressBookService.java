package com.java.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AddressBookService {
	static final String rootPath = System.getProperty("user.dir") + "\\";
	static final String filename = rootPath + "AdressBook.txt";

	protected void AddressList() {
		Reader reader = null;
		BufferedReader br = null;

		try {
			reader = new FileReader(filename);
			br = new BufferedReader(reader);
			List<AddressBook> adr = AddressBookList(br);
			for (int i = 0; i < adr.size(); i++) {
				System.out.print(
						(i + 1) + ". " + adr.get(i).getName() + "\t" + adr.get(i).getHp() + "\t" + adr.get(i).getTel()+"\n");
			}

		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾지 못했습니다.");
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void AddressInsert(AddressBook address) {
		Writer writer = null;
		BufferedWriter bw = null;
		try {
			writer = new FileWriter(filename, true);
			bw = new BufferedWriter(writer);
			bw.newLine();
			bw.append(address.getName() + "," + address.getHp() + "," + address.getTel());
			bw.flush();

		} catch (IOException e) {
			System.err.println("에러발생");
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				bw.close();
			} catch (Exception e) {

			}
		}
	}

	protected AddressBook AddressInfo(Scanner sc) {

		System.out.print(">이름 : ");
		String name = sc.next();
		System.out.print(">휴대전화 : ");
		String hp = sc.next();
		System.out.print(">집전화 : ");
		String tel = sc.next();
		AddressBook address = new AddressBook(name, hp, tel);
		return address;
	}

	protected List<AddressBook> AddressBookList(BufferedReader br) {

		List<AddressBook> list = new ArrayList<>();
		try {

			String line = null;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				AddressBook address = new AddressBook(st.nextToken(), st.nextToken(), st.nextToken());
				list.add(address);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	protected void AddressDelete(int num) {
		Writer writer = null;
		BufferedWriter bw = null;
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(filename);
			br = new BufferedReader(reader);

			String line = null;
//			String str = "";

//			int i = 0;

//			while ((line = br.readLine()) != null) {
//				i++;
//				if (num != i) {
//					str += line+"\n";
//				}
//			}
//			str = str.substring(0, str.length()-1);
//			writer = new FileWriter(filename);
//			bw = new BufferedWriter(writer);
//			bw.write(str);

//			배열로
			List<String> list = new ArrayList<>();
			for (int i = 1; (line = br.readLine()) != null; i++) {
				if (num != i) {
					list.add(line);
				}
			}
			writer = new FileWriter(filename);
			bw = new BufferedWriter(writer);
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i));
				if (i != (list.size() - 1)) {
					bw.newLine();
				}
			}

			bw.flush();

		} catch (IOException e) {
			System.err.println("에러발생");
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (Exception e) {

			}
		}
	}

	protected void AddressSearch(String str) {
		Reader reader = null;
		BufferedReader br = null;

		try {
			reader = new FileReader(filename);
			br = new BufferedReader(reader);

			String line = null;
//			int i = 1;
//			while ((line = br.readLine()) != null) {
//				if(line.contains(str)) {
//					StringTokenizer st = new StringTokenizer(i+". "+line, ",");
//					while (st.hasMoreTokens()) {
//						String token = st.nextToken();
//						System.out.print(token + "\t");
//					}
//					System.out.println();
//				}
//				i++;
//			}
			// 만약 검색조건이 이름만 이라면
			List<AddressBook> list = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				AddressBook adress = new AddressBook(st.nextToken(), st.nextToken(), st.nextToken());
				list.add(adress);
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().contains(str)) {
					System.out.println((i + 1) + ". " + list.get(i).toString());
				}
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾지 못했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
