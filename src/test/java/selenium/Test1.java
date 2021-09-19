package selenium;

import org.testng.annotations.Test;
import pages.BasePo;
import static seleniumUtils.WaitManager.wait2;


public class Test1 extends BaseTest{

    BasePo basePo = new BasePo();

    @Test
    public void test1() {
        basePo.typeIntoSearch("abraCadabra");
        basePo.pressEnter();
        wait2(50);
//        driver.close();
    }
}
