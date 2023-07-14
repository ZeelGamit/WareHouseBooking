/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Resource;

import EJB.WarehouseBookEJBLocal;
import Entity.Location;
import Entity.Participate;
import Entity.Person;
import Entity.Provideservice;
import Entity.Role;
import Entity.Service;
import Entity.Serviceincluded;
import Entity.Warehouse;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author DELL
 */
@Path("generic")
@RequestScoped
public class GenericResource {

    @Context
    private UriInfo context;

    @EJB WarehouseBookEJBLocal wejb;
    
    public GenericResource() {
    }

    @POST
    @Path("addRole/{rolename}")
    public void addRole(@PathParam("rolename")String roleName)
    {
        wejb.addRole(roleName);
    }
    
    @PUT
    @Path("updateRole/{id}/{name}")
    public void updateRole(@PathParam("id")int roleID,@PathParam("name")String roleName)
    {
        wejb.updateRole(roleID, roleName);
    }
    
    @DELETE
    @Path("removeRole/{id}")
    public void removeRole(@PathParam("id")int roleID)
    {
        wejb.removeRole(roleID);
    }
    
    @GET
    @Path("getRoles")
    @Produces("application/json")
    public Collection<Role> getAllRoles()
    {
        return wejb.getAllRoles();
    }
    
    @POST
    @Path("addPerson/{fname}/{lname}/{email}/{phone}")
    public void addPerson(@PathParam("fname")String firstname,@PathParam("lname")String lastname,@PathParam("email")String email,@PathParam("phone")String phone)
    {
        wejb.addPerson(firstname, lastname,email,phone);
    }
    
    @PUT
    @Path("updatePerson/{id}/{fname}/{lname}/{email}/{phone}")    
    public void updatePerson(@PathParam("id")int id,@PathParam("fname")String firstname,@PathParam("lname")String lastname,@PathParam("email")String email,@PathParam("phone")String phone)
    {
        wejb.updatePerson(id, firstname, lastname,email,phone);
    }

    @DELETE
    @Path("removePerson/{id}")    
    public void removePerson(@PathParam("id")int id)
    {
        wejb.removePerson(id);
    }
    
    @GET
    @Path("getPersonData")
    @Produces("application/json")    
    public Collection<Person> getPersonData()
    {
        return wejb.getPersonData();
    }
    
    @GET
    @Path("getLastAddedPerson")
    @Produces("application/json")
    public Person getLastPerson()
    {
        return wejb.getLastPerson();
    }
    
    @POST
    @Path("addParticipant/{PersonId}/{RoleId}/{Password}/{Username}")
    public void addParticipant(@PathParam("PersonId")int PersonId,@PathParam("RoleId")int RoleId,@PathParam("Password")String Password,@PathParam("Username") String username)
    {
        wejb.addParticipant(PersonId, RoleId, Password,username);
    }
    
    @PUT
    @Path("updateParticipant/{id}/{pid}/{rid}/{password}/{Username}")
    public void updateParticipant(@PathParam("id")int ParticipationId,@PathParam("pid")int PersonId,@PathParam("rid")int RoleId,@PathParam("password")String Password,@PathParam("Username") String username)
    {
        wejb.updateParticipant(ParticipationId, PersonId, RoleId, Password,username);
    }
    
    @DELETE
    @Path("removeParticipant/{id}/{pid}/{rid}")
    public void removeParticipant(@PathParam("id")int ParticipationId,@PathParam("pid")int PersonId,@PathParam("rid")int RoleId)
    {
        wejb.removeParticipant(ParticipationId, PersonId, RoleId);
    }
    
    @GET
    @Path("showAllParicipant")
    @Produces("application/json")
    public Collection<Participate> getAllParticipant() {
        return wejb.getAllParticipant();
    }
    
    @GET
    @Path("showParicipantData/{id}")
    @Produces("application/json")
    public Collection<Participate> showParticipantData(@PathParam("id")int PersonId)
    {
        return wejb.showParticipantData(PersonId);
    }
    
    @GET
    @Path("showParicipantByRole/{id}")
    @Produces("application/json")
    public Collection<Participate> showParticipantByRole(@PathParam("id")int RoleId)
    {
        return wejb.showParticipantByRole(RoleId);
    }
    
    @GET
    @Path("getLastAddedParticipant")
    @Produces("application/json")
    public Participate getLastAddedParticipant()
    {
        return wejb.getLastAddedParticipant();
    }
    
    @POST
    @Path("addLocation/{name}/{cityid}")
    public void addLocation(@PathParam("name")String name,@PathParam("cityid")int cityid)
    {
        wejb.addLocation(name, cityid);
    }
    
    @PUT
    @Path("updateLocation/{id}/{name}/{cityid}")
    public void updateLocation(@PathParam("id")int id,@PathParam("name")String name,@PathParam("cityid")int cityid)
    {
        wejb.updateLocation(id, name, cityid);
    }
    
