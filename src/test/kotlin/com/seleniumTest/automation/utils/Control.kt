package com.seleniumTest.automation.utils

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit


open class Control{
    companion object {
        fun getElementById(driver: WebDriver, id:String): WebElement {
            return driver.findElement(By.ById(id))
        }
        fun getElementByXpath(driver: WebDriver, xpath:String): WebElement {
            return driver.findElement(By.ByXPath(xpath))
        }

        fun getElementByCss(driver: WebDriver, csSelector:String): WebElement {
            return driver.findElement(By.ByCssSelector(csSelector))
        }

        fun waitForElementToLoad(driver:WebDriver, el: WebElement) {
            var wait = WebDriverWait(driver, 5)
            wait.until(ExpectedConditions.visibilityOf(el))
        }

        fun waitForPageToLoad(driver:WebDriver, el: WebElement){
            waitForElementToLoad(driver, el)
            TimeUnit.MILLISECONDS.sleep(1000)

        }
    }
}