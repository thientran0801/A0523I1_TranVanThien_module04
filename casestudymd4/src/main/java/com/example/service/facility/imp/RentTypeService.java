package com.example.service.facility.imp;

import com.example.model.facility.RentType;
import com.example.repository.facility.RentTypeRepository;
import com.example.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> showList() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Page<RentType> showList(Pageable pageable) {
        return rentTypeRepository.findAll(pageable);
    }

    @Override
    public boolean delete(Long id) {
        if (rentTypeRepository.existsById(id)) {
            rentTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public Optional<RentType> findById(Long id) {
        return rentTypeRepository.findById(id);
    }
}
