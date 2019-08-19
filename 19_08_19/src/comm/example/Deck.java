package comm.example;
import java.util.*;
public class Deck {
	static Scanner scan=new Scanner(System.in);
 static List<Cards> Deck=new ArrayList<Cards>();
 static {
	 for(Suit s:Suit.values()) {
		 for(Rank r:Rank.values()) {
			 Deck.add(new Cards(s,r));
		 }
	 }
 }
 public static void main(String[] args) {
	 System.out.println("Enter Number Of hands:");
	 int hands= scan.nextInt();
	 System.out.println("Enter Number Of cards per hand:");
	 int card= scan.nextInt();
	 List<Cards> OutCards = getCards(hands,card);
	 Collections.shuffle(Deck);
	 System.out.println("Cards are:");
for (int i=0;i<hands;i++) {
	for(int j=0;j<card;j++) {
		System.out.println(OutCards.get(i*card+j));
	}
	System.out.println();
}
 }
 static List<Cards> getCards(int hands,int card){
	 Collections.shuffle(Deck);
	 List<Cards> temp=new ArrayList<Cards>();
	 for (int i=0;i<hands;i++) {
			for(int j=0;j<card;j++) {
				temp.add(Deck.get(i*card+j));
			}
 }
	 return temp;
}
 }
