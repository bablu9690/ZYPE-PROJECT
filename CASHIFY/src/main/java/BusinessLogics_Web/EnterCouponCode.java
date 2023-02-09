
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
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
  import java.util.List;
  import org.springframework.stereotype.Component;

  @Component(value="EnterCouponCode")
  public class EnterCouponCode implements Nlp {
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

          // Your program element business logic goes here ...
          try {
        	  Robot robo = new Robot();
      	    robo.keyPress(KeyEvent.VK_CONTROL);
      	    robo.keyPress(KeyEvent.VK_V);
      	    robo.keyRelease(KeyEvent.VK_CONTROL);
      	    robo.keyRelease(KeyEvent.VK_V);
      	  nlpResponseModel.setStatus(CommonConstants.pass);
          nlpResponseModel.setMessage("Successfully pasted the coupon code");
          }
          catch (Exception e) {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
              nlpResponseModel.setMessage("Failed to paste the coupon code");
		}

          
          return nlpResponseModel;
      }
  } 