
  package BusinessLogics_Android;

  import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
  import com.tyss.optimize.nlp.util.NlpException;
  import com.tyss.optimize.nlp.util.NlpRequestModel;
  import com.tyss.optimize.nlp.util.NlpResponseModel;
  import com.tyss.optimize.nlp.util.annotation.InputParam;
  import com.tyss.optimize.nlp.util.annotation.InputParams;
  import com.tyss.optimize.nlp.util.annotation.ReturnType;

import io.appium.java_client.android.AndroidDriver;

import java.util.Map;
  import java.util.ArrayList;
  import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

  @Component(value="HandleAppExperience")
  public class HandleAppExperience implements Nlp {
     
      @InputParams({@InputParam(name = "elementName", type = "java.lang.String"), 
      @InputParam(name = "elementType", type = "java.lang.String"), 
      @InputParam(name = "element", type = "org.openqa.selenium.WebElement")})
     

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
          WebElement element = (WebElement) attributes.get("element");
         
          // Your program element business logic goes here ...
         
          try {
        	  if(element.isDisplayed()) {
        		  element.click();
        	  }
        		  nlpResponseModel.setStatus(CommonConstants.pass);
      			nlpResponseModel.setMessage("Clicked and handled the App experience");
        	  
          }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.pass);
        	  nlpResponseModel.setMessage("App experience handled");
    		  
		}

         
          return nlpResponseModel;
      }
  } 