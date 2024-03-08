package com.example.service.facility.imp;

import com.example.model.facility.FacilityType;
import com.example.repository.facility.FacilityTypeRepository;
import com.example.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private FacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> showList() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public Page<FacilityType> showList(Pageable pageable) {
        return facilityTypeRepository.findAll(pageable);
    }

    @Override
    public boolean delete(Long id) {
        if (facilityTypeRepository.existsById(id)) {
            facilityTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void save(FacilityType facilityType) {
        facilityTypeRepository.save(facilityType);
    }

    @Override
    public Optional<FacilityType> findById(Long id) {
        return facilityTypeRepository.findById(id);
    }
}
