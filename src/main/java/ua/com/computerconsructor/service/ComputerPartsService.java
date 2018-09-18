package ua.com.computerconsructor.service;

import ua.com.computerconsructor.model.ComputerParts;

import java.util.List;

public interface ComputerPartsService {
    ComputerParts addPart(ComputerParts part);

    void deleteById(Integer id);

    ComputerParts getByName(String name);

    ComputerParts editPart(ComputerParts part);

    List<ComputerParts> getAll();

}
