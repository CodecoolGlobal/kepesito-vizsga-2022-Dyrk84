import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectDayTest extends BasePage {

    private final String url = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    private final By arrowButton = By.id("select-demo");
    private final By saturday = By.xpath("//*[@id=\"select-demo\"]//option[last()]");
    private final By resultText = By.className("selected-value");

    public SelectDayTest(WebDriver driver) {
        super(driver);
        navigateToURL(url);
    }

    public String testSaturday(){
        buttonClicker(arrowButton);
        buttonClicker(saturday);
        return textFromWebElement(resultText);
    }
}