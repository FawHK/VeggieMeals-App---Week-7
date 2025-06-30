package de.syntax_institut.theveggieapp.utils

/**
 * A helper object for string manipulation operations.
 *
 * This object provides utility functions for working with strings, such as shortening text
 * to a specified maximum length.
 */
object StringHelper {
    /**
     * Shortens the provided text to the specified maximum length.
     * If the text exceeds the maximum length, it appends an ellipsis ("...") at the end.
     *
     * @param text The text to be shortened.
     * @param maxLength The maximum allowed length of the text.
     * @return The shortened text if it exceeds the [maxLength], or the original text if it doesn't.
     */
    fun shortenText(text: String, maxLength: Int): String {
        return if (text.length > maxLength) text.take(maxLength) + "..." else text
    }
}