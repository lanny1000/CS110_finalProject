import java.util.*;

public class SortEx {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("4. 888");
		list.add("3. 3.14");
		list.add("1. 5555666");
		list.add("2. 18.5");
		
				
		ArrayList<Double> numerals = new ArrayList<Double>();
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			String numeral = temp.substring(3, temp.length());
			double insertValue = Double.parseDouble(numeral);
			numerals.add(insertValue);
			System.out.println(numerals.get(i));
		}

	}

}
