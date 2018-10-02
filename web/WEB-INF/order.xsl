<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
            </head>
            <body>
                <xsl:apply-templates select="order/orderID"/>
                <xsl:apply-templates select="order/movies"/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="orderID">
        <h3 align="center">Order: <xsl:apply-templates/></h3>
    </xsl:template>
    
    <xsl:template match="movies">
        <table width="100%">
            <thead>
                <tr>
                    <th width="19%">Title</th>
                    <th width="19%">Genre</th>
                    <th width="19%">Release Date</th>
                    <th width="19%">Price</th>
                    <th width="19%">Amount</th>
                    <th width="5%">Remove</th>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>
    
    <xsl:template match="movie">
        <tr>
            <td><xsl:value-of select="title"/></td>
            <td><xsl:value-of select="genre"/></td>
            <td><xsl:value-of select="releaseDate"/></td>
            <td>$<xsl:value-of select="price"/></td>
            <td><xsl:value-of select="copies"/></td>
            <td><input type="submit" name="remove_{title}_{releaseDate}" class="material-icons" value="delete" /></td>
        </tr>
    </xsl:template>
</xsl:stylesheet>