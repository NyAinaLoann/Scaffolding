package ##package##;

import annotation.*;
import modelview.*;
import java.util.List;
import model.##EntityName##;

public class ##EntityName##Controller {
  
  @RestApi
  @MethodUrl(url = "##EntityName##-all")
  public List<##EntityName##> getAll##EntityName## () {
      return new ##EntityName##().findAll();  
  }
  
  @RestApi
  @MethodUrl(url = "##EntityName##-id")
  public ##EntityName## getAll##EntityName## (@ParamName("id##EntityName##") Object id##EntityName##) {
      return new ##EntityName##().findbyId(id##EntityName##);  
  }
   
}   
