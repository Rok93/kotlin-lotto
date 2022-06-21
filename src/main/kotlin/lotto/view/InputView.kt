package lotto.view

object InputView {
    fun inputPurchasedMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.also {
            require(it.isNotBlank()) { "구입금액은 null or 빈 값이 될 수 없습니다." }
            requireNotNull(it.toIntOrNull()) { "구입금액은 숫자만 허용됩니다. " }
        }!!.toInt()
    }

    fun inputWinningLotto(): IntArray {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = readLine() ?: throw IllegalStateException("당첨 번호는 null 값은 허용하지 않습니다.")
        return input.split(",").asSequence()
            .map { it.trim() }
            .map { it.toInt() }
            .toList()
            .toIntArray()
    }

    fun inputBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        val input = readLine() ?: throw IllegalStateException("당첨 번호는 null 값은 허용하지 않습니다.")
        return input.toInt()
    }

    fun inputManualLottoAmount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readLine()?.also {
            require(it.isNotBlank()) { "구입금액은 null or 빈 값이 될 수 없습니다." }
            requireNotNull(it.toIntOrNull()) { "구입금액은 숫자만 허용됩니다. " }
        }!!.toInt()
    }

    fun inputManualLottos(amountOfManualLotto: Int): List<IntArray> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(amountOfManualLotto) { inputManualLotto() }
    }

    private fun inputManualLotto(): IntArray {
        val input = readLine() ?: throw IllegalStateException("당첨 번호는 null 값은 허용하지 않습니다.")
        return input.split(",").asSequence()
            .map { it.trim() }
            .map { it.toInt() }
            .toList()
            .toIntArray()
    }
}
