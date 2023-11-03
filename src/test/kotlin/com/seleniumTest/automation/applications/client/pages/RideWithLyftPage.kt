package com.seleniumTest.automation.applications.client.pages

import com.seleniumTest.automation.applications.client.pages.components.Base
import com.seleniumTest.automation.utils.Control.Companion.getElementByXpath
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

open class RideWithLyftPage: Base(){

    companion object {
        //page outline
        val url = "https://www.lyft.com/ride-with-lyft"

        private val phoneNumberTextBox = "phone"
        private val phoneNumberSubmitButton = "//span[contains(text(),'Submit')]"
        private val phoneEntrySuccessText = "//h1[contains(text(),'Thanks! We’ve just sent you a link to download the')]"
        private val phoneEntryInvlaidText = "//p[@class='sc-cx1xxi-0 jDMCyI']"

        fun getPhoneNumberTextBox(driver: WebDriver):WebElement{
            return driver.findElement(By.name("phone"))
        }
        fun getSubmitButton(driver: WebDriver):WebElement{
            return getElementByXpath(driver, phoneNumberSubmitButton)
        }
        fun getPhoneSuccessText(driver: WebDriver):WebElement{
            return getElementByXpath(driver, phoneEntrySuccessText)
        }
        fun getPhoneInvalidText(driver: WebDriver):WebElement{
            return getElementByXpath(driver, phoneEntryInvlaidText)
        }
    }
}