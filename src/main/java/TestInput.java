import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestInput extends BasePage {

    private final String url = "http://demo.seleniumeasy.com/basic-first-form-demo.html";

    private final By enterABoxXpath = By.id("sum1");
    private final By enterBBoxXpath = By.id("sum2");
    private final By getTotalButtonXpath = By.xpath("//*[@id=\"gettotal\"]/button");
    private final By totalAPlusBXpath = By.id("displayvalue");

    public TestInput(WebDriver driver) {
        super(driver);
        navigateToURL(url);
    }

    public String TestAddAllElementButton(String testNumber1, String testNumber2){

        inputFieldLoader(enterABoxXpath, testNumber1);
        inputFieldLoader(enterBBoxXpath, testNumber2);
        buttonClicker(getTotalButtonXpath);
        return driver.findElement(totalAPlusBXpath).getText();
    }
}
