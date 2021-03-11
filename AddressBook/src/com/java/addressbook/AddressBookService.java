package com.java.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AddressBookService {
	static final String rootPath = System.getProperty("user.dir") + "\\";
	static final String filename = rootPath + "AdressBook.txt";
	
	protected static void AddressList() {
		Reader reader = null;
		BufferedReader br = null;

		try {
			reader = new FileReader(filename);
			br = new BufferedReader(reader);

			String line = null;
			int i = 1;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				System.out.print(i + ". ");
				while (st.hasMoreTokens()) { 
					String token = st.nextToken(); 
					System.out.print(token + "\t");
				}
				System.out.println();
				i++;
			}

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

	protected static void AddressInsert(AddressBook address) {
		Writer writer = null;
		BufferedWriter bw = null;
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(filename);
			br = new BufferedReader(reader);

			String line = null;
			String str = "";
			while ((line = br.readLine()) != null) {
				str += line + "\n";
			}
			writer = new FileWriter(filename);
			bw = new BufferedWriter(writer);
			bw.append(str);
			bw.append(address.getName() + "," + address.getPhone() + "," + address.getTel());
			bw.newLine();
			bw.flush();

		} catch (IOException e) {
			System.err.println("에러발생");
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (Exception e) {

			}
		}
	}

	protected static AddressBook AddressInfo(Scanner sc) {

		System.out.print(">이름 : ");
		String name = sc.next();
		System.out.print(">휴대전화 : ");
		String phone = sc.next();
		System.out.print(">집전화 : ");
		String tel = sc.next();
		AddressBook address = new AddressBook(name, phone, tel);
		return address;
	}

	protected static void AddressDelete(int num) {
		Writer writer = null;
		BufferedWriter bw = null;
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(filename);
			br = new BufferedReader(reader);

			String line = null;
			String str = "";
			int i = 0;
			while ((line = br.readLine()) != null) {
				i++;
				if (num != i) {
					str += line + "\n";
				}
			}
			writer = new FileWriter(filename);
			bw = new BufferedWriter(writer);
			bw.write(str);
			bw.flush();

		} catch (IOException e) {
			System.err.println("에러발생");
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (Exception e) {

			}
		}
	}

	protected static void AddressSearch(String str) {
		Reader reader = null;
		BufferedReader br = null;

		try {
			reader = new FileReader(filename);
			br = new BufferedReader(reader);

			String line = null;
			int i = 1;
			while ((line = br.readLine()) != null) {
				if(line.contains(str)) {
					StringTokenizer st = new StringTokenizer(i+". "+line, ",");
					while (st.hasMoreTokens()) {
						String token = st.nextToken();
						System.out.print(token + "\t");
					}
					System.out.println();
				}
				i++;
				
			}

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
