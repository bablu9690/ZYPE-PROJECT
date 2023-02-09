package BusinessLogics_Android;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;

import io.appium.java_client.AppiumDriver;

@Component(value = "MOB_SwipeLeftUntilElementIsVisible")
public class MOB_SwipeLeftUntilElementIsVisible implements Nlp {
	@InputParams({  @InputParam(name = "Reference element xpath", type = "java.lang.String"), 
		@InputParam(name = "Maximum swipe count", type = "java.lang.Integer")})

	@Override
	public List<String> getTestParameters() throws NlpException {
		List<String> params = new ArrayList<>();
		return params;
	}

	@Override
	public StringBuilder getTestCode() throws NlpException {
		StringBuilder sb = new StringBuilder();

		return sb;
	}
	@Override
	public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {

		NlpResponseModel nlpResponseModel = new NlpResponseModel();
		Map<String, Object> attributes = nlpRequestModel.getAttributes();
		String xpath = (String) attributes.get("Reference element xpath");
		int maxSwipeCount = (Integer) attributes.get("Maximum swipe count");

		AppiumDriver driver = (AppiumDriver) nlpRequestModel.getDriver().getSpecificIDriver();
		try {

			Dimension screenSize = driver.manage().window().getSize();// Identify screen dimension
			Point location = driver.findElement(By.xpath(xpath)).getLocation(); // Get location from element to swipe to
			int fromX = (int) (screenSize.getWidth()*0.2); // Get x location
			int toX = (int)(screenSize.getWidth()*0.7);
			int y = location.getY(); // Get y location
			int count = 0;

			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

			// Search Element until it is available on screen. If no, then perform below operations
			while (driver.findElements(By.xpath(xpath)).isEmpty()) {

				Sequence swipe =  new Sequence(finger, 1);

				//Move finger into starting position
				swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), fromX, y));

				//Finger goes up into contact with screen
				swipe.addAction(finger.createPointerDown(0));

				//Finger moves to End Position
				swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), toX, y));

				//Take out finger from screen
				swipe.addAction(finger.createPointerUp(0));

				driver.perform(Arrays.asList(swipe));

				if (++count >= maxSwipeCount) {
					break;
				}
			}

			if (count >= maxSwipeCount) {
				nlpResponseModel.setStatus(CommonConstants.fail);
				nlpResponseModel.setMessage("Element not found within given swipe count");
			}
			else {
				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Swiped left  until element option is visible");
			}
		}
		catch(Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to swipe left until element is visible");
		}
		return nlpResponseModel;
	}
} 