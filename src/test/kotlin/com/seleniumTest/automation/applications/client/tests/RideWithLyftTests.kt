package com.seleniumTest.automation.applications.client.tests

import com.seleniumTest.automation.applications.client.pages.RideWithLyftPage
import com.seleniumTest.automation.applications.client.pages.components.Base
import com.seleniumTest.automation.utils.Control
import org.testng.Assert
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeTest
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import java.util.*

import java.util.logging.Logger

class RideWithLyftTests : Base() {

    private val log = Logger.getLogger(RideWithLyftTests::class.java.name)

    @BeforeTest
    fun navigateToPage() {
        driver.navigate().to(RideWithLyftPage.url)
    }

    @AfterClass
    fun closeDriver() {
        driver.quit()
    }

    @Test(enabled = true,
            priority = 1,
            description = "Verify Successful phone number signup"
    )
    @Throws(Exception::class)
    fun completePhoneSignupWebForm() {

        driver.navigate().to(RideWithLyftPage.url)
        //Navigate to the phone signup webform
        Control.waitForPageToLoad(driver, RideWithLyftPage.getPhoneNumberTextBox(driver))

        //Entering a placeholder value for now of "9999999999".  However, in the actual test I would have a twilio test number created for this test.
        RideWithLyftPage.getPhoneNumberTextBox(driver).sendKeys("9999999999")
        RideWithLyftPage.getSubmitButton(driver).click()

        //Assert phone submission successful
        Assert.assertEquals(RideWithLyftPage.getPhoneSuccessText(driver).text, "Thanks! We’ve just sent you a link to download the app.")
    }

    @Test(enabled = true,
            priority = 2,
            description = "Verify Required Fields to submit",
            dataProviderClass = PhoneNumberDataProvider::class,
            dataProvider = "phoneNumberErrorData"
    )
    @Throws(Exception::class)
    fun contactUsRequiredToSubmitTest(scenario: String, phoneNumber: String) {

        driver.navigate().to(RideWithLyftPage.url)

        log.info("Invalid Phone Number Submit Scenario: " + scenario)
        //Navigate to the phone signup webform and verify element exists to continue
        Control.waitForPageToLoad(driver, RideWithLyftPage.getPhoneNumberTextBox(driver))

        //Entering invalid options test.
        RideWithLyftPage.getPhoneNumberTextBox(driver).sendKeys(phoneNumber)
        RideWithLyftPage.getSubmitButton(driver).click()

        //Assert phone submission successful
        Assert.assertEquals(RideWithLyftPage.getPhoneInvalidText(driver).text, "Invalid phone number: +1$phoneNumber")
    }
}


object PhoneNumberDataProvider {

    @DataProvider(name = "phoneNumberErrorData")
    @JvmStatic
    fun phoneNumberErrorData(): Array<Array<Any>> {
        return arrayOf(
                arrayOf("Phone too short", "385"),
                arrayOf("Phone cannot use emergency prefix", "9119119111"),
                arrayOf("Phone must be valid format area code", "0011234567"),
                arrayOf("Phone must be numeric only", "abc1234567")
        )
    }
}