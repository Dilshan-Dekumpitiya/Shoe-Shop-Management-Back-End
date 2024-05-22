package lk.ijse.shoeshopmanagementbackend.service.impl;

import lk.ijse.shoeshopmanagementbackend.conversion.ConversionData;
import lk.ijse.shoeshopmanagementbackend.dto.ItemDTO;
import lk.ijse.shoeshopmanagementbackend.entity.GenderEntity;
import lk.ijse.shoeshopmanagementbackend.entity.ItemEntity;
import lk.ijse.shoeshopmanagementbackend.entity.OccasionEntity;
import lk.ijse.shoeshopmanagementbackend.entity.VarietyEntity;
import lk.ijse.shoeshopmanagementbackend.exception.NotFoundException;
import lk.ijse.shoeshopmanagementbackend.repository.GenderServiceDAO;
import lk.ijse.shoeshopmanagementbackend.repository.ItemServiceDAO;
import lk.ijse.shoeshopmanagementbackend.repository.OccasionServiceDAO;
import lk.ijse.shoeshopmanagementbackend.repository.VarietyServiceDAO;
import lk.ijse.shoeshopmanagementbackend.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    private final ItemServiceDAO itemServiceDao;
    private final ConversionData conversionData;
    private final GenderServiceDAO genderServiceDao;
    private final OccasionServiceDAO occasionServiceDao;
    private final VarietyServiceDAO varietyServiceDao;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity itemEntity = conversionData.toItemEntity(itemDTO);
        itemEntity.setItemCode(generateItemCode(itemDTO));
        Optional<GenderEntity> genderEntity = genderServiceDao.findById(itemDTO.getGenderCode());
        if (genderEntity.isPresent()){
            GenderEntity genderEntity1 = genderEntity.get();
            itemEntity.setGenderEntity(genderEntity1);
        };
        Optional<OccasionEntity> occasionEntity = occasionServiceDao.findById(itemDTO.getOccasionCode());
        if (occasionEntity.isPresent()){
            OccasionEntity occasionEntity1 = occasionEntity.get();
            itemEntity.setOccasionEntity(occasionEntity1);
        }
        Optional<VarietyEntity> varietyEntity = varietyServiceDao.findById(itemDTO.getVarietyCode());
        if (varietyEntity.isPresent()){
            VarietyEntity varietyEntity1 = varietyEntity.get();
            itemEntity.setVarietyEntity(varietyEntity1);
        }
        itemServiceDao.save(itemEntity);
    }

    @Override
    public ItemDTO getItem(String id) {
        if(!itemServiceDao.existsById(id)){throw new NotFoundException("Item not found.");}
        return conversionData.toItemDTO(itemServiceDao.findById(id));
    }

    @Override
    public void deleteItem(String id) {
        if(!itemServiceDao.existsById(id)){throw new NotFoundException("Item not found.");}
        itemServiceDao.deleteById(id);
    }

    @Override
    public void updateItem(String id, String itemDesc, String pic) {
        if(!itemServiceDao.existsById(id)){throw new NotFoundException("Item not found.");}
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemCode(id);
        itemEntity.setItemDesc(itemDesc);
        itemEntity.setPic(pic);
        itemServiceDao.save(itemEntity);
    }

    private String generateItemCode(ItemDTO itemDTO) {

        StringBuilder prefixBuilder = new StringBuilder();

        if (!itemDTO.getVarietyCode().equals("-1")) {
            prefixBuilder.append(itemDTO.getVarietyCode());
        }
        if (!itemDTO.getOccasionCode().equals("-1")) {
            prefixBuilder.append(itemDTO.getOccasionCode());
        }
        if (!itemDTO.getGenderCode().equals("-1")) {
            prefixBuilder.append(itemDTO.getGenderCode());
        }

        String prefix = prefixBuilder.toString();

        String lastItemCodeStartingWithPrefix =
                itemServiceDao.findLastItemCodeStartingWithPrefix(
                        prefix
                );

        return (lastItemCodeStartingWithPrefix != null)
                ? String.format("%s%05d", prefix, Integer.parseInt(lastItemCodeStartingWithPrefix.replace(prefix, "")) + 1)
                : prefix + "00001";
    }
}
