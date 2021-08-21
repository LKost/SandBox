package testmocks;
import org.testng.Assert;
import org.testng.annotations.Test;
import formocks.House;
import formocks.Person;

import static org.easymock.EasyMock.*;

public class TestEasyMock {

    @Test(threadPoolSize = 10, invocationCount = 10, timeOut = 3000)
    void test1() throws InterruptedException {
        Thread.sleep(2000);
        Person person = mock(Person.class);
        House house = new House();
        house.setPerson(person);
        expect(person.getName()).andReturn("name");
        expect(person.getAge()).andReturn(28);
        replay(person); //apply
        Assert.assertEquals(house.getResult(), "28name");
        verify(person); //verify all 2 mocks are executed, throw exception;
    }
}
