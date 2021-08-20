package testmocks;

import formocks.House;
import formocks.Person;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestMockito {

    @Test(dataProvider = "dataP")
    void test3(String text, int num) throws InterruptedException {
        Thread.sleep(3000);
        Person person;
        House house;

        person = Mockito.mock(Person.class);
        house = new House(person);

        Mockito.when(person.getName()).thenReturn(text);
        Mockito.when(person.getAge()).thenReturn(num);
        Assert.assertEquals(house.getResult(), num + text);
    }

    @Test
    void test24() throws InterruptedException {
        Thread.sleep(3000);
        Person person;
        House house;

        person = Mockito.mock(Person.class);
        house = new House(person);

        Mockito.when(person.getName()).thenReturn("text");
        Mockito.when(person.getAge()).thenReturn(5);
        Assert.assertEquals(house.getResult(), 5 + "text");
    }

    @DataProvider(name = "dataP")
    public Object[][] test3_d() {
        return new Object[][]{
                {"name1", 1},
                {"name2", 2},
                {"name3", 3}};
    }
}
