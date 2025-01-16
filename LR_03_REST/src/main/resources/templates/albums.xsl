<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Albums List</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f4f4f9;
                        margin: 0;
                        padding: 20px;
                    }

                    h1 {
                        text-align: center;
                        color: #333;
                        margin-bottom: 20px;
                    }

                    table {
                        width: 100%;
                        border-collapse: collapse;
                        margin: 0 auto;
                        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                    }

                    th, td {
                        padding: 12px;
                        text-align: left;
                        border: 1px solid #ddd;
                    }

                    th {
                        background-color: #4CAF50;
                        color: white;
                    }

                    tr:nth-child(even) {
                        background-color: #f2f2f2;
                    }

                    tr:hover {
                        background-color: #ddd;
                    }

                    td {
                        font-size: 14px;
                    }
                </style>
            </head>
            <body>
                <h1>Albums</h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Label</th>
                    </tr>
                    <xsl:for-each select="albums/album">
                        <tr>
                            <td><xsl:value-of select="id"/></td>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="recordLabel"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
