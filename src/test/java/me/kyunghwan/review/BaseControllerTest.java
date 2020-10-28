package me.kyunghwan.review;

import me.kyunghwan.review.account.AccountRepository;
import me.kyunghwan.review.movie.Genre;
import me.kyunghwan.review.movie.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
public class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected GenreRepository genreRepository;

    @Autowired
    protected AccountRepository accountRepository;

    private String[] names = {"드라마", "판타지", "서부", "공포", "멜로/로맨스", "모험", "스릴러", "느와르", "컬트", "다큐멘터리", "코미디", "가족", "미스터리", "전쟁", "애니메이션", "범죄", "뮤지컬", "SF", "액션", "무협", "에로", "서스펜스", "서사", "블랙코미디", "실험", "공연실황"};

    @BeforeEach
    void init() {
        accountRepository.deleteAll();
        genreRepository.deleteAll();
        for (String name : names) {
            genreRepository.save(Genre.builder()
                    .name(name)
                    .build());
        }
    }

}