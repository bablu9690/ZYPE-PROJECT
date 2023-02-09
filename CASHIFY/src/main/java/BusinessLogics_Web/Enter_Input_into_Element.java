
  package BusinessLogics_Web;

  import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.data.models.dto.drivers.WebDriver;
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

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

  @Component(value="Enter_Input_into_Element")
  public class Enter_Input_into_Element implements Nlp {
      @InputParams({@InputParam(name = "Input", type = "java.lang.String"),
 @InputParam(name = "Element", type = "org.openqa.selenium.WebElement")})
     

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
          String Input = (String) attributes.get("Input");
          
          WebElement element = (WebElement) attributes.get("Element");

          WebDriver driver = (WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();

          try {
        	  element.sendKeys("Input");
        	  nlpResponseModel.setStatus(CommonConstants.pass);
        	  nlpResponseModel.setMessage("Successfully entered Input into the Element");
          }
          catch(Exception e){
        	  nlpResponseModel.setStatus(CommonConstants.fail);
        	  nlpResponseModel.setMessage("Failed entered Input into the Element");
         
          }
		return nlpResponseModel;
          
      }
  } 