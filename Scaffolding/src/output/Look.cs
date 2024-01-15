namespace t ;

using model.Look ; 
using Microsoft.AspNetCore.Mvc ; 
 

[ApiController]
[Route["Look"]]
public class LookController : ControllerBase {  

    [HttpGet()]
    public List Look readLook() { 
        return null ;
    }


    [HttpGet("{id:int}")]
    public Look readLook( [FromRoute] int id ) { 
        return null ;
    }


    [HttpPost()]
    public Look createLook( [FromBody] Look requestBody ) { 
        return null ;
    }

    [HttpPost()]
    public Look createLook( [FromRoute] int id , [FromBody] Look requestBody ) { 
        return null ;
    }

    [HttpDelete("{id:int}")]
    public Look deleteLook( [FromRoute] int id ) { 
        return null ;
    }

} 
        return null ;
    }

}