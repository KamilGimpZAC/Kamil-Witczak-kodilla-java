package facebook;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_ACCEPT_COOKIES = "//div[contains(@class, \"_9o-r\")]/button[2]";
    public static final String XPATH_COOKIES = "//div[contains(@class, \"_4-i2 _pig _9o-c _50f4 _5pfh\")]";
    public static final String XPATH_CREATE_ACCOUNT = "//div[contains(@class, \"_6ltg\")]/a";
    public static final String XPATH_SELECT_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_SELECT_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_SELECT_YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";
    public static final String XPATH_WAIT = "//div[contains(@class, \"_n3\")]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_COOKIES)).isDisplayed());

        WebElement acceptCookies = driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES));
        acceptCookies.click();

        WebElement createAccount = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT));
        createAccount.click();

        while (!driver.findElement(By.xpath(XPATH_WAIT)).isDisplayed());

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select day = new Select(selectDay);
        day.selectByIndex(5);

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select month = new Select(selectMonth);
        month.selectByIndex(2);

        WebElement selectYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select year = new Select(selectYear);
        year.selectByVisibleText(String.valueOf(1999));
    }
}
