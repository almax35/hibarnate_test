package org.example.service;

import org.example.dao.OwnerDao;
import org.example.models.Owner;

import java.io.IOException;
import java.sql.SQLException;

public class OwnerService {
    public OwnerService() {
    }
    public void addOwner() throws SQLException {
        OwnerDao.addOwner();
    }
    public void deleteOwner(int ownerId) throws SQLException{
        OwnerDao.deleteOwner();
    }
    public void updateOwner(Owner owner){
        OwnerDao.updateOwner(owner);
    }
    public void printOwners(){
        OwnerDao.printOwner();
    }
}
