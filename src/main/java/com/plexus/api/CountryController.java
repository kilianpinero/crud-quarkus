package com.plexus.api;

import com.plexus.domain.Country;
import com.plexus.repository.CountryRepository;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/country")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CountryController {

    final Logger log = Logger.getLogger("CountryController.class");

    @Inject
    CountryRepository countryRepo;

    @GET
    @Path("/list")
    public Response listAll() {
        List<Country> countries = countryRepo.findAll();
//        for (Country c :countries){
//            log.info(c.toString());
//        }
        log.info("Full country List retrieved");
       return Response.ok(countries).build();
    }

    @POST
    @Path("/add")
    public Response add(Country country) {
        countryRepo.add(country);
//        log.info("Country "+country.getName()+" added");
        return Response.ok().build();
    }

    @DELETE
    @Path("/remove/{id}")
    public Response remove(@PathParam("id") Long id) {
        Country country = countryRepo.findCountry(id);
        log.info("single Country found");
        countryRepo.delete(country);
        log.info("Country "+country.getName()+" deleted");
        return Response.ok().build();
    }

    @PUT
    @Path("/update")
    public Response update(@NotNull Country country) {
        Country c = countryRepo.findCountry(country.getId());
        c.setName(country.getName());
        countryRepo.updateCountry(c);
        log.info("Country updated");
        return Response.ok().build();
    }



}
