<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:sparql="http://www.w3.org/2005/sparql-results#">
    <xsl:output method="html" indent="yes" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Beatles Albums</title>
                <style>
                    table {
                    border-collapse: collapse;
                    width: 100%;
                    }
                    th, td {
                    border: 1px solid black;
                    padding: 8px;
                    text-align: left;
                    }
                    th {
                    background-color: #f2f2f2;
                    }
                </style>
            </head>
            <body>
                <h1>Beatles Albums</h1>
                <table>
                    <tr>
                        <th>Album Title</th>
                        <th>Release Date</th>
                    </tr>
                    <xsl:for-each select="//sparql:result">
                        <tr>
                            <td><xsl:value-of select="sparql:binding[@name='name']/sparql:literal"/></td>
                            <td><xsl:value-of select="sparql:binding[@name='release']/sparql:literal"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>