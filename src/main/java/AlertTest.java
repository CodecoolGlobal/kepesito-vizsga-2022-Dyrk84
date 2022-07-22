import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertTest extends BasePage {

    private final String url = "https://demo.seleniumeasy.com/bootstrap-modal-demo.html#";

    private final By launchModal1Button = By.xpath("//*[@href=\"#myModal0\"]");
    private final By modalBody = By.xpath("//*[@id=\"myModal0\"]//*[@class=\"modal-body\"]");
    private final By closeButton = By.xpath("//*[@class=\"modal fade in\"]//*[text()=\"Close\"]");

    public AlertTest(WebDriver driver)  {
        super(driver);
        navigateToURL(url);
    }

    public String testText(){
        buttonClicker(launchModal1Button);
        String textFromModalBody = textFromWebElement(modalBody);
        buttonClicker(closeButton);

        return textFromModalBody;
    }
}
