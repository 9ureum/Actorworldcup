package PKG;

import java.util.Arrays;
import java.util.Scanner;

public class Actors {
	public static int pictureNumber[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}; //16강부터, 위에 전역변수?선언해서 다 쓸수있게하기
	public static String actorsName[] = {"제임스 맥어보이", "크리스찬 베일", "키아누 리브스", "레오나르도 디카프리오",
			"브래드 피트", "토비 맥과이어", "로버트 패틴슨", "조니뎁","톰 하디", "마이클 패스벤터", "주드로", "알랭 들롱", "톰크루즈", 
			"에드워드 펄롱", "로버트 다우니 주니어", "휴잭맨"};
	public static int secondRound[] = new int[pictureNumber.length/2];//빈배열에 선택한 수 넣음 8
	public static int finalRound[] = new int[secondRound.length/2]; // 4
	public static int finalRound_real[] = new int[finalRound.length/2]; //2
	public static boolean actors[] = new boolean[pictureNumber.length];
	public static boolean secondRoundActors[] = new boolean[actors.length/2];
	public static boolean finalRoundActors[] = new boolean[secondRoundActors.length/2];
	public static int n1 = (int)(Math.random() * 16);
	public static int n2 = (int)(Math.random() * 16);
	public static int count = 0;
	public static int loop = 0;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		random();
		nextRound();
		finalRound();
	}


	public static void random() {
		Arrays.fill(actors,false);

		while(true) {
			n1 = (int)(Math.random() * 16);
			n2 = (int)(Math.random() * 16);
			if ( n1 == n2 || actors[n1] == true || actors[n2] == true) {
				continue;


			} else {
				System.out.printf("%d : %s ", n1, actorsName[n1]);
				System.out.printf("%d : %s\n", n2, actorsName[n2]);
				actors[n1] = true;
				actors[n2] = true;
			}

			System.out.println("Select a number!");
			int inputNumber = scanner.nextInt();
			secondRound[0+loop] = inputNumber;
			loop ++;

			for(int i = 0 ; i < actors.length; i++) {
				if(actors[i] == true) {
					count++;   
				}
			}
			if (count < 16) {
				count = 0;
			}
			if(count == 16) {
				System.out.println("Go Next Round");
				break;
			}
		}

	}

	public static void nextRound() {

		System.out.println("===== Next Round ======");
		loop = 0;
		count = 0;
		Arrays.fill(secondRoundActors,false);
		while(true) {
			int nextRoundOne = (int)(Math.random() * 8);
			int nextRoundTwo = (int)(Math.random() * 8);
			if ( nextRoundOne == nextRoundTwo || secondRoundActors[nextRoundOne] == true || secondRoundActors[nextRoundTwo] == true) {
				continue;
			} else {
				System.out.printf("%d : %s ", secondRound[nextRoundOne], actorsName[secondRound[nextRoundOne]]);
				System.out.printf("%d : %s\n", secondRound[nextRoundTwo], actorsName[secondRound[nextRoundTwo]]);
				secondRoundActors[nextRoundOne] = true;
				secondRoundActors[nextRoundTwo] = true;
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("Select a number!");
			int inputNumber = scanner.nextInt();
			finalRound[0 + loop] = inputNumber;
			loop ++;

			for (int i = 0 ; i < secondRoundActors.length; i++) {
				if (secondRoundActors[i] == true) {
					count++;   
				}

			}
			if (count < 8) {
				count = 0;
			}
			if (count == 8) {
				System.out.println("Go Next Round");
				break;
			}
		}

	}
	public static void finalRound() {

		System.out.println("===== Next Round ======");
		loop = 0;
		count = 0;
		Arrays.fill(finalRoundActors,false);
		while(true) {
			int finalRoundOne = (int)(Math.random() * 4);
			int finalRoundTwo = (int)(Math.random() * 4);
			if ( finalRoundOne == finalRoundTwo || finalRoundActors[finalRoundOne] == true || finalRoundActors[finalRoundTwo] == true) {
				continue;
			} else {
				System.out.printf("%d : %s ", finalRound[finalRoundOne], actorsName[finalRound[finalRoundOne]]);
				System.out.printf("%d : %s\n", finalRound[finalRoundTwo], actorsName[finalRound[finalRoundTwo]]);
				finalRoundActors[finalRoundOne] = true;
				finalRoundActors[finalRoundTwo] = true;
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("Select a number!");
			int inputNumber = scanner.nextInt();
			finalRound_real[0 + loop] = inputNumber;
			loop ++;

			for (int i = 0 ; i < finalRoundActors.length; i++) {
				if (finalRoundActors[i] == true) {
					count++;   
				}

			}
			if (count < 4) {
				count = 0;
			}
			if (count ==4) {
				System.out.println("Go Final Round");
				break;
			}

		}
		System.out.println("====== Final Round ======");
		Arrays.sort(finalRound_real);
		while(true) {
			int finalRoundRealOne = (int)(Math.random() * 2);
			int finalRoundRealTwo = (int)(Math.random() * 2);
			if ( finalRoundRealOne == finalRoundRealTwo ) {
				continue;
			} else {
				System.out.printf("%d : %s ", finalRound_real[finalRoundRealOne], actorsName[finalRound_real[finalRoundRealOne]]);
				System.out.printf("%d : %s\n", finalRound_real[finalRoundRealTwo], actorsName[finalRound_real[finalRoundRealTwo]]);
				break;
			}
		}
			System.out.println("Select a number!");
			int inputNumber = scanner.nextInt();
			System.out.printf("Winner : %s\n", actorsName[inputNumber]);
			System.out.println("Congratulations!");
		}
	

}