    @DELETE
    @Path("deleteLocation/{id}/{cityid}")
    public void deleteLocation(@PathParam("id")int id,@PathParam("cityid")int cityid)
    {
        wejb.deleteLocation(id, cityid);
    }
    
    @GET
    @Path("showAllLocation")
    @Produces("application/json")
    public Collection<Location> showAllLocations()
    {
        return wejb.showAllLocations();
    }
    
    @GET
    @Path("showLocationsByCity/{cityid}")
    @Produces("application/json")
    public Collection<Location> showLocationsByCity(@PathParam("cityid")int cityid)
    {
        return wejb.showLocationsByCity(cityid);
    }
    
    @POST
    @Path("addWarehouse/{constructionid}/{area}/{locationid}")
    public void addWarehouse(@PathParam("constructionid")int constructionid,@PathParam("area")double area,@PathParam("locationid")int locationid)
    {
        wejb.addWarehouse(constructionid, area,locationid);
    }
    
    @PUT
    @Path("updateWarehouse/{wid}/{constructionid}/{area}/{locationid}")    
    public void updateWarehouse(@PathParam("wid")int wid,@PathParam("constructionid")int constructionid,@PathParam("area")double area,@PathParam("locationid")int locationid)
    {
        wejb.updateWarehouse(wid, constructionid, area, locationid);
    }
    
    @DELETE
    @Path("removeWarehouse/{wid}/{constructionid}/{locationid}")
    public void removeWarehouse(@PathParam("wid")int wid,@PathParam("constructionid")int constructionid,@PathParam("locationid")int locationid)
    {
        wejb.removeWarehouse(wid, constructionid,locationid);
    }
 
    @GET
    @Path("getAllWarehouses")
    @Produces("application/json")
    public Collection<Warehouse> getAllWarehouse()
    {
        return wejb.getAllWarehouse();
    }

    @GET
    @Path("getWarehouseByCountructionType/{constructionId}")
    @Produces("application/json")    
    public Collection<Warehouse> getWarehouseByCountructionType(@PathParam("constructionId")int constructionId)
    {
        return wejb.getWarehouseByCountructionType(constructionId);
    }
    
    //AmenityIncluded 
    @POST
    @Path("addAmenityIncluded/{aid}/{wid}")
    public void addAmenityIncluded(@PathParam("aid")int amenityId,@PathParam("wid")int warehouseId)
    {
        wejb.addAmenityIncluded(amenityId, warehouseId);
    }
    
    //CompliencesIncluded
    @POST
    @Path("addCompliencesIncluded/{cid}/{wid}")
    public void addCompliencesIncluded(@PathParam("cid")int compliencesId,@PathParam("wid")int warehouseId)
    {
        wejb.addCompliencesIncluded(compliencesId, warehouseId);
    }
    
    //ProductTypeIncluded
    @POST
    @Path("addProductTypeIncluded/{pid}/{wid}")
    public void addProductTypeIncluded(@PathParam("pid")int ProductTypeId,@PathParam("wid")int warehouseId)
    {
        wejb.addProductTypeIncluded(ProductTypeId, warehouseId);
    }

    @GET
    @Path("checkUserReturnRole/{username}/{password}")
    @Produces("application/json")
    public int checkUserReturnRole(@PathParam("username")String username,@PathParam("password") String password)
    {
        return wejb.checkUserReturnRole(username, password);
    }
    
    @POST
    @Path("addService/{serviceName}/{picture}/{price}")
    public void addService(@PathParam("serviceName")String serviceName,@PathParam("picture")String picture,@PathParam("price")Double price)
    {
        wejb.addService( serviceName, picture, price);
    }
    
    @PUT
    @Path("updateService/{id}/{serviceName}/{picture}/{price}")
    public void updateService(@PathParam("id")int id,@PathParam("serviceName")String serviceName,@PathParam("picture")String picture,@PathParam("price")Double price)
    {
        wejb.updateService(id, serviceName, picture, price);
    }
    
    @DELETE
    @Path("removeService/{id}")
    public void removeService(@PathParam("id") int id)
    {
        wejb.removeService(id);
    }
    
    @GET
    @Path("getLastAddedService")
    @Produces("application/json")
    public Service getLastAddedService()
    {
        return wejb.getLastAddedService();
    }
    
    @GET
    @Path("getServiceData")
    @Produces("application/json")
    public Collection<Service> getServiceData()
    {
        return wejb.getServiceData();
    }
    
    @POST
    @Path("addProvidedService/{serviceId}/{userId}/{isActive}")
    public void addProvidedService(@PathParam("serviceId")int serviceId,@PathParam("userId")int userId,@PathParam("isActive")String isActive)
    {
        wejb.addProvidedService(serviceId, userId,isActive);
    }
    
