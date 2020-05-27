import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class copywriter {
	public static void main(String[] args) throws IOException {
		System.out.println(new java.io.File("src/MakeMeRich.java").getCanonicalPath());
		File file1 = new File("src\\MakeMeRich.java");
		FileUtils.write(file1,"//Copyright, Zachary Zensen 2020", true);
		System.out.println(new java.io.File("src/StockInfo.java").getCanonicalPath());
		File file2 = new File("src/StockInfo.java");
		FileUtils.write(file2,"//Copyright, Zachary Zensen 2020", true);
		System.out.println(new java.io.File("src/StockUtil.java").getCanonicalPath());
		File file3 = new File("src/StockUtil.java");
		FileUtils.write(file3,"//Copyright, Zachary Zensen 2020", true);
		System.out.println(new java.io.File("src/TimeIt.java").getCanonicalPath());
		File file4 = new File("src/TimeIt.java");
		FileUtils.write(file4, "//Copyright, Zachary Zensen 2020", true);
	}
}
