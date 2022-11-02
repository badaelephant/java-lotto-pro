package step3.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.model.machine.Result;
import step3.model.machine.Results;

class LottoListTest {
    private WinningLotto winningLotto;
    private List<Lotto> lottoList = new ArrayList<>();

    private List<LottoNumber> changeToLottoNumbers(List<Integer> numbers){
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toList());

    }
    @BeforeEach
    void setup() {
        List<LottoNumber> winningLottoNumbers = changeToLottoNumbers(Arrays.asList(1,2,3,4,5,6));
        Lotto winnigLotto = new Lotto(winningLottoNumbers);
        LottoNumber bonusNumber = new LottoNumber(7);
        winningLotto = new WinningLotto(winnigLotto, bonusNumber);
        Lotto first_winner = new Lotto(changeToLottoNumbers(Arrays.asList(1,2,3,4,5,6)));
        Lotto second_bonus_winner = new Lotto(changeToLottoNumbers(Arrays.asList(1,2,3,4,5,7)));
        Lotto second_winner = new Lotto(changeToLottoNumbers(Arrays.asList(1,2,3,4,5,8)));
        lottoList.addAll(Arrays.asList(first_winner, second_bonus_winner, second_winner));
    }

    @Test
    void 결과_확인_1등_2등_3등() {
        LottoList lottoTickets = new LottoList(lottoList);
        assertThat(lottoTickets.getMatchResults(winningLotto).getResultCount(Result.FIRST_PRIZE)).isEqualTo(1);
        assertThat(lottoTickets.getMatchResults(winningLotto).getResultCount(Result.SECOND_PRIZE_BONUS)).isEqualTo(1);
        assertThat(lottoTickets.getMatchResults(winningLotto).getResultCount(Result.SECOND_PRIZE)).isEqualTo(1);
    }


}