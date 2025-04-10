package com.core.data.helpers;

import java.util.Random;

public abstract class MakeRandom {
    private static final String VOWELS = "aeiou";
    private static final String CONSONANTS = "bcdfghklmnprstvwy";
    private static final String RARE_CONSONANTS = "zqxj";
    private static final String ALLOWED_CONSONANT_PAIRS = "ch, th, sh, ph, wh, fr, dr, br, cr, tr, pr, gr, sl, cl, fl, gl, pl, sm, sn, sp, st, sw, tw, bl, sc, sk, sm, sn, sp, st, sw, br, cr, dr, gr, pr, tr, fr";
    private static final String[] DOUBLE_VOWELS = {"ee", "ea", "oo", "ai", "oa", "ie", "ou", "au", "oi", "ui"};
    private static final String ALL_LETTERS = "aeioubcdfghjklmnpqrstvwxyzAEIOUBCDFGHJKLMNPQRSTVWXYZ";
    private static final String[] COMMON_TITLES = {"Mr.", "Mrs.", "Miss", "Ms.", "Dr.", "Prof.", "Sir", "Dame", "Lord", "Lady", "Rev."};
    private static final String[] RARE_TITLES = {"Rt Hon", "Baron", "Baroness", "Viscount", "Viscountess", "Earl", "Countess", "Duke", "Duchess", "Marquess", "Marchioness", "Prince", "Princess", "The Hon", "Admiral", "Brigadier", "Colonel", "Major", "Captain", "Commander", "Lieutenant", "Sergeant", "Corporal", "Wing Commander", "Flight Lieutenant", "Squadron Leader", "Group Captain", "Air Commodore", "Air Vice-Marshal", "Air Marshal", "Air Chief Marshal", "Field Marshal", "Marshal of the RAF"};
    private static final String[] DOMAINS = {"com", "org", "net", "edu", "gov", "mil", "co", "us", "uk", "ca", "de", "fr", "jp", "au", "cn", "in", "it", "es", "nl", "mx", "se", "ch", "no", "dk", "fi", "be", "at", "nz", "kr", "za", "il", "ie", "pl", "gr", "pt", "tr", "sg", "global"};

    private static final Random random = new Random();

    public static boolean chance(int percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Percent must be between 0 and 100");
        }
        return random.nextInt(100) < percent;
    }

    public static String word() {
        int length = random.nextInt(10) + 3;  // Length between 3 and 12
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            word.append(ALL_LETTERS.charAt(random.nextInt(ALL_LETTERS.length())));
        }
        return word.toString();
    }

    public static String email() {
        String name = chance(50) ? word() : word() + "." + word();
        return name + "@" + word() + "." + DOMAINS[random.nextInt(DOMAINS.length)];
    }

    public static String title() {
        return chance(10) ? RARE_TITLES[random.nextInt(RARE_TITLES.length)] : COMMON_TITLES[random.nextInt(COMMON_TITLES.length)];
    }

    public static String address(boolean withAddressee, boolean withPostcode) {
        String addressee = withAddressee ? person() : "";
        String address = (random.nextInt(999) + 1) + " " + word() + " " + word() + "\n" + word() + "\n" + word() + random.nextInt(6) + 6;

        if (withPostcode) {
            address += "\n" + postcode();
        }

        return withAddressee ? addressee + "\n" + address : address;
    }

    public static String postcode() {
        return word().toUpperCase() + random.nextInt(99) + " " + random.nextInt(9) + word().toUpperCase();
    }

    public static String person() {
        return title() + " " + word() + " " + word();
    }

    public static int integer(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static double decimal(double min, double max) {
        return random.nextDouble() * (max - min) + min;
    }

    public static String ulid() {
        return java.util.UUID.randomUUID().toString().replace("-", "").substring(0, 26).toUpperCase();
    }

    public static String uuid() {
        return java.util.UUID.randomUUID().toString();
    }

    public static String sentence(int wordCount) {
        StringBuilder sentence = new StringBuilder(word());
        for (int i = 1; i < wordCount; i++) {
            sentence.append(" ").append(word());
        }
        sentence.append(".");
        return sentence.toString();
    }

    public static String word(int length) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            word.append(ALL_LETTERS.charAt(random.nextInt(ALL_LETTERS.length())));
        }
        return word.toString();
    }

}
