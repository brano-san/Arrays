fun ex1() {
    print("Введите количество строк: ")
    val rows = readLine()!!.toInt()
    print("Введите количество столбцов: ")
    val cols = readLine()!!.toInt()

    val array = Array(rows) { IntArray(cols) }
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print("Введите трехзначное число для [$i][$j]: ")
            array[i][j] = readLine()!!.toInt()
        }
    }

    val uniqueDigits = mutableSetOf<Char>()
    for (row in array) {
        for (num in row) {
            uniqueDigits.addAll(num.toString().toSet())
        }
    }

    println("Двумерный массив:")
    for (row in array) {
        println(row.joinToString(" "))
    }

    println("В массиве использовано ${uniqueDigits.size} различных цифр")
}

fun ex2(){
    val matrix = arrayOf(
        intArrayOf(5, 9, 6, 7, 2),
        intArrayOf(9, 8, 4, 5, 3),
        intArrayOf(6, 4, 3, 8, 7),
        intArrayOf(7, 5, 8, 4, 8),
        intArrayOf(2, 3, 7, 8, 1)
    )

    if (matrix.size != matrix[0].size) {
        println("Массив не симметричен относительно главной диагонали")
        return
    }

    val n = matrix.size

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (matrix[i][j] != matrix[j][i]) {
                println("Массив не симметричен относительно главной диагонали")
                return
            }
        }
    }
    println("Массив симметричен относительно главной диагонали")
}

fun ex3(){
    val alphabet = hashMapOf(
        'А' to 21, 'Б' to 13, 'В' to 4, 'Г' to 20, 'Д' to 22, 'Е' to 1, 'Ё' to 25,
        'Ж' to 12, 'З' to 24, 'И' to 14, 'Й' to 2, 'К' to 28, 'Л' to 9, 'М' to 23,
        'Н' to 3, 'О' to 29, 'П' to 6, 'Р' to 16, 'С' to 15, 'Т' to 11, 'У' to 26,
        'Ф' to 5, 'Х' to 30, 'Ц' to 27, 'Ч' to 8, 'Ш' to 18, 'Щ' to 10, 'Ь' to 33,
        'Ы' to 31, 'Ъ' to 32, 'Э' to 19, 'Ю' to 7, 'Я' to 17
    )

    var text = "Сообщение"
    text = text.uppercase()
    println("Исходный текст:  $text")

    var keyword = "Поле"
    keyword = keyword.uppercase()
    println("Ключевое слово:  $keyword")

//Encrypt
    val encryptResult = StringBuilder()

    for (i in text.indices) {
        val textCharNumber = alphabet.filterKeys { it == text[i] }.values.first()
        val keywordCharNumber = alphabet.filterKeys { it == keyword[i % keyword.length] }.values.first()
        val encryptedCharNumber = (textCharNumber + keywordCharNumber) % 33
        val encryptedChar = alphabet.filterValues { it == encryptedCharNumber }.keys.first()
        encryptResult.append(encryptedChar)
    }

//Decrypt
    val decryptResult = StringBuilder()

    for (i in text.indices) {
        val textCharNumber = alphabet.filterKeys { it == encryptResult[i] }.values.first()
        val keywordCharNumber = alphabet.filterKeys { it == keyword[i % keyword.length] }.values.first()
        val decryptedCharNumber = (textCharNumber - keywordCharNumber + 33) % 33
        val decryptedChar = alphabet.filterValues { it == decryptedCharNumber }.keys.first()
        decryptResult.append(decryptedChar)
    }

    println("Зашифрованный текст: $encryptResult")
    println("Расшифрованный текст: $decryptResult")
}

fun ex4(){
    val array1 = intArrayOf(1, 2, 3, 2, 0)
    val array2 = intArrayOf(5, 1, 2, 7, 3, 2, 2)

    val intersection = mutableListOf<Int>()

    for (element in array1) {
        if (element in array2) {
            intersection.add(element)
            array2[array2.indexOf(element)] = Int.MIN_VALUE
        }
    }

    println("Пересечение массивов с учетом повторений: $intersection")
}

fun ex5(){
    val words = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

    val wordGroups = mutableMapOf<String, MutableList<String>>()

    for (word in words) {

        val sortedWord = word.toCharArray().sorted().toString()

        if (wordGroups.containsKey(sortedWord)) {
            wordGroups[sortedWord]!!.add(word)
        } else {
            wordGroups[sortedWord] = mutableListOf(word)
        }
    }

    for (group in wordGroups.values) {
        println(group)
    }
}

fun main()
{
        ex1()
}