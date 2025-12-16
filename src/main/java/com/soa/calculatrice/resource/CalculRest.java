package com.soa.calculatrice.resource;

import com.soa.calculatrice.metier.Calculatrice;
import com.soa.calculatrice.model.Operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calcul")
public class CalculRest {

    private Calculatrice calculatrice = new Calculatrice();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Ça marche !";
    }

    @GET
    @Path("/addition")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addition(@QueryParam("a") double a, @QueryParam("b") double b) {
        try {
            double resultat = calculatrice.addition(a, b);
            Operation operation = new Operation(a, b, resultat, "addition");
            return Response.ok(operation).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erreur: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/soustraction")
    @Produces(MediaType.APPLICATION_JSON)
    public Response soustraction(@QueryParam("a") double a, @QueryParam("b") double b) {
        try {
            double resultat = calculatrice.soustraction(a, b);
            Operation operation = new Operation(a, b, resultat, "soustraction");
            return Response.ok(operation).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erreur: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/multiplication")
    @Produces(MediaType.APPLICATION_JSON)
    public Response multiplication(@QueryParam("a") double a, @QueryParam("b") double b) {
        try {
            double resultat = calculatrice.multiplication(a, b);
            Operation operation = new Operation(a, b, resultat, "multiplication");
            return Response.ok(operation).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erreur: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/division")
    @Produces(MediaType.APPLICATION_JSON)
    public Response division(@QueryParam("a") double a, @QueryParam("b") double b) {
        try {
            double resultat = calculatrice.division(a, b);
            Operation operation = new Operation(a, b, resultat, "division");
            return Response.ok(operation).build();
        } catch (ArithmeticException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Erreur: " + e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur: " + e.getMessage()).build();
        }
    }
}