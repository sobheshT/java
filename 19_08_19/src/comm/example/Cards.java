package comm.example;
public class Cards {
private Suit suit;
private Rank rank;
public Cards() {
	super();
}
public Cards(Suit suit, Rank rank) {
	super();
	this.suit = suit;
	this.rank = rank;
}
public Suit suit() {
	return suit;
}
public Rank rank() {
	return rank;
}
@Override
public String toString() {
	return "Cards [suit=" + suit + ", rank=" + rank + "]";
}

}
