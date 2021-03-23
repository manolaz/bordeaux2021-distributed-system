package db.quarkus;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Date;

import db.dto.UserMapper;
import db.dto.UserDto;


@Path("/api/users")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class UserResource {
    @Inject
    UserMapper mapper;  
    
    @Inject 
    UserDao userDao; 

    @GET
    @Path("people")
    public List<UserDto> all() {
        return userDao.findAll();
    }

    @GET
    @Path("people/by-name/{name}")
    public List<UserDto> findByName(@PathParam("name") final String name) {
        return userDao.findByName(name);
    }

    @GET
    @Path("person/{id}")
    public UserDto findById(@PathParam("id") final Long id) {
        final User p = userDao.findById(id);
        if(p == null)
            throw new WebApplicationException(Status.NOT_FOUND);
        return p;
    }
}
