import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TableTest extends BasePage {

    private final String url = "https://demo.seleniumeasy.com/table-data-download-demo.html";

    private final By nameListXpath = By.xpath("//tr/td[1]");

    public TableTest(WebDriver driver) {
        super(driver);
        navigateToURL(url);
    }

    public List<String> listForWebElementsOfTableTest() {
        List<WebElement> nameListFromWEs = elementsFinder(nameListXpath);
        return stringListMakerFromWebElementsList(nameListFromWEs);
    }

    public void folderCreator(String folderPath) {

        File f = new File(folderPath);
        if (!f.exists()) {
            if (f.mkdir()) {
                System.out.println(folderPath + " Directory is created");
            } else {
                System.out.println(folderPath + " Directory cannot be created");
            }
        }
    }

    public void deleteFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.deleteIfExists(path);
        } catch (Exception e) {
            System.out.println("An error has occurred.");
        }
    }

    public static void stringListToFile(String filePath, List<String> stringList) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (String str : stringList) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Record not saved" + e);
        }
    }

    public String readFileToCreateString(String fileName) {
        String result = "";
        try {
            File myFile = new File(fileName);
            Scanner readMyFile = new Scanner(myFile);
            while (readMyFile.hasNextLine()) {
                String row = readMyFile.nextLine();
                result += row + "\n";
            }
            readMyFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        return result;
    }
}
