/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
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
import Entity.Status;
import Entity.Warehouse;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author DELL
 */
@DeclareRoles({"Admin", "Owner","User","Servicer"})
@Stateless
    public class WarehouseBookEJB implements WarehouseBookEJBLocal {

    @PersistenceContext(unitName = "WarehouseBookPU")
    EntityManager em;

    @Inject
    Pbkdf2PasswordHash passwordHasher;

    @Override
    public void addRole(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        em.persist(role);
    }

    @Override
    public void updateRole(int roleID, String roleName) {
        Role role = (Role) em.find(Role.class, roleID);
        role.setRoleName(roleName);
        em.merge(role);
    }

    @Override
    public void removeRole(int roleID) {
        Role role = (Role) em.find(Role.class, roleID);
        em.remove(role);
    }

    @Override
    public Collection<Role> getAllRoles() {
        return em.createNamedQuery("Role.findAll").getResultList();
    }

    @Override
    public void addPerson(String firstname, String lastname, String email, String phone) {
        Person p = new Person();
        p.setFirstName(firstname);
        p.setLastName(lastname);
        p.setEmail(email);
        p.setPhone(phone);
        em.persist(p);
    }

    @Override
    public void updatePerson(int id, String firstname, String lastname, String email, String phone) {
        Person p = em.find(Person.class, id);
        p.setFirstName(firstname);
        p.setLastName(lastname);
        p.setEmail(email);
        p.setPhone(phone);
        em.merge(p);
    }

    @Override
    public void removePerson(int id) {
        Person p = em.find(Person.class, id);
        em.remove(p);
    }

    @Override
    public Person getLastPerson() {
        return (Person) em.createQuery("SELECT p FROM Person p ORDER BY p.personId DESC").setMaxResults(1).getSingleResult();
    }

    @Override
    public Collection<Person> getPersonData() {
        return em.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public void addParticipant(int PersonId, int RoleId, String Password, String username) {
        Person person = (Person) em.find(Person.class, PersonId);
        Role role = em.find(Role.class, RoleId);

        Collection<Participate> pc = person.getParticipateCollection();
        Collection<Participate> rc = role.getParticipateCollection();

        Participate p = new Participate();
        p.setPersonId(person);
        p.setRoleId(role);
        p.setPassword(passwordHasher.generate(Password.toCharArray()));
        p.setUsername(username);
        pc.add(p);
        rc.add(p);

        person.setParticipateCollection(pc);
        role.setParticipateCollection(rc);
        em.persist(p);
    }

    @Override
    public void updateParticipant(int ParticipationId, int PersonId, int RoleId, String Password, String username) {
        Person person = em.find(Person.class, PersonId);
        Role role = em.find(Role.class, RoleId);
        Participate p = em.find(Participate.class, ParticipationId);
        Collection<Participate> pc = person.getParticipateCollection();
        Collection<Participate> rc = role.getParticipateCollection();
        p.setPersonId(person);
        p.setRoleId(role);
        p.setPassword(Password);
        p.setUsername(username);
        person.setParticipateCollection(pc);
        role.setParticipateCollection(rc);
        em.merge(p);
    }

    @Override
    public void removeParticipant(int ParticipationId, int PersonId, int RoleId) {
        Person person = em.find(Person.class, PersonId);
        Role role = em.find(Role.class, RoleId);
        Participate p = em.find(Participate.class, ParticipationId);
        Collection<Participate> pc = person.getParticipateCollection();
        Collection<Participate> rc = role.getParticipateCollection();
        pc.remove(p);
        rc.remove(p);
        person.setParticipateCollection(pc);
        role.setParticipateCollection(rc);
        em.remove(p);
    }

    @Override
    public Collection<Participate> getAllParticipant() {
        return em.createNamedQuery("Participate.findAll").getResultList();
    }
    
    @Override
    public Collection<Participate> showParticipantData(int PersonId) {
        Person p = em.find(Person.class, PersonId);
        return p.getParticipateCollection();
    }

    @Override
    public Collection<Participate> showParticipantByRole(int RoleId) {
        Role r = em.find(Role.class, RoleId);
        return r.getParticipateCollection();
    }

    @Override
    public Participate getLastAddedParticipant() {
        return (Participate) em.createQuery("SELECT p FROM Participate p ORDER BY p.participateId DESC").setMaxResults(1).getSingleResult();
    }

    @Override
    public void addLocation(String name, int cityid) {
        City c = em.find(City.class, cityid);
        Collection<Location> allCities = c.getLocationCollection();

        Location l = new Location();
        l.setLocationName(name);
        l.setCityId(c);
        allCities.add(l);
        c.setLocationCollection(allCities);
        em.persist(l);
    }

    @Override
    public void updateLocation(int id, String name, int cityid) {
        City c = em.find(City.class, cityid);
        Collection<Location> cities = c.getLocationCollection();

        Location l = em.find(Location.class, id);
        l.setLocationName(name);
        l.setCityId(c);

        c.setLocationCollection(cities);
        em.merge(l);
    }

    @Override
    public void deleteLocation(int id, int cityid) {
        City c = em.find(City.class, cityid);
        Collection<Location> cities = c.getLocationCollection();

        Location l = em.find(Location.class, id);
        cities.remove(l);
        c.setLocationCollection(cities);
        em.remove(l);
    }

    
    @Override
    public Collection<Location> showAllLocations() {
        return em.createNamedQuery("Location.findAll").getResultList();
    }

    @Override
    public Collection<Location> showLocationsByCity(int cityid) {
        City c = em.find(City.class, cityid);
        return c.getLocationCollection();
    }

    @Override
    public void addWarehouse(int constructionid, double area, int locationid) {
        Construction ct = em.find(Construction.class, constructionid);
        Location l = em.find(Location.class, locationid);

        Collection<Warehouse> ctCollection = ct.getWarehouseCollection();
        Collection<Warehouse> lCollection = l.getWarehouseCollection();

        Warehouse w = new Warehouse();
        w.setArea(area);
        w.setConstructionTypeId(ct);
        w.setLocationId(l);

        ctCollection.add(w);
        lCollection.add(w);

        ct.setWarehouseCollection(ctCollection);
        l.setWarehouseCollection(lCollection);

        em.persist(w);
    }

    @Override
    public void updateWarehouse(int wid, int constructionid, double area, int locationid) {
        Construction ct = em.find(Construction.class, constructionid);
        Location l = em.find(Location.class, locationid);

        Collection<Warehouse> ctCollection = ct.getWarehouseCollection();
        Collection<Warehouse> lCollection = l.getWarehouseCollection();

        Warehouse w = em.find(Warehouse.class, wid);
        w.setArea(area);
        w.setConstructionTypeId(ct);
        w.setLocationId(l);

        ct.setWarehouseCollection(ctCollection);
        l.setWarehouseCollection(lCollection);
        em.merge(w);
    }

    @Override
    public void removeWarehouse(int wid, int constructionid, int locationid) {
        Construction ct = em.find(Construction.class, constructionid);
        Location l = em.find(Location.class, locationid);

        Collection<Warehouse> ctCollection = ct.getWarehouseCollection();
        Collection<Warehouse> lCollection = l.getWarehouseCollection();
        Warehouse w = em.find(Warehouse.class, wid);

        ctCollection.remove(w);
        lCollection.remove(w);

        ct.setWarehouseCollection(ctCollection);
        l.setWarehouseCollection(lCollection);
        em.remove(w);
    }

    @Override
    public Collection<Warehouse> getAllWarehouse() {
        return em.createNamedQuery("Warehouse.findAll").getResultList();
    }

    @Override
    public Collection<Warehouse> getWarehouseByCountructionType(int constructionId) {
        Construction ct = em.find(Construction.class, constructionId);
        return ct.getWarehouseCollection();
    }

    @Override
    public Warehouse getLastAddedWarehouse() {
        return (Warehouse) em.createQuery("SELECT w FROM Warehouse w ORDER BY w.warehouseId DESC").setMaxResults(1).getSingleResult();
    }

    @Override
    public void addAmenityIncluded(int amenityId, int warehouseId) {
        Amenity a = em.find(Amenity.class, amenityId);
        Warehouse w = em.find(Warehouse.class, warehouseId);

        Collection<Amenityincluded> amenityCollection = a.getAmenityincludedCollection();
        Collection<Amenityincluded> wareouseAmenityCollection = w.getAmenityincludedCollection();

        Amenityincluded ai = new Amenityincluded();
        ai.setAmenityId(a);
        ai.setWarehouseId(w);

        amenityCollection.add(ai);
        wareouseAmenityCollection.add(ai);

        a.setAmenityincludedCollection(amenityCollection);
        w.setAmenityincludedCollection(wareouseAmenityCollection);

        em.persist(ai);
    }

    @Override
    public void addCompliencesIncluded(int compliencesId, int warehouseId) {
        Compliances c = em.find(Compliances.class, compliencesId);
        Warehouse w = em.find(Warehouse.class, warehouseId);

        Collection<Compliencesincluded> cc = c.getCompliencesincludedCollection();
        Collection<Compliencesincluded> wc = w.getCompliencesincludedCollection();

        Compliencesincluded ci = new Compliencesincluded();
        ci.setCompliencesId(c);
        ci.setWarehouseId(w);

        cc.add(ci);
        wc.add(ci);

        c.setCompliencesincludedCollection(cc);
        w.setCompliencesincludedCollection(wc);

        em.persist(ci);
    }

    @Override
    public void addProductTypeIncluded(int ProductTypeId, int warehouseId) {
        Producttype p = em.find(Producttype.class, ProductTypeId);
        Warehouse w = em.find(Warehouse.class, warehouseId);

        Collection<Producttypeincluded> pc = p.getProducttypeincludedCollection();
        Collection<Producttypeincluded> wc = w.getProducttypeincludedCollection();

        Producttypeincluded pi = new Producttypeincluded();
        pi.setProductTypeId(p);
        pi.setWarehouseId(w);

        pc.add(pi);
        wc.add(pi);

        p.setProducttypeincludedCollection(pc);
        w.setProducttypeincludedCollection(wc);

        em.persist(pi);
    }

    @Override
    public Collection<City> getAllCities() {
       return em.createNamedQuery("City.findAll").getResultList();
    }

    @Override
    public Location getLastLocation() {
        return (Location) em.createQuery("SELECT l FROM Location l ORDER BY l.locationId DESC").setMaxResults(1).getSingleResult();
    }

    @Override
    public Collection<Construction> getAllConstructionType() {
        return em.createNamedQuery("Construction.findAll").getResultList();
    }

    @Override
    public Collection<Amenity> getAllAmenities() {
        return em.createNamedQuery("Amenity.findAll").getResultList();
    }

    @Override
    public Collection<Producttype> getAllProductType() {
        return em.createNamedQuery("Producttype.findAll").getResultList();        
    }

    @Override
    public Collection<Compliances> getAllCompliances() {
        return em.createNamedQuery("Compliances.findAll").getResultList();
    }

    @Override
    public int checkUserReturnRole(String username, String password) {
        List<Participate> p = (List<Participate>) getAllParticipant();
        if (!p.isEmpty()) {
            for (int i = 0; i < p.size(); i++) {
                Participate pa = p.get(i);
                if (pa.getUsername().equals(username)) {
                    if (pa.getPassword().equals(password)) {
//                        System.out.println(i + " for loop");
                        return pa.getRoleId().getRoleId();
                    }
                }
            }
//            System.out.println(p.size() + "participants");
            return 0;
        } else {
//            System.out.println("check empty");
            return 0;
        }
    }

    @Override
    public void addService(String serviceName, String picture,Double price) {
        Service s = new Service();

        s.setServiceName(serviceName);
        s.setServicePicture(picture);
        s.setServicePrice(price);

        em.persist(s);
    }

    @Override
    public void updateService(int id, String serviceName,
             String picture, Double price
    ) {
        Service s = em.find(Service.class, id);

        s.setServiceName(serviceName);
        s.setServicePicture(picture);
        s.setServicePrice(price);

        em.merge(s);
    }

    @Override
    public void removeService(int id
    ) {
        Service s = em.find(Service.class, id);
        em.remove(s);
    }

    @Override
    public Service getLastAddedService() {
        return (Service) em.createQuery("SELECT s FROM Service s ORDER BY s.serviceId DESC").setMaxResults(1).getSingleResult();
    }

    @Override
    public Collection<Service> getServiceData() {
        return em.createNamedQuery("Service.findAll").getResultList();
    }

    @Override
    public void addProvidedService(int serviceId, int userId,String isActive) {
        Service s = em.find(Service.class, serviceId);  
        Collection<Provideservice> sc = s.getProvideserviceCollection();
        
        Participate p = em.find(Participate.class, userId);
        Collection<Provideservice> pc = p.getProvideserviceCollection();

        Provideservice ps = new Provideservice();

        ps.setServiceId(s);
        ps.setServicerId(p);
        ps.setIsActive(isActive);

        sc.add(ps);
        pc.add(ps);

        s.setProvideserviceCollection(sc);
        p.setProvideserviceCollection(pc);

        em.persist(ps);
    }

    @Override
    public void editProvidedService(int id, int serviceId, int userId, String isActive) {
        Service s = em.find(Service.class, serviceId);
        Participate p = em.find(Participate.class, userId);

        Collection<Provideservice> sc = s.getProvideserviceCollection();
        Collection<Provideservice> pc = p.getProvideserviceCollection();

        Provideservice ps = em.find(Provideservice.class, id);

        ps.setServiceId(s);
        ps.setServicerId(p);
        ps.setIsActive(isActive);

        s.setProvideserviceCollection(sc);
        p.setProvideserviceCollection(pc);

        em.merge(ps);
        em.merge(s);
        em.merge(p);
    }

    @Override
    public void removeProvidedService(int id, int serviceId, int userId
    ) {
        Provideservice ps = em.find(Provideservice.class, id);
        Service s = em.find(Service.class, serviceId);
        Participate p = em.find(Participate.class, userId);

        Collection<Provideservice> sc = s.getProvideserviceCollection();
        Collection<Provideservice> pc = p.getProvideserviceCollection();

        sc.remove(ps);
        pc.remove(ps);

        s.setProvideserviceCollection(sc);
        p.setProvideserviceCollection(pc);

        em.remove(ps);
    }

    @Override
    public Collection<Provideservice> getAllProvidedService() {
        return em.createNamedQuery("Provideservice.findAll").getResultList();
    }

    @Override
    public Collection<Provideservice> getProvidedServiceById(int id
    ) {
        Query q = em.createNamedQuery("Provideservice.findByProvideServiceId").setParameter("provideServiceId", id);
        return q.getResultList();
    }

    @Override
    public Collection<Provideservice> getProvidedServiceByService(int serviceId
    ) {
        Service s = em.find(Service.class, serviceId);
        return s.getProvideserviceCollection();
    }

    @Override
    public Collection<Provideservice> getProvidedServiceByUser(int userId
    ) {
        Participate p = em.find(Participate.class, userId);
        return p.getProvideserviceCollection();
    }

    @Override
    public Collection<Provideservice> getProvidedServiceByStatus(String isActive
    ) {
        Query q = em.createNamedQuery("Provideservice.findByIsActive").setParameter("isActive", isActive);
        return q.getResultList();
    }

    @Override
    public Provideservice getLastAddedProvidedService() {
        return (Provideservice) em.createQuery("SELECT s FROM Provideservice s ORDER BY s.provideServiceId DESC").setMaxResults(1).getSingleResult();
    }

    @Override
    public void addWarehouseBookig(Date startDate, Date endDate, int warehouseId,int userId) {
        Warehouse w = em.find(Warehouse.class, warehouseId);
        Participate p = em.find(Participate.class, userId);
        
        Collection<Booking> wc = w.getBookingCollection();
        Collection<Booking> pc = p.getBookingCollection();
        
        Booking booking = new Booking();
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setWarehouseId(w);
        booking.setParticipateId(p);
        
        wc.add(booking);
        pc.add(booking);
        
        w.setBookingCollection(wc);
        p.setBookingCollection(pc);
    
        em.persist(booking);    
    }

    @Override
    public void updateWarehouseBooking(int bookingId, Date startDate, Date endDate, int warehouseId,int userId) {
        Warehouse w = em.find(Warehouse.class, warehouseId);
        Participate p = em.find(Participate.class, userId);
        
        Collection<Booking> wc = w.getBookingCollection();
        Collection<Booking> pc = p.getBookingCollection();
        
        Booking booking = em.find(Booking.class, bookingId);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setWarehouseId(w);
        booking.setParticipateId(p);
        
        w.setBookingCollection(wc);
        p.setBookingCollection(pc);
    
        em.merge(booking);
    }

    @Override
    public void removeWarehouseBooking(int bookingId, int warehouseId,int userId) {
        Warehouse w = em.find(Warehouse.class, warehouseId);
        Participate p = em.find(Participate.class, userId);
        
        Collection<Booking> wc = w.getBookingCollection();
        Collection<Booking> pc = p.getBookingCollection();
        
        Booking booking = em.find(Booking.class, bookingId);
        
        wc.remove(booking);
        pc.remove(booking);
        
        w.setBookingCollection(wc);
        p.setBookingCollection(pc);
    
        em.merge(booking);
    }

    @Override
    public Collection<Booking> getAllBookedWarehouse() {
        return em.createNamedQuery("Booking.findAll").getResultList();
    }

    @Override
    public Collection<Booking> getBookingByWarehouse(int warehouseId) {
        Warehouse w = em.find(Warehouse.class, warehouseId);
        return w.getBookingCollection();
    }

    @Override
    public Collection<Booking> getBookingByStartDate(Date startDate) {
        return em.createNamedQuery("Booking.findByStartDate").setParameter("startDate", startDate).getResultList();
    }

    @Override
    public Collection<Booking> getBookingByEndDate(Date endDate) {
        return em.createNamedQuery("Booking.findByEndDate").setParameter("endDate", endDate).getResultList();
    }

    @Override
    public Collection<Booking> getBookingByUser(int userId) {
        Participate p = em.find(Participate.class, userId);
        return p.getBookingCollection();
    }

    @Override
    public Collection<Booking> getBookingById(int bookingId) {
        return em.createNamedQuery("Booking.findByBookingId").setParameter("bookingId", bookingId).getResultList();
    }

    @Override
    public Collection<Provideservice> getActiveWarehouseOwner() {
        return em.createQuery("SELECT ps FROM Provideservice ps WHERE ps.isActive = 'Active' AND ps.serviceId.serviceName = 'Warehouse Owner'").getResultList();
    }

    @Override
    public void addServiceIncluded(int warehouseId, int provideServiceId, double price, int currentStatusId) 
    {
        Warehouse warehouse = em.find(Warehouse.class, warehouseId);
        Provideservice service = em.find(Provideservice.class, provideServiceId);
        Status status = em.find(Status.class, currentStatusId);
        
        Collection<Serviceincluded> wc = warehouse.getServiceincludedCollection();
        Collection<Serviceincluded> sc = service.getServiceincludedCollection();
        Collection<Serviceincluded> stc = status.getServiceincludedCollection();
        
        Serviceincluded serviceincluded = new Serviceincluded();
        serviceincluded.setWarehouseId(warehouse);
        serviceincluded.setProvideServiceId(service);
        serviceincluded.setPrice(price);
        serviceincluded.setCurrentStatusId(status);
        
        wc.add(serviceincluded);
        sc.add(serviceincluded);
        stc.add(serviceincluded);
        
        warehouse.setServiceincludedCollection(wc);
        service.setServiceincludedCollection(sc);
        status.setServiceincludedCollection(stc);
        
        em.persist(serviceincluded);
    }

    @Override
    public void updateServiceIncluded(int serviceIncludedId, int warehouseId, int provideServiceId, double price, int currentStatusId) {
        Warehouse warehouse = em.find(Warehouse.class, warehouseId);
        Provideservice service = em.find(Provideservice.class, provideServiceId);
        Status status = em.find(Status.class, currentStatusId);
        
        Collection<Serviceincluded> wc = warehouse.getServiceincludedCollection();
        Collection<Serviceincluded> sc = service.getServiceincludedCollection();
        Collection<Serviceincluded> stc = status.getServiceincludedCollection();
        
        Serviceincluded serviceincluded = em.find(Serviceincluded.class, serviceIncludedId);
        
        serviceincluded.setWarehouseId(warehouse);
        serviceincluded.setProvideServiceId(service);
        serviceincluded.setPrice(price);
        serviceincluded.setCurrentStatusId(status);
        
        warehouse.setServiceincludedCollection(wc);
        service.setServiceincludedCollection(sc);
        status.setServiceincludedCollection(stc);
        
        em.persist(serviceincluded);
    }

    @Override
    public void deleteServiceIncluded(int serviceIncludedId, int warehouseId, int provideServiceId, int currentStatusId) {
        Warehouse warehouse = em.find(Warehouse.class, warehouseId);
        Provideservice service = em.find(Provideservice.class, provideServiceId);
        Status status = em.find(Status.class, currentStatusId);
        
        Collection<Serviceincluded> wc = warehouse.getServiceincludedCollection();
        Collection<Serviceincluded> sc = service.getServiceincludedCollection();
        Collection<Serviceincluded> stc = status.getServiceincludedCollection();
        
        Serviceincluded serviceincluded = em.find(Serviceincluded.class, serviceIncludedId);
        
        wc.remove(serviceincluded);
        sc.remove(serviceincluded);
        stc.remove(serviceincluded);
        
        warehouse.setServiceincludedCollection(wc);
        service.setServiceincludedCollection(sc);
        status.setServiceincludedCollection(stc);
        
        em.remove(serviceincluded);
    }

    @Override
    public Collection<Serviceincluded> getAllServiceIncluded() {
        return em.createNamedQuery("Serviceincluded.findAll").getResultList();
    }

    @Override
    public Collection<Serviceincluded> getIncludedServicesByWarehouseId(int warehouseId) {
        Warehouse warehouse = em.find(Warehouse.class, warehouseId);
        return warehouse.getServiceincludedCollection();
    }

    @Override
    public Collection<Serviceincluded> getIncludedServicesByProvidedserviceId(int providedServiceId) {
        Provideservice service = em.find(Provideservice.class, providedServiceId);
        return service.getServiceincludedCollection();
    }

    @Override
    public Collection<Serviceincluded> getIncludedServicesByStatus(int currentStatusId) {
        Status s = em.find(Status.class, currentStatusId);
        return s.getServiceincludedCollection();
    }

    @Override
    public Collection<Serviceincluded> getActiveWarehouseService() {
        return em.createQuery("SELECT si FROM Serviceincluded si WHERE si.currentStatusId.status = 1 AND si.provideServiceId.serviceId.serviceName = 'Warehouse Owner'").getResultList();
    }

    @Override
    public Collection<Serviceincluded> getServiceIncludedById(int serviceIncludedId) {
        return em.createNamedQuery("Serviceincluded.findByServiceIncludedId").setParameter("serviceIncludedId",serviceIncludedId).getResultList();
    }

    @Override
    public String checkLogin(Participate user) {
        try{
            Participate u1 = em.find(Participate.class,user.getUsername());
            if(u1.getPassword().equals(user.getPassword())){
                Query q1 = em.createNamedQuery("Projectgroups.findByUserId").setParameter("username", user);
                Participate g1 = (Participate) q1.getSingleResult();
                String gname= g1.getRoleId().getRoleName();
                return gname;
            }else
            {
                return "false";
            }
        }catch(Exception e){
            return "false";
        }
    }

    @Override
    public Collection<Amenityincluded> getAmenitiesOfWarehouse(int warehouseId) {
        Warehouse w = em.find(Warehouse.class, warehouseId);
        return w.getAmenityincludedCollection();
    }

    @Override
    public Collection<Compliencesincluded> getCompliencesOfWarehouse(int warehouseId) {
        Warehouse w = em.find(Warehouse.class, warehouseId);
        return w.getCompliencesincludedCollection();
    }

    @Override
    public Collection<Producttypeincluded> getProductTypeOfWarehouse(int warehouseId) {
        Warehouse w = em.find(Warehouse.class, warehouseId);
        return w.getProducttypeincludedCollection();
    }

}