package com.example.service.facility.imp;

import com.example.model.facility.Facility;
import com.example.repository.facility.FacilityRepository;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public List<Facility> showList() {
        return facilityRepository.findAll();
    }

    @Override
    public Page<Facility> showList(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public boolean delete(Long id) {
        if (facilityRepository.existsById(id)) {
            facilityRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findById(Long id) {
        return facilityRepository.findById(id);
    }
}