    @PUT
    @Path("editProvidedService/{id}/{serviceId}/{userId}/{isActive}")
    public void editProvidedService(@PathParam("id")int id,@PathParam("serviceId")int serviceId,@PathParam("userId")int userId,@PathParam("isActive")String isActive)
    {
        wejb.editProvidedService(id, serviceId, userId, isActive);
    }
    
    @DELETE
    @Path("removeProvidedService/{id}/{serviceId}/{userId}")
    public void removeProvidedService(@PathParam("id")int id,@PathParam("serviceId")int serviceId,@PathParam("userId")int userId)
    {
        wejb.removeProvidedService(id, serviceId, userId);
    }
    
    @GET
    @Path("getAllProvidedService")
    @Produces("application/json")
    public Collection<Provideservice> getAllProvidedService()
    {
        return wejb.getAllProvidedService();
    }
    
    @GET
    @Path("getProvidedServiceById/{id}")
    @Produces("application/json")
    public Collection<Provideservice> getProvidedServiceById(@PathParam("id")int id)
    {
        return wejb.getProvidedServiceById(id);
    }
    
    @GET
    @Path("getProvidedServiceByService/{serviceId}")
    @Produces("application/json")
    public Collection<Provideservice> getProvidedServiceByService(@PathParam("serviceId")int serviceId)
    {
        return wejb.getProvidedServiceByService(serviceId);
    }

    @GET
    @Path("getProvidedServiceByUser/{userId}")
    @Produces("application/json")    
    public Collection<Provideservice> getProvidedServiceByUser(@PathParam("userId")int userId)
    {
        return wejb.getProvidedServiceByUser(userId);
    }

    @GET
    @Path("getProvidedServiceByStatus/{isActive}")
    @Produces("application/json")    
    public Collection<Provideservice> getProvidedServiceByStatus(@PathParam("isActive")String isActive)
    {
        return wejb.getProvidedServiceByStatus(isActive);
    }

    @GET
    @Path("getLastAddedProvidedService")
    @Produces("application/json")    
    public Provideservice getLastAddedProvidedService()
    {
        return wejb.getLastAddedProvidedService();
    }
    
    @POST
    @Path("addServiceIncluded/{warehouseId}/{provideServiceId}/{price}/{currentStatusId}")
    public void addServiceIncluded(@PathParam("warehouseId") int warehouseId,@PathParam("provideServiceId") int provideServiceId,@PathParam("price") double price,@PathParam("currentStatusId") int currentStatusId)
    {
        wejb.addServiceIncluded(warehouseId, provideServiceId, price, currentStatusId);
    }
    
    @PUT
    @Path("updateServiceIncluded/{serviceIncludedId}/{warehouseId}/{provideServiceId}/{price}/{currentStatusId}")
    public void updateServiceIncluded(@PathParam("serviceIncludedId")int serviceIncludedId,@PathParam("warehouseId")int warehouseId,@PathParam("provideServiceId")int provideServiceId,@PathParam("price")double price,@PathParam("currentStatusId")int currentStatusId)
    {
        wejb.updateServiceIncluded(serviceIncludedId, warehouseId, provideServiceId, price, currentStatusId);
    }
    
    @DELETE
    @Path("deleteServiceIncluded/{serviceIncludedId}/{warehouseId}/{provideServiceId}/{currentStatusId}")
    public void deleteServiceIncluded(@PathParam("serviceIncludedId")int serviceIncludedId,@PathParam("warehouseId") int warehouseId,@PathParam("provideServiceId") int provideServiceId,@PathParam("currentStatusId")int currentStatusId)
    {
        wejb.deleteServiceIncluded(serviceIncludedId, warehouseId, provideServiceId, currentStatusId);
    }
    
    @GET
    @Path("getAllServiceIncluded")
    @Produces("application/json")
    public Collection<Serviceincluded> getAllServiceIncluded()
    {
        return wejb.getAllServiceIncluded();
    }
    
    @GET
    @Path("getIncludedServicesByWarehouseId/{warehouseId}")
    @Produces("application/json")
    public Collection<Serviceincluded> getIncludedServicesByWarehouseId(@PathParam("warehouseId") int warehouseId)
    {
        return wejb.getIncludedServicesByWarehouseId(warehouseId);
    }
    
    @GET
    @Path("getIncludedServicesByProvidedserviceId/{providedServiceId}")
    @Produces("application/json")
    public Collection<Serviceincluded> getIncludedServicesByProvidedserviceId(@PathParam("providedServiceId") int providedServiceId)
    {
        return wejb.getIncludedServicesByProvidedserviceId(providedServiceId);
    }
    
    @GET
    @Path("getIncludedServicesByStatus/{currentStatusId}")
    @Produces("application/json")
    public Collection<Serviceincluded> getIncludedServicesByStatus(@PathParam("currentStatusId") int currentStatusId)
    {
        return wejb.getIncludedServicesByStatus(currentStatusId);
    }
  
}