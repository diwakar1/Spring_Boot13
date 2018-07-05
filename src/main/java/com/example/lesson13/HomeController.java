package com.example.lesson13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @RequestMapping("/")
    public String index(Model model){
        Actor actor =new Actor();
        actor.setName("Sudha");
        actor.setRealname("sudha sharma");


        Movie movie = new Movie();
        movie.setTitle("Emoji movie");
        movie.setYear(2017);
        movie.setDescription("About Emozi.....");


        Movie movie1 = new Movie();
        movie1.setTitle("DDLJ");
        movie1.setYear(1999);
        movie1.setDescription("itsnice....");

        Set<Movie>movies=new HashSet<Movie>();

        movies.add(movie);
        movies.add(movie1);

        actor.setMovies(movies);
        actorRepository.save(actor);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";


    }
}
