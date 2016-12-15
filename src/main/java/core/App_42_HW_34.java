package core;

import com.beust.jcommander.*;
import java.util.*;

@Parameters(separators = "=")

public class App_42_HW_34 {

	@Parameter(names = { "-l", "--list" }, variableArity = true, description = "Your must type your List")

	static List<String> list = new ArrayList<String>();

//	@Parameter(names = { "-t", "—title_expected" }, description = "Title Expected")
//	static String title = null;

	@Parameter(names = "--help", help = true, hidden = true)

	static Boolean help = false;

	public static void main(String[] args) {

		new JCommander(new App_42_HW_34(), args);

		if (help) {
			new JCommander(new App_42_HW_34(), args).usage();
			System.exit(0);
		}

		if (list.size() == 0) {
			System.err.println("Your must type your List");
		}

		else {
			for (String l:list) {
				System.out.println("List item = " + l);
			}
		}

//		WebDriver driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//
//		String useragentregex = "(?:Mozilla/5.0)\\s(?:\\(.*\\))\\s(?:Gecko/\\d{8})\\s(\\w+)/(\\d+.\\d+)";
//		String useragent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
//		Matcher m_browser = Pattern.compile(useragentregex).matcher(useragent);
//		m_browser.find();
//
//		// for (int i = 0; i < args.length; i++) {
//		int i = 0;
//
//		for (String listElement : list) {
//
//			String text_case_id = "TC-001.0" + (i ++);
//			String param[] = listElement.split("\\|");
//
//			String url = param[0];
//			String title_expected = param[1];
//
//			driver.get(url);
//			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			String title_actual = driver.getTitle();
//			System.out.println("");
//			if (title_expected.equals(title_actual)) {
//				System.out.println("Test Case ID: \t\t" + text_case_id);
//				System.out.println("URL: \t\t\t" + url);
//				System.out.println("Title Expected: \t" + title_expected);
//				System.out.println("Title Actual: \t\t" + title_actual);
//				System.out.println("Test Case Result: \t" + "PASSED");
//			} else {
//				System.out.println("Test Case ID: \t\t" + text_case_id);
//				System.out.println("URL: \t\t\t" + url);
//				System.out.println("Title Expected: \t" + title_expected);
//				System.out.println("Title Actual: \t\t" + title_actual);
//				System.out.println("Test Case Result: \t" + "FAILED");
//			}
//
//		}
//
//		driver.quit();

	}

}
