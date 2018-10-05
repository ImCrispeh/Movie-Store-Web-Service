<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    <xsl:param name="Title"/>
    <xsl:param name="Genre"/>
    <xsl:param name="StartYear"/>
    <xsl:param name="EndYear"/>
    <xsl:output method = "html" />
    <xsl:template match = "/">
        <html>
            <body>
                <div style="text-align:center">
                    <div style="width:10%"/>
                    <div align="center" style="width: 80%; display: inline-block" >
                    <table>
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>Genre</th>
                                <th>Price</th>
                                <th>copeis</th>
                            </tr>
                        </thead>
                        <!--<xsl:apply-templates select="//movies/movie[title=$Title]" />-->
                        <xsl:apply-templates select="//movies/movie[title='The Lord of the Rings']" />
<!--                        <xsl:apply-templates select="//movies/movie[genre=$Genre]" />
                        <xsl:apply-templates select="//movies/movie[releaseDate>$StartYear and releaseDate>$EndYear ]" />-->
                    </table>
                    </div>
                    <div style="width:10%"/>
                </div>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="movie">
        <tr>
            <td>
                <xsl:value-of select="title" />
            </td>
            <td>
                <xsl:value-of select="genre"/>
            </td>
            <td>
                <xsl:value-of select="price"/>
            </td>
            <td>
                <xsl:value-of select="copies"/>
            </td>
        </tr>
    </xsl:template>
    <xsl:template match="movie"/>
</xsl:stylesheet>