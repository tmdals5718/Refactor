import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class Month_tableValueTest {
    int[] MonthTableValueTest ={31,28,31,30,31,30,31,31,30,31,30,31,29};

    @Test
    public void MonthTableValuecheck(){ ////달력의 양식에 맞는 값체크

        Month_table[] table = Month_table.values();

        assertEquals(table.length,MonthTableValueTest.length);

        for(int i=0;i<table.length;i++){
        assertEquals(table[i].getValue(),MonthTableValueTest[i]);
        }

    }



}