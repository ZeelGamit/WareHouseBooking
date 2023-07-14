/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        WarehouseClient client = new WarehouseClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author DELL
 */
public class WarehouseClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WarehouseBook/resources";

    public WarehouseClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public <T> T getAllWarehouse(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllWarehouses");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllServiceIncluded(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllServiceIncluded");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateRole(String id, String name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateRole/{0}/{1}", new Object[]{id, name})).request().put(null);
    }

    public <T> T showParticipantByRole(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("showParicipantByRole/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void editProvidedService(String id, String serviceId, String userId, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("editProvidedService/{0}/{1}/{2}/{3}", new Object[]{id, serviceId, userId, isActive})).request().put(null);
    }

    public void removeService(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeService/{0}", new Object[]{id})).request().delete();
    }

    public void addWarehouse(String constructionid, String area, String locationid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addWarehouse/{0}/{1}/{2}", new Object[]{constructionid, area, locationid})).request().post(null);
    }

    public void addParticipant(String PersonId, String RoleId, String Password, String Username) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addParticipant/{0}/{1}/{2}/{3}", new Object[]{PersonId, RoleId, Password, Username})).request().post(null);
    }

    public <T> T getServiceData(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getServiceData");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getProvidedServiceByService(Class<T> responseType, String serviceId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProvidedServiceByService/{0}", new Object[]{serviceId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCompliencesIncluded(String cid, String wid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCompliencesIncluded/{0}/{1}", new Object[]{cid, wid})).request().post(null);
    }

    public <T> T checkUserReturnRole(Class<T> responseType, String username, String password) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("checkUserReturnRole/{0}/{1}", new Object[]{username, password}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getLastAddedProvidedService(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getLastAddedProvidedService");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllProvidedService(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllProvidedService");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T showLocationsByCity(Class<T> responseType, String cityid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("showLocationsByCity/{0}", new Object[]{cityid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getProvidedServiceByUser(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProvidedServiceByUser/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getIncludedServicesByStatus(Class<T> responseType, String currentStatusId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getIncludedServicesByStatus/{0}", new Object[]{currentStatusId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getIncludedServicesByProvidedserviceId(Class<T> responseType, String providedServiceId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getIncludedServicesByProvidedserviceId/{0}", new Object[]{providedServiceId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T showParticipantData(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("showParicipantData/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateLocation(String id, String name, String cityid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateLocation/{0}/{1}/{2}", new Object[]{id, name, cityid})).request().put(null);
    }

    public void updateWarehouse(String wid, String constructionid, String area, String locationid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateWarehouse/{0}/{1}/{2}/{3}", new Object[]{wid, constructionid, area, locationid})).request().put(null);
    }

    public <T> T getProvidedServiceById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProvidedServiceById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateService(String id, String serviceName, String picture, String price) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateService/{0}/{1}/{2}/{3}", new Object[]{id, serviceName, picture, price})).request().put(null);
    }

    public <T> T getPersonData(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getPersonData");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteServiceIncluded(String serviceIncludedId, String warehouseId, String provideServiceId, String currentStatusId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteServiceIncluded/{0}/{1}/{2}/{3}", new Object[]{serviceIncludedId, warehouseId, provideServiceId, currentStatusId})).request().delete();
    }

    public void removeProvidedService(String id, String serviceId, String userId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeProvidedService/{0}/{1}/{2}", new Object[]{id, serviceId, userId})).request().delete();
    }

    public void addRole(String rolename) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addRole/{0}", new Object[]{rolename})).request().post(null);
    }

    public <T> T showAllLocations(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("showAllLocation");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getIncludedServicesByWarehouseId(Class<T> responseType, String warehouseId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getIncludedServicesByWarehouseId/{0}", new Object[]{warehouseId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllRoles(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getRoles");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addAmenityIncluded(String aid, String wid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAmenityIncluded/{0}/{1}", new Object[]{aid, wid})).request().post(null);
    }

    public void removePerson(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removePerson/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getAllParticipant(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("showAllParicipant");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addLocation(String name, String cityid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addLocation/{0}/{1}", new Object[]{name, cityid})).request().post(null);
    }

    public <T> T getProvidedServiceByStatus(Class<T> responseType, String isActive) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProvidedServiceByStatus/{0}", new Object[]{isActive}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addPerson(String fname, String lname, String email, String phone) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPerson/{0}/{1}/{2}/{3}", new Object[]{fname, lname, email, phone})).request().post(null);
    }

    public void removeWarehouse(String wid, String constructionid, String locationid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeWarehouse/{0}/{1}/{2}", new Object[]{wid, constructionid, locationid})).request().delete();
    }

    public void addService(String serviceName, String picture, String price) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addService/{0}/{1}/{2}", new Object[]{serviceName, picture, price})).request().post(null);
    }

    public void updateServiceIncluded(String serviceIncludedId, String warehouseId, String provideServiceId, String price, String currentStatusId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateServiceIncluded/{0}/{1}/{2}/{3}/{4}", new Object[]{serviceIncludedId, warehouseId, provideServiceId, price, currentStatusId})).request().put(null);
    }

    public <T> T getLastAddedService(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getLastAddedService");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addServiceIncluded(String warehouseId, String provideServiceId, String price, String currentStatusId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addServiceIncluded/{0}/{1}/{2}/{3}", new Object[]{warehouseId, provideServiceId, price, currentStatusId})).request().post(null);
    }

    public void removeRole(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeRole/{0}", new Object[]{id})).request().delete();
    }

    public void addProductTypeIncluded(String pid, String wid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addProductTypeIncluded/{0}/{1}", new Object[]{pid, wid})).request().post(null);
    }

    public void addProvidedService(String serviceId, String userId, String isActive) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addProvidedService/{0}/{1}/{2}", new Object[]{serviceId, userId, isActive})).request().post(null);
    }

    public void updateParticipant(String id, String pid, String rid, String password, String Username) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateParticipant/{0}/{1}/{2}/{3}/{4}", new Object[]{id, pid, rid, password, Username})).request().put(null);
    }

    public void removeParticipant(String id, String pid, String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeParticipant/{0}/{1}/{2}", new Object[]{id, pid, rid})).request().delete();
    }

    public <T> T getWarehouseByCountructionType(Class<T> responseType, String constructionId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getWarehouseByCountructionType/{0}", new Object[]{constructionId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getLastPerson(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getLastAddedPerson");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteLocation(String id, String cityid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteLocation/{0}/{1}", new Object[]{id, cityid})).request().delete();
    }

    public void updatePerson(String id, String fname, String lname, String email, String phone) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePerson/{0}/{1}/{2}/{3}/{4}", new Object[]{id, fname, lname, email, phone})).request().put(null);
    }

    public <T> T getLastAddedParticipant(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getLastAddedParticipant");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
