package ruixue.practice.ocpkasi.core_java.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class TestFailFastIterator {
	private static final Logger logger = LogManager.getLogger(TestFailFastIterator.class);
	
	/**
	 * If a thread modifies a collection directly while it is iterating over the collection with a fail-fast iterator, the iterator will throw this exception
	 */
	@Test
	public void testAddOnArrayListDuringIteration() {
		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add("world");
		list.add("jesus");
		assertThrows(ConcurrentModificationException.class, () -> {
			for (String current : list)
				list.add(current);
		});
		logger.info("Exception came from the line, where the for loop is!");
	}
	
	/**
	 * Modification of data is on the existing fail-fast iterator 
	 */
	@Test
	public void testSetOnArrayListDuringIteration() {
		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add("world");
		int i = 0;
		for (String current : list) {
			String changedString = "changed";
			if (i == 0) list.set(i+1, changedString);
			if (i == 1) assertEquals(changedString, current);
			i++;
		}
	}

}
