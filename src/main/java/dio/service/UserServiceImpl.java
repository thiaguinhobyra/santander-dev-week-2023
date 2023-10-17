package dio.service;

import dio.domain.dto.*;
import dio.domain.model.*;
import dio.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return convertToDTO(user);
    }

    @Override
    public UserDTO create(UserDTO userDTO) {

        User user = convertToEntity(userDTO);

        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("A conta já existe");
        }
        if (userRepository.existsByCardNumber(user.getCard().getNumber())) {
            throw new IllegalArgumentException("O cartão já existe");
        }

        User createdUser = userRepository.save(user);
        return convertToDTO(createdUser);
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            User user = convertToEntity(userDTO);
            user.setId(id);
            User updatedUser = userRepository.save(user);
            return convertToDTO(updatedUser);
        } else {
            throw new NoSuchElementException("User with ID " + id + " not found");
        }
    }

    @Override
    public UserDTO delete(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setAccount(convertToEntity(userDTO.getAccount()));
        user.setFeatures(convertFeturesToEntities(userDTO.getFeatures()));
        user.setCard(convertToEntity(userDTO.getCard()));
        user.setNews(convertToEntities(userDTO.getNews()));
        return user;
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAccount(convertToDTO(user.getAccount()));
        userDTO.setFeatures(convertFeturesToDTOs(user.getFeatures()));
        userDTO.setCard(convertToDTO(user.getCard()));
        userDTO.setNews(convertToDTOs(user.getNews()));
        return userDTO;
    }

    private Account convertToEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setNumber(accountDTO.getNumber());
        account.setAgency(accountDTO.getAgency());
        account.setBalance(accountDTO.getBalance());
        account.setLimit(accountDTO.getLimit());
        return account;
    }

    private AccountDTO convertToDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setNumber(account.getNumber());
        accountDTO.setAgency(account.getAgency());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setLimit(account.getLimit());
        return accountDTO;
    }

    private Feature convertToEntity(FeatureDTO featureDTO) {
        Feature feature = new Feature();
        feature.setIcon(featureDTO.getIcon());
        feature.setDescription(featureDTO.getDescription());
        return feature;
    }

    private FeatureDTO convertToDTO(Feature feature) {
        FeatureDTO featureDTO = new FeatureDTO();
        featureDTO.setIcon(feature.getIcon());
        featureDTO.setDescription(feature.getDescription());
        return featureDTO;
    }

    private Card convertToEntity(CardDTO cardDTO) {
        Card card = new Card();
        card.setNumber(cardDTO.getNumber());
        card.setLimit(cardDTO.getLimit());
        return card;
    }

    private CardDTO convertToDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setNumber(card.getNumber());
        cardDTO.setLimit(card.getLimit());
        return cardDTO;
    }

    private News convertToEntity(NewsDTO newsDTO) {
        News news = new News();
        news.setIcon(newsDTO.getIcon());
        news.setDescription(newsDTO.getDescription());
        return news;
    }

    private NewsDTO convertToDTO(News news) {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setIcon(news.getIcon());
        newsDTO.setDescription(news.getDescription());
        return newsDTO;
    }

    private List<Feature> convertFeturesToEntities(List<FeatureDTO> featureDTOs) {
        List<Feature> features = new ArrayList<>();
        for (FeatureDTO featureDTO : featureDTOs) {
            features.add(convertToEntity(featureDTO));
        }
        return features;
    }

    private List<FeatureDTO> convertFeturesToDTOs(List<Feature> features) {
        List<FeatureDTO> featureDTOs = new ArrayList<>();
        for (Feature feature : features) {
            featureDTOs.add(convertToDTO(feature));
        }
        return featureDTOs;
    }

    private List<News> convertToEntities(List<NewsDTO> newsDTOs) {
        List<News> newsList = new ArrayList<>();
        for (NewsDTO newsDTO : newsDTOs) {
            newsList.add(convertToEntity(newsDTO));
        }
        return newsList;
    }

    private List<NewsDTO> convertToDTOs(List<News> newsList) {
        List<NewsDTO> newsDTOs = new ArrayList<>();
        for (News news : newsList) {
            newsDTOs.add(convertToDTO(news));
        }
        return newsDTOs;
    }

}
