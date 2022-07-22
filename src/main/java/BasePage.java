import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class BasePage {

    WebDriver driver;
    private final By popUpCloseButtonXpath = By.id("at-cv-lightbox-close");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //super methods
    public void navigateToURL(String url) {
        driver.navigate().to(url);
    }

    public void closeThePopUp() {
        try {
            buttonClicker(popUpCloseButtonXpath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buttonClicker(By buttonXPath) {
        driver.findElement(buttonXPath).click();
    }

    public void inputFieldLoader(By inputFieldXPath, String text) {
        driver.findElement(inputFieldXPath).sendKeys(text);
    }

    public String textFromWebElement(By xpath){
        return driver.findElement(xpath).getText();
    }

    public List<WebElement> elementsFinder(By xpath) {
        return driver.findElements(xpath);
    }

    public List<String> stringListMakerFromWebElementsList(List<WebElement> ListOFWEs){
        List<String> nameList = new LinkedList<>();
        for (int i = 0; i < ListOFWEs.size(); i++) {
            nameList.add(ListOFWEs.get(i).getText());
        }
        return nameList;
    }
}
