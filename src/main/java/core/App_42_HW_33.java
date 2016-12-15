package core;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.beust.jcommander.*;

@Parameters(separators = "=")

public class App_42_HW_33 {


	@Parameter(names = { "-u", "--url" }, description = "You must type URL") 

	static String url = null;

	@Parameter(names = { "-t", "—title_expected" }, description = "Title Expected")
	static String title = null;


	@Parameter(names = "--help", help = true, hidden = true)

	static Boolean help = false;

	public static void main(String[] args) {

		new JCommander(new App_42_HW_33(), args);

		if (help) {
			new JCommander(new App_42_HW_33(), args).usage();
			System.exit(0);
		}

		if (url == null) {
			System.err.println("You must type URL");
		}

		else if (title == null) {
			System.err.println("Title is empty");
		}

		else {
			System.out.println("URL = " + url + ", Title = " + title);
		}

		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();
		String text_case_id = "TC-001.01";
		String useragentregex = "(?:Mozilla/5.0)\\s(?:\\(.*\\))\\s(?:Gecko/\\d{8})\\s(\\w+)/(\\d+.\\d+)";
		String useragent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		Matcher m_browser = Pattern.compile(useragentregex).matcher(useragent);
		m_browser.find();

		if (title.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("Browser: \t\t" + m_browser.group(1) + " " + m_browser.group(2));
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");

		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("Browser: \t\t" + m_browser.group(1) + " " + m_browser.group(2));
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}

		System.out.println("\nUserAgent: \t\t"
				+ (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"));

		driver.quit();
	}
}
