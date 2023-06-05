package com.xemphim.WebXemPhim.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xemphim.WebXemPhim.common.APIResponse;
import com.xemphim.WebXemPhim.dto.AccountDTO;
import com.xemphim.WebXemPhim.dto.mapper.AccountMapper;
import com.xemphim.WebXemPhim.dto.request.CreEpisodeLinkRequestDTO;
import com.xemphim.WebXemPhim.dto.request.CreEpisodeRequestDTO;
import com.xemphim.WebXemPhim.dto.request.CreFilmRequestDTO;
import com.xemphim.WebXemPhim.dto.request.CreFilmRequestLinkDTO;
import com.xemphim.WebXemPhim.entity.*;
import com.xemphim.WebXemPhim.repository.*;
import com.xemphim.WebXemPhim.service.AdminService;
import com.xemphim.WebXemPhim.service.FileService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AdminServiceImpl implements AdminService {
    @Value("${project.video}")
    private String path;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private NationRepository nationRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private FilmProducerRepository filmProducerRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private FileService fileService;


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public APIResponse getAccounts() {
        APIResponse apiResponse = new APIResponse();
        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountNames = new ArrayList<>();
        for (Account acc:accounts) {
            accountNames.add(AccountMapper.getInstance().toDTO(acc));
        }
        apiResponse.setData(accountNames);
        return apiResponse;
    }

    @Override
    public void creFilm(CreFilmRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if (filmRepository.findOneByFilmNameIgnoreCaseAndStatusTrue(requestDTO.getName()) != null) {
                APIResponse apiResponse = new APIResponse();
                apiResponse.setStatus(400);
                apiResponse.setError("Film title is duplicate");
                new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
                return;
            }
            String poster = fileService.uploadFile(path, requestDTO.getPoster());
            String trailer = fileService.uploadFile(path, requestDTO.getTrailer());
            Film film = new Film();
            film.setFilmName(requestDTO.getName().strip());
            film.setTrailerPath(trailer);
            film.setFilmPosterPath(poster);
            film.setFilmDescription(requestDTO.getDescription());
            film.setFilmDuration(requestDTO.getDuration());
            if (requestDTO.getEpisodeRequests() != null) {
                if (requestDTO.getEpisodeRequests().size() > 1) {
                    film.setOddFilm(false);
                } else if (requestDTO.getEpisodeRequests().size() == 0) {
                    film.setOddFilm(requestDTO.isOdd());
                } else {
                    film.setOddFilm(true);
                }
            } else {
                film.setOddFilm(requestDTO.isOdd());
            }

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            film.setNation(nationRepository.findOneByNationId(requestDTO.getNation_id()));
            film.setDirector(directorRepository.findOneByDirectorId(requestDTO.getDirector_id()));
            film.setFilmProducer(filmProducerRepository.findOneByFilmProducerId(requestDTO.getProducer_id()));
            film.setReleaseTime(dateFormat.parse(requestDTO.getRelease_time()));
            film.setStatus(true);
            film.setRating(Float.parseFloat("0"));
            filmRepository.save(film);
            film = filmRepository.findOneByFilmNameIgnoreCaseAndStatusTrue(film.getFilmName());
            List<String> episodes = new ArrayList<>();
            if (requestDTO.getEpisodeRequests() != null) {
                for (CreEpisodeRequestDTO e : requestDTO.getEpisodeRequests()) {
                    String pathEpisode = fileService.uploadFile(path.concat("content/"), e.getContent());
                    episodes.add(pathEpisode);
                    Episode episode = new Episode();
                    episode.setTitle(e.getTitle());
                    episode.setFilm(film);
                    episode.setEpisodePath(pathEpisode);
                    episode.setCreAt(new Date());
                    episode.setStatus(true);
                    episodeRepository.save(episode);
                }
            }

            System.out.print(poster + "\n" + trailer + "\n" + episodes);

            APIResponse apiResponse = new APIResponse();
            apiResponse.setData("Success");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError(e.getMessage());
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        }
    }


    @Override
    public void creEpisodes(String filmName, CreEpisodeRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Film film = filmRepository.findOneByFilmNameIgnoreCaseAndStatusTrue(filmName);
            Episode old_episode = episodeRepository.findOneByFilmAndTitleAndStatusTrue(film, requestDTO.getTitle());
            if (old_episode != null) {
                APIResponse apiResponse = new APIResponse();
                apiResponse.setStatus(400);
                apiResponse.setError("Episode title is duplicate");
                new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
                return;
            }
            String pathEpisode = fileService.uploadFile(path.concat("content/"), requestDTO.getContent());
            Episode episode = new Episode();
            episode.setTitle(requestDTO.getTitle());
            episode.setFilm(film);
            episode.setEpisodePath(pathEpisode);
            episode.setCreAt(new Date());
            episode.setStatus(true);
            episodeRepository.save(episode);

            APIResponse apiResponse = new APIResponse();
            apiResponse.setData("Success");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError(e.getMessage());
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        }

    }

    @Override
    public void deleteFilm(String filmName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Film film = filmRepository.findOneByFilmNameIgnoreCaseAndStatusTrue(filmName);
        if (film == null) {
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError("FilmName wrong");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        } else {
            film.setStatus(false);
            filmRepository.save(film);
            APIResponse apiResponse = new APIResponse();
            apiResponse.setData("Success");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        }
    }

    @Override
    public void deleleEpisode(String filmName, String title, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Film film = filmRepository.findOneByFilmNameIgnoreCaseAndStatusTrue(filmName);
        if (film == null) {
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError("FilmName wrong");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        } else {
            Episode episode = episodeRepository.findOneByFilmAndTitleAndStatusTrue(film, title);
            if (episode == null) {
                APIResponse apiResponse = new APIResponse();
                apiResponse.setStatus(400);
                apiResponse.setError("Title wrong");
                new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
            } else {
                episode.setStatus(false);
                episodeRepository.save(episode);
                APIResponse apiResponse = new APIResponse();
                apiResponse.setData("Success");
                new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
            }
        }
    }

    @Override
    public void creCategory(String name, HttpServletRequest request, HttpServletResponse response) throws IOException {

        Category category = categoryRepository.findByCategoryName(name);
        if (category != null) {
            if (category.getStatus()) {
                APIResponse apiResponse = new APIResponse();
                apiResponse.setStatus(400);
                apiResponse.setError("Category already exists");
                new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
            } else {
                category.setStatus(true);
                categoryRepository.save(category);
                APIResponse apiResponse = new APIResponse();
                apiResponse.setData("Success");
                new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
            }
        } else {
            category = new Category();
            category.setCategoryName(name);
            category.setStatus(true);
            categoryRepository.save(category);
            APIResponse apiResponse = new APIResponse();
            apiResponse.setData("Success");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        }

    }

    @Override
    public void deleteCategory(String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Category category = categoryRepository.findByCategoryNameAndStatusTrue(name);
        if (category == null) {
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError("Category cannot exists");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        } else {
            category.setStatus(false);
            categoryRepository.save(category);
            APIResponse apiResponse = new APIResponse();
            apiResponse.setData("Success");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        }
    }

    @Override
    public void updateCategory(String oldName, String newName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Category category = categoryRepository.findByCategoryNameAndStatusTrue(oldName);
        if (category == null) {
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError("Category cannot exists");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        } else {
            category.setCategoryName(newName);
            categoryRepository.save(category);
            APIResponse apiResponse = new APIResponse();
            apiResponse.setData("Success");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        }
    }

    @Override
    public void creEpisodeLink(String filmName, CreEpisodeLinkRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            Film film = filmRepository.findOneByFilmNameIgnoreCaseAndStatusTrue(filmName);
            Episode old_episode = episodeRepository.findOneByFilmAndTitleAndStatusTrue(film, requestDTO.getTitle());
            if (old_episode != null) {
                APIResponse apiResponse = new APIResponse();
                apiResponse.setStatus(400);
                apiResponse.setError("Episode title is duplicate");
                new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
                return;
            }
            Episode episode = new Episode();
            episode.setTitle(requestDTO.getTitle());
            episode.setFilm(film);
            episode.setEpisodePath(requestDTO.getLink());
            episode.setCreAt(new Date());
            episode.setStatus(true);
            episodeRepository.save(episode);

            APIResponse apiResponse = new APIResponse();
            apiResponse.setData("Success");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError(e.getMessage());
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        }
    }

    @Override
    public void creFilmLink(CreFilmRequestLinkDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Set<String> titles = new HashSet<>(); // lưu trữ các title đã xuất hiện
            for (CreEpisodeLinkRequestDTO e : requestDTO.getEpisodes()) {
                String title = e.getTitle();
                if (titles.contains(title)) {
                    APIResponse apiResponse = new APIResponse();
                    apiResponse.setStatus(400);
                    apiResponse.setError("Title is duplicate");
                    new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
                    return;
                } else {
                    titles.add(title);
                }
            }
            if (filmRepository.findOneByFilmNameIgnoreCaseAndStatusTrue(requestDTO.getName()) != null) {
                APIResponse apiResponse = new APIResponse();
                apiResponse.setStatus(400);
                apiResponse.setError("Film title is duplicate");
                new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
                return;
            }
            Film film = new Film();
            film.setFilmName(requestDTO.getName().strip());
            film.setTrailerPath(requestDTO.getTrailer());
            film.setFilmPosterPath(requestDTO.getPoster());
            film.setFilmDescription(requestDTO.getDescription());
            film.setFilmDuration(requestDTO.getDuration());
            film.setOddFilm(requestDTO.isOdd());
            if (requestDTO.getEpisodes().size() > 1) {
                film.setOddFilm(false);
            }
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            film.setNation(nationRepository.findOneByNationId(requestDTO.getNation_id()));
            film.setDirector(directorRepository.findOneByDirectorId(requestDTO.getDirector_id()));
            film.setFilmProducer(filmProducerRepository.findOneByFilmProducerId(requestDTO.getProducer_id()));
            film.setReleaseTime(dateFormat.parse(requestDTO.getRelease_time()));
            film.setStatus(true);
            film.setRating(Float.parseFloat("0"));
            filmRepository.save(film);
            film = filmRepository.findOneByFilmNameIgnoreCaseAndStatusTrue(film.getFilmName());
            List<String> episodes = new ArrayList<>();
            if (requestDTO.getEpisodes() != null) {
                for (CreEpisodeLinkRequestDTO e : requestDTO.getEpisodes()) {
                    Episode episode = new Episode();
                    episode.setTitle(e.getTitle());
                    episode.setFilm(film);
                    episode.setEpisodePath(e.getLink());
                    episode.setCreAt(new Date());
                    episode.setStatus(true);
                    episodeRepository.save(episode);
                }
            }
            APIResponse apiResponse = new APIResponse();
            apiResponse.setData("Success");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        } catch (Exception e) {
            e.printStackTrace();
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError(e.getMessage());
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        }
    }

    @Override
    public void updateEpisode(String filmName, String oldTitle, CreEpisodeLinkRequestDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Film film = filmRepository.findOneByFilmNameIgnoreCaseAndStatusTrue(filmName);
        if (film == null) {
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError("FilmName wrong ");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        } else {
            Episode episode = episodeRepository.findOneByFilmAndTitleAndStatusTrue(film, oldTitle);
            if (episode == null) {
                APIResponse apiResponse = new APIResponse();
                apiResponse.setStatus(400);
                apiResponse.setError("OldTitle wrong ");
                new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
            } else {
                episode.setTitle(requestDTO.getTitle());
                episode.setEpisodePath(requestDTO.getLink());
                episodeRepository.save(episode);
                APIResponse apiResponse = new APIResponse();
                apiResponse.setData("Success");
                new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
            }
        }
    }

    @Override
    public void updateFilm(String filmName, CreFilmRequestLinkDTO requestDTO, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        Film film = filmRepository.findOneByFilmNameIgnoreCaseAndStatusTrue(filmName);
        if (film == null) {
            APIResponse apiResponse = new APIResponse();
            apiResponse.setStatus(400);
            apiResponse.setError("FilmName wrong ");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);
        } else {
            film.setFilmName(requestDTO.getName());
            film.setFilmDescription(requestDTO.getDescription());
            film.setFilmDuration(requestDTO.getDuration());
            film.setOddFilm(requestDTO.isOdd());
            if(episodeRepository.findByFilm(film).size() > 1) {
                film.setOddFilm(false);
            }
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            film.setNation(nationRepository.findOneByNationId(requestDTO.getNation_id()));
            film.setDirector(directorRepository.findOneByDirectorId(requestDTO.getDirector_id()));
            film.setFilmProducer(filmProducerRepository.findOneByFilmProducerId(requestDTO.getProducer_id()));
            film.setReleaseTime(dateFormat.parse(requestDTO.getRelease_time()));
            film.setFilmPosterPath(requestDTO.getPoster());
            film.setTrailerPath(requestDTO.getTrailer());
            filmRepository.save(film);
            APIResponse apiResponse = new APIResponse();
            apiResponse.setData("Success");
            new ObjectMapper().writeValue(response.getOutputStream(), apiResponse);

        }
    }
}
