package ruixue.practice.ocpkasi.java_core.nio.file;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DemoPathGetName {

	public static void main(String[] args) {
		Path p = Paths.get("x");
		System.out.println(p.getName(0));
	}

}
