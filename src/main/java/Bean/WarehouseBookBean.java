/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Bean;

import Client.WarehouseClient;
import EJB.WarehouseBookEJBLocal;
import Entity.Amenity;
import Entity.Amenityincluded;
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
import Entity.Service;
import Entity.Serviceincluded;
import Entity.Warehouse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author DELL
 */
@Named(value = "warehouseBookBean")
@ApplicationScoped
public class WarehouseBookBean {

    WarehouseClient client;
    @EJB
    WarehouseBookEJBLocal ejb;

    Response res;

    //Person table
    Person currentPerson;
    int personId;
    String firstname;
    String lastname;
    String email;
    String phone;

    //Participate table
    Participate currentUser;
    int participateId;
    int uPersonId;
    int uRoleId;
    String username;
    String password;
    Collection<Participate> getAllUsers;
    Participate selectedUser;

    //ROle table
    int roleId;
    String roleName;

    //Warehouse table
    int selectedCity;
    int selectedConstructionType;
    String area;
    String locality;
    int getrole;
    String userSelection;
    private String[] selectedAmenities;
    private String[] selectedCompliances;
    private String[] selectedProductType;
    Collection<City> allCities;
    Collection<Construction> allConstructioType;
    Collection<Amenity> allAmenities;
    Collection<Producttype> allProductType;
    Collection<Compliances> allCompliances;
    Location location;
    Warehouse warehouse;
    Collection<Amenityincluded> amenitiesOfWarehouse;
    Collection<Producttypeincluded> productTypesOfWarehouse;
    Collection<Compliencesincluded> compliancesOfWarehouse;

    //Service table
    int serviceId;
    UploadedFile file;
    Double price;
    String serviceName;
    String imgName;

    //ProvideService table
    int provideServiceId;
    int pServiceId;
    int pUserId;
    String serviceStatus;
    Provideservice provideservice;
    Collection<Provideservice> allProvidedServices;
    Collection<Provideservice> activeWarehouseService;
    Collection<Provideservice> warehouseDataById;
    
    //Included service
    Collection<Serviceincluded> allIncludedServices;
    Collection<Serviceincluded> activeWarehouseIncludedService;
    Collection<Serviceincluded> IncludedServiceById;
    Serviceincluded serviceincluded;
    
    
    //Booking Table 
    int bookingId;
    private List<Date> range;
    Date startDate;
    Date endDate;
    int bWarehouseId;
    int bUserId;
    
//===================================================================================================================================================    

    public WarehouseBookBean() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getParticipateId() {
        return participateId;
    }

    public void setParticipateId(int participateId) {
        this.participateId = participateId;
    }

    public int getuPersonId() {
        return uPersonId;
    }

    public void setuPersonId(int uPersonId) {
        this.uPersonId = uPersonId;
    }

    public int getuRoleId() {
        return uRoleId;
    }

    public void setuRoleId(int uRoleId) {
        this.uRoleId = uRoleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
    }

