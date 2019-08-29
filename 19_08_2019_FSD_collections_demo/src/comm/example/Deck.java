package comm.example;

import java.util.ArrayList;
import java.util.List;

public class Deck {
public static void main(String[] args) {
	static List<Cards> Deck=new ArrayList<Cards>();
	 static {
		 for(Suit s:Suit.values()) {
			 for(Rank r:Rank.values()) {
				 Deck.add(new Cards(s,r));
			 }
		 }
	 }}

