/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package EJB;

import Entity.Amenity;
import Entity.Amenityincluded;
import Entity.Booking;
import Entity.City;
import Entity.Compliances;
import Entity.Compliencesincluded;
import Entity.Construction;
import Entity.Location;
import Entity.Participate;
import Entity.Person;
import Entity.Producttype;
import Entity.Producttypeincluded;
import Entity.Provideservice;
import Entity.Role;
import Entity.Service;
import Entity.Serviceincluded;
import Entity.Warehouse;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import javax.ejb.Local;

/**
 *
 * @author DELL
 */
@Local
public interface WarehouseBookEJBLocal {
    
    //Role CRUD 
    public void addRole(String roleName);
    public void updateRole(int roleID,String roleName);
    public void removeRole(int roleID);
    public Collection<Role> getAllRoles();
    
    //Person CRUD 
    public void addPerson(String firstname,String lastname,String email,String phone);
    public void updatePerson(int id,String firstname,String lastname,String email,String phone);
    public void removePerson(int id);
    public Person getLastPerson();
    public Collection<Person> getPersonData();
    
    //Participate CRUD
    public void addParticipant(int PersonId,int RoleId,String Password,String username);
    public void updateParticipant(int ParticipationId,int PersonId,int RoleId,String Password,String username);
    public void removeParticipant(int ParticipationId,int PersonId,int RoleId);
    public Collection<Participate> getAllParticipant();
    public Collection<Participate> showParticipantData(int PersonId);
    public Collection<Participate> showParticipantByRole(int RoleId);
    public Participate getLastAddedParticipant();
    public String checkLogin(Participate user);
    
    //Location CRUD
    public void addLocation(String name,int cityid);
    public void updateLocation(int id,String name,int cityid);
    public void deleteLocation(int id,int cityid);
    public Collection<Location> showAllLocations();
    public Collection<Location> showLocationsByCity(int cityid);
    
    //Warehouse CRUD
    public void addWarehouse(int constructionid,double area,int locationid);
    public void updateWarehouse(int wid,int constructionid,double area,int locationid);
    public void removeWarehouse(int wid,int constructionid,int locationid);
    public Collection<Warehouse> getAllWarehouse();
    public Collection<Warehouse> getWarehouseByCountructionType(int constructionId);
    public Warehouse getLastAddedWarehouse();
    
    //AmenityIncluded 
    public void addAmenityIncluded(int amenityId,int warehouseId);
    public Collection<Amenityincluded> getAmenitiesOfWarehouse(int warehouseId); 
    
    //CompliencesIncluded
    public void addCompliencesIncluded(int compliencesId,int warehouseId);
    public Collection<Compliencesincluded> getCompliencesOfWarehouse(int warehouseId);
    
    //ProductTypeIncluded
    public void addProductTypeIncluded(int ProductTypeId,int warehouseId);
    public Collection<Producttypeincluded> getProductTypeOfWarehouse(int warehouseId);
    
    //City Dropdown
    public Collection<City> getAllCities();
    public Location getLastLocation();
    
    //Contruction Type
    public Collection<Construction> getAllConstructionType();
    
    //Amenity
    public Collection<Amenity> getAllAmenities();
    
    //Product Type
    public Collection<Producttype> getAllProductType();
    
    //Compliances
    public Collection<Compliances> getAllCompliances();
    
    //Login
    public int checkUserReturnRole(String username, String password);
    
    //Service CRUD
    public void addService(String serviceName, String picture, Double price);
    public void updateService(int id,String serviceName, String picture, Double price);
    public void removeService(int id);
    public Service getLastAddedService();
    public Collection<Service> getServiceData();
    
    //Provided service CRUD
    public void addProvidedService(int serviceId,int userId,String isActive);
    public void editProvidedService(int id,int serviceId,int userId,String isActive);
    public void removeProvidedService(int id,int serviceId,int userId);
    public Collection<Provideservice> getAllProvidedService();
    public Collection<Provideservice> getProvidedServiceById(int id);
    public Collection<Provideservice> getProvidedServiceByService(int serviceId);
    public Collection<Provideservice> getProvidedServiceByUser(int userId);
    public Collection<Provideservice> getProvidedServiceByStatus(String isActive);
    public Provideservice getLastAddedProvidedService();
    public Collection<Provideservice> getActiveWarehouseOwner();
   
    //Booking table CRUD
    public void addWarehouseBookig(Date startDate,Date endDate,int warehouseId,int userId);
    public void updateWarehouseBooking(int bookingId,Date startDate,Date endDate,int warehouseId,int userId);
    public void removeWarehouseBooking(int bookingId,int warehouseId,int userId);
    public Collection<Booking> getAllBookedWarehouse();
    public Collection<Booking> getBookingByWarehouse(int warehouseId);
    public Collection<Booking> getBookingByStartDate(Date startDate);
    public Collection<Booking> getBookingByEndDate(Date endDate);
    public Collection<Booking> getBookingByUser(int userId);
    public Collection<Booking> getBookingById(int bookingId);
    
    //Service Included Table
    public void addServiceIncluded(int warehouseId,int provideServiceId,double price,int currentStatusId);
    public void updateServiceIncluded(int serviceIncludedId,int warehouseId,int provideServiceId,double price,int currentStatusId);
    public void deleteServiceIncluded(int serviceIncludedId,int warehouseId,int provideServiceId,int currentStatusId);
    public Collection<Serviceincluded> getAllServiceIncluded();
    public Collection<Serviceincluded> getIncludedServicesByWarehouseId(int warehouseId);
    public Collection<Serviceincluded> getIncludedServicesByProvidedserviceId(int providedServiceId);
    public Collection<Serviceincluded> getIncludedServicesByStatus(int currentStatusId);
    public Collection<Serviceincluded> getActiveWarehouseService();
    public Collection<Serviceincluded> getServiceIncludedById(int serviceIncludedId);
}
