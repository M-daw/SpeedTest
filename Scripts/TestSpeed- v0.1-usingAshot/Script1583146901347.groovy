import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/*
//Take date for the name of the screenshots
Date today = new Date()

String todaysDate = today.format('yyyy-MM-dd')

String nowTime = today.format('HH-mm-ss')*/

int j = 0
int i = 2


WebUI.openBrowser('http://developers.google.com/speed/pagespeed/insights/')

WebUI.setText(findTestObject('PageSpeed Insights/input_url-to-test'), 'dexerto.com')

WebUI.click(findTestObject('PageSpeed Insights/button_analize'))

WebUI.getText(findTestObject('PageSpeed Insights/mobile_speed'))

//WebUI.takeScreenshot('Screenshots/' + todaysDate + '/' + todaysDate + '_' + nowTime + '_' + j + 'Mobile.png') //this takes photos of viewport. Using Ashot for composing photos of all the site

CustomKeywords.'com.at.util.ScreenshotHelper.takeWebElementScreenshot'(findTestObject('PageSpeed Insights/main'), i, j, 'mobile')

WebUI.click(findTestObject('PageSpeed Insights/button_desktop'))

WebUI.getText(findTestObject('PageSpeed Insights/desktop_speed'))

//WebUI.takeScreenshot('Screenshots/' + todaysDate + '/' + todaysDate + '_' + nowTime + '_' + j + 'Desktop.png')

/*
 * Setting a different viewport is a solution provide for avoiding the duplicates sticky headers along the image. Doesn't work, 
 * the heigth isn't setted correctly
 * WebUI.setViewPortSize(102, 8000) //se cambia el wiewport para que quepa todo en una foto
 */



CustomKeywords.'com.at.util.ScreenshotHelper.takeWebElementScreenshot'(findTestObject('PageSpeed Insights/main'), i, j, 'desktop')

WebUI.closeBrowser()

