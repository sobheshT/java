package comm.assignment;

public class MyDate {
	 private int day;
	 private int month;
	 private int year;
	 public int getDay() {
		 return day;
			
	 }
	 public int getMonth() {
			return month;
	 }
	 public int getYear() {
			return year;
	 }
	 public boolean setDay(int d) {
		 if (d>30) {
			 return false;
		 }
			
		 return true;
	 }
	 public boolean setMonth(int m) {
		 if (m>12) {
			 return false;
		 }
			
		 return true;
	 }
	 public boolean setYear(int y) {
		 if (y<1990&&y>2020) {
			 return false;
		 }
			
		 return true;
			
	 }
}
