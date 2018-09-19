package com.example.lta.demo;

import com.example.lta.demo.domain.Address;
import com.example.lta.demo.domain.Solicitor;
import com.example.lta.demo.repository.AddressRepository;
import com.example.lta.demo.repository.SolicitorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SpringBootJPAIntegrationTest {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    SolicitorRepository solicitorRepository;

    @Test
    public void givenUserRepository_whenSaveAndRetreiveEntity_thenOK() {

        Address address = new Address();
        address.setId(1L);
        address.setLine1("fred");
        address.setLine2("assi");
        addressRepository.save(address);

        Solicitor solicitor = new Solicitor();
        solicitor.setId(1L);
        solicitor.setFlag(true);
        solicitor.setName("solicitor");
        solicitor.setAddress(address);
        solicitorRepository.save(solicitor);

        Optional<Solicitor> sol = solicitorRepository.findByName("solicitor");
        assertTrue(sol.isPresent());
        assertTrue(sol.get().getName().equals(solicitor.getName()));

    }



}