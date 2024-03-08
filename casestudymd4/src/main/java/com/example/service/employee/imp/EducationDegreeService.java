package com.example.service.employee.imp;

import com.example.model.employee.EducationDegree;
import com.example.repository.employee.EducationDegreeRepository;
import com.example.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> showList() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Page<EducationDegree> showList(Pageable pageable) {
        return educationDegreeRepository.findAll(pageable);
    }

    @Override
    public boolean delete(Long id) {
        if (educationDegreeRepository.existsById(id)) {
            educationDegreeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public Optional<EducationDegree> findById(Long id) {
        return educationDegreeRepository.findById(id);
    }
}
