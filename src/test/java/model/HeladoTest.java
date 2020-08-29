package model;

import org.junit.Assert;
import org.junit.Test;

public class HeladoTest {
    Helado helado = new Helado("name", 0, 0, "owner");

    @Test
    public void testSetHeladoID() throws Exception {
        helado.setHeladoID(0);
    }

    @Test
    public void testSetName() throws Exception {
        helado.setName("name");
    }

    @Test
    public void testSetPrice() throws Exception {
        helado.setPrice(0);
    }

    @Test
    public void testSetNumber() throws Exception {
        helado.setNumber(0);
    }

    @Test
    public void testSetOwner() throws Exception {
        helado.setOwner("owner");
    }

    @Test
    public void testEquals() throws Exception {
        boolean result = helado.equals("o");
        Assert.assertEquals(false, result);
    }

    @Test
    public void testCanEqual() throws Exception {
        boolean result = helado.canEqual("other");
        Assert.assertEquals(false, result);
    }

    @Test
    public void testHashCode() throws Exception {
        int result = helado.hashCode();
        Assert.assertEquals(-2075042785, result);
    }

    @Test
    public void testToString() throws Exception {
        String result = helado.toString();
        Assert.assertEquals("Helado(heladoID=0, name=name, price=0, number=0, owner=owner)", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme