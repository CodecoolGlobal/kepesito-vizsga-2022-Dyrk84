import org.openqa.selenium.WebDriver;

public class PageFactory {

    public static BasePage pageSwitcher(String pageName, WebDriver driver) { //IndexPage a visszatérési típus, mert a főosztályból örökli az összes többi a driverjét
        switch (pageName) {
            case "TestInput":
                return new TestInput(driver);
            case "SelectDayTest":
                return new SelectDayTest(driver);
            case "AlertTest":
                return new AlertTest(driver);
            case "NamecardTest":
                return new NamecardTest(driver);
            case "TableTest":
                return new TableTest(driver);
            default:
                return null;
        }
    }
}