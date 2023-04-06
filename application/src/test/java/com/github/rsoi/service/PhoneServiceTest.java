package com.github.rsoi.service;

import com.github.rsoi.domain.Phone;
import com.github.rsoi.repository.PhonesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PhoneServiceTest {

    @Mock
    private PhonesRepository phonesRepository;

    @InjectMocks
    private PhoneService phoneService;

    @Test
    public void testFindById() {
        Phone phone = new Phone();
        phone.setId(1L);
        phone.setName("Test Phone");
        when(phonesRepository.findById(1L)).thenReturn(Optional.of(phone));

        Phone result = phoneService.findById(1L);

        assertNotNull(result);
        assertEquals(phone, result);
    }

    @Test
    public void testExistsById() {
        when(phonesRepository.existsById(1L)).thenReturn(true);

        boolean result = phoneService.existsById(1L);

        assertTrue(result);
    }

    @Test
    public void testPhoneList() {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone());
        phones.add(new Phone());
        when(phonesRepository.findAll()).thenReturn(phones);

        List<Phone> result = phoneService.phoneList();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testSavePhone() {
        Phone phone = new Phone();
        phone.setName("Test Phone");

        phoneService.savePhone(phone);

        verify(phonesRepository, times(1)).save(phone);
    }

    @Test
    public void testDeletePhoneById() {
        Long id = 1L;

        phoneService.deletePhoneById(id);

        verify(phonesRepository, times(1)).deleteById(id);
    }

    @Test
    public void testFindAndCompareByParams() {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone());
        phones.add(new Phone());
        when(phonesRepository.findPhonesByParams(100, 200)).thenReturn(phones);

        List<Phone> result = phoneService.findAndCompareByParams(4, 5.5, true, 100, 200);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(phonesRepository, times(1)).increaseCounterForCompareWhereRam(4);
        verify(phonesRepository, times(1)).increaseCounterForCompareWhereSize(5.5);
        verify(phonesRepository, times(1)).increaseCounterForCompareWhereSDCard(true);
        verify(phonesRepository, times(1)).setCounterForCompareZero();
    }
}