    public Participate getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Participate currentUser) {
        this.currentUser = currentUser;
    }

    public int getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(int selectedCity) {
        this.selectedCity = selectedCity;
    }

    public int getSelectedConstructionType() {
        return selectedConstructionType;
    }

    public void setSelectedConstructionType(int selectedConstructionType) {
        this.selectedConstructionType = selectedConstructionType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getGetrole() {
        return getrole;
    }

    public void setGetrole(int getrole) {
        this.getrole = getrole;
    }

    public String getUserSelection() {
        return userSelection;
    }

    public void setUserSelection(String userSelection) {
        this.userSelection = userSelection;
    }

    public String[] getSelectedAmenities() {
        return selectedAmenities;
    }

    public void setSelectedAmenities(String[] selectedAmenities) {
        this.selectedAmenities = selectedAmenities;
    }

    public String[] getSelectedCompliances() {
        return selectedCompliances;
    }

    public void setSelectedCompliances(String[] selectedCompliances) {
        this.selectedCompliances = selectedCompliances;
    }

    public String[] getSelectedProductType() {
        return selectedProductType;
    }

    public void setSelectedProductType(String[] selectedProductType) {
        this.selectedProductType = selectedProductType;
    }

    public Collection<City> getAllCities() {
        allCities = ejb.getAllCities();
        return allCities;
    }

    public void setAllCities(Collection<City> allCities) {
        this.allCities = allCities;
    }

    public Collection<Construction> getAllConstructioType() {
        allConstructioType = ejb.getAllConstructionType();
        return allConstructioType;
    }

    public void setAllConstructioType(Collection<Construction> allConstructioType) {
        this.allConstructioType = allConstructioType;
    }

    public Collection<Amenity> getAllAmenities() {
        allAmenities = ejb.getAllAmenities();
        return allAmenities;
    }

    public void setAllAmenities(Collection<Amenity> allAmenities) {
        this.allAmenities = allAmenities;
    }

    public Collection<Producttype> getAllProductType() {
        allProductType = ejb.getAllProductType();
        return allProductType;
    }

    public void setAllProductType(Collection<Producttype> allProductType) {
        this.allProductType = allProductType;
    }

    public Collection<Compliances> getAllCompliances() {
        allCompliances = ejb.getAllCompliances();
        return allCompliances;
    }

    public void setAllCompliances(Collection<Compliances> allCompliances) {
        this.allCompliances = allCompliances;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public int getProvideServiceId() {
        return provideServiceId;
    }

    public void setProvideServiceId(int provideServiceId) {
        this.provideServiceId = provideServiceId;
    }

    public int getpServiceId() {
        return pServiceId;
    }

    public void setpServiceId(int pServiceId) {
        this.pServiceId = pServiceId;
    }

    public int getpUserId() {
        return pUserId;
    }

    public void setpUserId(int pUserId) {
        this.pUserId = pUserId;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Collection<Participate> getGetAllUsers() {
        getAllUsers = ejb.getAllParticipant();
        return getAllUsers;
    }

    public void setGetAllUsers(Collection<Participate> getAllUsers) {
        this.getAllUsers = getAllUsers;
    }

    public Collection<Provideservice> getAllProvidedServices() {
        allProvidedServices = ejb.getAllProvidedService();
        return allProvidedServices;
    }

    public void setAllProvidedServices(Collection<Provideservice> allProvidedServices) {
        this.allProvidedServices = allProvidedServices;
    }

    public Collection<Provideservice> getActiveWarehouseService() {
        activeWarehouseService = ejb.getActiveWarehouseOwner();
        return activeWarehouseService;
    }

    public void setActiveWarehouseService(Collection<Provideservice> activeWarehouseService) {
        this.activeWarehouseService = activeWarehouseService;
    }

    public Collection<Provideservice> getWarehouseDataById() {
        warehouseDataById = ejb.getProvidedServiceById(provideservice.getProvideServiceId());
        return warehouseDataById;
    }

    public void setWarehouseDataById(Collection<Provideservice> warehouseDataById) {
        this.warehouseDataById = warehouseDataById;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public List<Date> getRange() {
        return range;
    }

    public void setRange(List<Date> range) {
        this.range = range;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getbWarehouseId() {
        return bWarehouseId;
    }

    public void setbWarehouseId(int bWarehouseId) {
        this.bWarehouseId = bWarehouseId;
    }

    public int getbUserId() {
        return bUserId;
    }

    public void setbUserId(int bUserId) {
        this.bUserId = bUserId;
    }

    public Collection<Serviceincluded> getAllIncludedServices() {
        allIncludedServices = ejb.getAllServiceIncluded();
        return allIncludedServices;
    }

    public void setAllIncludedServices(Collection<Serviceincluded> allIncludedServices) {
        this.allIncludedServices = allIncludedServices;
    }

    public Collection<Serviceincluded> getActiveWarehouseIncludedService() {
        activeWarehouseIncludedService = ejb.getActiveWarehouseService();
        return activeWarehouseIncludedService;
    }

    public void setActiveWarehouseIncludedService(Collection<Serviceincluded> activeWarehouseIncludedService) {
        this.activeWarehouseIncludedService = activeWarehouseIncludedService;
    }

    public Collection<Serviceincluded> getIncludedServiceById() {
        IncludedServiceById = ejb.getServiceIncludedById(this.serviceincluded.getServiceIncludedId());
        return IncludedServiceById;
    }

    public void setIncludedServiceById(Collection<Serviceincluded> IncludedServiceById) {
        this.IncludedServiceById = IncludedServiceById;
    }

    public Participate getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Participate selectedUser) {
        this.selectedUser = selectedUser;
    }

    public Serviceincluded getServiceincluded() {
        return serviceincluded;
    }

    public void setServiceincluded(Serviceincluded serviceincluded) {
        this.serviceincluded = serviceincluded;
    }

    public Collection<Amenityincluded> getAmenitiesOfWarehouse() {
        return amenitiesOfWarehouse;
    }

    public void setAmenitiesOfWarehouse(Collection<Amenityincluded> amenitiesOfWarehouse) {
        this.amenitiesOfWarehouse = amenitiesOfWarehouse;
    }

    public Collection<Producttypeincluded> getProductTypesOfWarehouse() {
        return productTypesOfWarehouse;
    }

    public void setProductTypesOfWarehouse(Collection<Producttypeincluded> productTypesOfWarehouse) {
        this.productTypesOfWarehouse = productTypesOfWarehouse;
    }

    public Collection<Compliencesincluded> getCompliancesOfWarehouse() {
        return compliancesOfWarehouse;
    }

    public void setCompliancesOfWarehouse(Collection<Compliencesincluded> compliancesOfWarehouse) {
        this.compliancesOfWarehouse = compliancesOfWarehouse;
    }
    
    
    
    

//===================================================================================================================================================

    public void userReg() {
        System.out.println(firstname + " " + lastname + " " + email + " " + phone);
//        client.addPerson(firstname, lastname, email, phone);
        ejb.addPerson(firstname, lastname, email, phone);

        System.out.println("Person added");
//        res = client.getLastPerson(Response.class);
//        currentPerson = res.readEntity(Person.class);
        currentPerson = ejb.getLastPerson();
        uPersonId = currentPerson.getPersonId();
        System.out.println(uPersonId);
        System.out.println(password);
//        client.addParticipant(String.valueOf(uPersonId), String.valueOf(uRoleId), password, email);
        ejb.addParticipant(uPersonId, roleId, password, email);
    }

    public String goToRegistration() {
        return "userRegistration.jsf?faces-redirect=true";
    }

    public String doUserRegistration() {
        this.roleId = 2;
        userReg();
        return "login.jsf?faces-redirect=true";
    }

    public String goToUserHome() {
        return "showAllUsers.jsf?faces-redirect=true";
    }

    public String goToIndex() {
        return "../index.jsf?faces-redirect=true";
    }

    public String goToOwnerRegistration() {
        return "ownerRegistration.jsf";
    }

    public String doOwnerRegistration() throws FileNotFoundException, IOException {
        this.roleId = 3;
        this.serviceName = "Warehouse Owner";
        userReg();
        System.out.println("Owner registered");
        System.out.println(locality);
        System.out.println(selectedCity);
        addWarehouse();
        System.out.println("warehouse added");
        addService();
        System.out.println("service added");
        return "../login.jsf";
    }

    public void addWarehouse() {
//        client.addLocation(locality, String.valueOf(selectedCity));
        System.out.println(locality);
        System.out.println(selectedCity);
        ejb.addLocation(locality, selectedCity);
        this.location = ejb.getLastLocation();
        System.out.println(selectedConstructionType + " " + area);
        ejb.addWarehouse(selectedConstructionType, Double.parseDouble(area), location.getLocationId());
//        client.addWarehouse(String.valueOf(selectedConstructionType), area,location.getLocationId().toString());
        this.warehouse = ejb.getLastAddedWarehouse();

        System.out.println("Warehouse added");
        System.out.println(warehouse.getWarehouseId());

        for (int i = 0; i < selectedAmenities.length; i++) {
//            client.addAmenityIncluded(selectedAmenities[i], warehouse.getWarehouseId().toString());
            ejb.addAmenityIncluded(Integer.parseInt(selectedAmenities[i]), warehouse.getWarehouseId());
        }

        for (int k = 0; k < selectedCompliances.length; k++) {
//            client.addCompliencesIncluded(selectedCompliances[k], warehouse.getWarehouseId().toString());
            ejb.addCompliencesIncluded(Integer.parseInt(selectedCompliances[k]), warehouse.getWarehouseId());
        }

        for (int j = 0; j < selectedProductType.length; j++) {
//            client.addProductTypeIncluded(selectedProductType[j], warehouse.getWarehouseId().toString());
            ejb.addProductTypeIncluded(Integer.parseInt(selectedProductType[j]), warehouse.getWarehouseId());
        }
        System.out.println("Added");
    }

    public void addService() throws FileNotFoundException, IOException {
        this.imgName = this.file.getFileName();

        String uploadPath = "F:/Java Project/WarehouseBookingApp/src/main/webapp/serviceImage/" + imgName;
        System.out.println(uploadPath);

        FileOutputStream fos = new FileOutputStream(uploadPath);
        InputStream is = file.getInputStream();

        byte[] data = new byte[is.available()];
        is.read(data);
        fos.write(data);
        fos.close();

        System.out.println(imgName);
//        client.addService( serviceName, imgName, String.valueOf(price));
        ejb.addService(serviceName, imgName, price);

        System.out.println("In service() service added");

        try {
            Service service = ejb.getLastAddedService();
            System.out.println(service.getServiceId());
            this.pServiceId = service.getServiceId();

            Participate newuser = ejb.getLastAddedParticipant();
            System.out.println(newuser.getParticipateId());
            this.pUserId = newuser.getParticipateId();
            this.serviceStatus = "Inactive";
            
            Thread.sleep(100);
        } catch (Exception e) {
            System.err.println("Error occur");
        }
        //[0 = Not approved ; 1 = active ; 2 = inavtive]
        
//        client.addProvidedService(String.valueOf(pServiceId), String.valueOf(pUserId), "Inactive");
        ejb.addProvidedService(serviceId, pUserId, serviceStatus);
        System.out.println("Provided service added");
        provideservice = ejb.getLastAddedProvidedService();
        ejb.addServiceIncluded(ejb.getLastAddedWarehouse().getWarehouseId(), provideservice.getProvideServiceId(), provideservice.getServiceId().getServicePrice(),2);
        System.out.println("Service included");
    }

    public String doServicerRegistration() throws FileNotFoundException, IOException {
        this.roleId = 3;
        userReg();
        addService();
        return "../login.jsf";
    }

    public String goToDisplayUser() {
        return "showAllUsers.jsf";
    }

    public String removeUser(Participate p) {
        ejb.removeParticipant(p.getParticipateId(), p.getPersonId().getPersonId(), p.getRoleId().getRoleId());
        ejb.removePerson(p.getPersonId().getPersonId());
        return "shoAllUsers.jsf";
    }

    public String setUserData(Participate p) {
        this.participateId = p.getParticipateId();
        this.roleId = p.getRoleId().getRoleId();
        this.personId = p.getPersonId().getPersonId();
        this.email = p.getPersonId().getEmail();
        this.firstname = p.getPersonId().getFirstName();
        this.lastname = p.getPersonId().getLastName();
        this.phone = p.getPersonId().getPhone();
        this.password = p.getPassword();
        return "updateUser.jsf";
    }

    public String doUserUpdate() {
        ejb.updateParticipant(participateId, personId, roleId, password, email);
        ejb.updatePerson(personId, firstname, lastname, email, phone);
        return "showAllUsers.jsf";
    }
    
    public String goToLogin()
    {
        return "login.jsf";
    }
    
    public String doRemoveProvidedService(Provideservice ps)
    {
        ejb.removeProvidedService(ps.getProvideServiceId(), ps.getServiceId().getServiceId(), ps.getServicerId().getParticipateId());
        return "showAllProvidedServices.jsf";
    }
    
    public String doEditProvidedService(Provideservice ps)
    {
        if(ps.getIsActive().equals("Inactive"))
        {
            this.serviceStatus = "Active";
        }
        else
            this.serviceStatus = "Inactive";
        ejb.editProvidedService(ps.getProvideServiceId(), ps.getServiceId().getServiceId(), ps.getServicerId().getParticipateId(),serviceStatus );
        return "showAllProvidedServices.jsf";
    }
    
    public String goToShowWarehouse(Provideservice ps)
    {
        this.provideservice = ps;
        return "showWarehouseById.jsf";
    }
    
    public String goToBookWarehouse(Serviceincluded si)
    {
        this.serviceincluded = si;
        return "bookWarehouse.jsf";
    }

    public String doBookWarehouse()
    {
        System.out.println(range);
        System.out.println(range.get(0));
        System.out.println(range.get(1));
        this.startDate = range.get(0);
        this.endDate = range.get(1);
        ejb.addWarehouseBookig(startDate, endDate, serviceincluded.getWarehouseId().getWarehouseId(), serviceincluded.getProvideServiceId().getServicerId().getParticipateId());
        return "invoiceOfUser.jsf";
    }
    
    public String doEditIncludedService(Serviceincluded si)
    {
        if(si.getCurrentStatusId().getStatusId().equals(2))
        {
            this.serviceId = 1;
        }
        else
            this.serviceId = 2;
        
        ejb.updateServiceIncluded(si.getServiceIncludedId(), si.getWarehouseId().getWarehouseId(), si.getProvideServiceId().getProvideServiceId(), si.getPrice(),this.serviceId);
        
        return "showAllIncludedServices.jsf";
    }
    
    public String goToShowIncludedService(Serviceincluded si)
    {
        this.serviceincluded = si;
        amenitiesOfWarehouse = ejb.getAmenitiesOfWarehouse(si.getWarehouseId().getWarehouseId());
        compliancesOfWarehouse = ejb.getCompliencesOfWarehouse(si.getWarehouseId().getWarehouseId());
        productTypesOfWarehouse = ejb.getProductTypeOfWarehouse(si.getWarehouseId().getWarehouseId());
        return "showWarehouseById";
    }
    
    public String goTOShowActiveWarehouses()
    {
        return "showActiveWarehouseData.jsf";
    }
    
}
