package com.jensens.daniel.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sportsing.api.Match;

@RequestScoped
@Path("matchService")
public class MatchService {
	private static List<Match> matches;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Match> getMatches() {
		 if(matches == null) {
			matches = new ArrayList<Match>();
			Match m = new Match(0, "Fotboll");
			matches.add(m);
		 }
		return matches;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public void createMatch(Match match) {
		matches.add(match);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteMatch(@PathParam("id") int id) {
		getMatches();
		matches.remove(id);
	}
}
