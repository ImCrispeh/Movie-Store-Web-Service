<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

<xsl:output method = "html" />

    <xsl:template match = "movies">
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
                        <xsl:apply-templates />
                    </table>
                    </div>
                    <div style="width:10%"/>
                </div>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="//movie[title='Transporter']">
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