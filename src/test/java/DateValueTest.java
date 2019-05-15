import org.junit.Test;

import static org.junit.Assert.*;

public class DateValueTest {
    @Test
    public void BaseyearValueChecking(){
      Date date =new Date();

      assertEquals(date.getBase_year(),1900);
      assertEquals(date.getBase_month(),1);
    }

}