import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NamecardTest extends BasePage {

    private final String url = "https://demo.seleniumeasy.com/data-list-filter-demo.html";

    private final By names = By.xpath("//*[@class=\"searchable-container\"]//h4");

    public NamecardTest(WebDriver driver) {
        super(driver);
        navigateToURL(url);
    }

    public String[] nameResultArrayCreator(){
        List<WebElement> nameElements = driver.findElements(names);
        String[] nameResults = new String[nameElements.size()];
        for (int i = 0; i < nameElements.size(); i++) {
            String[] temporaryElement = nameElements.get(i).getText().split("Name: ");
            nameResults[i] = temporaryElement[1];
        }

        return nameResults;
    }
}
