package com.seleniumTest.automation.applications.client.pages.components

import com.seleniumTest.automation.config.UtilResources

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.*
import java.util.concurrent.TimeUnit
import java.net.URI

abstract class Base{

    lateinit var driver: WebDriver

    @BeforeTest
    fun setup() {
        System.setProperty(UtilResources.getProperties("nameDriver"),
                UtilResources.getProperties("pathDriver") + UtilResources.getProperties("exeDriver"))
        driver = ChromeDriver()
        driver?.manage()?.timeouts()?.implicitlyWait(5, TimeUnit.SECONDS)
        driver?.manage()?.window()?.maximize()
        //driver?.manage()?.window()?.fullscreen()
        driver?.get(URI(UtilResources.getProperties("pageURL")).toString())
    }

    @AfterTest
    fun driverClose() {
        driver?.close()

    }
}