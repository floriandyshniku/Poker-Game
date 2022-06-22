package projekt3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PokerGame {
	public static byte [] twoPairMeIMadh(byte[] letra1 , byte[] letra2) {
		ArrayList<Byte> letratMax1 = new ArrayList<Byte>();
		ArrayList<Byte> letratMax2 = new ArrayList<Byte>();
		for (int i = 0; i < letra1.length - 1; i++) {
			if (indeksGrade(letra1[i]) == indeksGrade(letra1[i+1])) {
				letratMax1.add((byte) indeksGrade(letra1[i]));
			}
			if (indeksGrade(letra2[i]) == indeksGrade(letra2[i + 1])) {

				letratMax2.add((byte) indeksGrade(letra2[i]));
			}
		}
		
		byte max1 = 0;
		byte max2 = 0;
		for (int i = 1; i >= 0; i--) {
			if (letratMax1.get(i) == 0) {
				max1 = 13;
			}
			if (letratMax2.get(i) == 0) {
				max2 = 13;
			}
			if (max1 < letratMax1.get(i)) {
				max1 = letratMax1.get(i);
			}
			if (max2 < letratMax2.get(i)) {
				max2 = letratMax2.get(i);
			}
			if (max1 == max2) {
				max1 = 0;
				max2 = 0;
			}
		}
		byte letratMax [] = new byte [2]; 
		letratMax[0] = (byte) max1;
		letratMax[1] = (byte) max2;
		return letratMax;
	}
	public static byte [] noPairMeImadh(byte[] letra1 , byte[] letra2) {
		byte a [] = new byte [letra1.length];
		byte b [] = new byte [letra2.length];
		for (int i = 0; i <= a.length-1; i++) {
			a[i] = (byte) indeksGrade(letra1[i]) ;
			b[i] = (byte) indeksGrade(letra2[i]) ;
		}
		int max1 = 0;
		int max2 = 0;
		for (int i = 0; i <= a.length-1; i++) {
			if (a[i] == 0) {
				max1 = 13;
			}
			if (b[i] == 0) {
				max2 = 13;
			}
			if (max1 < a[i]) {
				max1 = a[i];
			}
			if (max2 < b[i]) {
				max2 = b[i];
			}
			if (max1 == max2) {
				max1 = 0;
				max2 = 0;
			}
		}
		byte letratMax [] = new byte [2]; 
		letratMax[0] = (byte) max1;
		letratMax[1] = (byte) max2;
		return letratMax;
	} 

	public static void fituesApoBarazim(byte[] letraLojtari1, byte[] letraLojtari2) {
		byte a = 0 , b = 0;
		byte [] max = new byte [2];

		if (eshteNoPair(letraLojtari1) && eshteNoPair(letraLojtari2)) {
		
		max = noPairMeImadh(letraLojtari1, letraLojtari2);
		a = max[0];
		b = max[1];
		}
		if (eshteTwoPairs(letraLojtari1) && eshteTwoPairs(letraLojtari2)) {
		max = twoPairMeIMadh(letraLojtari1, letraLojtari2);
		a = max[0];
		b = max[1];
		}
		if (eshteOnePair(letraLojtari1) && eshteOnePair(letraLojtari2)) {
			for (int i = 0; i < letraLojtari2.length-1; i++) {
				if (indeksGrade(letraLojtari1[i]) == indeksGrade(letraLojtari1[i+1])) {
					if (indeksGrade(letraLojtari1[i]) == 0) {
						a = (byte) (a + 13 + indeksGrade(letraLojtari1[i]));
					}else {
						a = (byte) (a + indeksGrade(letraLojtari1[i]));
						}
				}
				
				if (indeksGrade(letraLojtari2[i]) == indeksGrade(letraLojtari2[i+1])) {
					if (indeksGrade(letraLojtari2[i]) == 0) {
						b = (byte) (b + 13 + indeksGrade(letraLojtari2[i]));
					}else {
						b = (byte) (b + indeksGrade(letraLojtari2[i]));
						}
				}
			}
		}
		 if (eshteThreeOfAKind(letraLojtari1) && eshteThreeOfAKind(letraLojtari2)) {
			for (int i = 0; i < 3; i++) {
				if (indeksGrade(letraLojtari1[i]) == indeksGrade(letraLojtari1[i+2])) {
					if (indeksGrade(letraLojtari1[i]) == 0) {
						a = (byte) (a + 13 + indeksGrade(letraLojtari1[i]));
					}else {
						a = (byte) (a + indeksGrade(letraLojtari1[i]));
						}
				}
				if (indeksGrade(letraLojtari2[i]) == indeksGrade(letraLojtari2[i+2])) {
					if (indeksGrade(letraLojtari2[i]) == 0) {
						b = (byte) (b + 13 + indeksGrade(letraLojtari2[i]));
					}else {
						b = (byte) (b + indeksGrade(letraLojtari2[i]));
						}
				}
				
			}
			
		}
		 if (eshteFourOfAKind(letraLojtari2) && eshteFourOfAKind(letraLojtari1)) {
			for (int i = 0; i < 2; i++) {
				if (indeksGrade(letraLojtari1[i]) == indeksGrade(letraLojtari1[i+3])) {
					if (indeksGrade(letraLojtari1[i]) == 0) {
						a = (byte) (a + 13 + indeksGrade(letraLojtari1[i]));
					}else {
						a = (byte) (a + indeksGrade(letraLojtari1[i]));
						}
				}
				if (indeksGrade(letraLojtari2[i]) == indeksGrade(letraLojtari2[i+3])) {
					if (indeksGrade(letraLojtari2[i]) == 0) {
						b = (byte) (b + 13 + indeksGrade(letraLojtari2[i]));
					}else {
						b = (byte) (b + indeksGrade(letraLojtari2[i]));
						}
				}
				
			}
		} if (eshteFlush(letraLojtari2) && eshteFlush(letraLojtari1)
				|| eshteStraight(letraLojtari1) && eshteStraight(letraLojtari2)
				|| eshteFullHouse(letraLojtari1) && eshteFullHouse(letraLojtari2)
				|| eshteStraightFlush(letraLojtari2) && eshteStraightFlush(letraLojtari1)) {
	
			for (int i = letraLojtari2.length-1; i >= 0; i--) {
				if (indeksGrade(letraLojtari1[i]) != indeksGrade(letraLojtari2[i])) {
					if (indeksGrade(letraLojtari1[i]) == 0) {
						a = 13;
					}
					if (indeksGrade(letraLojtari2[i]) == 0) {
						b = 13;
					}
					a = (byte) (a + indeksGrade(letraLojtari1[i]));
					b = (byte) (b + indeksGrade(letraLojtari2[i]));
					break;
				}else {
					a = b;
				}
			}
		}
		 if (eshteRoyalFlush(letraLojtari1) && eshteRoyalFlush(letraLojtari2)) {
			a = b;
		}
		
		 if (eshteRoyalFlush(letraLojtari1) && (eshteOnePair(letraLojtari2) || eshteTwoPairs(letraLojtari2)
				|| eshteThreeOfAKind(letraLojtari2) || eshteFourOfAKind(letraLojtari2) || eshteFlush(letraLojtari2)
				|| eshteStraight(letraLojtari2) ||eshteFullHouse(letraLojtari2) || eshteStraightFlush(letraLojtari2)
				|| eshteNoPair(letraLojtari2))) {
			a = 13;
			b = 0;
		}
		 if (eshteRoyalFlush(letraLojtari2) && (eshteOnePair(letraLojtari1) || eshteTwoPairs(letraLojtari1)
				|| eshteThreeOfAKind(letraLojtari1) || eshteFourOfAKind(letraLojtari1) || eshteFlush(letraLojtari1)
				|| eshteStraight(letraLojtari1) || eshteFullHouse(letraLojtari1) || eshteStraightFlush(letraLojtari1)
				|| eshteNoPair(letraLojtari1))) {
			a = 0;
			b = 13;
		}
		 if (eshteStraightFlush(letraLojtari1) && ((eshteOnePair(letraLojtari2) || eshteTwoPairs(letraLojtari2)
				|| eshteThreeOfAKind(letraLojtari2) || eshteFourOfAKind(letraLojtari2) || eshteFlush(letraLojtari2)
				|| eshteStraight(letraLojtari2) || eshteFullHouse(letraLojtari2) || eshteStraightFlush(letraLojtari2)
				|| eshteNoPair(letraLojtari2)))) {
			a = 13;
			b = 0;
		}
		 if (eshteStraightFlush(letraLojtari2) && ((eshteOnePair(letraLojtari1) || eshteTwoPairs(letraLojtari1)
				|| eshteThreeOfAKind(letraLojtari1) || eshteFullHouse(letraLojtari1) || eshteFourOfAKind(letraLojtari1) || eshteFlush(letraLojtari1)
				|| eshteStraight(letraLojtari1) || eshteNoPair(letraLojtari1)))) {
			a = 0;
			b = 13;
		}
		 if (  eshteFourOfAKind(letraLojtari1) && ((eshteOnePair(letraLojtari2) || eshteTwoPairs(letraLojtari2)
				|| eshteThreeOfAKind(letraLojtari2) || eshteFlush(letraLojtari2)|| eshteFullHouse(letraLojtari2) || eshteStraight(letraLojtari2)
				|| eshteNoPair(letraLojtari2)))) {
			a = 13;
			b = 0;
	
		}
		if (eshteFourOfAKind(letraLojtari2) && ((eshteOnePair(letraLojtari1) || eshteTwoPairs(letraLojtari1)
				|| eshteThreeOfAKind(letraLojtari1)|| eshteFullHouse(letraLojtari1) || eshteFlush(letraLojtari1) || eshteStraight(letraLojtari1)
				|| eshteNoPair(letraLojtari1)))) {
			a = 0;
			b = 13;
			
		}
		 if (  eshteFullHouse(letraLojtari2) && ((eshteOnePair(letraLojtari1) || eshteTwoPairs(letraLojtari1)
				 || eshteThreeOfAKind(letraLojtari1) || eshteFlush(letraLojtari1) || eshteStraight(letraLojtari1) || eshteNoPair(letraLojtari1)))) {
			 a = 0;
			 b = 13;
		 }
		 if (  eshteFullHouse(letraLojtari1) && ((eshteOnePair(letraLojtari2) || eshteTwoPairs(letraLojtari2)
				 || eshteThreeOfAKind(letraLojtari2) || eshteFlush(letraLojtari2) || eshteStraight(letraLojtari2) || eshteNoPair(letraLojtari2)))) {
			 a = 13;
			 b = 0;
			 
		 }
		 if ( eshteFlush(letraLojtari2) && ((eshteOnePair(letraLojtari1) || eshteTwoPairs(letraLojtari1)
				 || eshteThreeOfAKind(letraLojtari1)  || eshteStraight(letraLojtari1) || eshteNoPair(letraLojtari1) ))) {
			 a = 0;
			 b = 13;
		 }		 
		 if ( eshteFlush(letraLojtari1) && ((eshteOnePair(letraLojtari2) || eshteTwoPairs(letraLojtari2)
				 || eshteThreeOfAKind(letraLojtari2)  || eshteStraight(letraLojtari2) || eshteNoPair(letraLojtari2) ))) {
			 a = 13;
			 b = 0;
		 }		 
		 if ( eshteStraight(letraLojtari2) && ((eshteOnePair(letraLojtari1) || eshteTwoPairs(letraLojtari1)
				 || eshteThreeOfAKind(letraLojtari1) || eshteNoPair(letraLojtari1) ))) {
			 a = 0;
			 b = 13;
		 }
		 if ( eshteStraight(letraLojtari1) && ((eshteOnePair(letraLojtari2) || eshteTwoPairs(letraLojtari2)
				 || eshteThreeOfAKind(letraLojtari2) || eshteNoPair(letraLojtari2) ))) {
			 a = 13;
			 b = 0;
		 }
		 if ( eshteThreeOfAKind(letraLojtari1) && ((eshteOnePair(letraLojtari2) || eshteTwoPairs(letraLojtari2) || eshteNoPair(letraLojtari2) ))) {
			 a = 13;
			 b = 0;
		 }
		 if ( eshteThreeOfAKind(letraLojtari2) && ((eshteOnePair(letraLojtari1) || eshteTwoPairs(letraLojtari1) || eshteNoPair(letraLojtari1)))) {
			 a = 0;
			 b = 13;
		 }
		 if ( eshteTwoPairs(letraLojtari2) && (eshteOnePair(letraLojtari1) || eshteNoPair(letraLojtari1))) {
			 a = 0;
			 b = 13;
		 }
		 if ( eshteTwoPairs(letraLojtari1) && (eshteOnePair(letraLojtari2) || eshteNoPair(letraLojtari2))) {
			 a = 13;
			 b = 0 ;
		 }
		 if (  eshteOnePair(letraLojtari1) && eshteNoPair(letraLojtari2)) {
			 a = 13;
			 b = 0 ;
		 }
		 if (  eshteOnePair(letraLojtari2) && eshteNoPair(letraLojtari1)) {
			 a = 0;
			 b = 13 ;
		 }

		if (a > b) {
			System.out.println("Lojtari 1 eshte fitues.");


		}else if (b > a) {
			System.out.println("Lojtari 2 eshte fitues.");
		}
		else {
			System.out.println("Loja eshte barazim.");
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		char[] simbole = { '♠', '♣', '♥', '♦' };
		String[] grade = { "As", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", " J", " Q", " K" };
		byte[] pako = new byte[52];

		for (int i = 0; i < pako.length; i++) {
			pako[i] = (byte) i;
		}

		perziej(pako);
         
        
		byte[] letraLojtari1 = Arrays.copyOfRange(pako, 0, 5);
		pako = Arrays.copyOfRange(pako, 5, pako.length);

		System.out.println("Letrat fillestare jane: ");
		afishoLetra(letraLojtari1, simbole, grade);

		System.out.print("Deshiron ti nderrosh te gjitha? (po/jo) - ");
		String prgj = input.next();

		if (prgj.equalsIgnoreCase("po")) {
			letraLojtari1 = Arrays.copyOfRange(pako, 0, 5);
			pako = Arrays.copyOfRange(pako, 5, pako.length);
		} else {
			int il = 0;
			while (il < 5) {
				System.out
						.print("A do e nderroni letren " + emertim(letraLojtari1[il], simbole, grade) + "? (po/jo) - ");
				prgj = input.next();
				if (prgj.equalsIgnoreCase("po")) {
					letraLojtari1[il] = pako[0];
					pako = Arrays.copyOfRange(pako, 1, pako.length);
					System.out.println("Letra u zevendesua me " + emertim(letraLojtari1[il], simbole, grade) + ".");
				}
				il++;
			}
		}
		
		System.out.println("Letrat perfundimisht jane: ");
		afishoLetra(letraLojtari1, simbole, grade);

		System.out.println("Letrat e lojtarit 1 formojne \"" + doreLetrash(letraLojtari1) + "\"");
		System.out.println("-----------------------------------------");

		byte[] letraLojtari2 = Arrays.copyOfRange(pako, 0, 5);
		pako = Arrays.copyOfRange(pako, 5, pako.length);

		System.out.println("Letrat fillestare jane: ");
		afishoLetra(letraLojtari2, simbole, grade);
		System.out.print("Deshiron ti nderrosh te gjitha? (po/jo) - ");
	    prgj = input.next();

		if (prgj.equalsIgnoreCase("po")) {
			letraLojtari2 = Arrays.copyOfRange(pako, 0, 5);
			pako = Arrays.copyOfRange(pako, 5, pako.length);
		} else {
			int il = 0;
			while (il < 5) {
				System.out
						.print("A do e nderroni letren " + emertim(letraLojtari2[il], simbole, grade) + "? (po/jo) - ");
				prgj = input.next();
				if (prgj.equalsIgnoreCase("po")) {
					letraLojtari2[il] = pako[0];
					pako = Arrays.copyOfRange(pako, 1, pako.length);
					System.out.println("Letra u zevendesua me " + emertim(letraLojtari2[il], simbole, grade) + ".");
				}
				il++;
			}
		}
		System.out.println("Letrat perfundimisht jane: ");
		afishoLetra(letraLojtari2, simbole, grade);

		System.out.println("Letrat e lojtarit 2 formojne \"" + doreLetrash(letraLojtari2) + "\"");
         fituesApoBarazim(letraLojtari1,letraLojtari2);    
			
	}
	

	private static String doreLetrash(byte[] letraLojtari) {
//		byte letra[] = {28,0,27,29,30};
		renditSipasGrades(letraLojtari);
		if (eshteRoyalFlush(letraLojtari)) {
			return "Royal Flush";
		}
		if (eshteStraightFlush(letraLojtari)) {
			return "Straight Flush";
		}
		
		if (eshteFourOfAKind(letraLojtari)) {
			return "Four of a kind";
		}
		if (eshteFullHouse(letraLojtari)) {
			return "Full House";
		}
		if (eshteFlush(letraLojtari)) {
			return "Flush";
		}
		if (eshteStraight(letraLojtari)) {
			return "Straight";
		}
		if (eshteOnePair(letraLojtari)) {
			return "One pair";
		}
		if (eshteThreeOfAKind(letraLojtari)) {
			return "Three of a kind";
		}
		if (eshteTwoPairs(letraLojtari)) {
			return "Two pairs";
		}
		if (eshteNoPair(letraLojtari)) {
			return "No Pair";
		}
		return "";
	}
	private static boolean eshteNoPair( byte[] letraLojtari) {
		return !eshteOnePair(letraLojtari) && !eshteTwoPairs(letraLojtari)
				&& !eshteThreeOfAKind(letraLojtari) && !eshteFourOfAKind(letraLojtari)
				&& !eshteStraight(letraLojtari) && !eshteFlush(letraLojtari) && !eshteStraightFlush(letraLojtari)
				&& !eshteFullHouse(letraLojtari) && !eshteRoyalFlush(letraLojtari);
	}
	private static boolean eshteFlush(byte[] letraLojtari) {
		for (int i = 0; i < letraLojtari.length - 1; i++) {
			if (indeksSimboli(letraLojtari[i]) != indeksSimboli(letraLojtari[i + 1])) {
				return false;
			}
		}
		return true & !eshteRoyalFlush(letraLojtari) & !eshteStraightFlush(letraLojtari);
	}

	private static boolean eshteStraight(byte[] letraLojtari) {
		int i = 0;
		if (indeksGrade(letraLojtari[0]) == 0 && indeksGrade(letraLojtari[1]) == 9) {
			i = 1;
		}
		for (; i < letraLojtari.length - 1; i++) {
			if (indeksGrade(letraLojtari[i]) + 1 != indeksGrade(letraLojtari[i + 1])) {
				return false;
			}
		}
		return true;
	}

	private static boolean eshteThreeOfAKind(byte[] letraLojtari) {
		byte r = 0 ; //2 1 1 1 3
		for (int i = 0; i < 3; i++) {
			if (indeksGrade(letraLojtari[i]) == indeksGrade(letraLojtari[i + 2])
					&& indeksGrade(letraLojtari[i]) == indeksGrade(letraLojtari[i + 1])) {
				r++;
			}
		}
		return r == 1 && !eshteFullHouse(letraLojtari);
	}

	private static boolean eshteTwoPairs(byte[] letraLojtari) {
		byte r = 0;
		for (int i = 0; i < letraLojtari.length - 1; i++) {
			if (indeksGrade(letraLojtari[i]) == indeksGrade(letraLojtari[i + 1])
			) {
				r++;
			}
			//12233
		}
		return r == 2 && !eshteThreeOfAKind(letraLojtari);
	}

	private static boolean eshteOnePair(byte[] letraLojtari) {
		byte r = 0;
		for (int i = 0; i < letraLojtari.length - 1; i++) {
			if (indeksGrade(letraLojtari[i]) == indeksGrade(letraLojtari[i + 1])) {
				r++;

			}

		}
		return r == 1;
	}

	private static boolean eshteFullHouse(byte[] letraLojtari) {
		int r = 0;
		for (int i = 0; i < letraLojtari.length - 1; i++) {
			if (indeksGrade(letraLojtari[i]) == indeksGrade(letraLojtari[i + 1])) {
				r++;
			}
		}

		return r == 3 && !eshteFourOfAKind(letraLojtari);
	}

	private static boolean eshteFourOfAKind(byte[] letraLojtari) {
		for (int i = 0; i < 2; i++) {
			if (indeksGrade(letraLojtari[i]) == indeksGrade(letraLojtari[i + 3])) {
				return true;
			}
		}
		return false;
	}

	private static boolean eshteRoyalFlush(byte[] letraLojtari) {
		renditSipasGrades(letraLojtari);
		return eshteStraightFlush(letraLojtari) && indeksGrade(letraLojtari[0]) == 0
				&& indeksGrade(letraLojtari[4]) == 12;
	}

	private static boolean eshteStraightFlush(byte[] letraLojtari) {
		renditSipasGrades(letraLojtari); 
		int i = 0;
		if (indeksGrade(letraLojtari[0]) == 0 && indeksGrade(letraLojtari[1]) == 9) {
			i = 1;
		}
		for (; i < letraLojtari.length - 1; i++) {
			if (indeksGrade(letraLojtari[i]) + 1 != indeksGrade(letraLojtari[i + 1])
					|| indeksSimboli(letraLojtari[i]) != indeksSimboli(letraLojtari[i + 1])) {
				return false;
			}

		}
		return true;
	}

	private static void renditSipasGrades(byte[] letraLojtari) {
		for (int i = 0; i < letraLojtari.length - 1; i++) {
			int indMin = i;
			for (int j = i + 1; j < letraLojtari.length; j++) {
				if (indeksGrade(letraLojtari[j]) < indeksGrade(letraLojtari[indMin])) {
					indMin = j;
				}
			}
			byte tmp = letraLojtari[i];
			letraLojtari[i] = letraLojtari[indMin];
			letraLojtari[indMin] = tmp;
		}

	}

	private static void afishoLetra(byte[] letra, char[] simbole, String[] grade) {
		for (int leter : letra) {
			System.out.print(emertim(leter, simbole, grade) + "  ");
		}
		System.out.println();
	}

	private static String emertim(int leter, char[] simbole, String[] grade) {
		if (leter < 0 || leter > 53) {
			return "[----]";
		}
		return "[" + grade[indeksGrade(leter)] + " " + simbole[indeksSimboli(leter)] + "]";
	}

	private static int indeksSimboli(int leter) {
		return leter / 13;
	}

	private static int indeksGrade(int leter) {
		return leter % 13;
	}

	private static void perziej(byte[] pako) {
		ArrayList<Byte> pakoEPerzier = new ArrayList<Byte>();
		for (int i = 0; i < pako.length; i++) {
			pakoEPerzier.add(pako[i]);
		}
		Collections.shuffle(pakoEPerzier);
		for (int i = 0; i < pako.length; i++) {
			pako[i] = pakoEPerzier.get(i);
		}
	}
}
