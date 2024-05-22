package lk.ijse.shoeshopmanagementbackend.service.impl;

import lk.ijse.shoeshopmanagementbackend.conversion.ConversionData;
import lk.ijse.shoeshopmanagementbackend.dto.VarietyDTO;
import lk.ijse.shoeshopmanagementbackend.exception.DuplicateException;
import lk.ijse.shoeshopmanagementbackend.exception.NotFoundException;
import lk.ijse.shoeshopmanagementbackend.repository.VarietyServiceDAO;
import lk.ijse.shoeshopmanagementbackend.service.VarietyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VarietyServiceImpl implements VarietyService {

    private final VarietyServiceDAO varietyServiceDao;
    private final ConversionData conversionData;
    @Override
    public void saveVariety(VarietyDTO varietyDTO) {
        if (varietyServiceDao.existsById(varietyDTO.getVarietyCode())) throw new DuplicateException("Variety Id Duplicate");
        varietyServiceDao.save(conversionData.toVarietyEntity(varietyDTO));
    }

    @Override
    public List<VarietyDTO> getAllVariety() {
        return conversionData.convertToVarietyDTO(varietyServiceDao.findAll());
    }

    @Override
    public void deleteVariety(String id) {
        if (!varietyServiceDao.existsById(id)) throw new NotFoundException("Variety Not Found");
        varietyServiceDao.deleteById(id);
    }

    @Override
    public void updateVariety(String id, VarietyDTO varietyDTO) {
        if (!varietyServiceDao.existsById(id)) throw new NotFoundException("Variety Not Found");
        varietyServiceDao.save(conversionData.toVarietyEntity(varietyDTO));
    }
}
