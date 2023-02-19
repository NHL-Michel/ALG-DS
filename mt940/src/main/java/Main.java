/*
 * Copyright (c) http://www.prowidesoftware.com/, 2013. All rights reserved.
 */
import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.mt9xx.MT940;


import java.io.IOException;
import java.io.StringReader;

/**
 * Example of parsing an MT 940
 *
 * @author www.prowidesoftware.com
 */
public class Main {

    public static void main(String[] args) throws IOException {
        /*
         * The message we'll parse as a plain string for simplicity
         */
        String mtString  = "{1:F01INGBNL2ABXXX0000000000}\n" +
                "{2:I940INGBNL2AXXXN}\n" +
                "{4:\n" +
                ":20:P140220000000001\n" +
                ":25:NL69INGB0123456789EUR\n" +
                ":28C:00000\n" +
                ":60F:C140219EUR662,23\n" +
                ":61:1402200220C1,56NTRFEREF//00000000001005\n" +
                "/TRCD/00100/\n" +
                ":86:/EREF/EV12341REP1231456T1234//CNTP/NL32INGB0000012345/INGBNL2\n" +
                "A/ING BANK NV INZAKE WEB///REMI/USTD//EV10001REP1000000T1000/\n" +
                ":61:1402200220D1,57NTRFPREF//00000000001006\n" +
                "/TRCD/00200/\n" +
                ":86:/PREF/M000000003333333//REMI/USTD//TOTAAL 1 VZ/\n" +
                ":61:1402200220C1,57NRTIEREF//00000000001007\n" +
                "/TRCD/00190/\n" +
                ":86:/RTRN/MS03//EREF/20120123456789//CNTP/NL32INGB0000012345/INGB\n" +
                "NL2A/J.Janssen///REMI/USTD//Factuurnr 123456 Klantnr 00123/\n" +
                ":61:1402200220D1,14NDDTEREF//00000000001009\n" +
                "/TRCD/01016/\n" +
                ":86:/EREF/EV123REP123412T1234//MARF/MND-EV01//CSID/NL32ZZZ9999999\n" +
                "91234//CNTP/NL32INGB0000012345/INGBNL2A/ING Bank N.V. inzake WeB/\n" +
                "//REMI/USTD//EV123REP123412T1234/\n" +
                ":61:1402200220C1,45NDDTPREF//00000000001008\n" +
                "/TRCD/01000/\n" +
                ":86:/PREF/M000000001111111//CSID/NL32ZZZ999999991234//REMI/USTD//\n" +
                "TOTAAL 1 POSTEN/\n" +
                ":61:1402200220D12,75NRTIEREF//00000000001010\n" +
                "/TRCD/01315/\n" +
                ":86:/RTRN/MS03//EREF/20120501P0123478//MARF/MND-120123//CSID/NL32\n" +
                "ZZZ999999991234//CNTP/NL32INGB0000012345/INGBNL2A/J.Janssen///REM\n" +
                "I/USTD//CONTRIBUTIE FEB 2014/\n" +
                ":61:1402200220C32,00NTRF9001123412341234//00000000001011\n" +
                "/TRCD/00108/\n" +
                ":86:/EREF/15814016000676480//CNTP/NL32INGB0000012345/INGBNL2A/J.J\n" +
                "anssen///REMI/STRD/CUR/9001123412341234/\n" +
                ":61:1402200220D119,00NTRF1070123412341234//00000000001012\n" +
                "/TRCD/00108/\n" +
                ":86:/EREF/15614016000384600//CNTP/NL32INGB0000012345/INGBNL2A/ING\n" +
                "BANK NV///REMI/STRD/CUR/1070123412341234/\n" +
                ":62F:C140220EUR564,35\n" +
                ":64:C140220EUR564,35\n" +
                ":65:C140221EUR564,35\n" +
                ":65:C140224EUR564,35\n" +
                ":86:/SUM/4/4/134,46/36,58/\n" +
                "-}";
        /*
         *  Create an instance of the SWIFT parser
         */
        SwiftParser parser = new SwiftParser();
        /*
         * feed the parser with the MT String we want to parse
         */
        parser.setReader(new StringReader(mtString));
        /*
         * Actually parse the file and create a java object model from the message
         */
        SwiftMessage msg = parser.message();
        /*
         * msg contains java object from parsed message.
         * Printout several parts of the message's content.
         */
        MT940 mt = new MT940(msg);

        for (int i = 0; i < mt.getFields().size(); i++) {
            System.out.println(mt.getFields().get(i).toJson());
        }
    }
}
