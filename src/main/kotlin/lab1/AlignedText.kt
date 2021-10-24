package lab1

enum class Alignment {
    LEFT,
    RIGHT,
    CENTER,
}

fun alignText(
    text: String,
    lineWidth: Int = 120,
    alignment: Alignment = Alignment.LEFT
) : String {
    val textInList = arrayListOf<String>()
    var curText = text
    var indexToSplit : Int

    while (curText.isNotEmpty()){
        //find index of the last space
        //we will divide by it
        indexToSplit = curText.indexOf('\n')
        if (indexToSplit == -1 || indexToSplit > lineWidth)
            if (curText.length > lineWidth) {
                indexToSplit = curText.lastIndexOf(' ', lineWidth)
                if (indexToSplit == -1) indexToSplit = lineWidth
            }
            else indexToSplit = curText.lastIndex + 1


        //add spaces according to the alignment
        //and then add string to the list
        when (alignment){
            Alignment.LEFT -> textInList.add(curText.substring(0, indexToSplit).padEnd(lineWidth, ' '))
            Alignment.RIGHT -> textInList.add(curText.substring(0, indexToSplit).padStart(lineWidth, ' '))
            Alignment.CENTER ->
                //adding half of the spaces with pasStart, another half with padEnd
                textInList.add(curText.substring(0, indexToSplit)
                    .padStart(lineWidth - (lineWidth - indexToSplit)/2, ' ')
                    .padEnd(lineWidth, ' '))
        }

        var firstIndex : Int = indexToSplit
        while (curText.length > firstIndex &&
            (curText[firstIndex] == ' ' || curText[firstIndex] == '\n')) firstIndex++
        curText = curText.substring(firstIndex)
        //if (curText.length > indexToSplit && indexToSplit != lineWidth) curText = curText.substring(firstIndex)
        //else curText = curText.substring(indexToSplit)
    }

    //covert list to text with strings
    return textInList.joinToString(System.lineSeparator())
}