fun main() {

    val password = 

    val targetscore = 42  // you can change this to any number you like

    val score = calculatepasswordscore(password)

    // Print output based on password score

    if (score == targetscore) {

        // if score matches target set
        
        println("password accepted, system integrity verified")
        println("bomb defused; the quick brown fox jumps over lazy guard dog ")
    } 
    
    
    else {
        // if score incorrect and does not match target set
        println("password rejected")
    }
}

/*
 * The function given below
 * Calculates a numeric score from the password, using logic that involves:
 * - how many times each letter appears (frequency map),
 * - how many different letters there are,
 * - and the password length.
 */

fun calculatepasswordscore(password: string): int {

     // keep only letters and make everything lowercase
  
    val letters = password.lowercase().filter { it.isletter() }

    if (letters.isempty()) {
        return 0
    }

    // frequencyMap: each letter -> how many times it appears
    val frequencyMap = letters.groupingby { ch -> ch }.eachcount()


     // basic stats from the frequency map
    val distinctletters = frequencyMap.size
    val maxfrequency = frequencyMap.values.maxornull() ?: 0
    val minfrequency = frequencyMap.values.minornull() ?: 0

    val weightedsum = frequencyMap.values.sumof { (ch, count) ->
        val lettervalue = (ch - 'a' + 1)
        lettervalue * count
    }

    // build a final score using different pieces of information
    
    val lengthpart = letters.length * 7
    val spreadpart = (maxfrequency - minfrequency)

    val rawscore = weightedsum + lengthpart + spreadpart

    return rawscore % 97
}
