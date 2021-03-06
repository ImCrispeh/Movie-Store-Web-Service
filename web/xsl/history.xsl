<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : history.xsl
    Created on : 3 October 2018, 6:26 PM
    Author     : chris
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet
    xmlns:ns="http://uts/wsd/oms"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0">
    <xsl:param name="email"/>
    <xsl:output method="html"/>
    <xsl:template match="/">
        <form action="cancel.jsp" method="post">
            <table width="80%" align="center" class="historyTable">
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
                    <xsl:apply-templates select="//ns:history/ns:order[ns:email=$email]"/>
                </tbody>
            </table>
        </form>
    </xsl:template>
    <xsl:template match="ns:order">
        <tr>
            <td>
                <xsl:value-of select="ns:orderID"/>
            </td>
            <td id="historyMovies">
                <xsl:apply-templates select="ns:movies"/>
            </td>
            <td>
                $<xsl:value-of select="format-number(ns:saleTotal, '0.00')"/>
            </td>
            <td>
                <xsl:value-of select="ns:orderStatus"/>
            </td>
            <td>
                <xsl:choose>
                    <xsl:when test="ns:orderStatus = 'cancelled'">N/A</xsl:when>
                    <xsl:otherwise>
                        <input type="submit" name="order_{ns:orderID}" value="Cancel"></input>
                    </xsl:otherwise>
                </xsl:choose>
            </td>
        </tr>
    </xsl:template>
    <xsl:template match="ns:movies">
        <ul>
            <xsl:apply-templates/>
        </ul>
    </xsl:template>
    <xsl:template match="ns:movie">
        <li>
            <xsl:value-of select="ns:title"/> x <xsl:value-of select="ns:copies"/> [Genre: <xsl:value-of select="ns:genre"/>, Release Date: <xsl:value-of select="ns:releaseDate"/>, Individual Price: $<xsl:value-of select="format-number(ns:price, '0.00')"/>]
        </li>
    </xsl:template>
</xsl:stylesheet>
