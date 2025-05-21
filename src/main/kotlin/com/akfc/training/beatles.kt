package com.akfc.training.com.akfc.training

import java.net.URI
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.io.File
import javax.xml.transform.TransformerFactory
import javax.xml.transform.stream.StreamSource
import javax.xml.transform.stream.StreamResult

fun main() {
    // Query to get the Beatles albums
    val query = """
        SELECT DISTINCT ?name ?release WHERE {
            wd:Q61027305 wdt:P527 ?album.
            ?album rdfs:label ?name; wdt:P577 ?release.
            filter(lang(?name) = "fr").
        }
    """.trimIndent()

    val client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build()
    val url = URI("https://query.wikidata.org/sparql?query=${URLEncoder.encode(query, "UTF-8")}")
    val request = HttpRequest.newBuilder().GET().uri(url).header("Accept", "application/sparql-results+xml").build()
    val response = client.send(request, HttpResponse.BodyHandlers.ofString())
    println(response.body())

    // Save the XML response to a file
    File("src/main/resources/albums.xml").writeText(response.body())

    // Apply XSLT transformation
    val transformerFactory = TransformerFactory.newInstance()
    val xsltSrc = StreamSource(File("src/main/resources/beatles_albums.xslt"))
    val transformer = transformerFactory.newTransformer(xsltSrc)
    val xmlSrc = StreamSource(File("src/main/resources/albums.xml"))
    val html = StreamResult(File("src/main/resources/beatles.html"))
    transformer.transform(xmlSrc, html)
}