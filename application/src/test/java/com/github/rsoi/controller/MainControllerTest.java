package com.github.rsoi.controller;

import com.github.rsoi.domain.Phone;
import com.github.rsoi.service.PhoneService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.*;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {
    @Mock
    private Model model;
    @Mock
    private PhoneService phoneService;
    @InjectMocks
    private MainController controller;
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception
    {
        this.mockMvc.perform(get("/"))
                .andDo(print()).andExpect(status().isOk()).
                andExpect(content().string(containsString("Hello, RSOI!")));
    }

    @Test
    public void testGreeting() {
        String viewName = controller.greeting();

        assertEquals("main", viewName);
    }
    @Test
    public void testRequest() {
        String viewName = controller.request();

        assertEquals("request", viewName);
    }

    @Test
    public void testPhoneAdd() {
        // Arrange
        String name = "Test Phone";
        int ram = 8;
        double size = 6.2;
        String sdCard = "да";
        int minPrice = 500;
        int maxPrice = 700;
        String pictureURL = "https://test.com/phone.jpg";

        // Act
        String viewName = controller.phoneAdd(name, ram, size, sdCard, minPrice, maxPrice, pictureURL);

        // Assert
        verify(phoneService).savePhone(new Phone(name, ram, size, true, 500, 700, pictureURL));
        assertEquals("redirect:/phones", viewName);
    }

    @Test
    public void testPhoneUpdate() {
        // Arrange
        long id = 1L;
        String name = "Test Phone";
        int ram = 8;
        double size = 6.2;
        String sdCard = "да";
        int minPrice = 500;
        int maxPrice = 700;
        String pictureURL = "https://test.com/phone.jpg";

        Phone phone = new Phone(name, ram, size, true, minPrice, maxPrice, pictureURL);
        phone.setId(id);

        when(phoneService.findById(id)).thenReturn(phone);

        // Act
        String viewName = controller.phoneUpdate(id, name, ram, size, sdCard, minPrice, maxPrice, pictureURL);

        // Assert
        verify(phoneService).findById(id);
        verify(phoneService).savePhone(phone);
        assertEquals("redirect:/phones", viewName);
    }


    @Test
    public void testPhoneSearch() {
        Phone phone1 = new Phone("Samsung Galaxy S5", 2, 5.0, true, 100, 200);
        Phone phone2 = new Phone("Huawei P20", 3, 6.0, false, 250, 350);
        List<Phone> phones = new ArrayList<>(Arrays.asList(phone1, phone2));

        when(phoneService.findAndCompareByParams(2, 5.0, true, 100, 200)).thenReturn(phones);

        String expected = "request";
        String result = controller.phoneSearch(2, 5.0, "да", 100, 200, model);

        assertEquals(expected, result);
        verify(model).addAttribute("phones", phones);
        verify(model).addAttribute("result", "Найдено");
    }
    @Test
    public void testPhoneSearchEmptyList() {
        List<Phone> phones = new ArrayList<>();

        when(phoneService.findAndCompareByParams(4, 6.4, false, 150, 200)).thenReturn(phones);

        String expected = "request";
        String result = controller.phoneSearch(4, 6.4, "нет", 150, 200, model);

        assertEquals(expected, result);
        verify(model).addAttribute("phones", phones);
        verify(model).addAttribute("result", "Ничего не найдено");
    }

}
