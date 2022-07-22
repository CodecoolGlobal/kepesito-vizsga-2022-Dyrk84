import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver;

    @BeforeEach
    public void Setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void driverQuit() {driver.quit();}

    /* 1
    Tölts be a böngészőbe az alábbi oldalt: https://demo.seleniumeasy.com/basic-first-form-demo.html
    Írj tesztesetet két szám összegének ellenőrzésére a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. Az oldalon, a Two Input Fields” szekcióban két
    beviteli mezőjét töltsd ki tetszőleges számokkal, majd végezd el a számok összeadásának ellenőrzését kiolvasva az oldalon megjelenő összeget.
    Használj tetszőleges tesztadatot
     */
    @Test
    @Epic("Codecool KÉPESÍTŐ VIZSGA")
    @Story("TestInput")
    @Description("Tölts be a böngészőbe az alábbi oldalt: https://demo.seleniumeasy.com/basic-first-form-demo.html\n" +
            "    Írj tesztesetet két szám összegének ellenőrzésére a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. Az oldalon, a Two Input Fields” szekcióban két \n" +
            "    beviteli mezőjét töltsd ki tetszőleges számokkal, majd végezd el a számok összeadásának ellenőrzését kiolvasva az oldalon megjelenő összeget.\n" +
            "    Használj tetszőleges tesztadatot")
    @Severity(SeverityLevel.CRITICAL)
    public void TestInput() {
        TestInput page = (TestInput) PageFactory.pageSwitcher("TestInput", driver);
        page.closeThePopUp();
        String result = page.TestAddAllElementButton("10", "20");

        Assertions.assertEquals("30", result);
    }

    /* 2
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/basic-select-dropdown-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet a következők szerint: a Select List Demo szekció lenyíló mezőjében válaszd ki a
    hét utolsó napját és ellenőrizd, hogy az oldalon helyesen jelenik meg a kiválasztott érték.
    Tesztadatként használd az hét utolsó napját
     */
    @Test
    @Epic("Codecool KÉPESÍTŐ VIZSGA")
    @Story("SelectDayTest")
    @Description("Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/basic-select-dropdown-demo.html\n" +
            "    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet a következők szerint: a Select List Demo szekció lenyíló mezőjében válaszd ki a \n" +
            "    hét utolsó napját és ellenőrizd, hogy az oldalon helyesen jelenik meg a kiválasztott érték. \n" +
            "    Tesztadatként használd a hét utolsó napját")
    @Severity(SeverityLevel.CRITICAL)
    public void SelectDayTest() {
        SelectDayTest page = (SelectDayTest) PageFactory.pageSwitcher("SelectDayTest", driver);
        String expectedText = "Day selected :- Saturday";
        String resultText = page.testSaturday();

        Assertions.assertEquals(expectedText, resultText);
    }

    /* 3
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/bootstrap-modal-demo.html#
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetben ellenőrizd a modal alert ablak szöveges tartalmát összahasonlítva
    egy általad definiált elvárt eredménnyel. Nyisd meg a Single Modal ablakot, tárolt el az ablakon megjelenő szöveget egy változóba és zárd be az ablakot a bezárás gombbal
     */
    @Test
    @Epic("Codecool KÉPESÍTŐ VIZSGA")
    @Story("AlertTest")
    @Description("Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/bootstrap-modal-demo.html#\n" +
            "    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetben ellenőrizd a modal alert ablak szöveges tartalmát összahasonlítva\n" +
            "    egy általad definiált elvárt eredménnyel. Nyisd meg a Single Modal ablakot, tárolt el az ablakon megjelenő szöveget egy változóba és zárd be az ablakot a bezárás gombbal")
    @Severity(SeverityLevel.CRITICAL)
    public void AlertTest() {
        AlertTest page = (AlertTest) PageFactory.pageSwitcher("AlertTest", driver);
        String expected = "This is the place where the content for the modal dialog displays";
        page.closeThePopUp();
        String result = page.testText();

        Assertions.assertEquals(expected, result);

    }

    /* 4
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/data-list-filter-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A teszteset ellenőrizze a névjegykártyák tartalmát.Olvasd ki a neveket a
     megjelenő névjegykártyákról és ellenőrzésként hasonlítsd össze egy elvárt eredményként megadott listával.
    Használj relatív útvonalat a névjegykártya név elemeinek kiolvasásához.
     */
    @Test
    @Epic("Codecool KÉPESÍTŐ VIZSGA")
    @Story("NamecardTest")
    @Description("Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/data-list-filter-demo.html\n" +
            "    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A teszteset ellenőrizze a névjegykártyák tartalmát.Olvasd ki a neveket a\n" +
            "     megjelenő névjegykártyákról és ellenőrzésként hasonlítsd össze egy elvárt eredményként megadott listával.\n" +
            "    Használj relatív útvonalat a névjegykártya név elemeinek kiolvasásához.")
    @Severity(SeverityLevel.CRITICAL)
    public void NamecardTest() {
        NamecardTest page = (NamecardTest) PageFactory.pageSwitcher("NamecardTest", driver);

        String [] expectedNamesArray = {
                "Tyreese Burn",
                "Brenda Tree",
                "Glenn Pho shizzle",
                "Brian Hoyies",
                "Glenn Pho shizzle",
                "Arman Cheyia"
        };

        String[] nameResultArray = page.nameResultArrayCreator();

        Assertions.assertArrayEquals(expectedNamesArray, nameResultArray);
    }

    /* 5
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/table-data-download-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetet ellenőrizze a táblázatból a neveket, amelyeket a táblázat
    első oszlop tartalmaz. Gyűjtsd össze a neveket és tárold le a nameList.txt fájlba majd a tesztesetben a fájl tartalmát hasonlítsd össze egy elvárt eredménnyel.
     */
    @Test
    @Epic("Codecool KÉPESÍTŐ VIZSGA")
    @Story("TableTest")
    @Description("Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/table-data-download-demo.html\n" +
            "    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetet ellenőrizze a táblázatból a neveket, amelyeket a táblázat\n" +
            "    első oszlop tartalmaz. Gyűjtsd össze a neveket és tárold le a nameList.txt fájlba majd a tesztesetben a fájl tartalmát hasonlítsd össze egy elvárt eredménnyel.")
    public void TableTest() {
        TableTest page = (TableTest) PageFactory.pageSwitcher("TableTest", driver);
        List<String> resultNameList = page != null ? page.listForWebElementsOfTableTest() : null;
        String filepath = "files/nameList.txt";
        page.folderCreator("files/");
        page.deleteFile(filepath);
        page.stringListToFile(filepath, resultNameList);
        String resultNames = page.readFileToCreateString(filepath);
        String[] resultNamesArray = resultNames.split("\n");

        //ez mutatja meg Allure-ban, hogy lementődött a nameList.txt
        Path content = Paths.get(filepath);
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("Names of people", is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] expectedNamesArray = {
                "Tiger Nixon",
                "Garrett Winters",
                "Ashton Cox",
                "Cedric Kelly",
                "Airi Satou",
                "Brielle Williamson",
                "Herrod Chandler",
                "Rhona Davidson",
                "Colleen Hurst",
                "Sonya Frost",
                "Jena Gaines",
                "Quinn Flynn",
                "Charde Marshall",
                "Haley Kennedy",
                "Tatyana Fitzpatrick",
                "Michael Silva",
                "Paul Byrd",
                "Gloria Little",
                "Bradley Greer",
                "Dai Rios",
                "Jenette Caldwell",
                "Yuri Berry",
                "Caesar Vance",
                "Doris Wilder",
                "Angelica Ramos",
                "Gavin Joyce",
                "Jennifer Chang",
                "Brenden Wagner",
                "Fiona Green",
                "Shou Itou",
                "Michelle House"};

        Assertions.assertArrayEquals(expectedNamesArray,resultNamesArray);
    }
}
