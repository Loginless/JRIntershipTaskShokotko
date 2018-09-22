package ua.com.computerconsructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.computerconsructor.dao.ComputerPartsDao;
import ua.com.computerconsructor.model.ComputerParts;

import java.util.List;

@Service("computerPartsService")
public class ComputerPartsServiceImpl implements ComputerPartsService {

    @Autowired
    ComputerPartsDao computerPartsDao;


    @Override
    public ComputerParts addPart(ComputerParts part) {

        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public ComputerParts getByName(String partName) {
        return null;
    }

    @Override
    public ComputerParts editPart(ComputerParts part) {
        return null;
    }

    @Override
    public List<ComputerParts> getAll() {
        return computerPartsDao.getAllParts();
    }

    @Override
    public List<ComputerParts> listParts(String param) {
        return this.computerPartsDao.listParts(param);
    }

    @Override
    public int getComputersCount() {
        List<ComputerParts> mandatoryPartsList = computerPartsDao.listParts("mandatory");
        int compCount = 0;
        if (!mandatoryPartsList.isEmpty()) {
            compCount = mandatoryPartsList.get(0).getQuantity();
            for (ComputerParts temp : mandatoryPartsList) {
                if (temp.getQuantity() < compCount) {
                    compCount = temp.getQuantity();
                }
            }
        }
        return compCount;
    }

}

