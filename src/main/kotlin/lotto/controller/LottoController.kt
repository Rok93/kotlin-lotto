package lotto.controller

import lotto.controller.dto.LottoData
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.WinningLotto
import lotto.domain.getAutoLotto
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun handle() {
        val money = Money(InputView.inputPurchasedMoney())
        val lottoNumber = money.divide(Lotto.PRICE).also { ResultView.printPurchasedLottoNumber(it) }
        val lottos = Lottos.generateAutoLottos(lottoNumber) { getAutoLotto() }
            .also { ResultView.printLottos(it.toLottoDatas()) }
        val winningLotto = InputView.inputWinningLotto().toWinningLotto()
        lottos.getStatistics(winningLotto).also {
            ResultView.printStatistics(it.statistics)
            ResultView.printEarningRate(it.calculateEarningRate(money))
        }
    }
}

fun Lottos.toLottoDatas(): List<LottoData> = this.lottos.map { LottoData.of(it) }

fun List<Int>.toWinningLotto(): WinningLotto {
    val lotto = Lotto(this.map { LottoNumber.valueOf(it) })
    return WinningLotto(lotto)
}
