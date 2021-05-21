import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Zet {
	private int x;
	private int y;
	private Set<Integer> positions = new TreeSet<Integer>();
	private int sum;

	public Zet(int x, int y, int posX, int posY) {
		this.x = x;
		this.y = y;
		positions.add(posX);
		positions.add(posY);
		this.sum = x + y;
	}

	public Zet(int x, int y) {
		this.x = x;
		this.y = y;
		this.sum = x + y;
	}

	public int getX() {
		return x;
	}

	public Set<Integer> getPositions() {
		return positions;
	}

	public void addPostitions(Set<Integer> pos1) {
		Iterator<Integer> posIt = pos1.iterator();
		while (posIt.hasNext()) {
			positions.add(posIt.next());
		}
	}

	public int getSum() {
		return sum;
	}

}
