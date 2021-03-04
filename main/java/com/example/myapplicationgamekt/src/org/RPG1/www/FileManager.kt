package com.example.myapplicationgamekt

import java.io.*

class FileManager {
    private val FILE_PATH = "resources/"
    private val FILE_EXTENSION = ".txt"
    @Throws(IOException::class)
    fun write(fileName: String, content: String?) {
        val printWriter =
            PrintWriter(BufferedWriter(FileWriter(FILE_PATH + fileName + FILE_EXTENSION, true)))
        printWriter.println(content)
        println("FILE SAVED")
        printWriter.close()
    }

    @Throws(IOException::class)
    fun read(file: String): String {
        val fileReader = FileReader(FILE_PATH + file + FILE_EXTENSION)
        val bReader = BufferedReader(fileReader)
        var loadFile: String
        var result = ""
        while (bReader.readLine().also { loadFile = it } != null) {
            result += """
                $loadFile
                
                """.trimIndent()
        }
        println("LOADING FILE")
        bReader.close()
        return result
    }
}