package com.at.util

import javax.imageio.ImageIO

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import ru.yandex.qatools.ashot.shooting.ShootingStrategies

public class ScreenshotHelper {

	@Keyword
	public void takeWebElementScreenshot(TestObject object, def i, def j, String a){
		//no need to overload method, can use def instead of int7String
		//Take date for the name of the screenshots
		Date today = new Date()
		String todaysDate = today.format('yyyy-MM-dd')
		String nowTime = today.format('HH-mm-ss')

		WebElement element = WebUiCommonHelper.findWebElement(object,20)
		WebDriver driver = DriverFactory.getWebDriver();

		def url = j
		def repeat = i
		String device = a

		//Screenshot screenshot = new AShot().takeScreenshot(driver, element);  //doesn't work for that page, there is no jQuery
		/** 
		 * Problem: error "org.openqa.selenium.JavascriptException: javascript error: $ is not defined"
		 * jQuery is still required by AShot ( coords-single.js )
		 * Solution provided: coordsProvider(new WebDriverCoordsProvider() gives that coord
		 */
		//Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element)  //takes image, but only viewport, not entire web. Problem with sticky/fixed header doesn't allow proper scrolling
		/**
		 * Problem: image of the viewport, not entire web.
		 * Solutions provided: using shootingStrategy: aShot.shootingStrategy(ShootingStrategies.viewportPasting(int scrollTimeout)  
		 * scrollTimeout in ms. Is the custom timeout between scrolls. Users usually 1000. Tried 10, it's enough, web is no so long.
		 */
		//Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(10)).takeScreenshot(driver, element)  //now, the sticky header appears replicated along the image.
		/**
		 * Problem: sticky header of this web appearing in all screenshots taken by ashot, and appears multiplied in the composition given by ashot.
		 * Solution: new shootingStrategy that can avoid pixels on top and/or bottom of the image shootingStrategy(ShootingStrategies.viewportNonRetina(scrollTimeout, header, footer)
		 * scrollTimeout is in ms. Header and footer are in pixels.
		 */

		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportNonRetina(10, 98, 0)).takeScreenshot(driver, element)

		//ImageIO.write(screenshot.getImage(),'PNG', new File('image2.png'))  

		File dir = new File ('/home/maribel/Katalon Studio/Web Speed/Screenshots/' + todaysDate)
		
		if (!dir.exists()) {
			
			dir.mkdirs()
			
		}
		
		String filename = dir.getAbsolutePath() + '/' + todaysDate + '_' + nowTime + '_' + url + '_' + device + repeat + '.png'
		
		
		ImageIO.write(screenshot.getImage(),'PNG', new File(filename))
	}
}
