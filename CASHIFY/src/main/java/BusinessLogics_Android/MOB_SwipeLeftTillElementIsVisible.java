
package BusinessLogics_Android;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

  @Component(value="MOB_SwipeLeftTillElementIsVisible")
  public class MOB_SwipeLeftTillElementIsVisible implements Nlp {
      @InputParams({@InputParam(name = "Reference Xpath", type = "java.lang.String"), @InputParam(name = "Actual Xpath", type = "java.lang.String")})

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
          String referenceXpath = (String) attributes.get("Reference Xpath");
          String actualXpath = (String) attributes.get("Actual Xpath");

          // Your program element business logic goes here ...
          AndroidDriver driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
          int startX=0;
          int startY=0;
          int heightX=0;
          int widthX=0;
          try {
        	  List<WebElement> loc = driver.findElements(By.xpath(referenceXpath));
        	  Point loc1 = loc.get(0).getLocation();
     		  startX = loc1.getX();
     		  startY = loc1.getY();
     		 
     		  Dimension di = loc.get(0).getSize();
     		   heightX = di.getHeight();
     		   widthX = di.getWidth();
     		  
          }
          catch (NoSuchElementException e) {
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage("Failed to capture the Reference Xpath");
		}
          try {
        	  while(driver.findElements(By.xpath(actualXpath)).isEmpty()){
        		  
        		  TouchAction touch = new TouchAction(driver);
        		  touch.press(PointOption.point(startX+widthX,startY))
        		  .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
        		  .moveTo(PointOption.point(startX, startY)).release().perform();
        		  }
        	  if(driver.findElements(By.xpath(actualXpath)).size()>1)
        		  nlpResponseModel.setStatus(CommonConstants.pass);
    			nlpResponseModel.setMessage("Swiped left till element is visible");
               }
          catch(Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
  			nlpResponseModel.setMessage("Failed to Swipe left");
          }

         
          return nlpResponseModel;
      }
  } 