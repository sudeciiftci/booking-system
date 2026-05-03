public class HallService {

    HallDB hallDB = new HallDB();

    public boolean validateHall(String hallName, int hallCap) {

        if (hallName == null || hallName.trim().isEmpty()) {
            System.out.println("Hall name cannot be empty!");
            return false;
        }

        if (hallCap <= 0) {
            System.out.println("Capacity must be greater than 0!");
            return false;
        }

        return true;
    }

    public boolean addHall(String hallName, int hallCap) {

        if (!validateHall(hallName, hallCap)) {
            return false;
        }
        Hall hall = new Hall(hallName, hallCap);
        return hallDB.addHall(hall);
    }

    public boolean updateHall(String searchName, String newName, int newCapacity) {
        return hallDB.updateHall(searchName, newName, newCapacity);
    }

    public Hall getHallByName(String name) {
        return hallDB.getHallByName(name);
    }
}