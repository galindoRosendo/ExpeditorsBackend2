package ttl.PetAdoptionApplication.serivice;

import ttl.PetAdoptionApplication.Adopter;
import ttl.PetAdoptionApplication.dao.AdopterDAO;
import ttl.PetAdoptionApplication.dao.DAOFactory;

import java.util.List;

public class AdopterService {
    private AdopterDAO adopterDAO;

    public AdopterService(){
        adopterDAO = DAOFactory.adopterDAO();
    }

    public Adopter addAdopter(Adopter adopter) {

        Adopter insertedAdopter = adopterDAO.insert(adopter);

        return insertedAdopter;
    }

    public boolean deleteAdopter(int id) {
        return adopterDAO.delete(id);
    }

    public boolean updateAdopter(Adopter adopter){
        return adopterDAO.update(adopter);
    }

    public Adopter findBy(int id){
        return adopterDAO.findBy(id);
    }

    public Adopter findBy(String name){
        return adopterDAO.findBy(name);
    }

    public List<Adopter> getAllAdopters() {
        return adopterDAO.findAll();
    }

    public List<Adopter> sortByNaturalOrder() {
        return adopterDAO.sortByNaturalOrder();
    }

    public AdopterDAO getStudentDAO() {
        return adopterDAO;
    }

    public void setAdopterDAO(AdopterDAO adopterDAO){
        this.adopterDAO = adopterDAO;
    }
}
