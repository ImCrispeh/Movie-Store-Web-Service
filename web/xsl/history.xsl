<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : history.xsl
    Created on : 3 October 2018, 6:26 PM
    Author     : chris
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <form action="cancel.jsp" method="post">
            <table width="80%" align="center">
                <thead>
                    <tr>
                        <th width="8%">Order ID</th>
                        <th>Movies</th>
                        <th width="8%">Cost</th>
                        <th width="8%">Status</th>
                        <th width="8%">Cancel?</th>
                    </tr>
                </thead>
                <tbody>
                    <xsl:apply-templates/>
                </tbody>
            </table>
        </form>
    </xsl:template>
    <xsl:template match="order">
        <tr>
            <td style="text-align:center">
                <xsl:value-of select="orderID"/>
            </td>
            <td>
                <xsl:apply-templates select="movies"/>
            </td>
            <td style="text-align:center">
                $<xsl:value-of select="format-number(saleTotal, '0.00')"/>
            </td>
            <td style="text-align:center">
                <xsl:value-of select="orderStatus"/>
            </td>
            <td style="text-align:center">
                <xsl:choose>
                    <xsl:when test="orderStatus = 'cancelled'">N/A</xsl:when>
                    <xsl:otherwise>
                        <input type="submit" name="order{orderID}" value="Cancel"></input>
                    </xsl:otherwise>
                </xsl:choose>
            </td>
        </tr>
    </xsl:template>
    <xsl:template match="movies">
        <ul>
            <xsl:apply-templates/>
        </ul>
    </xsl:template>
    <xsl:template match="movie">
        <li>
            <xsl:value-of select="title"/> x <xsl:value-of select="copies"/>
        </li>
    </xsl:template>
</xsl:stylesheet>
