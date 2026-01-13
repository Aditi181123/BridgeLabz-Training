package JUnit;
import java.util.*;

public class ListManager {
	public void addElement(List<Integer> list, int num) {
		list.add(num);
	}

	public void removeElemnet(List<Integer> list, int num) {
		list.remove(Integer.valueOf(num));
	}

	public int getSize(List<Integer> list) {
		return list.size();
	}
}
