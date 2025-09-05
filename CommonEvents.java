package coreUtilities.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonEvents {
    WebDriver driver;

    public CommonEvents(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void sendKeys(By locator, String value) {
        findElement(locator).clear();
        findElement(locator).sendKeys(value);
    }

    public void sendKeys(By locator, Keys key) {
        findElement(locator).sendKeys(key);
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    public boolean isSelected(By locator) {
        return findElement(locator).isSelected();
    }

    public void selectByVisibleText(By locator, String text) {
        Select select = new Select(findElement(locator));
        select.selectByVisibleText(text);
    }

    public String getFirstSelectedOptionFromDropdown(By locator, String dummy1, String dummy2) {
        return new Select(findElement(locator)).getFirstSelectedOption().getText();
    }

    public void jsClick(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", findElement(locator));
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsScrollToBottomOfThePage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

	public void navigateTo(String url) {
		driver.get(url);
		// TODO Auto-generated method stub
		
	}
}
