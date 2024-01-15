namespace t ;

using model.Test ; 
using Microsoft.AspNetCore.Mvc ; 
 

[ApiController]
[Route["Test"]]
public class TestController : ControllerBase {  

    [HttpGet()]
    public List Test readTest() { 
        return null ;
    }


    [HttpGet("{id:int}")]
    public Test readTest( [FromRoute] int id ) { 
        return null ;
    }


    [HttpPost()]
    public Test createTest( [FromBody] Test requestBody ) { 
        return null ;
    }

    [HttpPost()]
    public Test createTest( [FromRoute] int id , [FromBody] Test requestBody ) { 
        return null ;
    }

    [HttpDelete("{id:int}")]
    public Test deleteTest( [FromRoute] int id ) { 
        return null ;
    }

}