package ua.com.computerconsructor.dao;


import ua.com.computerconsructor.model.ComputerParts;

import java.util.List;

public interface ComputerPartsDao {
    public void addPart(ComputerParts part);

    public void deletePart(Integer partId);

    public ComputerParts updatePart(ComputerParts part);

    public ComputerParts getPart(int partId);

    public List<ComputerParts> getAllParts();

}
