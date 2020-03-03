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

def urls = ['dexerto.com','dexerto.com/call-of-duty/call-of-duty-pros-name-the-best-modern-warfare-player-1324503'] as String[]

for (i=0; i< 5; i++) {
	
	for (j=0; j<urls.length; j++){
		
		WebUI.openBrowser('http://developers.google.com/speed/pagespeed/insights/')
	
		WebUI.setText(findTestObject('PageSpeed Insights/input_url-to-test'), urls[j])
	
		WebUI.click(findTestObject('PageSpeed Insights/button_analize'))
	
		WebUI.getText(findTestObject('PageSpeed Insights/mobile_speed'))
	
		CustomKeywords.'com.at.util.ScreenshotHelper.takeWebElementScreenshot'(findTestObject('PageSpeed Insights/main'), i, j, 'mobile')
	
		WebUI.click(findTestObject('PageSpeed Insights/button_desktop'))
	
		WebUI.getText(findTestObject('PageSpeed Insights/desktop_speed'))
	
		CustomKeywords.'com.at.util.ScreenshotHelper.takeWebElementScreenshot'(findTestObject('PageSpeed Insights/main'), i, j, 'desktop')
	
		WebUI.closeBrowser()
	}
}
