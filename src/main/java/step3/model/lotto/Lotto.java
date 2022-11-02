package step3.model.lotto;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import step3.model.machine.Match;
import step3.model.value.ErrMsg;
import step3.model.value.Rule;

public class Lotto{
    private final List<LottoNumber> lotto;
    public Lotto(List<LottoNumber> lotto) {
        verifyLotto(lotto);
        this.lotto = lotto;
    }


    public boolean isMatched(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }
    private void verifyLotto(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != Rule.LOTTO_NUMBER_LENGTH){
            throw new IllegalArgumentException(ErrMsg.WRONG_LENGTH);
        }
        if(lottoNumbers.size() != new HashSet<>(lottoNumbers).size()){
            throw new IllegalArgumentException(ErrMsg.DUPLICATED_INPUT);
        }
    }

    @Override
    public String toString() {
        return this.lotto.toString();
    }
}