package org.example.quote;

public enum VoteType {
    UP_VOTE,
    DOWN_VOTE;


    public static boolean isEnumValue(String inputString) {
        try {
            VoteType.valueOf(inputString);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
