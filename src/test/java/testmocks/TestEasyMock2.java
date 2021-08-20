package testmocks;

import formocks.House;
import formocks.Person;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.easymock.EasyMock.*;

public class TestEasyMock2 {

    @Mock
    Person person;
    @TestSubject
    House house = new House();
    @BeforeMethod
    public void setup() {
        EasyMockSupport.injectMocks(this);
    }

    @Test
    void test2() {
        house.setPerson(person);
        expect(person.getName()).andReturn("name");
        expect(person.getAge()).andReturn(22);
        replay(person); //apply
        Assert.assertEquals(house.getResult(), "22name");
        verify(person); //verify all 2 mocks are executed, throw exception
    }
}
