/**
 * File Name: BasicPage.java<br>
 * Tychynska, Yana<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Feb 4, 2017
 */
package com.sqa.yt.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * BasicPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Tychynska, Yana
 * @version 1.0.0
 * @since 1.0
 */
public class BasicPage extends Core {

	public BasicPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
