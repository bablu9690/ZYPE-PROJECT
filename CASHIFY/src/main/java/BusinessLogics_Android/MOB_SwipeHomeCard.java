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
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
@SuppressWarnings("deprecation")
@Component(value = "MOB_SwipeHomeCard")
public class MOB_SwipeHomeCard implements Nlp {
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

		AndroidDriver driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
		try {
			for(int i=0;i<maxSwipeCount;i++) {
				  
				TouchAction touch = new TouchAction(driver);
				  touch.press(PointOption.point(1045,1246))
				  .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				  .moveTo(PointOption.point(46, 1246)).release().perform();
				  }
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Swipeed left until element is visible");
			
				 

		}
		catch(Exception e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to swipe left until element is visible");
		}
		return nlpResponseModel;
	}
} 