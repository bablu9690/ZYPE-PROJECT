package BusinessLogics_Web;

	  import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
	  import com.tyss.optimize.nlp.util.NlpException;
	  import com.tyss.optimize.nlp.util.NlpRequestModel;
	  import com.tyss.optimize.nlp.util.NlpResponseModel;
	  import com.tyss.optimize.nlp.util.annotation.InputParam;
	  import com.tyss.optimize.nlp.util.annotation.InputParams;
	  import java.util.Map;
	  import java.util.ArrayList;
	  import java.util.List;
	  
	  import org.openqa.selenium.WebElement;
	  import org.springframework.stereotype.Component;
	  	
	  
	   @Component(value="ClickOnElement")
	  public class ClickOnElement implements Nlp {
	        @InputParams({@InputParam(name = "elementName", type = "java.lang.String"), 
	      @InputParam(name = "elementType", type = "java.lang.String"), 
	      @InputParam(name = "element", type = "org.openqa.selenium.WebElement"),
	      @InputParam(name = "Count", type = "java.lang.Integer")})
	      

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
	         Integer count = (Integer) attributes.get("Count");

	          WebElement element = (WebElement)attributes.get("element");
	          try {
	        	  for(int i=0;i<count;i++) {  
	    	          element.click();
	        	  }
	        	  nlpResponseModel.setStatus(CommonConstants.pass);
	    	       nlpResponseModel.setMessage("Clicked On Element");
	    	      
	        	  
	          }
	          catch(Exception e){
	        	  nlpResponseModel.setStatus(CommonConstants.fail);
	        	  nlpResponseModel.setMessage("No Such Element Exception");
	         
	          }
	          String string3 = "Return Value";
	          nlpResponseModel.getAttributes().put("string3", string3);
	          return nlpResponseModel;
	      }
	  } 
	


