package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		System.out.println("******************************");
		System.out.println("*      전화번호 관리 프로그램      *");
		System.out.println("******************************");

		Scanner sc = new Scanner(System.in);

		Reader fr = new FileReader("./PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		List<Person> pList = new ArrayList<Person>();

		while (true) {

			String str = br.readLine();
			if (str == null) {
				break;
			}
			String[] pArray = str.split(",");
			Person person = new Person(pArray[0], pArray[1], pArray[2]);

			pList.add(person);

		}

		while (true) {

			System.out.println("");
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("-------------------------------");
			System.out.print(">메뉴번호:");
			int num = sc.nextInt();
			sc.nextLine();

			if (num == 5) {

				System.out.println("");
				System.out.println("******************************");
				System.out.println("*           감사합니다          *");
				System.out.println("******************************");

				break;

			} else if (num == 1) {

				System.out.println("<1.리스트>");

				int listNo = 1;

				for (Person p : pList) {

					System.out.println(listNo + ".  " + p.getName() + "  " + p.getHp() + "  " + p.getOffice());
					listNo++;

				}

			} else if (num == 2) {
				Person person = new Person();

				System.out.println("<2.등록>");
				System.out.print(">이름:");
				// 이름입력
				String name = sc.nextLine();
				person.setName(name);

				System.out.print(">휴대전화:");
				// 번호입력
				String hp = sc.nextLine();
				person.setHp(hp);

				System.out.print(">회사전화:");
				// 번호입력
				String office = sc.nextLine();
				person.setOffice(office);

				// 리스트에 추가
				pList.add(person);

				System.out.println("[등록되었습니다.]");

			} else if (num == 3) {

				System.out.println("<3.삭제>");
				System.out.print(">번호:");
				// 리스트 삭제
				int delete = sc.nextInt() - 1;
				pList.remove(delete);

				System.out.println("[삭제되었습니다.]");

			} else if (num == 4) {

				System.out.println("<4.검색>");
				System.out.print(">이름:");
				String serch = sc.nextLine();

				int listNo = 1;
				for (Person p : pList) {
					if (p.getName().contains(serch)) {
						System.out.println(listNo + ".  " + p.getName() + "  " + p.getHp() + "  " + p.getOffice());
					}
					listNo++;
				}

			} else {
				System.out.println("[다시 입력해 주세요.]");
			}

			Writer fw = new FileWriter("./PhoneDB.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (Person pp : pList) {

				bw.write(pp.getName() + "," + pp.getHp() + "," + pp.getOffice());
				bw.newLine();
			}

			bw.close();

		}

		br.close();
		sc.close();
	}

}
