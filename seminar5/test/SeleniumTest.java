import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {
    // 5.4.
    // Напишите автоматизированный тест, который выполнит следующие шаги:
    // 1. Открывает главную страницу Google.
    // 2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".
    // 3. В результатах поиска ищет ссылку на официальный сайт Selenium (https://www.selenium.dev) и проверяет,
    // что ссылка действительно присутствует среди результатов поиска.

    @Test
    void findSeleniumTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();


        // поиск по xpath

        // WebElement searchUrl = driver.findElement(By.xpath("/html/body/div[5]/div/div[9]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/div/div/div/cite"));
        // assertThat(searchUrl.getText()).isEqualTo("https://www.selenium.dev");

        // поиск по элементу

        List<WebElement> searchUrls = driver.findElements(By.cssSelector("div"));

        boolean isFound = false;
        for (WebElement element : searchUrls) {
            if (element.getText().contains("https://www.selenium.dev")) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound);

        driver.quit();

    }

    // 5.5. Нужно написать сквозной тест с использованием Selenium,
    // который авторизует пользователя на сайте https://www.saucedemo.com/.
    // Данные для входа - логин: "standard_user", пароль: "secret_sauce".
    // Проверить, что авторизация прошла успешно и отображаются товары.
    // Вам необходимо использовать WebDriver для открытия страницы и методы sendKeys() для ввода
    // данных в поля формы, и submit() для отправки формы. После этого, проверьте, что на странице
    // отображаются продукты (productsLabel.getText() = "Products").

    @Test
    void checkUserAuthorizationOnTheSite() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        WebElement loginBox = driver.findElement(By.name("user-name"));
        loginBox.sendKeys("standard_user");

        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("secret_sauce");

        WebElement button = driver.findElement(By.id("login-button"));
        button.click();

        WebElement product = driver.findElement(By.className("title"));

        assertThat(product.getText().contains("Products"));

        driver.quit();

    }


}
