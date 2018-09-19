package com.example.lta.demo;

import com.example.lta.demo.domain.Address;
import com.example.lta.demo.domain.Solicitor;
import com.example.lta.demo.repository.AddressRepository;
import com.example.lta.demo.repository.SolicitorRepository;
import com.example.lta.demo.service.SolicitorDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author Fred Assi
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class SolicitorControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;
    private Address address;
    private Solicitor solicitor;
    private SolicitorDto solicitorDto;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    private SolicitorRepository solicitorRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup(){
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        address = new Address();
        address.setId(1L);
        address.setLine1("fred");
        address.setLine2("assi");
        addressRepository.save(address);

        solicitor = new Solicitor();
        solicitor.setId(1L);
        solicitor.setFlag(true);
        solicitor.setName("solicitor");
        solicitor.setAddress(address);
        solicitorRepository.save(solicitor);

        solicitorDto = new SolicitorDto.Builder()
                .line1(address.getLine1())
                .line2(address.getLine2())
                .name(solicitor.getName())
                .build();
    }

    @Test
    public void readSingleBookmark() throws Exception {
        mockMvc.perform(get("/api/solicitors/"
                + this.solicitor.getName()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.name", is(this.solicitor.getName())));
    }
}