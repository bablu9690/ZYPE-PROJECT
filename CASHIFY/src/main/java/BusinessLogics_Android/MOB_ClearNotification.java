package BusinessLogics_Android;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import org.springframework.stereotype.Component;
import com.tyss.optimize.nlp.util.*;
import com.tyss.optimize.common.util.CommonConstants;
import java.util.Set;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
@Component(value =  "MOB_ClearNotification")
public class MOB_ClearNotification  implements Nlp {
    @InputParams({@InputParam(name = "locatorValue", type = "java.lang.String")})
    
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
        String loctorValue = (String) attributes.get("locatorValue");
        AndroidDriver driver=null;
        driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
        // Your program element business logic goes here ...
        try {
            
              if (driver.findElement(By.xpath(loctorValue)).isEnabled()) 
                     {
	    	             driver.findElement(By.xpath(loctorValue)).click();
	    	             nlpResponseModel.setStatus(CommonConstants.pass);
		                 nlpResponseModel.setMessage("Successfully cleared  notification ");
                     }
	           else
	               {
		                driver.navigate().back();
		                nlpResponseModel.setStatus(CommonConstants.pass);
		                nlpResponseModel.setMessage("Notification is not present at the movement");
	               }
            
        } catch(Exception e) {
                  nlpResponseModel.setStatus(CommonConstants.fail);
			         nlpResponseModel.setMessage("Failed to clear notification");
        }
        return nlpResponseModel;
    }
} 
