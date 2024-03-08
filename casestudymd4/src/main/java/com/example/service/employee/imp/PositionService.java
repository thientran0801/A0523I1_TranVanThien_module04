package com.example.service.employee.imp;

import com.example.model.employee.Position;
import com.example.repository.employee.PositionRepository;
import com.example.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PositionService implements IPositionService {

    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> showList() {
        return positionRepository.findAll();
    }

    @Override
    public Page<Position> showList(Pageable pageable) {
        return positionRepository.findAll(pageable);
    }

    @Override
    public boolean delete(Long id) {
        if (positionRepository.existsById(id)) {
            positionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void save(Position position) {
positionRepository.save(position);
    }

    @Override
    public Optional<Position> findById(Long id) {
        return positionRepository.findById(id);
    }
}
