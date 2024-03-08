package com.example.service.employee.imp;

import com.example.model.employee.Division;
import com.example.repository.employee.DivisionRepository;
import com.example.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public List<Division> showList() {
        return divisionRepository.findAll();
    }

    @Override
    public Page<Division> showList(Pageable pageable) {
        return divisionRepository.findAll(pageable);
    }

    @Override
    public boolean delete(Long id) {
        if (divisionRepository.existsById(id)) {
            divisionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public Optional<Division> findById(Long id) {
        return divisionRepository.findById(id);
    }
}
