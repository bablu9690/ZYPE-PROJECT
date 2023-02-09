
  package BusinessLogics_Android;

  import com.tyss.optimize.common.util.CommonConstants;
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

  @Component(value="MOB_GetAttributeFromElement")
  public class MOB_GetAttributeFromElement implements Nlp {
	  @InputParams({@InputParam(name = "elementName", type = "java.lang.String"), 
	  @InputParam(name = "elementType", type = "java.lang.String"), 
	  @InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
	  @InputParam(name = "propertyName", type = "java.lang.String")})
      @ReturnType(name = "string3", type = "java.lang.String")

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
          String attributeName=(String)attributes.get("propertyName");
          String attributeValue=null;
          try {
        	  attributeValue=element.getAttribute(attributeName);
        	  nlpResponseModel.setStatus(CommonConstants.pass);
              nlpResponseModel.setMessage("Successfully fetched the attribute + "+attributeName+"+"+attributeValue+"");
          }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("Failed to fetch the "+attributeName+"");
		}
          

          
          nlpResponseModel.getAttributes().put("attributeValue", attributeValue);
          return nlpResponseModel;
      }
  } 