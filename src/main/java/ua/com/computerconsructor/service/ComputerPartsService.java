package ua.com.computerconsructor.service;

import ua.com.computerconsructor.model.ComputerParts;

import java.util.List;

public interface ComputerPartsService {
    ComputerParts addPart(ComputerParts part);

    void deleteById(Integer id);

    ComputerParts getById(Integer id);

    ComputerParts editPart(ComputerParts part);

    List<ComputerParts> getAll();

    List<ComputerParts> listParts(String param);

    int getComputersCount();
}
