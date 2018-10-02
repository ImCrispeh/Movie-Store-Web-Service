<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
            </head>
            <body>
                <xsl:template match="movie">
                    <tr>
                        <td><xsl:value-of select="@title"/></td>
                        <td><xsl:value-of select="genre"/></td>
                        <td><xsl:value-of select="@releaseDate"/></td>
                        <td>$<xsl:value-of select="@price"/></td>
                        <td><xsl:value-of select="@copies"/></td>
                    </tr>
                </xsl:template>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
