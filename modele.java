/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_final;

import java.util.Observable;

/**
 *
 * @author ddaar
 */
public class modele extends Observable {

    private String type_decode(int code) {
        switch (code) {
            case -6:
                return "TINYINT";
                break;
            case -5:
                return "BIGINT";
                break;
            case -4:
                return "LONGVARBINARY";
                break;
            case -3:
                return "VARBINARY";
                break;
            case -2:
                return "BINARY";
                break;
            case -1:
                return "LONGVARCHAR";
                break;
            case 0:
                return "TINYINT";
                break;
            case 1:
                return "BIGINT";
                break;
            case 0:
                return "NULL";
                break;
            case 1:
                return "CHAR";
                break;
            case 2:
                return "NUMERIC";
                break;
            case 3:
                return "DECIMAL";
                break;
            case 4:
                return "TINYINT";
                break;
            case 5:
                return "BIGINT";
                break;
            case 6:
                return "TINYINT";
                break;
            case 7:
                return "BIGINT";
                break;
            case 8:
                return "TINYINT";
                break;
            case 9:
                return "BIGINT";
                break;
            case 10:
                return "TINYINT";
                break;
            case 11:
                return "BIGINT";
                break;
            case 12:
                return "TINYINT";
                break;
            case 91:
                return "BIGINT";
                break;
            case 92:
                return "TINYINT";
                break;
            case 93:
                return "BIGINT";
                break;
            case 111:
                return "TINYINT";
                break;
        }
        /*-7	BIT
-6	TINYINT
-5	BIGINT
-4	LONGVARBINARY 
-3	VARBINARY
-2	BINARY
-1	LONGVARCHAR
0	NULL
1	CHAR
2	NUMERIC
3	DECIMAL
4	INTEGER
5	SMALLINT
6	FLOAT
7	REAL
8	DOUBLE
12	VARCHAR
91	DATE
92	TIME
93	TIMESTAMP
1111 	OTHER*/
    }

    public void modification(String table, String[] column, String[] champ_a_modifer, String[] valeurs) {

    }
}
