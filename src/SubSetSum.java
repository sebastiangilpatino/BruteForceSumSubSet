import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import java.util.List;

public class SubSetSum {

	public static Integer[] array = { 1, 3, 5, 2 };
	public static int k = 7;
	public static List<Zet> numbers = new ArrayList<Zet>();

	public static void main(String[] args) {

		for (int i = 0; i < array.length; i++) {
			numbers.add(new Zet(array[i], 0, i, i));
		}

		subsetsum(numbers, k);

	}

	public static void subsetsum(List<Zet> arr, int k) {

		if (arr.size() == 0 || k == 0) {
			return;
		}

		List<Zet> T = new ArrayList<Zet>();

		for (int i = 0; i < numbers.size(); i++) {
			for (int j = 0; j < arr.size(); j++) {

				if (positionRepited(numbers.get(i).getPositions(), arr.get(j).getPositions()) == false) {
					T.add(new Zet(numbers.get(i).getX(), arr.get(j).getSum()));
					T.get(T.size() - 1).addPostitions(numbers.get(i).getPositions());
					T.get(T.size() - 1).addPostitions(arr.get(j).getPositions());

				}
			}
		}

		Iterator<Zet> Titerator = T.iterator();

		while (Titerator.hasNext()) {
			Zet temp = Titerator.next();
			if (temp.getSum() == k) {
				System.out.println(temp.getPositions().toString());
				System.exit(0);
			}
		}

		subsetsum(T, k);

	}

	public static boolean positionRepited(Set<Integer> list1, Set<Integer> list2) {

		Integer[] pos1 = list1.stream().toArray(Integer[]::new);
		Integer[] pos2 = list2.stream().toArray(Integer[]::new);

		for (int i = 0; i < pos1.length; i++) {
			for (int j = 0; j < pos2.length; j++) {
				if (pos1[i].equals(pos2[j])) {
					return true;
				}
			}
		}

		return false;
	}

}
