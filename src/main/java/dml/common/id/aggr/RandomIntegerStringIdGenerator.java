package dml.common.id.aggr;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 字符串形式的几位随机数字
 * 
 * @author neo
 *
 */
public class RandomIntegerStringIdGenerator implements IdGenerator {

	private Random random;
	private int numbersCount;// 几位数

	private List<Integer> idsLeft;

	public RandomIntegerStringIdGenerator(int numbersCount, Set<Integer> idsLeft) {
		this.random = new Random();
		this.numbersCount = numbersCount;
		this.idsLeft = new LinkedList<>(idsLeft);
	}

	@Override
	public String generateId() {
		if (idsLeft.isEmpty()) {
			return null;
		}
		int idValue = idsLeft.remove(random.nextInt(idsLeft.size()));
		String id = String.valueOf(idValue);

		// 补0
		int zeros = numbersCount - id.length();
		if (zeros == 0) {
			return id;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < zeros; i++) {
			sb.append('0');
		}

		return sb.append(id).toString();
	}

	public List<Integer> getIdsLeft() {
		return idsLeft;
	}

}
