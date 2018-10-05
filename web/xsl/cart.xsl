<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet 
    xmlns:ns="http://uts/wsd/oms"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
            </head>
            <body>
                <form action="checkoutAction.jsp" method="Post">
                    <xsl:apply-templates select="ns:order/ns:orderID"/>
                    <xsl:apply-templates select="ns:order/ns:movies"/>
                    <input type="submit" name="cancelOrder" value="Cancel Order"/>
                    <input type="submit" name="placeOrder" value="Place Order"/>
                </form>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="ns:orderID">
        <h3 align="center">Order: <xsl:apply-templates/></h3>
    </xsl:template>
    
    <xsl:template match="ns:movies">
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
    
    <xsl:template match="ns:movie">
        <tr>
            <td>
                <xsl:value-of select="ns:title"/>
            </td>
            <td>
                <xsl:value-of select="ns:genre"/>
            </td>
            <td>
                <xsl:value-of select="ns:releaseDate"/>
            </td>
            <td>$<xsl:value-of select="ns:price"/></td>
            <td>
                <xsl:value-of select="ns:copies"/>
            </td>
            <td>
                <input type="submit" name="remove_{ns:title}_{ns:releaseDate}" class="material-icons" value="delete" />
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>