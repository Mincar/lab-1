package com.github.rsoi.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
public class PhoneTest {
    @Test
    public void testConstructorWithNoParams() {
        Phone phone = new Phone();

       assertNotNull(phone);
    }
    @Test
    public void testConstructorWithAllParams() {
        Phone phone = new Phone(1L, "Test Phone", 4, 5.5, true, 100, 200, 0, null);

        assertEquals(1L, phone.getId().longValue());
        assertEquals("Test Phone", phone.getName());
        assertEquals(4, phone.getRAM());
        assertEquals(5.5, phone.getSize(), 0.1);
        assertTrue(phone.isSDCard());
        assertEquals(100, phone.getMinPrice());
        assertEquals(200, phone.getMaxPrice());
        assertEquals(0, phone.getCounterForCompare(), 0.1);
        assertNull(phone.getPicURL());
    }

    @Test
    public void testConstructorWithParams() {
        Phone phone = new Phone("Test Phone", 4, 5.5, true, 100, 200);

        assertEquals("Test Phone", phone.getName());
        assertEquals(4, phone.getRAM());
        assertEquals(5.5, phone.getSize(), 0.1);
        assertTrue(phone.isSDCard());
        assertEquals(100, phone.getMinPrice());
        assertEquals(200, phone.getMaxPrice());
    }

    @Test
    public void testConstructorWithPicURL() {
        Phone phone = new Phone("Test Phone", 4, 5.5, true, 100, 200, "http://test.com/image.jpg");

        assertEquals("Test Phone", phone.getName());
        assertEquals(4, phone.getRAM());
        assertEquals(5.5, phone.getSize(), 0.1);
        assertTrue(phone.isSDCard());
        assertEquals(100, phone.getMinPrice());
        assertEquals(200, phone.getMaxPrice());
        assertEquals("http://test.com/image.jpg", phone.getPicURL());
    }

    @Test
    public void testEqualsAndHashCode() {
        Phone phone1 = new Phone(1L, "Test Phone", 4, 5.5, true, 100, 200, 0, "http://test.com/image.jpg");
        Phone phone2 = new Phone(1L, "Test Phone", 4, 5.5, true, 100, 200, 0, "http://test.com/image.jpg");
        Phone phone3 = new Phone(2L, "Another Phone", 8, 6.0, false, 200, 300, 0, null);

        assertTrue(phone1.equals(phone2));
        assertTrue(phone2.equals(phone1));
        assertFalse(phone1.equals(phone3));
        assertFalse(phone3.equals(phone1));

        assertEquals(phone1.hashCode(), phone2.hashCode());
        assertNotEquals(phone1.hashCode(), phone3.hashCode());
        assertNotEquals(phone1.hashCode(), 1);
        assertNotEquals(1, phone1.hashCode());
    }

    @Test
    public void testEquals() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        Phone phone2 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");

        assertEquals(phone1, phone2);
        assertEquals(phone1.hashCode(), phone2.hashCode());

        phone2.setId(2L);
        assertNotEquals(phone1, phone2);
    }

    @Test
    public void testEqualsSameObject() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");

        assertEquals(phone1, phone1);
        assertEquals(phone1.hashCode(), phone1.hashCode());
    }

    @Test
    public void testEqualsNull() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");

        assertNotEquals(phone1, null);
    }

    @Test
    public void testEqualsDifferentClass() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");

        assertNotEquals(phone1, new Object());
    }

    @Test
    public void testEqualsDifferentId() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        Phone phone2 = new Phone(2L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");

        assertNotEquals(phone1, phone2);
    }

    @Test
    public void testEqualsDifferentName() {
        Phone phone1 = new Phone(1L, "Samsung", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        Phone phone2 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");

        assertNotEquals(phone1, phone2);
    }

    @Test
    public void testEqualsDifferentRam() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        Phone phone2 = new Phone(1L, "Samsung Galaxy", 6, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");

        assertNotEquals(phone1, phone2);
    }

    @Test
    public void testEqualsDifferentSize() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        Phone phone2 = new Phone(1L, "Samsung Galaxy", 4, 6.0, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");

        assertNotEquals(phone1, phone2);
    }

    @Test
    public void testEqualsDifferentSDCard() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        Phone phone2 = new Phone(1L, "Samsung Galaxy", 4, 5.5, false, 200, 400, 0, "https://example.com/samsung-galaxy.png");

        assertNotEquals(phone1, phone2);
    }
    @Test
    public void testEqualsDifferentMinPrice() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        Phone phone2 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 300, 400, 0, "https://example.com/samsung-galaxy.png");

        assertNotEquals(phone1, phone2);
    }
    @Test
    public void testEqualsDifferentMaxPrice() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        Phone phone2 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 500, 0, "https://example.com/samsung-galaxy.png");

        assertNotEquals(phone1, phone2);
    }
    @Test
    public void testEqualsDifferentCounterForCompare() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        Phone phone2 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 5, "https://example.com/samsung-galaxy.png");

        assertNotEquals(phone1, phone2);
    }
    @Test
    public void testEqualsDifferentPicUrl() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        Phone phone2 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, " ");

        assertNotEquals(phone1, phone2);
    }

    @Test
    public void testEqualsSameObject1() {
        Phone phone1 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        Phone phone2 = new Phone(1L, "Samsung Galaxy", 4, 5.5, true, 200, 400, 0, "https://example.com/samsung-galaxy.png");
        assertEquals(phone1, phone2);
        assertEquals(phone1.hashCode(), phone2.hashCode());
    }
    public void testEqualsSameObject2() {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        assertEquals(phone1, phone2);
        assertEquals(phone1.hashCode(), phone2.hashCode());
    }
}