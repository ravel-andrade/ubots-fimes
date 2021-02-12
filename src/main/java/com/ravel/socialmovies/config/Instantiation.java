package com.ravel.socialmovies.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ravel.socialmovies.domain.Movie;
import com.ravel.socialmovies.domain.Review;
import com.ravel.socialmovies.domain.User;
import com.ravel.socialmovies.dto.AuthorDTO;
import com.ravel.socialmovies.repository.MovieRepository;
import com.ravel.socialmovies.repository.ReviewRepository;
import com.ravel.socialmovies.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieRepository MovieRepository;
	
	@Autowired
	private ReviewRepository ReviewRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		if(MovieRepository.findAll() == null && MovieRepository.findAll() == null) {
			User maria = new User(null, "Maria Brown", "maria@gmail.com");
			User alex = new User(null, "Alex Green", "alex@gmail.com");
			User bob = new User(null, "Bob Grey", "bob@gmail.com");
			
			userRepository.saveAll(Arrays.asList(maria, alex, bob));
			
			Movie Movie1 = new Movie(null, sdf.parse("21/03/2018"), "Tom & Jerry: O Filme", "Uma das rivalidades mais amadas da história é reacendida quando Jerry se muda para o melhor hotel de Nova York na véspera do \"casamento do século\" ", new AuthorDTO(maria));
			Movie Movie2 = new Movie(null, sdf.parse("23/03/2018"), "Mulher-Maravilha 1984", "Na década de 1980, a Mulher-Maravilha enfrenta dois novos inimigos: Max Lord e Mulher-Leopardo.", new AuthorDTO(maria));
			Movie Movie3 = new Movie(null, sdf.parse("23/03/2018"), "Pinóquio", "Gepeto é um solitário marceneiro que sonha em ser pai e deseja que Pinóquio, o boneco que acabou de construir, ganhe vida.", new AuthorDTO(alex));
			
			Review c1 = new Review(null, "Adoro esse filme", sdf.parse("21/03/2018"), new AuthorDTO(alex));
			Review c2 = new Review(null, "Muito bom", sdf.parse("22/03/2018"), new AuthorDTO(bob));
			Review c3 = new Review(null, "Perfeito", sdf.parse("23/03/2018"), new AuthorDTO(alex));
			
			Review c4 = new Review(null, "Achei sem graça", sdf.parse("21/03/2018"), new AuthorDTO(maria));

			ReviewRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
			
			Movie1.getReviews().addAll(Arrays.asList(c1, c2));
			Movie2.getReviews().addAll(Arrays.asList(c3));
			Movie3.getReviews().add(c4);
			
			MovieRepository.saveAll(Arrays.asList(Movie1, Movie2, Movie3));
			
			alex.getMovies().add(Movie3);
			
			maria.getMovies().addAll(Arrays.asList(Movie1, Movie2));
			userRepository.save(maria);
			userRepository.save(alex);
		}
		
	}

}
