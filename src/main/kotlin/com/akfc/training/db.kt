import com.akfc.training.com.akfc.training.Man
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

fun main() {
    // Modify this line to specify the path to your resources folder
    val url = "jdbc:sqlite:src/main/resources/man_database.db"
    var connection: Connection? = null

    try {
        // Establish a connection
        connection = DriverManager.getConnection(url)

        // Create the Man table if it doesn't exist
        val createTableQuery = """
            CREATE TABLE IF NOT EXISTS Man (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                age INTEGER NOT NULL
            )
        """.trimIndent()
        connection.createStatement().execute(createTableQuery)

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        // Ensure the connection is closed even if an error occurs
        connection?.close()
    }
}