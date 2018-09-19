package com.example.lta.demo.service;

import com.example.lta.demo.domain.Solicitor;
import com.example.lta.demo.exception.ResourceNotFoundException;
import com.example.lta.demo.repository.AddressRepository;
import com.example.lta.demo.repository.SolicitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitorService {

    SolicitorRepository solicitorRepository;
    AddressRepository addressRepository;

    @Autowired
    public SolicitorService(SolicitorRepository solicitorRepository,
                            AddressRepository addressRepository){
        this.solicitorRepository = solicitorRepository;
        this.addressRepository = addressRepository;
    }

        public SolicitorDto getSocilitorContactByName(String name ) {

            Solicitor solicitor = retrieveSolicitorByName(name);

            SolicitorDto solicitorDto = new SolicitorDto.Builder()
                    .name(solicitor.getName())
                    .line1(solicitor.getAddress().getLine1())
                    .line2(solicitor.getAddress().getLine2())
                    .build();

            return solicitorDto;
        }

    private Solicitor retrieveSolicitorByName(String name) {
        return solicitorRepository.findByName(name)
                        .orElseThrow(() -> new ResourceNotFoundException("solicitor", "name", name));
    }


}
